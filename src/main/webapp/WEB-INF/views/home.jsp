<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>
			Hello world!  
		</h1>
		
		<P>  The time on the server is ${serverTime}. </P>
		
		<p> Questa � la stringa di prova dal server: ${testString} </p>
		<p> Questo � il numero negativo di prova dal server: ${numeroNegativo} </p>
		<p> Questa � la valuta di prova dal server: ${valuta} </p>
	</body>
</html>
