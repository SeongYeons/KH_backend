## 배포 테스트
### 1. 07_OpenData 프로젝트 배포
#### 1.1. jre17 컨테이너 생성
* docker run -it --name boot-web -p 30000:8080 -e TZ=Asia/Seoul openjdk:17 /bin/bash
#### 1.2. 코드 수정 및 빌드
* application.properties에 spring.datasource.url을 수정 (본인 PC IP)
* maven install로 빌드
#### 1.3. jar 파일을 컨테이너 내부에 복사
* docker cp .\07_OpenData-0.0.1-SNAPSHOT.jar boot-web:/root
#### 1.4. 명령어로 jar 파일 실행
* java -jar 07_OpenData-0.0.1-SNAPSHOT.jar
#### 1.5. 페이지 접속
* http://localhost:30000/
### 2. 08_SpringPractice 프로젝트 배포
#### 2.1. Tomcat 컨테이너 생성
* docker run -d --name myweb -p 40000:8080 -e TZ=Asia/Seoul tomcat:9.0.78-jre11-temurin
#### 2.2. 코드 수정 및 빌드
* src/main/webapp/META-INF/context.xml 추가
* driver.properties에 db.url을 수정 (본인 PC IP)
* maven install로 빌드
#### 2.3. war 파일을 컨테이너 내부에 복사
* docker cp .\practice.war myweb:/usr/local/tomcat/webapps
#### 2.4. 페이지 접속
* localhost:40000/practice