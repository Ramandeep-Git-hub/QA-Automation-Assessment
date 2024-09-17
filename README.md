QA-Automation-Assessment

Author: Ramandeep Brar

Open the Readme file in the 'Code' tab to see the proper structure

Setup Prerequisite:
Installed JDK 21.0.3 on local

Update Env with the following
Add the JDK bin folder path to the 'Path' variable
Add 'JAVA_HOME' with the path to the JDK folder
Maven version on local 3.9.9
Add the 'MAVEN_HOME' variable with a path to the Maven folder

Installed IntelliJ
Installed 2 plugins 'Cucumber for Java' and 'Gherkin' in IntelliJ plugins.
Restart IntelliJ


ProjectName: SauceDemo
Project Type: Maven Java project
Technology stack: Selenium, Java, Cucumber, TestNG, Maven, Lo4j2, Spark Reports
Style: BDD project with Page Object Model

Test Framework:
logs
  -show log4j2 logs
 
Reports
  -shows test reports
 
src
  config
   -has config file to store property variables
 
src
  main
    java
      org.saucedemo.pages
        -has POM java classes
 
 
src
  main
    test
      java
        hooks
          -has hooks file
  
src
  main
    test
      java
        runner
          -has TestRunner
 
src
  main
    test
      java
        stepdefinitions
          -has stepdefinitions
 
src
  test
    resources
      features
        -has feature files

 src
   test
     resources
       -has log4j2, testng.xml and extent.properties file.

pom.xml file with all the Maven dependencies
 
 

How to Run:
To run the project: Go to - src/test/java/runner/TestRunner.java
Right-click on the file and click Run TestRunner
A total 3 test cases will run
Or run from the IntelliJ terminal with the 'mvn test' command

Logs:
To see logs open the app.log file located at - logs/app.log

Reports:
To see reports open the Spark.html file(browser Chrome) located at - Reports/Spark.html
