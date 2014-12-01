package com.cloud.testsuite;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.cloud.entity.BarChart;
import com.cloud.entity.Input;
import com.cloud.entity.InputParameter;
import com.cloud.entity.LineChart;
import com.cloud.logic.GenerateOutput;
import com.cloud.logic.PerformanceTest;

public class GenerateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		//super.doPost(req, resp);
		System.out.println(req.getAttribute("index"));
		if(req.getParameter(InputParameter.baseUrl)!=null) {
		Input input = new Input();
		input.setBaseUrl(req.getParameter(InputParameter.baseUrl));
		input.setMethod(req.getParameter(InputParameter.method));
		input.setPath(req.getParameter(InputParameter.path));
		//input.setNoCalls(Integer.parseInt(req.getParameter(InputParameter.noCalls)));
		input.setPollFrequency(Integer.parseInt(req.getParameter(InputParameter.pollFrequency)));
		input.setNoUsers(Integer.parseInt(req.getParameter(InputParameter.noUsers)));
		input.setTextarea(req.getParameter(InputParameter.textarea));
		req.setAttribute("input", input);
		req.getSession().setAttribute("input", input);
		input.setFirst(1);
		PerformanceTest.runTest(input);
		//GenerateOutput.generateFiles();
		String barChartResponse = BarChart.readFileforBar("./barchartresponse.txt");
		String lineChartResponse = LineChart.readFileforLine("./linechartresponse.txt");
		String barChartTput = BarChart.readFileforBar("./barcharttput.txt");
		String lineChartTput = LineChart.readFileforLine("./linecharttput.txt");
//		req.setAttribute("jsonString", arg1);
		req.setAttribute("barStringResponse", barChartResponse);
		req.setAttribute("lineStringResponse", lineChartResponse);
		req.setAttribute("barStringTput", barChartTput);
		req.setAttribute("lineStringTput", lineChartTput);
		req.getRequestDispatcher("/result.jsp").forward(req, resp);
		}else {
			System.out.println("load case");
			Input input = (Input)req.getSession().getAttribute("input");
			input.setFirst(0);
			PerformanceTest.runTest(input);
			//GenerateOutput.generateFiles();
			String barChartResponse = BarChart.readFileforBar("./barchartresponse.txt");
			String lineChartResponse = LineChart.readFileforLine("./linechartresponse.txt");
			String barChartTput = BarChart.readFileforBar("./barcharttput.txt");
			String lineChartTput = LineChart.readFileforLine("./linecharttput.txt");
//			req.setAttribute("jsonString", arg1);
			req.setAttribute("barStringResponse", barChartResponse);
			req.setAttribute("lineStringResponse", lineChartResponse);
			req.setAttribute("barStringTput", barChartTput);
			req.setAttribute("lineStringTput", lineChartTput);
			req.getRequestDispatcher("/load2.jsp").forward(req, resp);
		}
		//System.out.println("Input "+input);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get");
		//super.doGet(req, resp);
	}
}
