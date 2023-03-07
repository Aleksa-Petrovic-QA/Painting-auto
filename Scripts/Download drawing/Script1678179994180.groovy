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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

String home = System.getProperty('user.home')

String userDownloads = new File(home + '/Downloads/')

WebUI.setText(findTestObject('Home page/Board name_input field'), 'test test')

WebUI.click(findTestObject('Home page/Go_button'))

WebUI.click(findTestObject('Sidebar menu/Download icon'))

WebUI.delay(3)

//keyword is checking if the file is present in the "download" folder and then it deletes the file
//IMPORTANT There shouldn't be any file in the "download" folder with the same name before running this test
CustomKeywords.'wbo.downloadCheck.isFileDownloaded'(userDownloads, 'test test.svg')

WebUI.closeBrowser()

