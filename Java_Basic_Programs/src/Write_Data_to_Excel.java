import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write_Data_to_Excel {

    public static void main(String[] args) {
        try {
        	
        	String filePath = "C:\\Users\\52300409\\Downloads\\DummyData.xlsx";
        	File file = new File(filePath);
        	XSSFWorkbook wb;
        	XSSFSheet sheet;
        	if(file.exists())
        	{
        		FileInputStream fis = new FileInputStream("C:\\Users\\52300409\\Downloads\\DummyData.xlsx");
                wb = new XSSFWorkbook(fis);
                fis.close();
        	}
        	else
        	{
        		wb = new XSSFWorkbook(); // It will create workbook.
        	}
        	
        	
            
            sheet = wb.getSheet("BCD");
            if(sheet==null)
            {
            	sheet = wb.createSheet("BCD");
            }

            // Check if the row exists; if not, create it
            XSSFRow row = sheet.getRow(3);
            if (row == null) {
                row = sheet.createRow(3);  // Create the row if it doesn't exist
            }

            // Check if the cell exists; if not, create it
            XSSFCell cell = row.getCell(2);
            if (cell == null) {
                cell = row.createCell(2);  // Create the cell if it doesn't exist
            }

            // Set the value in the cell
            cell.setCellValue("Mohd Pervez");

            // Close the input stream and write the updated workbook to the file
//            fis.close();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\52300409\\Downloads\\DummyData.xlsx");
            wb.write(fos);
            fos.close();
            wb.close();  // Always close the workbook

            System.out.println("Name written successfully to the Excel file!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}