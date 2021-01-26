Sample Java Project
This is a reference for setting up the Person CRUD console application. GitHUb project https://github.com/AlbaCorvus/accela_revised.git

Setup
Import project from github using IDE of your choice run maven configuration base directory ${project_loc:revised} Goals clean compile assembly:single use JUnit 4 dependency
In your target folder for the project workspace example C:\workspace\accela_revised\revised\target open a shell command and run the following

Or given that I have pushed the target folder you can just import the project and run the following from the target folder without building the project again.

java -cp revised-0.0.1-SNAPSHOT-jar-with-dependencies.jar org.h2.tools.Console

This will open your browser window and launch the H2DB ~test database your credentials will be username "sa" and password "" by default please don not change these as applications persistence.xml refers to these credentials for DB connection.

After you hit connect button from h2 Console open another console window from target folder and run the following cmd

java -jar revised-0.0.1-SNAPSHOT-jar-with-dependencies.jar

This will launch the application assessment from App.java class as main.

Dependencies

Spring Framework
org.h2
Java JRE 8 >

Work Notes

Replaced data management actions with Command pattern, removed most of the domain management functionality into a mediator class UIMediator.

Cleaned up the Menu classes to mainly deal with display functionality.

Tried to promote an open closed architectural approach, incorporating scalability through implementation classes only.