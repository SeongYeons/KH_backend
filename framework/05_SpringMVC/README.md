## 스프링 MVC
### 1. 스프링 MVC
* 스프링 프레임워크에서는 클라이언트의 화면을 표현하기 위한 뷰(View) 영역과 서비스 수행을 위한 비지니스 로직 영역을 나누는 MVC2 패턴을 지원한다.
* 또한 모델(Model), 뷰(View), 컨트롤러(Controller) 사이의 의존 관계를 DI 컨테이너에서 관리하여 유연한 웹 애플리케이션을 쉽게 구현 및 개발할 수 있다.
  <table>
    <tr>
      <td>@Controller</td>
      <td>웹 애플리케이션에서 웹 요청과 응답을 처리하는 빈을 생성한다.</td>
    </tr>
    <tr>
      <td>@Service</td>
      <td>웹 애플리케이션에서 비즈니스 로직을 처리하는 빈을 생성한다.</td>
    </tr>
      <tr>
      <td>@Repository</td>
      <td>웹 애플리케이션에서 영속성(파일, 데이터베이스) 처리를 위한 빈을 생성한다.</td>
    </tr>
  </table>
### 2. 스프링 MVC 요청 처리 과정 
* 디스패처 서블릿(DispatcherServlet)은 사용자의 요청을 받는 프론트 컨트롤러 서블릿이다.
* 핸들 매핑(HandlerMapping)은 요청 URL을 바탕으로 적절한 컨트롤러를 선택하는 역할을 한다.
* 컨트롤러(Controller)는 요청을 처리하기 위한 빈이다. (클라이언트의 요청을 처리 후 반환한다.)
* 뷰 리졸버(ViewResolver)는 디스패처 서블릿에서 전달해 주는 뷰의 이름과 실제로 구현된 뷰를 매핑해준다.
  <br><img src="https://user-images.githubusercontent.com/26870393/182376640-202a56b6-f396-464f-b4dc-6075b0b824d4.png" width="800px"/><br>