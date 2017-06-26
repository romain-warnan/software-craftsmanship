<!-- .slide: data-background-image="images/swcraftmanship.jpg" data-background-size="1200px" class="chapter" -->
## 1
### Manifeste de l’artisanat du logiciel

---

<!-- .slide: class="slide" -->
### Manifeste

<blockquote>
En tant qu’aspirants Artisans du Logiciel, nous relevons le niveau du développement professionnel de logiciels par la pratique et en aidant les autres à acquérir le savoir-faire. Grâce à ce travail, nous avons appris à apprécier :
</blockquote>

<blockquote>
<table>
<tr><td>Pas seulement des logiciels opérationnels,</td><td><strong class="fragment">mais aussi des logiciels bien conçus.</strong></td></tr>
<tr><td>Pas seulement l’adaptation aux changements,</td><td><strong class="fragment">mais aussi l’ajout constant de la valeur.</strong></td></tr>
<tr><td>Pas seulement les individus et leurs interactions,</td><td><strong class="fragment">mais aussi une communauté de professionnels.</strong></td></tr>
<tr><td>Pas seulement la collaboration avec les clients,</td><td><strong class="fragment">mais aussi des partenariats productifs.</strong></td></tr>
</table>
</blockquote>

<blockquote>
C’est à dire qu’en recherchant les éléments de gauche, nous avons trouvé que les éléments de droite sont indispensables.
</blockquote>

<small>
© 2009, les sous-signés.
Cette déclaration peut être copiée librement, quelle que soit la forme, mais seulement dans sa totalité, y compris cette remarque.
</small>

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