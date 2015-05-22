package br.ufv.julian;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import br.ufv.willian.LevelGenerator;
import dk.itu.mario.level.Level;

public class ReadXsl {

	double metric1;
	double metric2;
	double metric3;
	double metric4;
	int gerador;

	public ReadXsl() {
	}

	public void reading(int width, int height, long seed, int difficulty,
			int type) {
		String s="";
		String delimitadores = "\\s+";
		String[] cadenasSeparadas;
		int counterTiles = 0;
		String tipo;
		int counterPeter =0;
		try {
			FileOutputStream fileOut = new FileOutputStream("D:\\MESTRADO2014\\pesquisa2\\otros\\resultados\\conpeter\\poi-test.xls");
			InputStream input = new BufferedInputStream(new FileInputStream(
					"D:\\MESTRADO2014\\pesquisa2\\otros\\resultados\\conpeter\\arquivo.xls"));
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			
			while (rows.hasNext()) {
				
				HSSFRow row = (HSSFRow) rows.next();
				row.createCell(18);
				row.createCell(19);
				row.createCell(20);
				System.out.println("\n");
				Iterator cells = row.cellIterator();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell) cells.next();

					if (cell.getColumnIndex() == 10) {
						if (gerador == 1) {

							s = cell.getStringCellValue();
							// System.out.print( s);
							cadenasSeparadas = s.split(delimitadores);
							System.out.println("el tam de las separadas"
									+ cadenasSeparadas.length);
							Level currentLevel = new Level();
							currentLevel = LevelGenerator.createLevelMetrics(
									width, height, seed, difficulty, type, 0,
									cadenasSeparadas);
							Metrics objMetrics = new Metrics(
									currentLevel.getWidth(),
									currentLevel.getHeight(), currentLevel);
							metric1 = objMetrics.MetricsCalc(1);
							metric2=objMetrics.MetricsCalc(2);
							metric3=objMetrics.MetricsCalc(3);
							//metric4=objMetrics.MetricsCalc(4);
						} else if (gerador == 2) {

							cadenasSeparadas = s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
							Level currentLevel = new Level();
							currentLevel = LevelGenerator.createLevelMetrics(
									width, height,  Long.parseLong(cadenasSeparadas[1]), Integer.parseInt(cadenasSeparadas[3]), Integer.parseInt(cadenasSeparadas[5]), 2,
									cadenasSeparadas);
							Metrics objMetrics = new Metrics(
									currentLevel.getWidth(),
									currentLevel.getHeight(), currentLevel);
							metric1 = objMetrics.MetricsCalc(1);
							metric2=objMetrics.MetricsCalc(2);
							metric3=objMetrics.MetricsCalc(3);
							//metric4=objMetrics.MetricsCalc(4);
							
							
						} else if (gerador == 3) {

							counterPeter=counterPeter+1;
							cadenasSeparadas = s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
							if(counterPeter<28)
							{
								cadenasSeparadas[0]="player_mal.txt";
							}
							else
							{
								cadenasSeparadas[0]="player_bien.txt";
							}
							Level currentLevel = new Level();
							currentLevel = LevelGenerator.createLevelMetrics(
									width, height,  0, 0, 0, 4,
									cadenasSeparadas);
							System.out.println("aca entramos3");
							Metrics objMetrics = new Metrics(
									currentLevel.getWidth(),
									currentLevel.getHeight(), currentLevel);
							metric1 = objMetrics.MetricsCalc(1);
							metric2=objMetrics.MetricsCalc(2);
							metric3=objMetrics.MetricsCalc(3);
							
							//metric4=objMetrics.MetricsCalc(4);
						}

					}
					

					else if (cell.getColumnIndex() == 9) {
						counterTiles = counterTiles + 1;
						if (counterTiles > 1) {
							tipo = cell.getStringCellValue();
							if (tipo.startsWith("EquacaoRandomica")) {
								gerador = 1;
								// System.out.println(tipo);
							} else if (tipo.startsWith("PeterLevelGenerator")) {
								s = cell.getStringCellValue();
								gerador = 3;
								// System.out.println(tipo);
							} else if (tipo.startsWith("RandomLevel")) {
								s = cell.getStringCellValue();
								gerador = 2;
								// System.out.println(tipo);
							} else if (tipo.startsWith("EquacaoEspecial")) {
								gerador = 1;
							}
						}
					} else if (  cell.getColumnIndex() == 18) {
						
						if (gerador == 1) {
							cell.setCellValue(metric1);

						} else if (gerador == 2) {
							cell.setCellValue(metric1);
							// System.out.println(tipo);
						} else if (gerador == 3) {
							//gerador = 2;
							cell.setCellValue(metric1);
						}

					} else if (  cell.getColumnIndex() == 19) {
						
						if (gerador == 1) {
							cell.setCellValue(metric2);

						} else if (gerador == 2) {
							cell.setCellValue(metric2);
							// System.out.println(tipo);
						} else if (gerador == 3) {
							//gerador = 2;
							cell.setCellValue(metric2);
						}

					} else if (  cell.getColumnIndex() == 20) {
						
						if (gerador == 1) {
							cell.setCellValue(metric3);

						} else if (gerador == 2) {
							cell.setCellValue(metric3);
							// System.out.println(tipo);
						} else if (gerador == 3) {
							//gerador = 2;
							cell.setCellValue(metric3);
						}

					}
					

				}
			}
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
