package TestData;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriven2 {

	public static WebDriver driver;

	/*
	 * @BeforeMethod public static void initialization() {
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * driver = new ChromeDriver();
	 * 
	 * driver.get(
	 * "http://www.gcrit.com/build3/admin/login.php?osCAdminID=e15ci0v5pkgieg6c0v12kqpg04"
	 * );
	 * 
	 * }
	 */

	@Test(dataProvider = "testdata")

	public void addition(String num1, String num2, String num3) {
		
		int a = Integer.parseInt(num1);
		int b = Integer.parseInt(num1);
		int c = Integer.parseInt(num1);
		
		System.out.println(a+b+c);

		

	}

	@DataProvider(name = "testdata")

	public Object[][] readExcel() throws BiffException, IOException {

		File inputFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\excelFile\\integer.xls");
		Workbook wb = Workbook.getWorkbook(inputFile);

		Sheet sheet = wb.getSheet("Sheet1");
		int cols = sheet.getColumns();
		int rows = sheet.getRows();
		

		String inputData[][] = new String[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				Cell cel = sheet.getCell(j, i);
				inputData[i][j] = cel.getContents();
				//System.out.println(inputData[i][j]);
			}
		}
		return inputData;

	}
}
