--- French README ---

# GestionEnseignants 👨‍🏫

[![Licence](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.java.com/)
[![Statut](https://img.shields.io/badge/status-L2%20Project-green)](https://github.com/N1N0u/GestionEnseignants)

> Projet universitaire — Licence
> Système complet de gestion des enseignants pour les établissements éducatifs.

## 📋 Table des matières

* [Aperçu](#aperçu)
* [Fonctionnalités](#fonctionnalités)
* [Technologies](#technologies)
* [Installation](#installation)
* [Utilisation](#utilisation)
* [Structure du projet](#structure-du-projet)
* [Contributions](#contributions)
* [Licence](#licence)
* [Contact](#contact)

## 🎯 Aperçu

**GestionEnseignants** est une application de bureau conçue pour simplifier la gestion des enseignants, des emplois du temps, des cours et des tâches administratives dans les établissements éducatifs. Développée comme projet académique de deuxième année (L2), elle illustre la mise en pratique de la programmation orientée objet et de la gestion de base de données.

## ✨ Fonctionnalités

### Fonctionnalités principales

* 👤 **Gestion des profils enseignants** – Ajouter, modifier, supprimer et consulter les profils détaillés
* 📚 **Attribution de cours** – Assigner des cours aux enseignants et gérer les emplois du temps
* 📅 **Gestion des emplois du temps** – Création et gestion des horaires de cours
* 🔍 **Recherche & Filtrage** – Recherche avancée pour accéder rapidement aux données
* 📊 **Rapports** – Générer des rapports sur la charge des enseignants et la distribution des cours

### Fonctionnalités administratives

* 🔐 **Authentification utilisateur** – Système sécurisé avec contrôle des rôles
* 📝 **Export de données** – Exporter vers PDF et Excel
* 🗄️ **Intégration base de données** – Support MySQL/PostgreSQL pour stockage persistant

## 🛠️ Technologies

| Catégorie       | Technologie             |
| --------------- | ----------------------- |
| Langage         | Java 17+                |
| GUI             | JavaFX / Swing          |
| Base de données | MySQL / PostgreSQL      |
| Outils de build | Maven / Gradle          |
| IDE             | IntelliJ IDEA / Eclipse |
| Versionning     | Git & GitHub            |

## 🚀 Installation

### Prérequis

* JDK 17 ou supérieur
* MySQL 8.0+ ou PostgreSQL 13+
* Maven 3.8+ ou Gradle 7+

### Étapes

1. **Cloner le dépôt**

```bash
git clone https://github.com/N1N0u/GestionEnseignants.git
cd GestionEnseignants
```

2. **Configurer la base de données**

* Créer une base nommée `gestion_enseignants`
* Modifier les identifiants dans `src/main/resources/config.properties`

```
db.url=jdbc:mysql://localhost:3306/gestion_enseignants
db.username=your_username
db.password=your_password
```

3. **Construire le projet**

```
# Avec Maven
mvn clean install
# Avec Gradle
gradle build
```

4. **Lancer l’application**

```
# Avec Maven
mvn javafx:run
# Ou lancer le JAR directement
java -jar target/GestionEnseignants-1.0.jar
```

## 💻 Utilisation

**Premier lancement**

1. Lancer l’application
2. Se connecter avec les identifiants par défaut :

```
Username: admin
Password: admin123
```

3. Changer le mot de passe par défaut immédiatement pour la sécurité

**Gestion des enseignants**

1. Naviguer vers `Enseignants → Ajouter`
2. Remplir les informations personnelles et professionnelles
3. Télécharger une photo (optionnel)
4. Enregistrer dans la base de données

**Attribution de cours**

1. Sélectionner un enseignant dans la liste
2. Cliquer sur `Assigner cours`
3. Choisir département et cours
4. Définir l’emploi du temps et la salle
5. Confirmer l’attribution

## 📁 Structure du projet

```
GestionEnseignants/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/gestion/enseignants/
│   │   │   │   ├── controllers/
│   │   │   │   ├── models/
│   │   │   │   ├── dao/
│   │   │   │   ├── services/
│   │   │   │   ├── utils/
│   │   │   │   └── Main.java
│   │   └── resources/
│   │       ├── fxml/
│   │       ├── css/
│   │       ├── images/
│   │       └── config.properties
│   └── test/
├── docs/
├── database/
│   ├── schema.sql
│   └── seed_data.sql
├── README.md
├── LICENSE
└── pom.xml / build.gradle
```

## 🤝 Contributions

Les contributions sont les bienvenues !

1. Fork du dépôt
2. Créer votre branche : `git checkout -b feature/AmazingFeature`
3. Commit des changements : `git commit -m 'Add some AmazingFeature'`
4. Pousser la branche : `git push origin feature/AmazingFeature`
5. Ouvrir un Pull Request

**Bonnes pratiques**

* Suivre les conventions Java
* Écrire des tests unitaires pour les nouvelles fonctionnalités
* Mettre à jour la documentation
* Vérifier que le code compile sans avertissements

## 📄 Licence

Projet sous licence MIT — voir le fichier LICENSE

## 📞 Contact

Auteur : ALIAT Atef
GitHub : [@N1N0u](https://github.com/N1N0u)
Projet : [Lien du projet](https://github.com/N1N0u/GestionEnseignants)

<p align="center">
  <i>Conçu avec ❤️ à des fins pédagogiques</i><br>
  <sub>Projet L2 Informatique - Année Académique 2016-2017</sub>
</p>
