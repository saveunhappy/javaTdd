package org.example;

import com.codeborne.selenide.Configuration;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;

/**
 * 	JBehave
 *
 *	JBehave是一个Java BDD框架，用于编写可执行和自动化的验收测试。
 *
 *	Eclipse 安装：Help->Eclipse Marketplace->搜索Natural
 *	@author hzweiyongqiang
 */
public class Course101JBehave {
	/**
	 * 	故事：src\main\resources\bdd\jbehave\stories\wikipediaSearch.story
	 * 	执行：com.java.testdriven.chapter02.JBehaveTest
	 */

	/**
	 * 	这是一个Given步骤，表示要成功执行后续操作必须满足的一个前置条件，此处指打开一个维基百科网页。
	 */
	@Given("I go to Wikipedia homepage")
	public void goToWikePage() {
		System.setProperty("webdriver.chrome.driver", "/Users/houjiangtao/devCode/chromedriver");
		Configuration.browser = "chrome";
		//  打开维基百科页面
		open("http://en.wikipedia.org/wiki/Main_Page");
	}

	/**
	 * 	操作是使用注解 @When 定义的。注意，引入参数可让步骤更灵活。
	 * 	我们使用这些步骤设置一个文本框的值。
	 *	@param value
	 *	@param fieldName
	 */
	@When("I enter the value $value on a field named $fieldName")
	public void enterValueOnFieldByName(String value, String fieldName) {
		//  搜索TDD
//		$(By.name(fieldName)).setValue(value);
//		$(By.id("searchInput")).setValue("Test-derven development");
		$(By.id(fieldName)).setValue(value);

	}
	/**
	 * 	单击特定按钮
	 *	@param buttonName
	 */
	@When("I click the button $buttonName")
	public void clickButtonByName(String buttonName) {
		// 单击搜索按钮
//		$(By.name(buttonName)).click();
//		$(By.className("cdx-search-input__end-button")).click();
		$(By.className(buttonName)).click();

	}

	/**
	 * 	操作执行完毕后进行验证，验证是使用注解 @Then 声明的。
	 *	@param title
	 */
	@Then("the page title contains $title")
	public void pageTitleIs(String title) {
		//  检查结果
		assertThat(title(),startsWith(title));
	}
}
