# Spring Security Filters



## spring security在启动的时候默认加载的15个过滤器



<img src="https://blog-images-1309758663.cos.ap-nanjing.myqcloud.com/202304211826194.png" alt="image-20230421182602041" style="zoom:50%;" />

> 我们的登录页面就是通过 过滤器6：`DefaultLoginPageGeneratingFilter`生成的登录页

## Security Filters

> 在Spring Security中给我们提供了哪些过滤器呢？

[官网查看](https://docs.spring.io/spring-security/reference/5.7.6/servlet/architecture.html#servlet-security-filters)

| 过滤器                                    | 过滤器作用                                              | 默认是否加载 |
| ----------------------------------------- | ------------------------------------------------------- | ------------ |
| ChannelProcessingFilter                   | 过滤请求协议HTTP、HTTPS                                 | NO           |
| `WebAsyncManagerIntegrationFilter`        | 将WebAsyncManger与SpringSecurity上下文进行集成          | YES          |
| `SecurityContextPersistenceFilter`        | 在处理请求之前将安全信息加载到//SecurityContextHolder中 | YES          |
| `HeaderWriterFilter`                      | 处理头信息加入相应中                                    | YES          |
| CorsFilters                               | 处理跨域问题                                            | NO           |
| `CsrfFilters`                             | 处理CSRF攻击                                            | YES          |
| `LogoutFilter`                            | 处理注销登录                                            | YES          |
| OAuth2AuthorizationRequestRedirectFilter  | 处理OAuth2认证重定向                                    | NO           |
| Saml2WebSsoAuthenticationRequestFilter    | 处理SAML认证                                            | NO           |
| X509AuthenticationFilter                  | 处理X509认证                                            | NO           |
| AbstractPreAuthenticatedProcessingFilter  | 处理预认证问题                                          | NO           |
| CasAuthenticationFilter                   | 处理CAS单点登录                                         | NO           |
| OAuth2LoginAuthenticationFilter           | 处理OAuth2认证                                          | NO           |
| Saml2WebSsoAuthenticationFilter           | 处理SAML认证                                            | NO           |
| `UsernamePasswordAuthenticationFilter`    | 处理表单登陆                                            | YES          |
| OpenIDAuthenticationFilter                | 处理OpenID认证                                          | NO           |
| `DefaultLoginPageGeneratingFilter`        | 配置默认登录页面                                        | YES          |
| `DefaultLogoutPageGeneratingFilter`       | 配置默认注销页面                                        | YES          |
| ConcurrentSessionFilter                   | 处理Session有效期                                       | NO           |
| DigestAuthenticationFilter                | 处理HTTP摘要认证                                        | NO           |
| BearerTokenAuthenticationFilter           | 处理OAuth2认证的Access Token                            | NO           |
| `BasicAuthenticationFilter`               | 处理HttpBasic登录                                       | YES          |
| `RequestCacheAwareFilter`                 | 处理请求缓存                                            | YES          |
| `SecurityContextHolderAwareRequestFilter` | 包装原始请求                                            | YES          |
| JaasApiIntegrationFilter                  | 处理JAAS认证                                            | NO           |
| RememberMeAuthenticationFilter            | 处理RememberMe登录                                      | NO           |
| `AnonymousAuthenticationFilter`           | 配置匿名认证                                            | YES          |
| OAuth2AuthorizationCodeGrantFilter        | 处理OAuth2认证中授权码                                  | NO           |
| `SessionManagementFilter`                 | 处理Session并发问题                                     | YES          |
| `ExceptionTranslationFilter`              | 处理认证、授权中的异常                                  | YES          |
| `FilterSecurityInterceptor`               | 处理授权相关                                            | YES          |
| SwitchUserFilter                          | 处理账户切换                                            | NO           |

> 可以看出，Spring Security提供了`30`多个过滤器。默认情况下SpringBoot在对SpringSecurity进行自动化配置的时候，会创建一个名为`SpringSecurityFilterChain`的过滤器，并注入到Spring容器中，这个过滤器将负责所有的安全管理器，包括认证、授权、重定向到登录页面等。

## 流程分析

> 这个流程简化了许多，目的是为了探究怎么重定向到默认登陆页面

![spring-security-login-page](https://blog-images-1309758663.cos.ap-nanjing.myqcloud.com/202304211934929.jpg)







