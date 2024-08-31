# saucedemoTest

# PREREQUISITES
- VSCode Installed
- JDK Installed and Set the JAVA_HOME
- VSCode Extension
    - Java Extension Pack
    - Cucumber

# SELENIUM - JAVA - CUCUMBER INSTALLATION ON VSCODE
1. Create Java Project > maven > archetype-quickstart-jdk8
2. Add Maven Dependencies
    - [Cucumber Java](https://mvnrepository.com/artifact/io.cucumber/cucumber-java)
    - [Cucumber jUnit](https://mvnrepository.com/artifact/io.cucumber/cucumber-junit)
    - [jUnit](https://mvnrepository.com/artifact/junit/junit )
    - [Selenium Java](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
    - [WebDriverManager](https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager)
4. Modify _settings.json_ (read _Cucumber (Gherkin) Full Support_ details)
    ```
    
    ```
# PROJECT STRUCTURE (POM PATTERN)
### Feature file
- Scenario on a feature file group by test case 

### Step Definition 
- Maps all test case steps on feature file to code

### Page Object
- One page object class represent one page on software under test
- Page object class include : 
    - Web element locator
    - All action on this particular page

### Test Runner
# RUN TEST AS JUNIT
## Run all testcases
1. Open TestRunner.java on \src\test\java\TestRunner\TestRunner.java
2. Remove tags on tags
    ```
	tags= "",
    ```
3. Click Run Test on TestRunner.java

## Run testcases based on feature file
1. Open TestRunner.java on \src\test\java\TestRunner\TestRunner.java
2. Put the tag above the scenario
    ```
    @Login
    Feature: Test Login 
        @Test-1
        Scenario: Test-1:Login success
            Given user is on Login Page
    ```
3. Put the tag on tags
    ```
	tags= "@Test-1",
    ```
4. Click Run Test on TestRunner.java to execute 1 scenario 

5. Put the tag on tags
    ```
	tags= "@Run",
    ```
6. Click Run Test on TestRunner.java to execute all scenario on 1 feature file
