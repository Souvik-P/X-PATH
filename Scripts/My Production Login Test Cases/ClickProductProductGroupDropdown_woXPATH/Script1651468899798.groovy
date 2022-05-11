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

import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

public class WebElementHelper {
	public static String getWebElementWithXpath(WebElement webelement) {
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
				
		return strXpath
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

// Section to search in Normal Single Select Dropdown

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/bom/new?subType=EN20022-ST01")
WebUI.delay(10)

TestObject testObjBOMProduct = findTestObject('Application_My Production/BOMPage_woXPATH/NormalSingleSelectDropdown/dropdown_Product')
WebElement webelementBOMProduct = WebUI.findWebElement(testObjBOMProduct, 10)
WebUI.check(TestObjectHelper.getTestObjectWithXpath(webelementBOMProduct))
WebUI.delay(5)

TestObject testObjBOMProductSearchText = findTestObject('Application_My Production/BOMPage_woXPATH/NormalSingleSelectDropdown/dropdown_Product_Search')
WebElement webelementBOMProductSearchText = WebUI.findWebElement(testObjBOMProductSearchText, 10)
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSearchText), "100")
WebUI.delay(5)

TestObject testObjBOMProductSelected = findTestObject('Application_My Production/BOMPage_woXPATH/NormalSingleSelectDropdown/dropdown_Product_Selected')
WebElement webelementBOMProductSelected = WebUI.findWebElement(testObjBOMProductSelected, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSelected))
WebUI.delay(5)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// Section to search in Autocomplete Single Select Dropdown

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/bom/new?subType=EN20022-ST01")
WebUI.delay(10)

TestObject testObjBOMProductSearchText = findTestObject('Application_My Production/BOMPage_woXPATH/AutocompleteDropdown/autocomplete_Product')
WebElement webelementBOMProductSearchText = WebUI.findWebElement(testObjBOMProductSearchText, 10)
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSearchText), "100")
WebUI.delay(5)

TestObject testObjBOMProductSelected = findTestObject('Application_My Production/BOMPage_woXPATH/AutocompleteDropdown/autocomplete_Product_Selected')
WebElement webelementBOMProductSelected = WebUI.findWebElement(testObjBOMProductSelected, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSelected))
WebUI.delay(5)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to search in RichMultiSelect Dropdown

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/bom/new?subType=EN20022-ST01")
WebUI.delay(10)

TestObject testObjBOMProductSearchText = findTestObject('Application_My Production/BOMPage_woXPATH/RichMultiSelectDropdown/richmultiselect_Product')
WebElement webelementBOMProductSearchText = WebUI.findWebElement(testObjBOMProductSearchText, 10)
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSearchText), "100")
WebUI.delay(5)

TestObject testObjBOMProductSelected = findTestObject('Application_My Production/BOMPage_woXPATH/RichMultiSelectDropdown/richmultiselect_Product_Selected')
WebElement webelementBOMProductSelected = WebUI.findWebElement(testObjBOMProductSelected, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementBOMProductSelected))
WebUI.delay(5)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to search in multiple ExpandDetails Link

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/productroute/b99f879b-6acc-47ad-8134-013dff9741e5?subType=EN20028-ST01&mode=preview")
WebUI.delay(10)

TestObject testObjProductRouteOperationTab = findTestObject('Application_My Production/ProductRoutePage_woXPATH/tab_ProductRouteOperation')
WebElement webelementProductRouteOperationTab = WebUI.findWebElement(testObjProductRouteOperationTab, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationTab))
WebUI.delay(10)

TestObject testObjProductRouteExpandDetails1 = findTestObject('Application_My Production/ProductRoutePage_woXPATH/link_ExpandDetails_1')
WebElement webelementProductRouteExpandDetails1 = WebUI.findWebElement(testObjProductRouteExpandDetails1, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails1))
WebUI.delay(20)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails1))
WebUI.delay(5)

TestObject testObjProductRouteExpandDetails2 = findTestObject('Application_My Production/ProductRoutePage_woXPATH/link_ExpandDetails_2')
WebElement webelementProductRouteExpandDetails2 = WebUI.findWebElement(testObjProductRouteExpandDetails2, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails2))
WebUI.delay(20)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails2))
WebUI.delay(5)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to retrieve text by Grid cell identification

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/productroute/b99f879b-6acc-47ad-8134-013dff9741e5?subType=EN20028-ST01&mode=preview")
WebUI.delay(10)

TestObject testObjProductRouteOperationTab = findTestObject('Application_My Production/ProductRoutePage_woXPATH/tab_ProductRouteOperation')
WebElement webelementProductRouteOperationTab = WebUI.findWebElement(testObjProductRouteOperationTab, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationTab))
WebUI.delay(10)

WebDriver driver = DriverFactory.getWebDriver()
TestObject testObjProductRouteOperationTD3 = findTestObject('Application_My Production/ProductRoutePage_woXPATH/td_Assembly')
WebElement webelementProductRouteOperationTD3 = WebUI.findWebElement(testObjProductRouteOperationTD3, 10)
WebElement webelementProductRouteOperationTD3_2 = driver.findElement(By.xpath(WebElementHelper.getWebElementWithXpath(webelementProductRouteOperationTD3)))
String celltext = webelementProductRouteOperationTD3_2.getText();
KeywordUtil.logInfo(celltext.toString())
KeywordUtil.logInfo(webelementProductRouteOperationTD3.getText().toString())
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to click the Workflow Button

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/productroute/d476e72b-bedd-415b-b537-1007927d0e06?subType=EN20028-ST01&mode=edit")
WebUI.delay(10)

TestObject testObjProductRouteWorkflow = findTestObject('Application_My Production/ProductRoutePage_woXPATH/WorkflowButton/button_Workflow_NextStep')
WebElement webelementProductRouteWorkflow = WebUI.findWebElement(testObjProductRouteWorkflow, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteWorkflow))
WebUI.delay(10)

TestObject testObjProductRouteWorkflowToApproval = findTestObject('Application_My Production/ProductRoutePage_woXPATH/WorkflowButton/link_ToApproval')
WebElement webelementProductRouteWorkflowToApproval = WebUI.findWebElement(testObjProductRouteWorkflowToApproval, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteWorkflowToApproval))
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to click Nested Add Button

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/productroute/d476e72b-bedd-415b-b537-1007927d0e06?subType=EN20028-ST01&mode=edit")
WebUI.delay(10)

TestObject testObjProductRouteOperationTab = findTestObject('Application_My Production/ProductRoutePage_woXPATH/tab_ProductRouteOperation')
WebElement webelementProductRouteOperationTab = WebUI.findWebElement(testObjProductRouteOperationTab, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationTab))
WebUI.delay(10)

TestObject testObjProductRouteOperationAdd = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/parent_button_Add')
WebElement webelementProductRouteOperationAdd = WebUI.findWebElement(testObjProductRouteOperationAdd, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationAdd))
WebUI.delay(10)

TestObject testObjProductRouteOperationClose = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/button_ProductRouteOperation_Close')
WebElement webelementProductRouteOperationClose = WebUI.findWebElement(testObjProductRouteOperationClose, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationClose))
WebUI.delay(10)

TestObject testObjProductRouteExpandDetails = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/link_ExpandDetails')
WebElement webelementProductRouteExpandDetails = WebUI.findWebElement(testObjProductRouteExpandDetails, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails))
WebUI.delay(10)

TestObject testObjProductRouteOperationWorkcenterAdd = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/child_button_Add')
WebElement webelementProductRouteOperationWorkcenterAdd = WebUI.findWebElement(testObjProductRouteOperationWorkcenterAdd, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationWorkcenterAdd))
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to click Nested Action Link

WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/productroute/d476e72b-bedd-415b-b537-1007927d0e06?subType=EN20028-ST01&mode=edit")
WebUI.delay(10)

TestObject testObjProductRouteOperationTab = findTestObject('Application_My Production/ProductRoutePage_woXPATH/tab_ProductRouteOperation')
WebElement webelementProductRouteOperationTab = WebUI.findWebElement(testObjProductRouteOperationTab, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationTab))
WebUI.delay(10)

/*TestObject testObjProductRouteOperationActionLink = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedActionLink/parent_ActionLink_ParentRouteOperation')
WebElement webelementProductRouteOperationActionLink = WebUI.findWebElement(testObjProductRouteOperationActionLink, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationActionLink))
WebUI.delay(10)

TestObject testObjProductRouteOperationWorkcenterLink = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedActionLink/parent_Link_AddProductRouteOperationWorkcenter')
WebElement webelementProductRouteOperationWorkcenterLink = WebUI.findWebElement(testObjProductRouteOperationWorkcenterLink, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationWorkcenterLink))
WebUI.delay(10) 

TestObject testObjProductRouteOperationWorkcenterClose = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedActionLink/button_ProductRouteOperationWorkcenter_Close')
WebElement webelementProductRouteOperationWorkcenterClose = WebUI.findWebElement(testObjProductRouteOperationWorkcenterClose, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationWorkcenterClose))
WebUI.delay(10)*/

TestObject testObjProductRouteExpandDetails = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/link_ExpandDetails')
WebElement webelementProductRouteExpandDetails = WebUI.findWebElement(testObjProductRouteExpandDetails, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteExpandDetails))
WebUI.delay(10)


WebDriver driver = DriverFactory.getWebDriver()
// WebElement webelementProductRouteOperationWorkcenterActionLink1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product route operation workcenters'])[1]/following::tr[2]//following::a[@class=\"mat-menu-trigger gridAction ng-star-inserted\"]"))
WebElement webelementProductRouteOperationWorkcenterActionLink1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product route operation workcenters'])[1]/following::tr[2]//following::a[2]"))
webelementProductRouteOperationWorkcenterActionLink1.click();
WebUI.delay(10)

WebElement webelementProductRouteOpWCSetDefault1 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product route operation workcenters'])[1]/following::tr[2]//following::a[2]//following::a[contains(text(),'Set default')]"))
webelementProductRouteOpWCSetDefault1.click();
WebUI.delay(10)

WebElement webelementProductRouteOperationWorkcenterActionLink2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product route operation workcenters'])[1]/following::tr[3]//following::a[2]"))
webelementProductRouteOperationWorkcenterActionLink2.click();
WebUI.delay(10)
 
WebElement webelementProductRouteOpWCSetDefault2 = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Product route operation workcenters'])[1]/following::tr[3]//following::a[2]//following::a[contains(text(),'Set default')]"))
webelementProductRouteOpWCSetDefault2.click();
WebUI.delay(10) 

/*TestObject testObjProductRouteOpWCSetDefault = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedActionLink/child_Link_SetDefault_1')
WebElement webelementProductRouteOpWCSetDefault = WebUI.findWebElement(testObjProductRouteOpWCSetDefault, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOpWCSetDefault))
WebUI.delay(10)*/

// TestObject testObjProductRouteOperationWorkcenterActionLink1 = findTestObject('Application_My Production/ProductRoutePage_woXPATH/NestedAddButton/child_ActionLink_ProductRouteOperationWorkcenter_1')
// WebElement webelementProductRouteOperationWorkcenterActionLink1 = WebUI.findWebElement(testObjProductRouteOperationWorkcenterActionLink1, 10)
// WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductRouteOperationWorkcenterActionLink1))
// WebUI.delay(10)

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to test Radio Button, Checkbox and Kendo Dropdown

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/product/new?subType=EN20021-ST01")
WebUI.delay(10)

TestObject testObjCanBeManufactured = findTestObject('Application_My Production/ProductPage_woXPATH/radio_CanBeManufactured')
WebElement webelementCanBeManufactured = WebUI.findWebElement(testObjCanBeManufactured, 10)
WebUI.check(TestObjectHelper.getTestObjectWithXpath(webelementCanBeManufactured))
WebUI.delay(10)

TestObject testObjStopDrillDown = findTestObject('Application_My Production/ProductPage_woXPATH/checkbox_StopDrillDown')
WebElement webelementStopDrillDown = WebUI.findWebElement(testObjStopDrillDown, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementStopDrillDown))
WebUI.delay(10)

TestObject testObjProductGroup = findTestObject('Application_My Production/ProductPage_woXPATH/product_productgroup')
WebElement webelementProductGroup = WebUI.findWebElement(testObjProductGroup, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductGroup))
WebUI.delay(10)

TestObject testObjProductGroupSelected = findTestObject('Application_My Production/ProductPage_woXPATH/ProductGroupSelected')
WebElement webelementProductGroupSelected = WebUI.findWebElement(testObjProductGroupSelected, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementProductGroupSelected))
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to test Kendo Multiselect Dropdown

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/user/new?subType=EN10003-ST01")
WebUI.delay(10)

TestObject testObjCompetence = findTestObject('Application_My Production/UserPage_woXPATH/dropdown_Competence')
WebElement webelementCompetence = WebUI.findWebElement(testObjCompetence, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementCompetence))
WebUI.delay(10)

TestObject testObjCompetenceSelected1 = findTestObject('Application_My Production/UserPage_woXPATH/dropdown_CompetenceSelected_1')
WebElement webelementCompetenceSelected1 = WebUI.findWebElement(testObjCompetenceSelected1, 10)
WebUI.check(TestObjectHelper.getTestObjectWithXpath(webelementCompetenceSelected1))
WebUI.delay(10)

TestObject testObjCompetenceSelected2 = findTestObject('Application_My Production/UserPage_woXPATH/dropdown_CompetenceSelected_2')
WebElement webelementCompetenceSelected2 = WebUI.findWebElement(testObjCompetenceSelected2, 10)
WebUI.check(TestObjectHelper.getTestObjectWithXpath(webelementCompetenceSelected2))
WebUI.delay(10)

WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementCompetence))
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// Section to test Task Action link

/*WebUI.navigateToUrl("http://dev.myproduction.cloud/#/en-us/addressee?layout=4ac80b95-e265-41e3-8866-c05a62a3f0cf")
WebUI.delay(10)

TestObject testObjFilterAddresseeName = findTestObject('Application_My Production/AddresseePage_woXPATH/filter_AddresseeName')
WebElement webelementFilterAddresseeName = WebUI.findWebElement(testObjFilterAddresseeName, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementFilterAddresseeName))
WebUI.setText(TestObjectHelper.getTestObjectWithXpath(webelementFilterAddresseeName), "Just Testing None ADD-013-005-005") 
// Just Testing None ADD-012-004-004, Just Testing None ADD-013-005-005
WebUI.delay(10)

TestObject testObjLinkAction = findTestObject('Application_My Production/AddresseePage_woXPATH/link_Action')
WebElement webelementLinkAction = WebUI.findWebElement(testObjLinkAction, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementLinkAction))
WebUI.delay(10)

TestObject testObjTaskConvertPotentialCustomer = findTestObject('Application_My Production/AddresseePage_woXPATH/task_ConvertPotentialCustomer')
WebElement webelementTaskConvertPotentialCustomer = WebUI.findWebElement(testObjTaskConvertPotentialCustomer, 10)
WebUI.click(TestObjectHelper.getTestObjectWithXpath(webelementTaskConvertPotentialCustomer))
WebUI.delay(10)*/

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






