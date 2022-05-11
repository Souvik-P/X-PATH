import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.entity.repository.WebElementXpathEntity

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject as TestObject

public class TestObjectHelper {
	public static TestObject getTestObjectWithXpath(WebElement webelement) {
		String strXpath = WebUI.executeJavaScript(
			"function absoluteXPath(element) {"+
					"var comp, comps = [];"+
					"var parent = null;"+
					"var xpath = '';"+
					"var getPos = function(element) {"+
					"var position = 1, curNode;"+
					"if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
					"return null;"+
					"}"+
					"for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
					"if (curNode.nodeName == element.nodeName) {"+
					"++position;"+
					"}"+
					"}"+
					"return position;"+
					"};"+
		
					"if (element instanceof Document) {"+
					"return '/';"+
					"}"+
		
					"for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
					"comp = comps[comps.length] = {};"+
					"switch (element.nodeType) {"+
					"case Node.TEXT_NODE:"+
					"comp.name = 'text()';"+
					"break;"+
					"case Node.ATTRIBUTE_NODE:"+
					"comp.name = '@' + element.nodeName;"+
					"break;"+
					"case Node.PROCESSING_INSTRUCTION_NODE:"+
					"comp.name = 'processing-instruction()';"+
					"break;"+
					"case Node.COMMENT_NODE:"+
					"comp.name = 'comment()';"+
					"break;"+
					"case Node.ELEMENT_NODE:"+
					"comp.name = element.nodeName;"+
					"break;"+
					"}"+
					"comp.position = getPos(element);"+
					"}"+
		
					"for (var i = comps.length - 1; i >= 0; i--) {"+
					"comp = comps[i];"+
					"xpath += '/' + comp.name.toLowerCase();"+
					"if (comp.position !== null) {"+
					"xpath += '[' + comp.position + ']';"+
					"}"+
					"}"+
		
					"return xpath;"+
		
					"} return absoluteXPath(arguments[0]);", Arrays.asList(webelement))
		KeywordUtil.logInfo(strXpath.toString())
				
		return new TestObject().addProperty('xpath', ConditionType.EQUALS, strXpath)
	}
}


WebUI.openBrowser("http://dev.myproduction.cloud/")
WebUI.delay(5)

TestObject testObjTenantCode = findTestObject('Application_My Production/LoginPage/tenantcode')
WebElement webelementTenantCode = WebUI.findWebElement(testObjTenantCode, 10)

TestObject testObjUserName = findTestObject('Application_My Production/LoginPage/username')
WebElement webelementUserName = WebUI.findWebElement(testObjUserName, 10)

TestObject testObjPassword = findTestObject('Application_My Production/LoginPage/password')
WebElement webelementPassword = WebUI.findWebElement(testObjPassword, 10)

TestObject testObjLogin = findTestObject('Application_My Production/LoginPage/btn_Login')
WebElement webelementLogin = WebUI.findWebElement(testObjLogin, 100)

WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementTenantCode), "manual testing")
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementUserName), "aray@appsnovel.com")
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementPassword), "joyjoggonath")
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementLogin))
// WebUI.click(findTestObject('Application_My Production/LoginPage/btn_Login'))
// WebUI.click(new TestObject().addProperty('xpath', ConditionType.CONTAINS, "//button[@class=\"btn\"]"))
WebUI.delay(10)


/*WebUI.click(TestObjectHelper.getTestObjectWithXpath('//body[@id=\'fixedPosition\']/app-root/div/app-login/div/div/div/div/div/div/div/div/form/div/div/input'))
 WebUI.setText(TestObjectHelper.getTestObjectWithXpath('//body[@id=\'fixedPosition\']/app-root/div/app-login/div/div/div/div/div/div/div/div/form/div/div/input'), "Tenant Code")
 
 WebUI.click(TestObjectHelper.getTestObjectWithXpath('//body[@id=\'fixedPosition\']/app-root/div/app-login/div/div/div/div/div/div/div/div/form/div[2]/div/input'))
 WebUI.setText(TestObjectHelper.getTestObjectWithXpath('//body[@id=\'fixedPosition\']/app-root/div/app-login/div/div/div/div/div/div/div/div/form/div[2]/div/input'), "User Name")
 
 WebUI.click(TestObjectHelper.getTestObjectWithXpath('//input[@type=\'password\']'))
 WebUI.setText(TestObjectHelper.getTestObjectWithXpath('//input[@type=\'password\']'), "Secret Password")*/

/*xpathTenantCode = WebUI.executeJavaScript(
	"function absoluteXPath(element) {"+
			"var comp, comps = [];"+
			"var parent = null;"+
			"var xpath = '';"+
			"var getPos = function(element) {"+
			"var position = 1, curNode;"+
			"if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
			"return null;"+
			"}"+
			"for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling) {"+
			"if (curNode.nodeName == element.nodeName) {"+
			"++position;"+
			"}"+
			"}"+
			"return position;"+
			"};"+

			"if (element instanceof Document) {"+
			"return '/';"+
			"}"+

			"for (; element && !(element instanceof Document); element = element.nodeType == Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
			"comp = comps[comps.length] = {};"+
			"switch (element.nodeType) {"+
			"case Node.TEXT_NODE:"+
			"comp.name = 'text()';"+
			"break;"+
			"case Node.ATTRIBUTE_NODE:"+
			"comp.name = '@' + element.nodeName;"+
			"break;"+
			"case Node.PROCESSING_INSTRUCTION_NODE:"+
			"comp.name = 'processing-instruction()';"+
			"break;"+
			"case Node.COMMENT_NODE:"+
			"comp.name = 'comment()';"+
			"break;"+
			"case Node.ELEMENT_NODE:"+
			"comp.name = element.nodeName;"+
			"break;"+
			"}"+
			"comp.position = getPos(element);"+
			"}"+

			"for (var i = comps.length - 1; i >= 0; i--) {"+
			"comp = comps[i];"+
			"xpath += '/' + comp.name.toLowerCase();"+
			"if (comp.position !== null) {"+
			"xpath += '[' + comp.position + ']';"+
			"}"+
			"}"+

			"return xpath;"+

			"} return absoluteXPath(arguments[0]);", Arrays.asList(webelementTenantCode));*/
		
		



// TestObject testObjPassword = findTestObject('Application_My Production/LoginPage/password')
// WebElement anElement = WebUI.findWebElement(testObjPassword, 100)
// WebUI.click(findTestObject('id("fixedPosition")/app-root[1]/div[1]/app-login[1]/div[@class="account-body"]/div[@class="accountbg"]/div[@class="row vh-100"]/div[@class="col-12 align-self-center"]/div[@class="auth-page"]/div[@class="card auth-card shadow-lg"]/div[@class="login-body"]/div[@class="px-3"]/form[@class="form-horizontal auth-form my-4 ng-invalid ng-touched ng-dirty"]/div[@class="form-group"]/div[@class="input-group"]/input[@class="form-control ng-touched ng-dirty ng-invalid"]'))
// KeywordUtil.logInfo(anElement.toString())
// TestObject testObjPassword2 = WebUI.convertWebElementToTestObject(anElement)
// KeywordUtil.logInfo(anElement.getProperties().toString())
// KeywordUtil.logInfo(anElement.getMetaPropertyValues().toString())
// KeywordUtil.logInfo(anElement.getTagName().toString())
// KeywordUtil.logInfo(anElement.properties.toString())
// KeywordUtil.logInfo(testObjPassword2.activeXpaths.toString())
// KeywordUtil.logInfo(testObjPassword2.getXpaths().toString());
// KeywordUtil.logInfo(testObjPassword2.activeProperties.toString());



// KeywordUtil.logInfo(hello.toString())
// WebUI.click(TestObjectHelper.getTestObjectWithXpath(hello.toString()))
// WebUI.setText(TestObjectHelper.getTestObjectWithXpath(hello.toString()), "Secret Password")
// WebUI.click(findTestObject(hello.toString()))
// WebUI.closeBrowser()










