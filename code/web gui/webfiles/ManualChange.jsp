<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>
	

</script>
</head>
<body >

<h2 class="vzh2">QoS POLICY UPDATE</h2>
	<br><br><br>
	<table class="vztable"><tr></tr><tr><td>
	<form action="PushPolicy" method="get">
	<table class="vztable">
	
		<tr>
			<td><b>Enter new Bandwidth for Video and Audio streaming </b>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" id="bw" name="bw" class="vztext"/>
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" class="vzbtn" /><input type="reset" class="vzbtn2"/>
			</td>
		</tr>
	</table>
	</form>
	</td>
	<td>
	<form action="ConfigChangerServlet" method="get">
	<table class="vztable">
	
		<tr>
			<td><b>Enter new Threshold for Congestion </b>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" id="threshold" name="threshold" class="vztext"/>
			</td>
		</tr>
		<tr>
			<td>
			<input type="submit" class="vzbtn" /><input type="reset" class="vzbtn2"/>
			</td>
		</tr>
	</table>
	</form>
	</td></tr></table>
</body>
</html>