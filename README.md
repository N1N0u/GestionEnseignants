# GestionEnseignants 👨‍🏫

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java](https://img.shields.io/badge/Java-17%2B-orange)](https://www.java.com/)
[![Status](https://img.shields.io/badge/status-L2%20Project-green)](https://github.com/N1N0u/GestionEnseignants)

> Licence Univeristy Project 
> A comprehensive teacher management system built for educational institutions.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## 🎯 Overview

**GestionEnseignants** is a desktop application designed to streamline the management of teacher information, schedules, courses, and administrative tasks within educational institutions. Developed as a second-year (L2) academic project, this system demonstrates practical implementation of object-oriented programming principles and database management.

## ✨ Features

### Core Functionality
- 👤 **Teacher Profile Management** - Add, edit, delete, and view detailed teacher profiles
- 📚 **Course Assignment** - Assign courses to teachers and manage schedules
- 📅 **Schedule Management** - Create and manage class timetables
- 🔍 **Search & Filter** - Advanced search capabilities for quick data retrieval
- 📊 **Reporting** - Generate reports on teacher workloads and course distributions

### Administrative Features
- 🔐 **User Authentication** - Secure login system with role-based access
- 📝 **Data Export** - Export data to PDF and Excel formats
- 🗄️ **Database Integration** - Persistent storage with MySQL/PostgreSQL support

## 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Java 17+ |
| **GUI Framework** | JavaFX / Swing |
| **Database** | MySQL / PostgreSQL |
| **Build Tool** | Maven / Gradle |
| **IDE** | IntelliJ IDEA / Eclipse |
| **Version Control** | Git & GitHub |

## 🚀 Installation

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- MySQL Server 8.0+ or PostgreSQL 13+
- Maven 3.8+ or Gradle 7+

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/N1N0u/GestionEnseignants.git
   cd GestionEnseignants
2. 
Configure Database
 
Create a new database named  gestion_enseignants 
 
Update database credentials in  src/main/resources/config.properties 

db.url=jdbc:mysql://localhost:3306/gestion_enseignants
db.username=your_username
db.password=your_password
3. Build the Project
# Using Maven
mvn clean install

# Using Gradle
gradle build

4. 
Run the Application
# Using Maven
mvn javafx:run

# Or run the JAR directly
java -jar target/GestionEnseignants-1.0.jar

💻 Usage
First Launch
1. 
Launch the application
2. 
Login with default credentials:
 
Username:  admin 
 
Password:  admin123 
3. 
Change default password immediately for security
Managing Teachers
1. 
Navigate to Teachers → Add New
2. 
Fill in personal and professional information
3. 
Upload profile photo (optional)
4. 
Save to database
Assigning Courses
1. 
Select a teacher from the list
2. 
Click Assign Course
3. 
Choose department and course from dropdown
4. 
Set schedule and classroom
5. 
Confirm assignment
📁 Project Structure
GestionEnseignants/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/gestion/enseignants/
│   │   │   │   ├── controllers/     # UI Controllers
│   │   │   │   ├── models/          # Data Models (Teacher, Course, etc.)
│   │   │   │   ├── dao/             # Data Access Objects
│   │   │   │   ├── services/        # Business Logic
│   │   │   │   ├── utils/           # Utility Classes
│   │   │   │   └── Main.java        # Entry Point
│   │   └── resources/
│   │       ├── fxml/                # JavaFX Layout Files
│   │       ├── css/                 # Stylesheets
│   │       ├── images/              # Icons and Images
│   │       └── config.properties    # Configuration
│   └── test/                        # Unit Tests
├── docs/                            # Documentation
├── database/                        # SQL Scripts
│   ├── schema.sql                   # Database Schema
│   └── seed_data.sql               # Sample Data
├── README.md
├── LICENSE
└── pom.xml / build.gradle          # Build Configuration

🤝 Contributing
Contributions are welcome! This is an academic project, but improvements are appreciated.
1. 
Fork the repository
2. 
Create your feature branch ( git checkout -b feature/AmazingFeature )
3. 
Commit your changes ( git commit -m 'Add some AmazingFeature' )
4. 
Push to the branch ( git push origin feature/AmazingFeature )
5. 
Open a Pull Request
Development Guidelines
 
Follow Java naming conventions
 
Write unit tests for new features
 
Update documentation accordingly
 
Ensure code compiles without warnings
📄 License
This project is licensed under the MIT License - see the LICENSE file for details.
📞 Contact
Project Author: ALIAT Atef
GitHub: @N1N0u
Project Link: https://github.com/N1N0u/GestionEnseignants
<p align="center">
  <i>Built with ❤️ for educational purposes</i><br>
  <sub>L2 Computer Science Project - Academic Year 2016-2017</sub>
</p>
```

