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

TestObject testObjTenantCode = findTestObject('Application_My Production/LoginPage_woXPATH/input_Workspace')
WebElement webelementTenantCode = WebUI.findWebElement(testObjTenantCode, 10)

TestObject testObjUserName = findTestObject('Application_My Production/LoginPage_woXPATH/input_Username')
WebElement webelementUserName = WebUI.findWebElement(testObjUserName, 10)

TestObject testObjPassword = findTestObject('Application_My Production/LoginPage_woXPATH/input_Password')
WebElement webelementPassword = WebUI.findWebElement(testObjPassword, 10)

TestObject testObjLogin = findTestObject('Application_My Production/LoginPage_woXPATH/btn_Login')
WebElement webelementLogin = WebUI.findWebElement(testObjLogin, 100)

WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementTenantCode), "manual testing")
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementUserName), "aray@appsnovel.com")
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementPassword), "joyjoggonath")
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementLogin))

WebUI.delay(10)