<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Form for query 15 -->
	<form action="Entertainment_Activities" method="GET">
		<input type="hidden" name="q15" value="1"/>
		<label>Entertainment activities: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 17 -->
	<form action="Entertainment_Activities" method="GET">
		<input type="hidden" name="q17" value="1"/>
		<label>Entertainment activities that open in daylight: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 18 -->
	<form action="Entertainment_Activities" method="POST">
		<label>Entertainment activities that open in daylight with price less than: </label>
		<select name="price">
			<option value="20">20</option>
			<option value="40">40</option>
			<option value="60">60</option>
			<option value="80">80</option>
			<option value="100">100</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 19 -->
	<form action="Entertainment_Activities" method="POST">
		<label>Entertainment activities that open in daylight having duration time: </label>
		<select name="duration">
			<option value="0.5">0.5</option>
			<option value="1.0">1.0</option>
			<option value="1.5">1.5</option>
			<option value="2.0">2.0</option>
			<option value="2.5">2.5</option>
			<option value="3.0">3.0</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>