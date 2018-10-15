package libraries;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import generic.Auto_Const;
public class ExcelLibrary implements Auto_Const
{
	public String getExceldata(String sheetName, int rowNum, int colNum)
	{
		String retval=null;
		try
		{
			FileInputStream fis=new FileInputStream(EXCEL_PATH);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetName);
			Row r=s.getRow(rowNum);
			Cell c=r.getCell(colNum);
			retval=c.getStringCellValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return retval;
	}
	
	public int getRowCount(String sheetName)
	{
		int rowCount=0;
		try
		{
			FileInputStream fis=new FileInputStream("./data/data.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetName);
			rowCount=s.getLastRowNum();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
	public void setExcelData(String sheetName, int rowNum, int cellNum, String data)
	{
		try
		{
			FileInputStream fis=new FileInputStream("./data/data.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet s=wb.getSheet(sheetName);
			Row r=s.getRow(rowNum);
			Cell c=r.createCell(cellNum);
			c.setCellValue(data);
			FileOutputStream fos=new FileOutputStream("./data/data.xlsx");
			wb.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
