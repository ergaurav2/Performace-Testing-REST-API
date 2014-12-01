package com.cloud.logic;

import com.cloud.entity.BarChart;
import com.cloud.entity.LineChart;

public class GenerateOutput {

	public static void generateFiles() {
		BarChart.generateFileforBar();
		LineChart.generateFileforLine();
	}
	
}
