<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Form for query 20 -->
	<form action="Food_Activities" method="GET">
		<input type="hidden" name="q20" value="1"/>
		<label>Food activities</label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 21 -->
	<form action="Food_Activities" method="POST">
		<label>Food activities with cuisine: </label>
		<select name="cuisine">
			<option value="American">American</option>
			<option value="British">British</option>
			<option value="Caribbean">Caribbean</option>
			<option value="Chinese">Chinese</option>
			<option value="Egyptian">Egyptian</option>
			<option value="French">French</option>
			<option value="German">German</option>
			<option value="Greek">Greek</option>
			<option value="Indian">Indian</option>
			<option value="International">International</option>
			<option value="Italian">Italian</option>
			<option value="Korean">Korean</option>
			<option value="Mexican">Mexican</option>
			<option value="Turkish">Turkish</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 22 -->
	<form action="Food_Activities" method="POST">
		<label>Food activities with cuisine (and cheap): </label>
		<select name="cuisine_cheap">
			<option value="American">American</option>
			<option value="British">British</option>
			<option value="Caribbean">Caribbean</option>
			<option value="Chinese">Chinese</option>
			<option value="Egyptian">Egyptian</option>
			<option value="French">French</option>
			<option value="German">German</option>
			<option value="Greek">Greek</option>
			<option value="Indian">Indian</option>
			<option value="International">International</option>
			<option value="Italian">Italian</option>
			<option value="Korean">Korean</option>
			<option value="Mexican">Mexican</option>
			<option value="Turkish">Turkish</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 23 -->
	<form action="Food_Activities" method="GET">
		<input type="hidden" name="q23" value="1"/>
		<label>Food activities rated</label>
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Form for query 24 -->
	<form action="Food_Activities" method="POST">
		<label>Food activities rated with cuisine: </label>
		<select name="cuisine_rating">
			<option value="American">American</option>
			<option value="British">British</option>
			<option value="Caribbean">Caribbean</option>
			<option value="Chinese">Chinese</option>
			<option value="Egyptian">Egyptian</option>
			<option value="French">French</option>
			<option value="German">German</option>
			<option value="Greek">Greek</option>
			<option value="Indian">Indian</option>
			<option value="International">International</option>
			<option value="Italian">Italian</option>
			<option value="Korean">Korean</option>
			<option value="Mexican">Mexican</option>
			<option value="Turkish">Turkish</option>
		</select>
		<input type="submit" value="Submit" />
	</form>
</body>
</html>