package br.ufv.julian;

import java.util.Arrays;

import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.SimpleLinearRegression;
import br.ufv.willian.LevelGenerator;
import br.ufv.willian.auxiliares.Parabola;
import dk.itu.mario.engine.sprites.SpriteTemplate;
import dk.itu.mario.level.Level;

public class Metrics extends LevelGenerator {

	public Metrics(int width, int height, Level level) {
	
		this.width = width;
		this.height = height;
		this.level = level;
		
		//Metric2 objMetric2= new Metric2();
	}
	public Metrics(){}

	public double MetricsCalc(int metric) {
		switch (metric) {
		case 1:
			Metric1 objMetric1= new Metric1(width, height, level);
			return objMetric1.Metric1M();
		case 2:
			Metric2 objMetric2= new Metric2(width, height, level);
			return objMetric2.Metric2M();
		}
		return 0;
	}








}
