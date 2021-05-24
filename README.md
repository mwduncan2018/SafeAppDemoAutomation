# SafeAppDemoAutomation
###### This is test automation of a C# .NET CORE MVC website using Java, Selenium WebDriver, Selenium's Page Factory annotations, Behavior-Driven Development (BDD), Cucumber, and RestAssured.
## Page Factory Annotations
###### AND CONDITION
```diff
- @FindBys({ @FindBy(class="highlight-row"), @FindBy(id="warzone") })
```
###### OR CONDITION
```diff
+ @FindAll({ @FindBy(name="blackops"), @FindBy(id="mw3"), @FindBy(className="btn-warning") })
```
## Scenario Context - Picocontainer
###### Sharing test state between step definitions can be done using picocontainer (http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer). Picocontainer will invisibly handle the dependency injection that allows shared state between the steps of a scenario. To use picocontainer, do the following.
###### 1) Create a ScenarioContext class
###### 2) Each step definition class has a private ScenarioContext class.
###### 3) Each step definition class has a constructor that takes ScenarioContext as a parameter and assigns it to the private ScenarioContext.
###### 4) Put picocontainer in the pom.xml file.
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-picocontainer</artifactId>
			<version>6.10.3</version>
			<scope>test</scope>
		</dependency>

## Test Context - ConcurrentHashMap<String,Object>
###### Sharing test state between all tests can be accomplished with a TestContext class with methods that are all static.
###### During parallel test exucution, Cucumber runs a thread for each feature file. For thread safety in the TestContext class, use a ConcurrentHashMap<String,Object> to store data throughout the test run.

## Page-Object Model
###### Implement the Page-Object Model by following three rules.
```diff
! 1) For each GUI page in the app, create a corresponding class.
! 2) For each action/verification on the GUI page, create a method in the class.
! 3) Store GUI element location strategies as private member data in the class.
```

## Cucumber "Before Each Scenario" and "After Each Scenario" Hooks
######

