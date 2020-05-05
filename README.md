RestTemplate 살펴보기
====

## 프로젝트 확인


## 실행

### 테스트 서버 실행하기
```bash
$ ./gradlew :server:bootRun
```

### RestTemplate 예제

## 참고
- `RestTemplate` API Doc: [https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html)
- `RestTemplate` Source:  [https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/main/java/org/springframework/web/client/RestTemplate.java](https://github.com/spring-projects/spring-framework/blob/master/spring-web/src/main/java/org/springframework/web/client/RestTemplate.java)
- `RestTemplateBuilder` API Doc: [https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/client/RestTemplateBuilder.html](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/web/client/RestTemplateBuilder.html)
- `ClientHttpRequestInterceptor` API Doc: [https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/javadoc-api/org/springframework/http/client/ClientHttpRequestInterceptor.html?is-external=true](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/javadoc-api/org/springframework/http/client/ClientHttpRequestInterceptor.html?is-external=true)
- [https://docs.spring.io/spring-android/docs/current/reference/html/rest-template.html](https://docs.spring.io/spring-android/docs/current/reference/html/rest-template.html)
- [https://sjh836.tistory.com/141](https://sjh836.tistory.com/141)
- [https://multifrontgarden.tistory.com/249](https://multifrontgarden.tistory.com/249)
    - RestTemplate 에서 Connection pool 에 대한 설정을 조금 더 이해해보자.
- [https://gunju-ko.github.io/http/httpclient/2019/01/23/Apache-HttpClient.html](https://gunju-ko.github.io/http/httpclient/2019/01/23/Apache-HttpClient.html)
- [https://tomining.tistory.com/164](https://tomining.tistory.com/164)
- [http://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/connmgmt.html](http://hc.apache.org/httpcomponents-client-4.5.x/tutorial/html/connmgmt.html)
- [https://taes-k.github.io/2019/11/27/spring-java-connections/](https://taes-k.github.io/2019/11/27/spring-java-connections/)
- [https://tech.kakao.com/2016/04/21/closewait-timewait/](https://tech.kakao.com/2016/04/21/closewait-timewait/)
- [https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/conn/PoolingHttpClientConnectionManager.html](https://hc.apache.org/httpcomponents-client-ga/httpclient/apidocs/org/apache/http/impl/conn/PoolingHttpClientConnectionManager.html)