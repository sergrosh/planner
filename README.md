# Family planner

Test project just for fun

## How to run planner locally

 - Navigate to folder where you want to clone the planner repository
 - Clone the planner repo:  **git clone https://github.com/sergrosh/planner**

Planner consists of backend (Spring boot) and frontend (ReactJs?) applications.

### What should be installed:
 - Docker 
 - JDK 11 or later (https://jdk.java.net/)
 - MySQL (https://dev.mysql.com/doc/mysql-installation-excerpt/8.0/en/source-installation.html)
 - Git (https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)
 - NodeJS and NPM (https://nodejs.org)
 
##### Note: If you're using Intellij Idea as your IDE then Lombok plugin should be installed 
 
### To run backend:

#### Option 1
 - Navigate to planner folder: **cd planner**
 - run: **./gradlew**
 - run **ls -la build/libs/** to find out the [version] of the jar file you will execute
 - run **java -jar build/libs/planner-[version].jar**

#### Option 2
 - Navigate to planner folder: **cd planner**
 - run **docker-compose build**
 - run **docker-compose up**