<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Form for query 1 -->
	<form action="Home" method="POST">
		<label>Cities to visit in: </label>
		<select name="season">
		  <option value="Summer">Summer</option>
		  <option value="Autumn">Autumn</option>
		  <option value="Winter">Winter</option>
		  <option value="Spring">Spring</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 2 -->
	<form action="Home" method="POST">
		<label>Cities to visit with category: </label>
		<select name="category">
		  <option value="African">African</option>
		  <option value="Beach">Beach</option>
		  <option value="Capital">Capital</option>
		  <option value="Countryside">Countryside</option>
		  <option value="Historical">Historical</option>
		  <option value="Modern">Modern</option>
		  <option value="Tropical">Tropical</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>