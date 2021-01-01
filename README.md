# rest-api-with-spring
인프런 백기선님의 강의 (https://www.inflearn.com/course/spring_rest-api/dashboard)

controller 에서 repository 를 사용하고 
@WebMvcTest 만 있는 EventControllerTests에서 테스트를 실행하면 repository가 Bean으로 등록되지 않았다는 에러가 나온다.  

왜냐하면 @WebMvcTest는 웹용 슬라이스 테스트이기 때문에 repository 를 Bean으로 등록해주지 않는다. 
그래서 @MockBean을 이용해서 repository 를 등록해준다. 

이러면 또 다른 에러가 나는데, 이 repository는 Mocking된 것이기 때문에 save 등 어떤 동작을 수행해도 결과가 null로 나온다. 
우리는 객체에서 id를 가져오라고 하고 있기 때문에, NPE가 발생한다.

이를 위해, 실제로 어떻게 동작하라고, save를 했을 떄 어떻게 동작하라고 지정해주어야 한다. 
```java
Mockito.when(eventRepository.save(event)).thenReturn(event);
```
id도 넣어주어야 한다. 

---

modelMapper 적용했더니 다시 NPE 발생.
이유는 controller 에서 저장하려고 하는 객체는 modelMapper 를 통해 새로 만든 객체. 
그래서 test에서 만든 Event객체와 같지 않아. 그래서 repository mocking이 적용되지 않았고, 기본적으로 제공하는 null이 넘어갔고, 그래서 newEvent.getId() 할 때 NPE 가 발생한 것.

해결해 주기 위해서 mock을 안함. 그럴라면 슬라이스 테스트가 아니여야 함. @SpringBootTest 적용
이제 실제 repository를 사용해서 동작 -> 그러면 test에 넣어준 값(event.build로 만든)들은 무시가 됨 .

---

옳지 않은 값을 주면 bad request 응답.

spring boot 에서 제공하는 설정

```properties
spring.jackson.deserialization.fail-on-unknown-properties=true
```