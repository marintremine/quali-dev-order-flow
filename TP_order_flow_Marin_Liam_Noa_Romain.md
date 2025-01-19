# TP Exercice 1: Analysez l'application 

## Membre du groupe 
- Liam SOTIER : 
  - [@sotier.liam (Private GitHub)](https://github.com/LiamSottier)
- Noa Jacquet :
  - [@jacquet.noa (Private GitHub)](https://github.com/NoaJacquet)
- Marin TREMINE : 
  - [@tremine.marin (Private GitHub)](https://github.com/marintremine)
- Romain MECHAIN : 
  - [@mechain.romain (Private GitHub)](https://github.com/RomainMechain)
- Lien vers le git du projet : 
    - [@OrderFlow](https://github.com/marintremine/quali-dev-order-flow/tree/main)

## Tâche 1 : Ségrégation des responsabilités 

### 1: Quels sont les principaux domaines métiers de l'application Order flow ?

Dans les domaines métier de l'application Order flow, on retrouve:

Les domaines principaux : Rreprésentant les fonctionnalité qui demarquent l'application des autres applications.
- Le panier d'achat 
- La gestion des commandes

Mais aussi des domaines de support : permettant de supporter les domaines principaux
- Regidtre des produits 
- Catalogue de produits
- Gestion des stocks
- Gestion des clients

Et enfin des domaines génériques : Qui sont des domaines qui sont commun à grand nombre d'applications
- Notification
- Sourcing d'événements
- Monnaie

### 2: Comment les microservices sont-ils conçus pour implémenter les domaines métiers ?

Il y a plusieurs raisons pour lesquelles les microservices sont conçus pour implémenter les domaines métiers : 

- La scalabilité : Les microservices permettent de scaller les services de manière indépendante, notamment en choisissant des nombres d'instances en fonctions des besoins de chaque service.

- La réutilisation : Les microservices permettent de réutiliser les services dans d'autres applications.

- Le debugage : Les microservices permettent de débugger les services de manière indépendante.

Il faut aussi noté que l'on utilise différents domaines pour séparer la lecture et l'écriture.

### 3: Quelles sont les responsabilités des conteneurs de code ? 

- apps/of-api-gateway : Permet de recevoir les requêtes HTTP et de les rediriger vers le message broker.

- pps/of-product-registry-microservices/product.registry : Permet de gérer les requetes d'ecriture sur les produits.

- apps/of-product-registry-microservices/product.registry.read : Permet de gérer les requetes de lecture sur les produits.

On a donc l'api-gateway qui permet de rediriger les requetes vers le message broker, qui va donc centraliser les messages et faire appelle au service correspondant, independament des autres. 

- libs/event-sourcing : Permet de garder un historique des evenements, notament pour pouvoir retracer ce qui s'est passé en cas de problème. Permet de rejouer les evenement pour comprendre l'erreur. 

- libs/published-language : Il s'agit de l'endroit ou l'on définit tout les objets en fonction du contexte, pour avoir un langage commun entre les services.

## Tâche 2 : Questions 

### 1: Quels sont les concepts principaux utilisés dans l'application Order flow ?

On retrouve plusieurs concepts principaux dans l'application Order flow :

- Quarkus: Framework applicatif
- PulsarAppache : Ordonanceur
- MangoDB : Persistance des données
- Graddle : Gestionnaire de dépendances

### 2: Comment les concepts principaux sont-ils implémentés dans les microservices ?

Répondu dans la tâche 1

### 3: Que fait la bibliothèque libs/event-sourcing ? Comment est-elle utilisée dans les microservices (relation entre métier et structure du code) ?

La bibliothèque libs/event-sourcing permet de garder un historique des événements, notament pour pouvoir retracer ce qui s'est passé en cas de problème. Permet de rejouer les événements pour comprendre l'erreur.
Cela permet une materialisation de la relation métier.

### 4: Comment l'implémentation actuelle de l'event-sourcing assure-t-elle la fiabilité des états internes de l'application ?

Event-sourcing : Paradigme de prommation se basant sur les événements. 

## Tache 3 : Identifier les problèmes de qualité 

### SonarLint : 

**Exemple concret de problèmes de qualité :**

- ProducIdTest.java : `Remove this 'public' modifier.sonarlint(java:S5786)` : Les méthodes et les classes sont en public alors que cela n'est pas utile, il faut donc retirer le mot clé "public". 
- GetProducts.java : Sur la fonction méthode GetProducts : `Add a nested comment explaining why this method is empty, throw an UnsupportedOperationException or complete the implementation.` : Il faut rajouter un commentaire pour expliquer pourquoi le constructeur de la classe est vide. Dans le cas ou il est vide, on peut même le supprimer. 
- ProductUpdated.java : 
    - Dans la declaration de la constante : `Reorder the modifiers to comply with the Java Language Specification.`, il faut réorganiser l'ordre des modifiers, ainsi on aura `public static final`

**Problèmes de qualité identifiés :**

- Manque des javaDoc
- Manque test unitaire et d'intégration 
- Eviter les accès en public, les structure interne n'ont pas besoin d'etre public (exemple fichier *Entity), cependant pas pour la classe public car le fait que cela soit en public est conseillé par le framework qu'elle utilise -> Utilisation de record au lieu des classes 
- Utilisation d'exception bien précise pas des général -> Pas en utiliser de trop car c'est très lourd 
- ProductRegistryCommandConsumer : Ligne 76 et 80 gère les message. Si il y a une erreur (ligne 80), on relance toujours le message pour le faire repasser plus tard. Cependant dans le cas d'une erreur métier cela n'est pas pertinent car peu importe le nombre d'essaie, cela a peu de chance de finir par fonctionner. Il faut donc que cela renvoie un mesage à l'API qui va donc informer l'utilisateur. 
- C'est le micro-service qui renvoit le message alors que ca devrait être la lecture.  