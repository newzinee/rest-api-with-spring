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