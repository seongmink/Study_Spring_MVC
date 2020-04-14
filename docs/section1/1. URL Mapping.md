# URL Mapping

### Servlet/JSP URL 주소

- 사용자가 서버에 접속해서 서비스를 받기 위해 입력하는 주소를 URL이라고 부른다.
- URL 주소는 여러 의미를 가지고 있는 값들로 구성된다.
- 프로토콜://도메인주소(IP):포트번호/경로1/경로2/경로3/...
  - 프로토콜 : 서버와 클라이언트간의 통신을 위한 약속(생략시 http)
  - 도메인 주소(IP 주소) : IP 주소는 같은 네트워크 망에서 컴퓨터를 구분하기 위해 제공되는 숫자로 구성된 고유 주소이다. 인터넷 망은 연결된 컴퓨터는 전 세계에서 유일한 주소를 할당 받고 공유기 등에 연결된 컴퓨터는 공유기안에서 유일한 주소를 할당받는다.(사설 IP) 그러나 숫자는 사람이 외우기 어려워 도메인 주소라는 것을 만들어 제공한다. 도메인 주소는 IP주소로 변환되어 쉽게 접근이 가능하도록 한다.
  - 포트번호 : 1부터 65535번 까지로 구성된 숫자. 컴퓨터 내에서 프로그램을 구분하기 위해 사용한다.(생략시 80)
  - 경로1/경로2/경로3... : 여기서 부터는 서버 혹은 개발 방식이나 분야에 따라 다르게 해석된다. Servlet/JSP 에서는 첫번째 경로는 Context Path라고 부른다. 하나의 서버에서 각 웹 애플리케이션을 구분하기 위해 지정되는 이름이며 폴더의 이름이 Context Path가 된다. 그 이후 경로는 하위 경로가 된다.

### SpringMVC에서의 주소

- Spring MVC에서는 Context Path 다음에 나오는 주소는 실제 물리적인 경로와 다르게 지정할 수 있다.

  ```java
  @Controller
  public class TestController {
  	
  	@RequestMapping(value = "/test1", method = RequestMethod.GET)
  	public String test1() {
  		return "test1";
  	}
  }
  ```

- 하위 경로

  ```java
  @Controller
  public class Sub1Controller {
  	
  	@RequestMapping(value = "/sub1/test3", method = RequestMethod.GET)
  	public String sub1Test3() {
  		return "sub1/test3";
  	}
  	
  	@RequestMapping(value = "/sub1/test4", method = RequestMethod.GET)
  	public String sub1Test4() {
  		return "sub1/test4";
  	}
  }
  ```

- 하위 경로 통합

  ```java
  @Controller
  @RequestMapping("/sub2")
  public class Sub1Controller {
  	
  	@RequestMapping(value = "/test3", method = RequestMethod.GET)
  	public String test5() {
  		return "sub2/test5";
  	}
  	
  	@RequestMapping(value = "/test4", method = RequestMethod.GET)
  	public String test6() {
  		return "sub2/test6";
  	}
  }
  ```

RequestMapping 어노테이션으로 요청 주소 처리가 가능하다
