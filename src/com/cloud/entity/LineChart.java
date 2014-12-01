package com.cloud.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineChart {
	public static void generateFileforLine() {

		File file;
		try {

			file = new File("./linechart.txt");
			FileWriter writer = new FileWriter(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			String json = "{" + "\"label\": \"10\","
					+ "\"value\": \"4400000\"," + "\"color\": \"008ee4\"" + "}";
			writer.write(json);
			writer.flush();
			writer.close();
			System.out.println("Done**********"+file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFileforLine(String filename) {
		StringBuffer sb = null;
		try {
			FileReader fr = new FileReader(new File(filename));
			BufferedReader br = new BufferedReader(fr);
			 sb = new StringBuffer();
			String line = "";
			while((line=br.readLine())!=null) {
				sb.append(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}