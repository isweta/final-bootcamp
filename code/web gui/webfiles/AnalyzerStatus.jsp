<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >

<%
		String paths = "C:\\Users\\Public\\Documents\\file2\\GetMonitorStats\\src\\MonitorStats\\policyChangeLog.txt";

		File fileObject = new File(paths);

		BufferedReader br = new BufferedReader(new FileReader(paths));

		String line = null;
		
		
		if((line=br.readLine())!=null)
			out.println("<b><br>"+line);
		if((line=br.readLine())!=null)
			out.println("<br>"+line+"</b>");
		out.println("<br>");
		out.println("<table class='vztable'>");
		out.println("<tr></tr>");
		out.println("<tr>");
		if((line=br.readLine())!=null)
			out.println("<td bgcolor='#595a5d'><font color='#ffffff'>"+line+"</font></td>");
		for(int i=0; i<10; i++){
			if((line=br.readLine())!=null){
				int num=Integer.parseInt(line);
				if(num>0)
					out.println("<td bgcolor='red'>"+num+"</td>");
				else
					out.println("<td bgcolor='green'>"+num+"</td>");
			}
			
		}
			
		out.println("</table>");
		out.println("</tr>");
		out.println("<h3 class='vzh3'>");
		while ((line = br.readLine()) != null) {
			out.println("<br> "+line);
		}
		out.println("</h3>");

		%>


</body>
</html>