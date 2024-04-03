## 마이바티스(Mybatis)
### 1. 마이바티스(Mybatis)
* 마이바티스는 JDBC를 통해 구현했던 상당 부분의 코드와 파라미터 설정 및 결과 매핑을 xml 설정을 통해 쉽게 구현할 수 있게 해주는 영속성 프레임워크이다.
### 2. 마이바티스(Mybatis) 동작 구조
* mybatis-config.xml은 mybatis의 메인 환경 설정 파일이다. 
* mapper.xml은 실행할 쿼리문과 매핑 구문을 정의해놓은 파일이다.
* SqlSession 객체는 실제 DB와 연결된 객체로 mapper.xml에 정의된 쿼리문을 실행시키고 실행 결과를 리턴 받는 객체이다.
  <br><img src="https://user-images.githubusercontent.com/26870393/181508391-55795934-8b49-4972-9a84-5befd298c451.png" width="800px"/><br>
### 3. mybatis-config
* mybatis-config.xml은 mybatis의 메인 환경 설정 파일이다. 
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!-- mybatis config 설정 파일임을 선언한다. -->
  <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
  
  <configuration>
    <!-- 필요한 설정들을 작성한다. -->
  </configuration>
  ```
* properties 요소는 외부 properties 파일의 내용을 불러올 때 사용하는 요소이다.
* properties 하위에 property 요소를 지정하여 mybatis-config.xml 사용할 값을 미리 지정할 수 있다.
  ```xml
    <properties resource="driver.properties" />

    또는

    <properties> 
      <property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
      <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
      <property name="user" value="WEB"/>
      <property name="password" value="WEB"/>
    </properties>
  ```
* properties 요소를 통해 불러온 값 또는 지정된 값을 아래와 같이 필요한 곳에서 사용할 수 있다.
  ```xml
    <dataSource type="POOLED">
      <property name="driver" value="${driver}"/>
      <property name="url" value="${url}"/>
      <property name="username" value="${username}"/>
      <property name="password" value="${password}"/>
    </dataSource>
  ```
* settings 요소는 mybatis 구동 시 선언할 설정들을 작성하는 요소이다.
  ```xml
    <!-- 참고 : http://www.mybatis.org/mybatis-3/ko/configuration.html -->
    <settings>
		  <setting name="jdbcTypeForNull" value="NULL"/>
    </settings>
  ```
* typeAliases 요소는 mybatis에서 사용할 자료형의 별칭을 선언하는 요소이다.
  ```xml
  <typeAliases>
    <typeAlias type="com.ismoon.mybatis.member.model.vo.Member" alias="Member"/>
    <typeAlias type="com.ismoon.mybatis.board.model.vo.Board" alias="Board"/>
  </typeAliases>
  ```
* Mybatis 내장 별칭 
  <table>
    <tr>
      <th>Mybatis 타입</th>
      <th> Java 자료형</th>
      <th>Mybatis 타입</th>
      <th> Java자료형</th>
    </tr>
    <tr>
      <td>_byte</td>
      <td>byte</td>
      <td>double</td>
      <td>Double</td>
    </tr>
    <tr>
      <td>_long</td>
      <td>long</td>
      <td>float</td>
      <td>Float</td>
    </tr>
    <tr>
      <td>_short</td>
      <td>short</td>
      <td>boolean</td>
      <td>Boolean</td>
    </tr>
    <tr>
      <td>_int / _integer</td>
      <td>int</td>
      <td>date</td>
      <td>Date</td>
    </tr>
    <tr>
      <td>_double</td>
      <td>double</td>
      <td>object</td>
      <td>Object</td>
    </tr>
    <tr>
      <td>_float</td>
      <td>float</td>
      <td>map</td>
      <td>Map</td>
    </tr>
    <tr>
      <td>_boolean</td>
      <td>boolean</td>
      <td>hashmap</td>
      <td>HashMap</td>
    </tr>
    <tr>
      <td>string</td>
      <td>String</td>
      <td>list</td>
      <td>List</td>
    </tr>
    <tr>
      <td>byte</td>
      <td>Byte</td>
      <td>arraylist</td>
      <td>ArrayList</td>
    </tr>
    <tr>
      <td>long</td>
      <td>Long</td>
      <td>collection</td>
      <td>Collection</td>
    </tr>
    <tr>
      <td>short</td>
      <td>Short</td>
      <td>iterator</td>
      <td>Iterator</td>
    </tr>
    <tr>
      <td>int / integer</td>
      <td>Integer</td>
      <td colspan="2"></td>
    </tr>
  </table>
* environments 요소는 mybatis에서 연동할 DataBase 정보를 등록하는 요소이다.
  ```xml
  <environments default="web">
    <environment id="web">
      <transactionManager type="JDBC"/>
      <dataSource type="POOLED">
        <property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>
        <property name="username" value="web"/>
        <property name="password" value="web"/>
      </dataSource>
    </environment>
    <!-- 여러 개의 DB를 등록하여 사용할 수 있다. -->
    <environment id="sample">
      ...
    </environment>
  </environments>
  ```
* transactionManager 요소의 타입
  * JDBC는 JDBC가 commit과 rollback을 직접 사용 가능하게 하는 타입이다.
  * MANAGED는 트랜잭션에 대해 어떠한 직접적인 영향도 행사하지 않는 타입이다.
* dataSource 요소의 타입
  <table>
    <tr>
      <th>구분</th>
      <th>POOLED</th>
      <th>UNPOOLED</th>
    </tr>
    <tr>
      <td>특징</td>
      <td>최초 Connection 객체를 생성할 때 여러 개의 Connection 객체 풀 영역에 저장해둔다.<br>Connection 객체를 생성할 때 이를 재 사용한다.</td>
      <td>Connection 객체를 별도로 저장하지 않는다.<br>객체 호출 시 매번 생성하여 사용한다.</td>
    </tr>
    <tr>
      <td>장점</td>
      <td>Connection 객체를 생성하여 DataBase와 연결하는데 걸리는 시간이 단축된다.</td>
      <td>Connection 연결이 많지 않은 코드를 작성할 때 간단하게 구현할 수 있다.</td>
    </tr>
    <tr>
      <td>단점</td>
      <td>단순한 로직을 수행하는 객체를 만들기에는 설정해야 하는 정보가 많다.</td>
      <td>매번 새로운 Connection 객체를 생성하므로 속도가 상대적으로 느리다.</td>
    </tr>
  </table>
* mappers 요소는 쿼리문과 데이터 매핑이 정의된 mapper 파일을 등록하는 요소이다.
  ```xml
  <mappers>
    <mapper resource="mappers/member/member-mapper.xml"/>
    <mapper resource="mappers/board/board-mapper.xml"/>
  </mappers>
  ```
### 4. mapper
* mapper.xml은 실행할 쿼리문과 매핑 구문을 정의해놓은 파일이다.
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!-- mybatis mapper 설정 파일임을 선언한다. -->
  <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

  <mapper namespace="memberMapper">
    <!-- 필요한 쿼리문과 매핑 구문들을 작성한다. -->
  </mapper>
  ```
* select 요소는 SQL의 조회 구문을 작성할 때 사용되는 요소이다. 
  ```xml
  <!-- 구문의 이름은 selectPerson이고 int 타입의 파라미터를 가진다. 그리고 결과 데이터는 HashMap에 저장된다. -->
  <select id="selectPerson" parameterType="int" resultType="hashmap">
    SELECT * FROM PERSON WHERE ID = #{id}
  </select>
  ```
* select 요소의 주요 속성
  <table>
    <tr>
      <th>속성</th>
      <th>내용</th>
    </tr>
    <tr>
      <td>id</td>
      <td>구문을 찾기 위해 사용될 수 있는 네임스페이스 내 유일한 구분자</td>
    </tr>
    <tr>
      <td>parameterType</td>
      <td>구문에 전달될 파라미터의 클래스 명(패키지 경로 포함)이나 별칭</td>
    </tr>
    <tr>
      <td>resultType</td>
      <td>리턴되는 타입의 패키지 경로를 포함한 전체 클래스 명이나 별칭,<br>collection인 경우 list, arraylist로 설정할 수 있다.</td>
    </tr>
    <tr>
      <td>resultMap</td>
      <td>사용할 resultMap의 id를 기술한다.</td>
    </tr>
    <tr>
      <td>flushCache</td>
      <td>이 값을 true로 설정하면 구문이 호출될 때마다 로컬, 2nd 레벨 캐시가 지워진다(flush).<br>(기본 값 : false)</td>
    </tr>
    <tr>
      <td>useCache</td>
      <td>이 값을 true로 설정하면 구문의 결과가 2nd 레벨 캐시에 저장된다.<br>(기본값 : true)</td>
    </tr>
    <tr>
      <td>timeout</td>
      <td>예외가 발생하기 전에 데이터베이스의 요청 결과를 기다리는 최대 시간을 설정한다.<br>드라이버에 따라 지원되지 않을 수 있다.</td>
    </tr>
    <tr>
      <td>statementType</td>
      <td>STATEMENT, PREPARED 또는 CALLABLE 중 하나를 선택할 수 있다.<br>Mybatis에게 Statement, PreparedStatement 또는 CallableStatement를 사용하게 한다.<br>(기본 값 : PREPARED)</td>
    </tr>
  </table>
* resultMap과 resultType은 둘 모두를 사용할 수 없으며, 둘 중 하나만 선언해야 된다.
* insert, update, delete 요소는 데이터를 변경하는 구문을 작성할 때 사용되는 요소이다.
  ```xml
  <insert id="insertMember" parameterType="Member">
    INSERT INTO MEMBER
    VALUES (
      #{id},
      #{name},
      #{password},
      #{email} 
    )
  </insert>

  <update id="updateMember" parameterType="Member">
    UPDATE MEMBER 
    SET 
      NAME = #{name},
      PASSWORD = #{password},
      EMAIL = #{email},
    WHERE ID = #{id}
  </update>
  
  <delete id="deleteMember" parameterType="int">
    DELETE FROM MEMBER WHERE NO = #{no}
  </delete>
  ```
* insert, update, delete 요소의 주요 속성
  <table>
    <tr>
      <th>속성</th>
      <th>내용</th>
    </tr>
    <tr>
      <td>id</td>
      <td>구문을 찾기 위해 사용될 수 있는 네임스페이스 내 유일한 구분자</td>
    </tr>
    <tr>
      <td>parameterType</td>
      <td>구문에 전달될 파라미터의 클래스 명(패키지 경로 포함)이나 별칭</td>
    </tr>
    <tr>
      <td>flushCache</td>
      <td>이 값을 true로 설정하면 구문이 호출될 때마다 캐시가 지워진다(flush).<br>(기본값 : false)</td>
    </tr>
    <tr>
      <td>timeout</td>
      <td>예외가 발생하기 전에 데이터베이스의 요청 결과를 기다리는 최대 시간을 설정한다.<br>드라이버에 따라 지원되지 않을 수 있다.</td>
    </tr>
    <tr>
      <td>userGeneratedKeys</td>
      <td>insert, update에만 적용되는 속성이다.<br>데이터베이스에서 내부적으로 생성한 키를 받는 JDBC getGeneratedKeys 메소드를 사용하도록 설정한다.<br>(기본 값 : false)</td>
    </tr>
    <tr>
      <td>keyProperty</td>
      <td>insert, update에만 적용되는 속성이다.<br>getGeneratedKeys 메소드나 insert 구문의 selectKey 태그의 결과가 세팅될 대상 프로퍼티 설정이다.<br>여러 개의 컬럼을 사용한다면 프로퍼티 명에 콤마를 구분자로 나열할 수 있다.</td>
    </tr>
  </table>
* resultMap 요소는 쿼리문의 조회한 결과를 객체와 매핑하기 위한 요소이다.
  ```xml
  <!-- type 속성은 실제로 구현해 놓은 자바 클래스를 지정한다. -->
  <resultMap type="Member" id="memberResultMap">
    <id property="no" column="NO"/>
    <result property="id" column="ID" />
    <result property="password" column="PASSWORD"/>
    <result property="email" column="EMAIL"/>
  </resultMap>
  ```
### 5. SqlSession 객체
#### 5.1. SqlSessionFactoryBuilder 객체
* mybatis-config.xml을 읽어들여 SqlSessionFactory 객체를 생성한다.
  <table>
    <tr>
      <th>메소드</th>
      <th>설명</th>
    </tr>
    <tr>
      <td>build(InputStream)</td>
      <td>config.xml 파일만 불러옴</td>
    </tr>
    <tr>
      <td>build(InputStream, String)</td>
      <td>config.xml 파일과 지정한 DB를 불러옴</td>
    </tr>
    <tr>
      <td>build(InputStream, Properties)</td>
      <td>config.xml 파일과 프로퍼티로 설정한 내용으로 불러옴 (“${key명 }”)</td>
    </tr>
    <tr>
      <td>build(InputStream, String, Properties)</td>
      <td>config.xml 파일과 지정한 DB,Properties 파일을 불러옴</td>
    </tr>
    <tr>
      <td>build(configuration)</td>
      <td>configuration 객체에 설정한 내용을 불러옴</td>
    </tr>
  </table>
#### 5.2. SqlSessionFactory 객체
* SqlSession 객체는 SqlSessionFactory 객체를 통해 생성한다.
  <table>
    <tr>
      <th>메소드</th>
      <th>설명</th>
    </tr>
    <tr>
      <td>openSession()</td>
      <td>기본 값을 통해 SqlSession을 생성한다.</td>
    </tr>
    <tr>
      <td>openSession(Boolean)</td>
      <td>SqlSession 생성 시 AutoCommit 여부를 true / false로 지정할 수 있다.<br>(기본 값 : true)</td>
    </tr>
    <tr>
      <td>openSession(Connection)</td>
      <td>직접 생성한 Connection 객체를 이용해 SqlSession을 생성한다.<br>(기본 값 :X)</td>
    </tr>
    <tr>
      <td>openSession(ExecutorType)</td>
      <td>쿼리를 실행할 때 PreparedStatement의 재사용 여부를 설정한다.<br>(기본 값: ExecutorType.SIMPLE)</td>
    </tr>
  </table>
#### 5.3. SqlSession 객체
* SqlSession 객체를 통해 mapper에 정의된 쿼리를 실행할 수 있다.
* SqlSession 객체는 쿼리문을 실행하기 위한 다양한 메소드를 가지고 있다.
  ```java
  session.selectOne("namespace.query_id");
  ```
* SqlSession 메소드
  <table>
    <tr>
      <th>메소드</th>
      <th>반환형</th>
      <th>설명</th>
    </tr>
    <tr>
      <td>selectOne(String mapper, Object param)</td>
      <td>Object</td>
      <td>하나의 객체만을 받고자 할 때 사용</td>
    </tr>
    <tr>
      <td>selectList(String mapper, Object param)</td>
      <td>List&lt;E&gt;</td>
      <td>결과에 대한 값을 List로 받고자 할 때 사용</td>
    </tr>
    <tr>
      <td>selectMap(String mapper, Object param,<br> String mapKey)</td>
      <td>Map&lt;K, V&gt;</td>
      <td>결과에 대한 값을 Map으로 받고자 할 때 사용<br>(마지막 인자로 키로 사용될 컬럼을 명시)</td>
    </tr>
    <tr>
      <td>insert(String mapper, Object param)</td>
      <td>int</td>
      <td>DB에 데이터를 입력하고자 할 때 사용</td>
    </tr>
    <tr>
      <td>update(String mapper, Object param)</td>
      <td>int</td>
      <td>DB의 데이터를 수정하고자 할 때 사용</td>
    </tr>
    <tr>
      <td>delete(String mapper, Object param)</td>
      <td>int</td>
      <td>DB의 데이터를 삭제하고자 할 때 사용</td>
    </tr>
  </table>
## 마이바티스 동적 쿼리
### 1. 동적 쿼리(SQL)
* 동적 쿼리는 마이바티스의 강력한 기능 중 하나이다.
* 마이바티스에서는 쿼리를 동적으로 제어할 수 있는 요소(Element)들을 제공한다.
* 동적 쿼리 요소들을 사용하여 좀 더 쉽게 쿼리를 구현할 수 있다.
### 2. if 요소
* 자바의 if 구문과 같은 역할을 하는 요소이다.
* 특정 조건을 만족할 경우 요소 안의 구문을 쿼리에 포함시키는 요소이다.
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    WHERE STATUS = 'Y'
    <if test="writer != null">
      AND WRITER = #{writer}
    </if>
  </select>
  ```
* 필요로 하는 조건이 1개 이상일 경우 if 요소를 여러 개 사용할 수 있다.
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    WHERE STATUS = 'Y'
    <if test="writer != null">
      AND WRITER = #{writer}
    </if>
    <if test="title != null">
      AND TITLE = #{title}
    </if>
  </select>
  ```
### 3. choose 요소
* 자바의 switch 구문과 같은 역할을 하는 요소이다.
* 하위 요소인 when, otherwise 요소와 함께 사용한다.
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    WHERE STATUS = 'Y'
    <choose>
      <when test="writer != null">
        AND WRITER = #{writer}
      </when>
      <when test="title != null">
        AND TITLE = #{title}
      </when>
      <otherwise>
        <!-- 위의 조건 중 하나도 만족하지 않는 경우 -->
      </otherwise>
    </choose>
  </select>
  ```
### 4. foreach 요소
* 자바의 for 구문에 해당하는 역할을 하는 요소로 배열과 컬렉션에 대한 반복 처리에 사용된다.
  ```xml
  <select>
    SELECT COUNT(*)
    FROM BOARD
    WHERE STATUS = 'Y' 
    AND TITLE IN
    <foreach item="item" collection="list" open="(" separator="," close=")">
      #{item}
    </foreach>
  </select>
  ```
* foreach 요소의 속성
  <table>
    <tr>
      <th>속성</th>
      <th>설명</th>
    </tr>
    <tr>
      <td>item</td>
      <td>반복될 때 접근 가능한 각 객체 변수</td>
    </tr>
    <tr>
      <td>index</td>
      <td>반복되는 횟수를 가리키는 변수, 0부터 순차적으로 증가</td>
    </tr>
    <tr>
      <td>collection</td>
      <td>전달받은 인자로 반복에 쓰이는 Collection 객체(List나 Array만 가능)</td>
    </tr>
    <tr>
      <td>open</td>
      <td>해당 구문이 시작될 때 삽입할 문자열</td>
    </tr>
    <tr>
      <td>separator</td>
      <td>반복되는 객체를 나열할 때 사용할 구분자</td>
    </tr>
    <tr>
      <td>close</td>
      <td>해당 구문이 종료될 때 삽입할 문자열</td>
    </tr>
  </table>
### 5. trim, where, set, bind 요소
* 동적 쿼리의 잘못된 사용 예시이다.
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    WHERE
    <if test="writer != null">
      WRITER = #{writer}
    </if>
    <if test="title != null">
      AND TITLE = #{title}
    </if>
  </select>
  ```
* if 요소의 조건들을 모두 만족하지 못했을 경우에는 아래와 같은 쿼리가 만들어진다.
  ```sql
  SELECT * FROM BOARD
  WHERE
  ```
* 두 번째 if 요소의 조건만 만족했을 경우에는 아래와 같은 쿼리가 만들어진다.
  ```sql
  SELECT * FROM BOARD
  WHERE AND TITLE = 'OOO'
  ```
#### 5.1. where 요소
* 쿼리문의 WHERE 절을 동적으로 구현할 때 사용하는 요소이다.
* 단순히 WHERE만을 추가하지만, 요소 안의 내용이 'AND'나 'OR'로 시작할 경우 'AND'나 'OR'를 제거한다. 
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    <where>
      <if test="writer != null">
        WRITER = #{writer}
      </if>
      <if test="title != null">
        AND TITLE = #{title}
      </if>
    </where>
  </select>
  ```
#### 5.2. set 요소
* UPDATE 쿼리문의 SET 절을 동적으로 구현할 때 사용하는 요소이다.
* UPDATE 하고자 하는 컬럼을 동적으로 포함시키기 위해 사용한다.
* set 요소는 SET 키워드를 붙이고 불필요한 콤마를 제거한다.
  ```xml
  <update>
    UPDATE MEMBER
    <set>
      <if test="name != null">
        NAME = #{name},
      </if>
      <if test="address != null">
        ADDRESS = #{address}
      </if>
    </set>
  </update>
  ```
#### 5.3. trim 요소
* 쿼리문의 특정 구문을 추가하거나 없앨 때 사용하는 요소이다.
* 요소 안의 쿼리문이 완성될 때 처음 시작할 단어(prefix)와 시작 시 제거해야 할 단어(prefixOverrides)를 명시하여 where 요소와 동일한 기능을 하도록 구현할 수 있다.
  ```xml
  <select>
    SELECT * 
    FROM BOARD
    <trim prefix="WHERE" prefixOverrides="AND|OR">
      <if test="writer != null">
        WRITER = #{writer}
      </if>
      <if test="title != null">
        AND TITLE = #{title}
      </if>
    </trim>
  </select>
  ```
* 요소 안의 쿼리문이 완성될 때 처음 시작할 단어(prefix)와 마지막에 제거해야 할 단어(suffixOverrides)를 명시하여 set 요소와 동일한 기능을 하도록 구현할 수 있다.
  ```xml
  <update>
    UPDATE MEMBER
    <trim prefix="SET" suffixOverrides=",">
      <if test="name != null">
        NAME = #{name},
      </if>
      <if test="address != null">
        ADDRESS = #{address}
      </if>
    </trim>
  </update>
  ```
#### 5.4. bind 요소
* 특정 문장을 미리 생성하여 변수를 만든 뒤 쿼리에 적용할 때 사용한다.
* `_parameter`를 통해 전달받은 값에 접근하여 구문을 생성할 수 있다.
  ```xml
  <select>
    <bind name="pattern" value="'%' + _parameter.getTitle() + '%'" />
    SELECT * FROM BLOG
    WHERE title LIKE #{pattern}
  </select>
  ```
