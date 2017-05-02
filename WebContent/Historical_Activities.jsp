<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Form for query 3 -->
	<form action="Historical_Activities" method="POST">
		<label>Historical activities in: </label>
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
	
	<!-- Form for query 4 -->
	<form action="Historical_Activities" method="GET">
		<input type="hidden" name="q4" value="1"/>
		<label>Historical activities sorted: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 5 -->
	<form action="Historical_Activities" method="POST">
		<label>Historical activities with ranking: </label>
		<select name="ranking">
		  <option value="5">5</option>
		  <option value="4">4</option>
		  <option value="3">3</option>
		  <option value="2">2</option>
		  <option value="1">1</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 6 -->
	<form action="Historical_Activities" method="GET">
		<input type="hidden" name="q6" value="1"/>
		<label>Historical activities open in daylight: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 7 -->
	<form action="Historical_Activities" method="GET">
		<input type="hidden" name="q7" value="1"/>
		<label>Historical activities open at night: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 8 -->
	<form action="Historical_Activities" method="GET">
		<input type="hidden" name="q8" value="1"/>
		<label>Historical activities with prices: </label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 9 -->
	<form action="Historical_Activities" method="GET">
		<input type="hidden" name="q9" value="1"/>
		<label>Historical activities with prices (sorted): </label>
		<input type="submit" value="Submit" />
	</form>
	
</body>
</html>