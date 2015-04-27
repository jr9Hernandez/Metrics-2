package br.ufv.julian;

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
	 
	 return level;
 }
	
}
