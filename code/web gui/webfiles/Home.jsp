<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AUTOMATIC TRAFFIC SHAPER DASHBOARD</title>
</head>
<frameset rows="7%,43%,43%,*">
<frame src="Header.jsp" scrolling="no">
<frameset cols="50%,*">
<frame src="RefreshLatest.jsp" scrolling="no">
<frame  src="RefreshAnalyzer.jsp" scrolling="no">

</frameset>
<frameset cols="50%,*">
<frame src="Refresh.jsp">
<frame src="ManualChange.jsp" scrolling="no">
</frameset>
<frame src="Footer.jsp" scrolling="no">
</frameset>
</html>