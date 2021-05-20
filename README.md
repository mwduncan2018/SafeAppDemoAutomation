# SafeAppDemoAutomation
###### This is test automation of a C# .NET CORE MVC website using Java, Selenium WebDriver, Selenium's Page Factory annotations, Behavior-Driven Development (BDD), Cucumber, and RestAssured.

## Page Factory Annotations
###### AND CONDITION
@FindBys({
  @FindBy(class="highlight-row"),
  @FindBy(id="warzone")
})
###### OR CONDITION
@FindAll({
  @FindBy(name="blackops"),
  @FindBy(id="mw3"),
  @FindBy(className="btn-warning")
})

## Picocontainer - Sharing Test State Between Step Definitions
###### Sharing state between step definitions can be done using picocontainer (http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer). Picocontainer will invisibly handle the dependency injection that allows shared state among steps. To use picocontainer, do the following.
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
