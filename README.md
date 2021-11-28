# Techtest-Javaselenium

Steps to Execute: -
1. Clone the project from github repo
2. Make sure Maven 3.8.4 and Java installed
3. Download cucumber plugin from Eclipse Marketplace

Various ways to execute the test:

Method 1. Go to Test Runner class under steps folder and right-click (Run As-> junit test) for feature file execution

Method 2. Go to Feature file and right click(Run As-> Cucumber Feature)

Method 3: Right-click on the project and select Run As - Maven test

Method 4: Command line execution

1. Check MAVEN is installed   mvn -version

2. CD to the project location

3. Run command  mvn test

By default mvn test will run the files with naming syntax
**/Test*.java
**/*Test.java
**/*TestCase.java

Overriding Cucumber Options from Command Line :-

Run specific feature : mvn test -Dcucumber.options="src/test/resources/order.feature" 

Run with Tags : mvn test -Dcucumber.options="--tags @Smoke" 

Method 5: Command line execution with cucumber html report

running mvn clean test will generate the Cucumber report file

running mvn verify will generate the cucumber-report-html based on the cucumber.json

running mvn clean verify will do all together
