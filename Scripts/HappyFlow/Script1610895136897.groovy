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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.concurrent.ThreadLocalRandom as ThreadLocalRandom

int quantity_phones = ThreadLocalRandom.current().nextInt(2, 10 + 1)

int quantity_jeans = ThreadLocalRandom.current().nextInt(2, 10 + 1)

int phone_price = 100

int jean_price = 1

int expected_price = (quantity_phones * phone_price) + (quantity_jeans * jean_price)

WebUI.openBrowser('')

WebUI.navigateToUrl('http://demowebshop.tricentis.com/')

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop/a_Log in'))

WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Email_Email'), 'katalon@test.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Password_Password'), 'o+tS4OuGt32s9ezZj287yw==')

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Login/input_Forgot password_button-1 login-button'))

WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop/input_You have no items in your shopping cart._q'), 'smartphone')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Demo Web Shop/a_Smartphone'), 0)

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop/a_Smartphone'))

WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop. Smartphone/input_Qty_addtocart_43.EnteredQuantity'), 
    quantity_phones.toString())

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Smartphone/input_Qty_add-to-cart-button-43'))

WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop. Smartphone/input_Sub-Total_q'), 'Jeans')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Demo Web Shop. Smartphone/a_Blue Jeans'), 0)

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Smartphone/a_Blue Jeans'))

WebUI.setText(findTestObject('Object Repository/Page_Demo Web Shop. Blue Jeans/input_Qty_addtocart_36.EnteredQuantity'), 
    quantity_jeans.toString())

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Blue Jeans/input_Qty_add-to-cart-button-36'))

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Blue Jeans/span_Shopping cart'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/span_101.00'), expected_price.toString() + 
    '.00')

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/input_Remove_removefromcart'))

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/input_Total_updatecart'))

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/input_Remove_removefromcart'))

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/input_Total_updatecart'))

WebUI.click(findTestObject('Object Repository/Page_Demo Web Shop. Shopping Cart/a_Log out'))

WebUI.closeBrowser()

