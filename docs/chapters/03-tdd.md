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

Le codage se fait à un rythme cadancé