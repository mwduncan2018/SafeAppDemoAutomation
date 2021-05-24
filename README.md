# SafeAppDemoAutomation
###### This is test automation of a C# .NET CORE MVC website using Java, Selenium WebDriver, Selenium's Page Factory annotations, Behavior-Driven Development (BDD), Cucumber, and RestAssured.

## Selenium WebDriver
###### Selenium client libraries exist in many languages (C#, Java, Python, Ruby, JS, etc.). When executed, those libraries send JSON to a server running locally. That server is called a webdriver and it knows how to take that JSON and turn it into actions on a browser. Each browser has a specific webdriver. Geckodriver is the webdriver for Firefox. Chromedriver is the webdriver for Chrome. Webdrivers exist for Safari, Internet Explorer, Edge, and Opera also. You should put the executable webdriver in a folder that is on the PATH environment variable so Selenium can find it easily.

###### Selenium locates GUI elements by:
```diff
+ CSS Selector
+ ID
+ Name
+ Class
+ Link Text
+ Partial Link Text
+ XPATH
+ Tag
```
###### After Selenium locates a GUI element, there are methods to trigger events on the GUI element (e.g. click, submit, etc.) and methods to pull data from the GUI element (text, attribute values, etc.).


## Page-Object Model
###### Implement the Page-Object Model by following three rules.
```diff
! 1) For each GUI page in the app, create a corresponding class.
! 2) For each action/verification on the GUI page, create a method in the class.
! 3) Store GUI element location strategies as private member data in the class.
```

## Page Factory Annotations
###### Annotations are available to allow multiple strategies to locate each GUI element.
###### AND CONDITION
```diff
- @FindBys({ @FindBy(class="submit-me"), @FindBy(id="btnSubmit") })
- private WebElement SUBMIT_BUTTON;
```
###### OR CONDITION
```diff
- @FindAll({ @FindBy(name="blackops"), @FindBy(id="mw3"), @FindBy(className="btn-warning") })
- private WebElement BLACK_OPS_BUTTON;
```
## Scenario Context - Picocontainer
###### Sharing test state between step definitions and test hooks ("before each scenario" and "after each scenario") for each individual scenario can be done using picocontainer (http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer). Picocontainer will invisibly handle the dependency injection that allows shared state between the steps of a scenario. To use picocontainer, do the following.
###### 1) Create the ScenarioContext class. This class contains a HashMap<String,Object> for the step definitions to store scenario state.
###### 2) Each step definition class has a private ScenarioContext class. Each step definition class has a constructor that takes ScenarioContext as a parameter and assigns it to the private ScenarioContext.
###### 3) The Hooks class a private ScenarioContext class.The Hooks class has a constructor that takes ScenarioContext as a parameter and assigns it to the private ScenarioContext.
###### 4) Put picocontainer in the pom.xml file.
		<dependency>
			<groupId>io.cucumber</groupId>
			<artifactId>cucumber-picocontainer</artifactId>
			<version>6.10.3</version>
			<scope>test</scope>
		</dependency>

## Test Context - ConcurrentHashMap<String,Object>
###### Sharing test state between all scenarios can be accomplished with a TestContext class with methods that are all static.
###### During parallel test execution, Cucumber runs a thread for each feature file. For thread safety in the TestContext class, use a ConcurrentHashMap<String,Object> to store data throughout the test run.

## Cucumber "Before Each Scenario" and "After Each Scenario" Hooks
###### These test hooks go in the Hooks.java file.
###### Multiple hook methods can occur before each scenario and after each scenario. Control the order of test hook execution with an annotation on hooks like the example below. @Before order starts execution at 1 and the goes up. @After order starts execution at 9999 and goes down to 1.
```diff
! @Before(order=99)
! @After(order=1)
```
## Cucumber "Before All" and "After All" Hooks
###### Within the RunCucumberTest.java file, use the JUnit annotations for "Before All" and "After All".
```diff
+ @BeforeClass
+ @AfterClass
```
## HTML Report
###### Use the following @CucumberOption for the HTML report.

		@CucumberOptions(plugin = { "pretty", "html:target/Destination", "json:target/cucumber.json" },
			monochrome = true, snippets = SnippetType.UNDERSCORE,
			features = "src/test/resources")
		public class RunCucumberTest { ... }
