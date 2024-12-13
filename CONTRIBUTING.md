# Guide de Contribution

Lorsque vous contribuez à ce dépôt, veuillez d'abord discuter de la modification que vous souhaitez apporter via une issue,
email, ou toute autre méthode avec les propriétaires de ce dépôt (Voir README) avant de faire un changement. 

## Workflow Git

### Principes Généraux
- Nous utilisons le Git Flow comme modèle de branching
- Aucun push direct sur les branches `main` et `develop`
- Toute modification passe par une pull request

### Branches
- `main` : Version stable de production
- `develop` : Branche de développement principale
- `feature/` : Nouvelles fonctionnalités
- `fix/` : Corrections de bugs
- `release/` : Préparation de nouvelles versions

### Création de Branches
```bash
# Exemple de création de branche de fonctionnalité
git checkout -b feature/nouvelle-fonctionnalite develop
```

## Règles de Commit

### Convention de Nommage
- Commits en anglais
- Message clair et concis
- Format : `<type>: <description>`

### Types de Commits
- `feat:` Nouvelle fonctionnalité
- `fix:` Correction de bug
- `docs:` Modifications de documentation
- `style:` Formatage de code
- `refactor:` Refactorisation de code
- `test:` Ajout/modification de tests
- `chore:` Tâches de maintenance

### Exemple de Commit
```
feat: add user authentication module
```

## Pull Requests

### Processus
1. Créer une branche depuis `develop`
2. Implémenter la fonctionnalité/correction
3. Tester localement
4. Soumettre une pull request
5. Attendre la revue et l'approbation

### Critères de Revue
- Code propre et lisible
- Tests unitaires
- Documentation à jour
- Pas de régressions

## Communication
- Utiliser les issues GitHub pour le suivi
- Slack/Discord pour communication rapide
- Réunions d'équipe hebdomadaires

## Code de Conduite
- Respect mutuel
- Communication professionnelle
- Ouverture aux retours constructifs