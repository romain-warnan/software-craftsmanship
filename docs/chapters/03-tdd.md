<!-- .slide: data-background-image="images/swcraftmanship.jpg" data-background-size="100%" class="chapter" -->
## 3
### Développement piloté par les tests

===

<!-- .slide: class="slide" -->
### Principe 

Écrire et exécuter fréquemment des tests et avancer à petits pas

 1. Écrire un test pour une nouvelle fonction
  - le test doit échouer
  - au début, il ne compile même pas
 
 2. Implémenter la fonction pour que le test passe
 
 3. _Refactorer_ tant que nécessaire
  - les tests assurent alors la non-régression
  
 4. Retourner à l’étape 1.

Le codage se fait à un rythme cadencé

===

<!-- .slide: class="slide" -->
### Démonstration du principe
 
Cas simplifié, mais réel :

 - créer un flux RSS contenant les cinq dernières publications de l’Insee

Trois étapes

 1. Récupérer les 5 dernières publications dans la base de données
  - base de test HSQLDB
 
 2. Convertir la liste de 5 publications en objet de type `FluxRss`
  - utilisation d’un _builder_
  
 3. Création d’un contrôleur retournant le flux RSS
  - sérialisé sous forme de XML

===

<!-- .slide: class="slide" -->
### Rapide présentation du code existant 

<iframe width="640" height="360" src="https://www.youtube.com/embed/KHx9S9_UFLs?rel=0" frameborder="0" allowfullscreen></iframe>

===

<!-- .slide: class="slide" -->
### Récupérer les 5 dernières publications dans la base de donnée

<iframe width="640" height="360" src="https://www.youtube.com/embed/dNPezd7w43Q?rel=0" frameborder="0" allowfullscreen></iframe>

===

<!-- .slide: class="slide" -->
### Convertir la liste de 5 publications en objet de type `FluxRss`

<iframe width="640" height="360" src="https://www.youtube.com/embed/JtLnFM7rRYc?rel=0" frameborder="0" allowfullscreen></iframe>

===

<!-- .slide: class="slide" -->
### Création d’un contrôleur retournant le flux RSS

<iframe width="640" height="360" src="https://www.youtube.com/embed/Yaxd2BOeHkI?rel=0" frameborder="0" allowfullscreen></iframe>
