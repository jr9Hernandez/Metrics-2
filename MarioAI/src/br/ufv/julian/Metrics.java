package br.ufv.julian;

import java.util.Arrays;

import br.ufv.willian.LevelGenerator;
import br.ufv.willian.auxiliares.Parabola;
import dk.itu.mario.level.Level;



public class Metrics extends LevelGenerator {

 public Metrics(int width, int height){
	 this.width=width;
	 this.height=height;
 }
 
 public Level MetricsCalc(int metric)
 {
	 level = retornaTela(level, "TelasSelecionadas/Telas/" + "tela1599");
	 fixWalls();
	 switch (metric) {
		case 1:
			return Metric1();		
			
	 }
	 return level;
}
 
 public Level Metric1()
 {
	 System.out.println("magoo");
	 level.setBlock(0, 2, (byte) (14 + 0 * 16));
	 level.setBlock(1, 2, (byte) (11 + 1 * 16));
	 level.setBlock(2, 2, (byte) (10 + 1 * 16));
	 level.setBlock(3, 2, (byte) (11 + 0 * 16));
	 level.setBlock(4, 2, (byte) (10 + 0 * 16));
	 level.setBlock(5, 2, (byte) (0 + 1 * 16));
	 level.setBlock(6, 2, (byte) (0 + 1 * 16));
	 level.setBlock(7, 2, (byte) (0 + 1 * 16));
	 level.setBlock(8, 2, (byte) (4 + 2 + 1 * 16));
	 level.setBlock(9, 2, (byte) (4 + 1 + 1 * 16));
	 level.setBlock(10, 2, (byte) (2 + 1 * 16));
	 level.setBlock(11, 2, (byte) (1 + 1 * 16));
	 level.setBlock(12, 2, (byte) (9 + 0 * 16));
	 level.setBlock(13, 2, (byte) (2 + 8 * 16));
	 level.setBlock(14, 2, (byte) (0 + 8 * 16));
	 level.setBlock(15, 2, (byte) (3 + 11 * 16));
	 level.setBlock(16, 2, (byte) (3 + 10 * 16));
	 level.setBlock(17, 2, (byte) (1 + 8 * 16));
	 level.setBlock(18, 2, (byte) (2 + 9 * 16));
	 level.setBlock(19, 2, (byte) (0 + 9 * 16));

	 level.print(level.getMap());
	 
	 return level;
 }
	
}
