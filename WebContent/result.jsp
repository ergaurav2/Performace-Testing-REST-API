<%@page import="com.cloud.entity.Input"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.cloud.testsuite.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="fc/js/fusioncharts.js"></script>
<script type="text/javascript"
	src="fc/js/themes/fusioncharts.theme.fint.js"></script>
<script type="text/javascript" src="fc/js/queue.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<script type="text/javascript">
     var chartQ = new Queue(); 
     var chartQ2 = new Queue(); 
     var linechart;
     var linechart2;
	
     function manageQueue(chartDataPoint){
 		if(chartQ.getLength()<5){
 			chartQ.enqueue(chartDataPoint);
 		}else{
 			chartQ.dequeue();
 			chartQ.enqueue(chartDataPoint);
 			//lineChartData= chartQ.getAll();
 		}
 	}
     
     
     function manageQueue2(chartDataPoint){
  		if(chartQ2.getLength()<5){
  			chartQ2.enqueue(chartDataPoint);
  		}else{
  			chartQ2.dequeue();
  			chartQ2.enqueue(chartDataPoint);
  			//lineChartData= chartQ.getAll();
  		}
  	}
     
     
     
     
	
	 FusionCharts.ready(function(){
		var pollFrequency =  document.getElementById('label3').innerHTML ;
		 
		var barData = document.getElementById("label1").innerHTML;
		var lineData = document.getElementById("label2").innerHTML;

		var barData2 = document.getElementById("label4").innerHTML;
		var lineData2 = document.getElementById("label5").innerHTML;
		  
		  
		 
		 manageQueue(lineData);
		 manageQueue2(lineData2);
		 
		 //bar chart
		 var barChart = new FusionCharts({
		        "type": "column3d",
		        "renderAt": "chartContainer",
		        "width": "500",
		        "height": "300",
		        "dataFormat": "json"
		    });

	    barChart.render();
	    barData ='{ "chart": { "caption" : "Response  Time Summary" , ' +
        '"xAxisName" : "Cases", "yAxisName" : "Time in nn sec", "numberPrefix" : "" , "theme": "fint"}, ' +
        '"data" :  '+barData+'  } ';
	    barChart.setJSONData(barData);
	    
	    
	    //first line chart
	    linechart = new FusionCharts({
		    "id":"linechartid",
	        "type": "line",
	        "renderAt": "lineChart",
	        "width": "500",
	        "height": "300",
	        "dataFormat": "json"
	    });
	    linechart.render();
	    lineChartData='{ "chart": {"caption": "Response time timeline",'+
	    '"numberprefix": "$","bgcolor": "FFFFFF","showalternatehgridcolor": "0",'+
	    '"plotbordercolor": "008ee4","plotborderthickness": "3","showvalues": "0",'+
	    '"divlinecolor": "CCCCCC","showcanvasborder": "0","tooltipbgcolor": "00396d",'+
	    '"tooltipcolor": "FFFFFF","tooltipbordercolor": "00396d","numdivlines": "2",'+
	    '"yaxisvaluespadding": "20","anchorbgcolor": "008ee4","anchorborderthickness": "0",'+
	    '"showshadow": "0","anchorradius": "4","chartrightmargin": "25","canvasborderalpha": "0",'+
	    '"showborder": "0"},'+'"data": ['+chartQ.getAll()+']'+
	    '}';
	    linechart.setJSONData(lineChartData);
	    
	    
	    
	    
	    
	    
	    var barChart2 = new FusionCharts({
	        "type": "column3d",
	        "renderAt": "chartContainer2",
	        "width": "500",
	        "height": "300",
	        "dataFormat": "json"
	    });

    barChart2.render();
    barData2 ='{ "chart": { "caption" : "Throughput Summary" , ' +
    '"xAxisName" : "Cases", "yAxisName" : "Time in nn sec", "numberPrefix" : "" , "theme": "fint"}, ' +
    '"data" :  '+barData2+'  } ';
    barChart2.setJSONData(barData2);
    
    
    //first line chart
    linechart2 = new FusionCharts({
	    "id":"linechartid2",
        "type": "line",
        "renderAt": "lineChart2",
        "width": "500",
        "height": "300",
        "dataFormat": "json"
    });
    linechart2.render();
    lineChartData2='{ "chart": {"caption": "Throughput timeline",'+
    '"numberprefix": "$","bgcolor": "FFFFFF","showalternatehgridcolor": "0",'+
    '"plotbordercolor": "008ee4","plotborderthickness": "3","showvalues": "0",'+
    '"divlinecolor": "CCCCCC","showcanvasborder": "0","tooltipbgcolor": "00396d",'+
    '"tooltipcolor": "FFFFFF","tooltipbordercolor": "00396d","numdivlines": "2",'+
    '"yaxisvaluespadding": "20","anchorbgcolor": "008ee4","anchorborderthickness": "0",'+
    '"showshadow": "0","anchorradius": "4","chartrightmargin": "25","canvasborderalpha": "0",'+
    '"showborder": "0"},'+'"data": ['+chartQ2.getAll()+']'+
    '}';
    linechart2.setJSONData(lineChartData2);
	    
	    
	    
	    
	    function reRenderChart(){
		 	// rerender the chart 
			var lineChartData='{ "chart": {"caption": "Response time timeline",'+
			    '"numberprefix": "","bgcolor": "FFFFFF","showalternatehgridcolor": "0",'+
			    '"plotbordercolor": "008ee4","plotborderthickness": "3","showvalues": "0",'+
			    '"divlinecolor": "CCCCCC","showcanvasborder": "0","tooltipbgcolor": "00396d",'+
			    '"tooltipcolor": "FFFFFF","tooltipbordercolor": "00396d","numdivlines": "2",'+
			    '"yaxisvaluespadding": "20","anchorbgcolor": "008ee4","anchorborderthickness": "0",'+
			    '"showshadow": "0","anchorradius": "4","chartrightmargin": "25","canvasborderalpha": "0",'+
			    '"showborder": "0"},'+'"data": ['+chartQ.getAll()+']'+
			    '}';
			    //alert(chartQ.getAll());
			    linechart.setJSONData(lineChartData);
		}
	    
	    function reRenderChart2(){
		 	// rerender the chart 
			var lineChartData2='{ "chart": {"caption": "Throughput timeline",'+
			    '"numberprefix": "","bgcolor": "FFFFFF","showalternatehgridcolor": "0",'+
			    '"plotbordercolor": "008ee4","plotborderthickness": "3","showvalues": "0",'+
			    '"divlinecolor": "CCCCCC","showcanvasborder": "0","tooltipbgcolor": "00396d",'+
			    '"tooltipcolor": "FFFFFF","tooltipbordercolor": "00396d","numdivlines": "2",'+
			    '"yaxisvaluespadding": "20","anchorbgcolor": "008ee4","anchorborderthickness": "0",'+
			    '"showshadow": "0","anchorradius": "4","chartrightmargin": "25","canvasborderalpha": "0",'+
			    '"showborder": "0"},'+'"data": ['+chartQ2.getAll()+']'+
			    '}';
			    //alert(chartQ.getAll());
			    linechart2.setJSONData(lineChartData2);
		}
		
		 // this script 
		(function worker() {
		  $.ajax({
		  	type : "POST",
	                url : "generate",                
	                success : function(data) {
	                	//alert(data);
	                	//data = data.split("</body>")[1];
	                	//alert(data.trim());
	                	
	                	var data1 = data.split("---")[0];
	                	var data2= data.split("---")[1];
		                manageQueue(data1.trim());
		                manageQueue2(data2.trim());
		        		reRenderChart(); 
		         		reRenderChart2(); 
	                },
	               
		    complete: function() {
		    	
	  		
		      // Schedule the next request when the current one's complete
		      //alert( pollFrequency*1000);
		      setTimeout(worker, pollFrequency*1000);
		    }
		  });
		})();


	})
	
	
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	Input input1 = (Input) request.getAttribute("input");
%>
<%
//out.print(request.getAttribute("barString"));
%>
<%
//out.print(request.getAttribute("lineString"));
%>
<div id="label1" style="display: none;"><%=request.getAttribute("barStringResponse")%></div>
<div id="label2" style="display: none;"><%= request.getAttribute("lineStringResponse")%></div>
<div id="label3" style="display: none;"><%=input1.getPollFrequency()%></div>

<div id="label4" style="display: none;"><%=request.getAttribute("barStringTput")%></div>
<div id="label5" style="display: none;"><%= request.getAttribute("lineStringTput")%></div>
</head>
																	
<body																																																																																																																																																																																																																																																		
	style="margin-left: auto; margin-right: auto; width: 85%; height: 1200px; border-style: solid; border-width: 1px;">
	<div
		style="background-color: #001F29; color: white; text-align: center; padding: 5px;">
		<h1>Performance Testing for API</h1>
<%Input input = (Input) request.getAttribute("input");
		%>

		<h3>Results</h3>
	</div>
	<div
		style="display: block; float: left; border-style: solid; border-width: 1px; width: 100%;">
		<div style="display: block;padding-left:50px" >
			<h1>Input Parameters</h1>
		</div>
		
		<div
			style="display: block; float: left; padding-left: 200px; width: 50%;">																																																																																																																																																																																																																																				

			<table>
				<tr>
					<td>Base Url :</td>
					<td><label name="pageurl"><%=input.getBaseUrl()%></td>
				</tr>

				<tr>
					<td>Poll Frequency :</td>
					<td><label name="pollfrequency"><%=input.getPollFrequency()%></td>
				</tr>

				<tr>
					<td>Number of Users :</td>
					<td><label name="nousers" class=box><%=input.getNoUsers()%></td>
				</tr>

				<tr>
					<td>Path :</td>
					<td><label name="path" class=box><%=input.getPath()%></td>
				</tr>

				
			</table>

		</div>
	</div>

	<div>
		<h1 style="padding-left:50px">Results</h1>
		<hr>
		<h2 style="padding-left:50px">Response Time</h2>
		<div style="float:left" id="chartContainer" >FusionCharts XT will load here!</div>
		<div style="float: right"id="lineChart"></div>
		
		<h2 style="padding-left:50px">Throughput</h2>
		<div style="float:left" id="chartContainer2">FusionCharts XT will load here!</div>
		<div style="float:right" id="lineChart2"></div>
	</div>
	
</body>

</html>