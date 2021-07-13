# 예약 서비스

BoostCourse의 과제로 진행한 프로젝트입니다. 아무것도 없는 상태에서 만들기 시작하였으며, Web API 명세서를 참고하여 Json을 반환하는 형태로 진행하였습니다. 



## 메인, 상세보기 관련 Web API 만들기

예약 서비스 메인 페이지에서 사용하는 Web API와 예약 메인 페이지에서 전시 상품을 클릭했을 때 보여지는 상세 페이지와 관련된 Web API를 구현하였습니다.

- 아무것도 없는 상태에서부터 만들기 시작하였기 때문에 `WebApplicationInitializer / AbstractAnnotationConfigDispatcherServletInitializer`의 차이와 Maven Project 기본적인 틀 만드는 법을 알게 되었습니다. 
  - [Maven Project MVC 기본적인 틀 만들기 포스트 링크](https://dev-splin.github.io/spring/Spring-Maven-Project-MVC-Create-Basic-Frame/)
  - [WebApplicationInitializer / AbstractAnnotationConfigDispatcherServletInitializer 포스트 링크](https://dev-splin.github.io/spring/Spring-WebApplicationInitializer,AbstractAnnotationConfigDispatcherServletInitializer/)
- 데이터베이스를 설정하면서 `Properties`와 `Environment` 사용법을 익힐 수 있었습니다.
  - [Properties / Environment / Profile 포스트 링크](https://dev-splin.github.io/spring/Spring-Properties-Environment-Profile/#profile-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0)
- Web API 명세서를 참고하여 개발하는 방법을 익힐 수 있었습니다.
- MockMvc와 Swagger를 사용하여 테스트를 진행하며 사용법을 익힐 수 있었고, 이 과정에서 `Given-When-Then` 패턴에 대해 알게 되었습니다. 
  - [Given-When-Then Pattern 포스트 링크](https://dev-splin.github.io/spring/Spring-Given-When-Then-Pattern/)
- 자체적으로 Git flow를 사용하여 branch를 이용하고, Merge, conflict처리등에 익숙해 질 수 있었습니다.
- **코드 리뷰**
- 기존에는 눈으로 데이터를 확인하는 방식으로 단위 테스트를 진행하였는데, 코드 리뷰를 통해 로직을 검증하는 방법으로 바꾸었습니다.
  - 기존에 SQL 쿼리문을 서브 쿼리와, left join을 남발하여 사용하였는데, 코드 리뷰를 통해 불필요한 서브 쿼리 및 left join을 지양하게 되었습니다.
  
- 기존에는 예외처리를 진행하지 않았는데, 코드 리뷰를 통해 예외처리를 해주었지만, 아직은 적절한 예외처리가 어려운 것 같습니다.





## 로그인, 로그아웃 및 예약 관련 Web API 만들기

Spring Security를 이용한 로그인, 로그아웃 기능과 로그인 후 접근할 수 있는 예약 페이지에서의 예약하기, 예약한 상품 보기, 예약 취소 Web API를 구현하였습니다.

- **Spring Security를 이용해 로그인 및 로그아웃을 구현**하는데 익숙해질 수 있었고, **@AuthenticationPrincipal** 어노테이션을 이용해 현재 로그인한 유저의 정보를 이용하는 방법을 알게 되었습니다.

- API를 구현하면서 **생성자 주입을 사용해야 하는 이유**와 **Entity,VO,DTO의 차이**를 알게 되었습니다.
  - [생성자 주입을 사용해야하는 이유 포스트 링크](https://dev-splin.github.io/spring/Spring-Constructor-Injection/)
  - [Entity, VO, DTO의 차이 포스트 링크](https://dev-splin.github.io/spring/Spring-Entity-DTO-VO/)

- Entity, VO, DTO등을 쉽게 만들 수 있게 도와주는 **Lombok의 사용법**을 익힐 수 있었습니다.
  - [Lombok의 사용법 및 주의점 포스트 링크](https://dev-splin.github.io/spring/Spring-Lombok/)

- 객체 끼리의 Mapping을 도와주는 **MapStruct 사용법**을 익힐 수 있었고, MapStruct 의존성 설정 중에 **pluginManagement와 plugins의 차이와 주의할 점**을 알게 되었습니다.
  - [MapStruct의 사용법 및 ModelMapper와의 비교 포스트 링크](https://dev-splin.github.io/spring/Spring-ModelMapper,MapStruct/)
  - [pluginManagement와 plugins의 차이와 주의할 점 포스트 링크](https://dev-splin.github.io/spring/Spring-pluginManagement,plugins/)

- Controller에서 Json으로 데이터를 주고받을 때(직렬화, 역직렬화) 사용하는 **Jackson 어노테이션의 사용법**을 익힐 수 있었습니다.
  - [Jackson Annotation 사용법 포스트 링크](https://dev-splin.github.io/spring/Spring-Jackson-Annotation/)

- 데이터의 값이 유효한지 검사해주는 **유효성 검사(Validation) 방법** 익힐 수 있었습니다.
  - [유효성 검사(Validation) 방법 및 Custom Annotation 포스트 링크](https://dev-splin.github.io/spring/Spring-Validation/)

- Controller 반환 타입을 Headers와 상태코드가 포함된 **ResponseEntity로 사용하는 방법**을 익힐 수 있었습니다.
  - [ResponseEntity를 사용해야 하는 이유 포스트 링크](https://dev-splin.github.io/spring/Spring-ResponseEntity/)

- 유효성 검사를 진행하면서, Exception Handler를 이용해 **Exception Handling을 경험**하였습니다.
  - [Exception 전략 참고 사이트](https://cheese10yun.github.io/spring-guide-exception/)

- **코드 리뷰**
  - 메서드명을 작성할 때 알아보기 쉽게 prefix 작성 시 주의를 기울여야 하고 **동사 + 명사**로 작성해야 한다는 것을 알게 되었습니다.
  - 예외처리를 할 때, **공통된 error코드 유형**을 정하고 **Exception Handler**를 통해 결과값이 해당 error 코드가 포함되도록 구현하는 방식을 알게 되었습니다.
  - ResponseEntity를 사용해 Http 규약을 지키면서 값을 반환할 때, **상태 코드 처리에 대해 고민할 필요성**이 있습니다.
  - **Custom Annotation**과 **Custom Exception**에 대한 경험이 필요합니다.