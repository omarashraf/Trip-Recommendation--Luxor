<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Form for query 10 -->
	<form action="Sports_Activities" method="POST">
		<label>Sports activities in: </label>
		<select name="city">
		  <option value="Amsterdam">Amsterdam</option>
		  <option value="Aswan">Aswan</option>
		  <option value="Barcelona">Barcelona</option>
		  <option value="Berlin">Berlin</option>
		  <option value="Cairo">Cairo</option>
		  <option value="Luxor">Luxor</option>
		  <option value="Paris">Paris</option>
		  <option value="Prague">Prague</option>
		  <option value="Rome">Rome</option>
		  <option value="Stuttgart">Stuttgart</option>
		  <option value="Venice">Venice</option>
		  <option value="Vienna">Vienna</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 11 -->
	<form action="Sports_Activities" method="GET">
		<input type="hidden" name="q11" value="1"/>
		<label>Sports activities with prices: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 12 -->
	<form action="Sports_Activities" method="GET">
		<input type="hidden" name="q12" value="1"/>
		<label>Sports activities that include water: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 13 -->
	<form action="Sports_Activities" method="POST">
		<label>Sports activities in: </label>
		<select name="price">
		  <option value="20">20</option>
		  <option value="40">40</option>
		  <option value="60">60</option>
		  <option value="80">80</option>
		  <option value="100">100</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>