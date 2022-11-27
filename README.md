# Fursa_devops
Repository for all github homeworks.

Homework2-------------

For homework 2 we were asked to make a java project that takes the "breaking news" from ynet https://www.ynet.co.il/Integration/StoryRss2.xml and present it in an html file on localhost.
After that we should run them on jenkins server (CI/CD).

What I've done is writing a java code that takes the <title> tage from the xml and <description> then put them in a string of an html file. Then save the string in src/main/resources/static/index.html, this way the spring will run it in default.

to run the code all you need is java 17 and maven installed. (you can install them by runnning the requirements.sh file if you're using ubuntu). After cloning the project all you have to do is run the following code:

    cd Homework2/demo
    mvn clean package
    java -jar target/*.jar


Alternatively if you want to test it without making a jar every time you can just run: 

    cd Homework2/demo && ./mvnw spring-boot:run

Homework3-------------

In Homework 3 we were asked to make a flask app and connect it to a redis database, each in their own container running on the same docker using docker-compose. Putting all this in CI/CD cycle using jenkins and publishing the container on Dockerhub.