<!-- .slide: data-background-image="images/swcraftmanship.jpg" data-background-size="1200px" class="chapter" -->
## 1
### Introduction

---

<!-- .slide: class="slide" -->
### Définition
Spring core : conteneur qui implémente le *pattern* «&nbsp;inversion de contrôle&nbsp;» (IoC)

Définitions des objets (*bean*)
 - XML : `applicationContext.xml`
 - Annotations
  - Stéréotypes : `@Component`, `@Service`, `@Repository`, `@Controller`…
  - Injection : `@Autowired`, `@Resource`, `@Value`…
  - Configuration : `@Configuration`

---

<!-- .slide: class="slide" -->
### Spring core
Au démarrage de l’application, chargement du contexte
Web : *listener*
```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```
Batch : de manière explicite en Java
```java
try(AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
    Service service1 = (Service) context.getBean("beanName");
    Service service2 = context.getBean(Service.class);
    Service service3 = context.getBean("beanName", Service.class);
}
```