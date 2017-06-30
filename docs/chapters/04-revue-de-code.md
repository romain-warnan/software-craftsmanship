<!-- .slide: data-background-image="images/swcraftmanship.jpg" data-background-size="100%" class="chapter" -->
## 4
### Revue de code

===

<!-- .slide: class="slide" -->
### Objectifs de la revue de code
 
Comparaison avec un article de presse
 - fond : le code fonctionne correctemment
 - forme : le code est clair, lisible et respecte les standards
 
Bénéfice principal
 - détecter les défauts
 - efficacité supérieure à celle des tests

Autres bénéfices
 - améliorer la qalité du logiciel
 - partager de connaissance fonctionnelle (« propriété collective du code »)
 - apprendre : former les plus jeunes, les derniers arrivés

===

<!-- .slide: class="slide" -->
### Deux types de revues de code
 
 1. Revue de code collective
 2. Revue de code par un pair

Détection des défauts
 - pas de correction en séance
 - une minute maximum à chaque défaut

Code sélectionné et communiqué à l’avance

Statut et suivi
 - le code revu est acceptée ou rejeté
 - les défauts retenus sont enregistrés et leur correction est vérifiée

===

<!-- .slide: class="slide" -->
### La revue de code collective

Temps et périmètre limité
 - 1h30 maximum, une fois toutes les deux semaines
 - 300 lignes de code par heure
 
Participants
 - l’auteur du code
 - plusieurs relecteurs, dont…
 - un modérateur
 - un scribe
 - un gardien du temps
 
Sélection du code
 - code complexe, nouveau concept, qui fait peur, sujet à regressions…

===

<!-- .slide: class="slide" -->
### La revue de code par un pair

En binôme
 - d’abord l’auteur présente le code
 - ensuite le relecteur navigue dans le code

Périmètre
 - une seule fonctionnalité
 - dès que le développement est terminée
 
Systématique
 - revue est systématique et obligatoire
 - rajouter une colonne entre « en cours » et « en recette »

Outillée
 - utiliser le _diff_
 - outils (Gerrit, Github, Gitlab…)
