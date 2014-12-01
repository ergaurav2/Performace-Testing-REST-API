package com.cloud.logic;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.management.ManagementFactory;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cloud.entity.Input;

public class PerformanceTest {
	
	static {
		count = 0 ;
	}
	private static long timeToPrint=0,sumTimes=0;
	private static long count = 0;
	public static class Get implements Runnable {
		private final String url1;
		
		Get(String url) {
			this.url1 = url;
		}

		@Override
		public void run() {
			// long start_time = System.currentTimeMillis();
			try {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
						"proxy.iiit.ac.in", 8080));
				URL url = new URL(url1);
				HttpURLConnection conn = (HttpURLConnection) url
						.openConnection(proxy);
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/json");

		//		if (conn.getResponseCode() != 200) {
			//		throw new RuntimeException("Failed : HTTP error code : "
			//				+ conn.getResponseCode());
			//	}

				/*
				 * BufferedReader br = new BufferedReader(new InputStreamReader(
				 * (conn.getInputStream())));
				 * 
				 * String output;
				 * System.out.println("Output from Server .... \n"); while
				 * ((output = br.readLine()) != null) {
				 * System.out.println(output); }
				 */
				long tID = Thread.currentThread().getId();
				long time = ManagementFactory.getThreadMXBean()
						.getThreadCpuTime(tID);
				System.out.println("My thread " + tID + " execution time: "
						+ time  + " ns.");
				sumTimes=sumTimes+time;
				conn.disconnect();

			} catch (MalformedURLException e) {

				e.printStackTrace();

			} catch (IOException e) {

				e.printStackTrace();

			} catch (Exception e) {

				e.printStackTrace();

			}

			// long end_time = System.currentTimeMillis();

			// long difference = end_time-start_time;
			// System.out.println("Complete in "+difference+" ms.");
		}
	}

	public static class Delete implements Runnable {
        private final String url1;

        Delete(String url) {
            this.url1 = url;
        }

        @Override
        public void run() {

            try {
                System.out.println(url1);
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
                        "proxy.iiit.ac.in", 8080));
                URL url = new URL(url1);
                
            //    HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
                //connection.setRequestMethod("DELETE");
            //    int responseCode = connection.getResponseCode();
                
                HttpURLConnection conn = (HttpURLConnection) url
                        .openConnection(proxy);
                conn.setRequestMethod("DELETE");
            //    conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                long tID = Thread.currentThread().getId();
                long time = ManagementFactory.getThreadMXBean()
                        .getThreadCpuTime(tID);
                System.out.println("My thread " + tID + " execution time: "
                        + time  + " ns.");
                sumTimes=sumTimes+time;
                conn.disconnect();
            //    connection.disconnect();

            } catch (MalformedURLException e) {

                e.printStackTrace();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }
    }

	public static class Post implements Runnable {
		private final String url1;
		private final String parameters;

		Post(String url, String parameters) {
			this.url1 = url;
			this.parameters = parameters;
		}

		@Override
		public void run() {
			/*
			 * 
			 * String urlParameters = "fName=" + URLEncoder.encode("???",
			 * "UTF-8") + "&lName=" + URLEncoder.encode("???", "UTF-8")
			 */
			try {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
						"proxy.iiit.ac.in", 8080));
				URL url = new URL(url1);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection(proxy);
				connection.setRequestMethod("POST");
				// connection.setRequestProperty("Content-Type",
				// "application/x-www-form-urlencoded");

				connection.setRequestProperty("Content-Length",
						"" + Integer.toString(parameters.getBytes().length));
				connection.setRequestProperty("Content-Language", "en-US");

				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);

				// Send request
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(parameters);
				wr.flush();
				wr.close();

				// Get Response
				InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(is));
				String line;
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				// return response.toString();
				long tID = Thread.currentThread().getId();
				long time = ManagementFactory.getThreadMXBean()
						.getThreadCpuTime(tID);
				System.out.println("My thread " + tID + " execution time: "
						+ time  + " ns.");
				sumTimes=sumTimes+time;
				connection.disconnect();
			} catch (Exception e) {

				e.printStackTrace();
				// return null;

			} finally {

			}
		}
	}

	public static class Put implements Runnable {
		private final String url1;
		private final String parameters;

		Put(String url, String parameters) {
			this.url1 = url;
			this.parameters = parameters;
		}

		@Override
		public void run() {

			try {
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
						"proxy.iiit.ac.in", 8080));
				URL url = new URL(url1);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection(proxy);
				connection.setRequestMethod("PUT");

				connection.setRequestProperty("Content-Length",
						"" + Integer.toString(parameters.getBytes().length));
				connection.setRequestProperty("Content-Language", "en-US");

				connection.setUseCaches(false);
				connection.setDoInput(true);
				connection.setDoOutput(true);

				// Send request
				DataOutputStream wr = new DataOutputStream(
						connection.getOutputStream());
				wr.writeBytes(parameters);
				wr.flush();
				wr.close();

				// Get Response
				InputStream is = connection.getInputStream();
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(is));
				String line;
				StringBuffer response = new StringBuffer();
				while ((line = rd.readLine()) != null) {
					response.append(line);
					response.append('\r');
				}
				rd.close();
				// return response.toString();
				long tID = Thread.currentThread().getId();
				long time = ManagementFactory.getThreadMXBean()
						.getThreadCpuTime(tID);
				System.out.println("My thread " + tID + " execution time: "
						+ time  + " ns.");
				sumTimes=sumTimes+time;
				connection.disconnect();
			} catch (Exception e) {

				e.printStackTrace();
				// return null;

			} finally {

			}
		}
	}
	
	public static long startTask(String what,int threads,String url,String payLoad)
	{		
		timeToPrint=0;sumTimes=0;
		ExecutorService executor = Executors.newFixedThreadPool(threads);
		switch (what) {
		case "GET":
			//long start_time = System.nanoTime();
			int i;
			for (i = 0; i < threads; i++) {

				//Runnable worker = new Get(
					//	"http://www.thomas-bayer.com/sqlrest/PRODUCT/49/");
				Runnable worker = new Get(url);
				executor.execute(worker);

			}
			executor.shutdown();

			// Wait until all threads are finish
			while (!executor.isTerminated()) {

			}			
			/*
			 * for ( i = 0; i < threads; ++i) { new Get(
			 * "http://www.thomas-bayer.com/sqlrest/PRODUCT/49/").start(); }
			 */
		//	long end_time = System.nanoTime();
			//
		//	long difference = end_time - start_time;
		//	System.err.println("\nFinished all threads in " + difference
			//		+ "ns.\n\n");

			break;

		case "POST":
			for (i = 0; i < threads; i++) {
				Runnable worker = new Post(
						url,
						payLoad);
				executor.execute(worker);
			}
			executor.shutdown();
			// Wait until all threads are finish
			while (!executor.isTerminated()) {

			}
			System.out.println("\nFinished all threads");
			break;

		case "PUT":
			for (i = 0; i < threads; i++) {
				Runnable worker = new Put(
						url,
						payLoad);
				executor.execute(worker);
			}
			executor.shutdown();
			// Wait until all threads are finish
			while (!executor.isTerminated()) {

			}
			System.out.println("\nFinished all threads");
			break;
		case "DELETE":
			for (i = 0; i < threads; i++) {
				Runnable worker = new Delete(
						url);
				executor.execute(worker);
			}
			executor.shutdown();
			// Wait until all threads are finish
			while (!executor.isTerminated()) {

			}
			System.out.println("\nFinished all threads");
			break;
		}
		System.err.println("Sum of all threads "+sumTimes+" ns.\n");
		timeToPrint=sumTimes/threads;
		return timeToPrint;
	}
	
	public static String convertSectoMin(long totalSecs) {
		long minutes = totalSecs / 60;
		long seconds = totalSecs % 60;
		System.out.println("Total sec"+totalSecs+ "min "+minutes+"seconds "+seconds);
		return  String.format("%02dm:%02ds", minutes, seconds);
	}

	public static void runTest(Input input) {

		String what = input.getMethod().toUpperCase();
		String url=input.getBaseUrl()+input.getPath();
		System.out.println(input);
		System.out.println("what "+what);
		System.out.println("url "+url);
	    String payLoad= input.getTextarea();
	    System.out.println(payLoad);
	    
		
		int threads = input.getNoUsers();
		System.out.println("threads  "+threads);
		//threads=1000;
		int first = input.getFirst();
		System.out.println("first "+first);
		// PerformanceTest pt = new PerformanceTest();

      
		if (first==1) {
			System.out.println("If case--->");
			long worstTime =startTask(what,threads,url,payLoad);
			int worstThroughput= (threads*100000000)/(int)worstTime;
			long avgTime =startTask(what,threads/2,url,payLoad);
			int avgThroughput = (threads*100000000)/(int)(avgTime/2);
			long bestTime = startTask(what,1,url,payLoad);
			int bestThroughput = (threads*100000000)/(int)bestTime;

			PrintWriter writer;
			count = input.getPollFrequency();
			try {
				File f = new File("statistics.txt");
				System.out.println(f.getAbsolutePath());
				writer = new PrintWriter("barchartresponse.txt", "UTF-8");
				System.out.println();
		String output = "[{ \"label\": \"Best case\",\"value\": \""
				+ bestTime
				+ "\"},{\"label\": \"Avg. case\",\"value\": \""
				+ avgTime
				+ "\"},{\"label\": \"Worst case\",\"value\": \""
				+ worstTime
				+ "\"}]";
		System.out.println(output);
		writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer = new PrintWriter("linechartresponse.txt", "UTF-8");
			//	writer.println("{{label:Worst Time, Time: "+worstTime+"}}");
			String output =	"{\"label\": \""
					+ convertSectoMin(count)
				//	+ count
					+ "\",\"value\": \""
					+ worstTime
					+ "\",\"color\": \""
					+ "008ee4"
					+ "\"}";
       			System.out.println("this should be printed -->"+output);
				writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				writer = new PrintWriter("barcharttput.txt", "UTF-8");
			//	writer.println("{{label:Worst Time, Time: "+worstTime+"}}");
				String output = "[{ \"label\": \"Best case\",\"value\": \""
						+ bestThroughput
						+ "\"},{\"label\": \"Avg. case\",\"value\": \""
						+ avgThroughput
						+ "\"},{\"label\": \"Worst case\",\"value\": \""
						+ worstThroughput
						+ "\"}]";
       			System.out.println("this should be printed -->"+output);
				writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				writer = new PrintWriter("linecharttput.txt", "UTF-8");
			//	writer.println("{{label:Worst Time, Time: "+worstTime+"}}");
			String output =	"{\"label\": \""
					+ convertSectoMin(count)
					+ "\",\"value\": \""
					+ worstThroughput
					+ "\",\"color\": \""
					+ "008ee4"
					+ "\"}";
       			System.out.println("this should be printed -->"+output);
				writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Else case--->");
			count = count + input.getPollFrequency();
			long worstTime =startTask(what,threads,url,payLoad);
			int worstThroughput= (threads*100000000)/(int)worstTime;
			PrintWriter writer;
			try {
				writer = new PrintWriter("linechartresponse.txt", "UTF-8");
			//	writer.println("{{label:Worst Time, Time: "+worstTime+"}}");
			String output =	"{\"label\": \""
					+ convertSectoMin(count)
				//	+ count
					+ "\",\"value\": \""
					+ worstTime
					+ "\",\"color\": \""
					+ "008ee4"
					+ "\"}";
       			System.out.println("this should be printed -->"+output);
				writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			try {
				writer = new PrintWriter("linecharttput.txt", "UTF-8");
			//	writer.println("{{label:Worst Time, Time: "+worstTime+"}}");
			String output =	"{\"label\": \""
					+ convertSectoMin(count)
					+ "\",\"value\": \""
					+ worstThroughput
					+ "\",\"color\": \""
					+ "008ee4"
					+ "\"}";
       			System.out.println("this should be printed -->"+output);
				writer.println(output);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
}