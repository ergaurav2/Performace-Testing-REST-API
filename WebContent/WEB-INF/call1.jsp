<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
.box
{
height: 25px;
width: 250px;
}
.ta
{

}
</style>

<script type ="text/javascript">
document.getElementById("inputform").submit();
        function TextAreaVisibility(){
if (document.getElementById('dropdown').value=="put" || document.getElementById('dropdown').value=="post") //only display the value when user select 1

document.getElementById('textarea1').style.display='block';
else

document.getElementById('textarea1').style.display='none';
}
function myFunction() {
   var js=document.getElementById("textarea1").value;
jsonobj = JSON.parse(js);

document.getElementById("textarea1").value=JSON.stringify(jsonobj,null,'\t');
}
</script>

<body style="margin-left: auto;margin-right: auto; width: 70%;height:650px;border-style: solid;border-width: 1px;">	
	
	<div style="background-color:#001F29;color:white;text-align:center;padding:5px;">
	<h1>Performance Testing for API</h1>
	</div>

	<div style="padding-top: 1cm">	
		<form id="inputform" action="generate" method="post">

			<table style="float:left;padding-left:200px;">
				  <tr>
				    <td>Base Url :</td>
				    <td><input type="text" name="baseUrl" placeholder="Enter URL" class=box></td> 
				  </tr>

				  <tr>
				    <td>Poll Frequency :</td>
				    <td><input type="number"  name="pollFrequency" class=box></td> 
				  </tr>

					<tr>
					    <td>Number of Users :</td>
					    <td><input type="number"  name="noUsers" class=box></td> 
					  </tr>

					<tr>
					    <td>Path :</td>
					    <td><input type="text" name="path" class=box></td> 
					  </tr>
					
					<tr>
					    <td>No of Polls :</td>
					    <td><input type="number"   name="noPolls" class=box></td> 
					</tr>
	
					<tr>
						  <td>Method :</td>
						  <td><select id="dropdown" name="method" onchange ="TextAreaVisibility()">
						  <option value="get">Get</option>
						  <option value="put">Put</option>
						  <option value="post">Post</option>
						  <option value="delete">Delete</option>
								</select>
							</td> 
					</tr>
					
					<tr>
					<td></td>	   
					 <td><textarea id="textarea1"  name="textarea" cols="70" rows="15"  style="display: none;resize: none;" onchange ="myFunction()"/></textarea></td>
					</tr>
	
					<tr>
					    <td></td>
					    <td><input type="submit" value="Submit"></td> 
					</tr>
			</table>
		</form>
	</div>

</body>
</html>