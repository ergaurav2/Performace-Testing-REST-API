
    <%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<script type ="text/javascript">
function formSubmit(){
	alert(1);
	document.getElementById("inputform").submit();	
	
}
</script>
<body onload="formSubmit();">	
	<form  id="inputform" action="generate" method="post">
		</form>
	
</body>
	<%
            String jspPath = session.getServletContext().getRealPath("");
            String txtFilePath = "/home/manish/Downloads/eclipse"+ "/linechart.txt";
            BufferedReader reader = new BufferedReader(new FileReader(txtFilePath));
            StringBuilder sb = new StringBuilder();
            String line;

            while((line = reader.readLine())!= null){
                sb.append(line);
            }
            out.println(sb.toString());
        %>
		  
