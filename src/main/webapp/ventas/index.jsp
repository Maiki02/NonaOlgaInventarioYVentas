<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

<script src="https://kit.fontawesome.com/555dcb9a92.js"
	crossorigin="anonymous"></script>
<script type="text/javascript" src="../assets/scripts/datosVenta.js"
	defer></script>

</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<br>
	<section>
	<form action="/Nonaolga/ventas/listDay.do" method="get" class="form-inline">
	<input id="date" type="date" name="date"  class="form-control col-md-4">
<button type="submit" class="btn btn-success"><i class="fas fa-search-dollar"></i></button>
	
	
	
	</form>
		
		
		<button type="button" class="btn btn-success">Ventas de ayer</button>
		<button type="button" class="btn btn-success">Ventas de la semana</button>
		<button type="button" class="btn btn-success">Ventas del mes</button>
		<button type="button" class="btn btn-success">Ventas del año</button>
		<a href="/Nonaolga/ventas/list.do"><button type="button" class="btn btn-success">Ventas historicas</button></a>


	</section>
	<footer></footer>
</body>
</html>