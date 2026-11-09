package ReadUtils;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;



public class DataProviderExample {

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() throws IOException, InvalidFormatException {
        // Provide the path to the Excel file and the sheet name
       // return ExcelUtils.getExcelData("/Users/thiruveedi.vasista/Desktop/loginData.xlsx", "Sheet1");
        return ExcelUtils.getExcelData("src/main/resources/demo.xlsx", "Sheet1");
    }
    
    
    
}