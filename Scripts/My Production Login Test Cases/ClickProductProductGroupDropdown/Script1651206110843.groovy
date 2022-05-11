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
	public static TestObject getTestObjectWithXpath(String xpath) {
		return new TestObject().addProperty('xpath', ConditionType.CONTAINS, xpath)
	}
}

WebUI.openBrowser("http://dev.myproduction.cloud/")
WebUI.delay(10)

WebUI.setText(findTestObject('Application_My Production/LoginPage/tenantcode'), "manual testing")
WebUI.setText(findTestObject('Application_My Production/LoginPage/username'), "aray@appsnovel.com")
WebUI.setText(findTestObject('Application_My Production/LoginPage/password'), "joyjoggonath")
WebUI.click(findTestObject('Application_My Production/LoginPage/btn_Login'))
WebUI.delay(10)

WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/product/new?subType=EN20021-ST01")
WebUI.delay(10)

TestObject testObjProductGroup = findTestObject('Application_My Production/ProductPage/product_productgroup')
WebElement elementProductGroup = WebUI.findWebElement(testObjProductGroup, 10)

xpathProductGroup = WebUI.executeJavaScript(
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

			"} return absoluteXPath(arguments[0]);", Arrays.asList(elementProductGroup));

TestObject testObjectProductGroup = TestObjectHelper.getTestObjectWithXpath(xpathProductGroup.toString());	
WebUI.click(testObjectProductGroup)
WebUI.delay(10)
//WebUI.selectOptionByIndex(testObjectProductGroup, 1)


