package com.cloud.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BarChart {

	public static void generateFileforBar() {

		File file;
		try {

			file = new File("./barchart.txt");
			FileWriter writer = new FileWriter(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			String json = "[{ \"label\": \"Best case\"," + "\"value\": \"232000\""
					+ "}," + "{" + "\"label\": \"Avg. case\","
					+ "\"value\": \"810000\"" + "}," + "{"
					+ "\"label\": \"Worst case\"," + "\"value\": \"720000\""
					+ "}]";
			writer.write(json);
			writer.flush();
			writer.close();
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String readFileforBar(String filename) {
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
