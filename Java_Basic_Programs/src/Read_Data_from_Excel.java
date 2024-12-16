import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data_from_Excel {

	public static void main(String[] args) throws IOException {
		
		getData("C:\\Users\\52300409\\Downloads\\DummyData.xlsx", "BCD");

	}
	
	static void getData(String filePath, String sheetName) throws IOException
	{
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		for(int i = 0; i<=rowCount; i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			if(row!=null)
			{
				System.out.print("Value from "+ i + " row : ");
				Iterator<Cell> cellIterator = row.cellIterator();
				while(cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();
					switch(cell.getCellType())
					{
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						default:
							System.out.print("Unknown\t");
                            break;
					}
				}
			}
			
			System.out.println();
		}
	
		
	}

}
