package br.ufv.julian;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class ReadXsl {

	public ReadXsl() {
	}

	public void reading() {
		String s;
		String delimitadores = "[ .,;?!¡¿\'\"\\[\\]]+";
		String[] cadenasSeparadas;
		
		String tipo;
		try {
			InputStream input = new BufferedInputStream(new FileInputStream(
					"D:\\MESTRADO2014\\pesquisa2\\otros\\arquivo.xls"));
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();
				System.out.println("\n");
				Iterator cells = row.cellIterator();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();

					if (HSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
						if (cell.getColumnIndex() == 9) {
							s = cell.getStringCellValue();
							System.out.print( s);
							cadenasSeparadas = s.split(delimitadores);

						}
					}

					else {
						if (cell.getColumnIndex() == 9)
							System.out.print("blank");

					}

					if (cell.getColumnIndex() == 10) {
						tipo = cell.getStringCellValue();
						if(tipo.startsWith("EquacaoRandomica"))
						{
							System.out.println(tipo);
						}
						else if(tipo.startsWith("PeterLevelGenerator"))
						{
							System.out.println(tipo);
						}
						else if(tipo.startsWith("RandomLevel"))
						{
							System.out.println(tipo);
						}
						else if(tipo.startsWith("EquacaoEspecial"))
						{
							System.out.println(tipo);
						}
						
					}

				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
