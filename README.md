# SafeAppDemoAutomation

### Page Factory Annotations
##### AND CONDITION
@FindBys({
  @FindBy(class="highlight-row"),
  @FindBy(id="warzone")
})
##### OR CONDITION
@FindAll({
  @FindBy(name="blackops"),
  @FindBy(id="mw3"),
  @FindBy(className="btn-warning")
})
