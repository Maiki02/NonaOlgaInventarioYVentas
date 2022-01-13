<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

<script src="https://kit.fontawesome.com/555dcb9a92.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<br>
	<section>
		<div class="mb-3">
			<form action="/Nonaolga/ventas/listDate.do" method="get"
				class="form-inline">
				<label>Busqueda por día:</label> <br>
				<input id="date" type="date"
					name="date" class="form-control col-md-4">
					<input type="number" name="tipo-busqueda" readonly style="visibility:hidden; display:none;" value="1">
				<button type="submit" class="btn btn-success">
					<i class="fas fa-search-dollar"></i>
				</button>



			</form>
		</div>
		<div class="mb-3">
			<form action="/Nonaolga/ventas/listDate.do" method="get"
				class="form-inline">
				<label>Busqueda por semana:</label><br> <input id="date" type="date"
					name="date" class="form-control col-md-4">
					<input type="number" name="tipo-busqueda" readonly style="visibility:hidden; display:none;" value="2">
				<button type="submit" class="btn btn-success">
					<i class="fas fa-search-dollar"></i>
				</button>

			</form>
		</div>
		
		<div class="mb-3">
			<form action="/Nonaolga/ventas/listDate.do" method="get"
				class="form-inline">
				<label>Busqueda por mes:</label><br> <input id="date" type="date"
					name="date" class="form-control col-md-4">
					<input type="number" name="tipo-busqueda" readonly style="visibility:hidden; display:none;" value="3">
				<button type="submit" class="btn btn-success">
					<i class="fas fa-search-dollar"></i>
				</button>

			</form>
		</div>
		
			<div class="mb-3">
			<form action="/Nonaolga/ventas/listDate.do" method="get"
				class="form-inline">
				<label>Busqueda por año:</label><br> <input id="date" type="date"
					name="date" class="form-control col-md-4">
					<input type="number" name="tipo-busqueda" readonly style="visibility:hidden; display:none;" value="4">
				<button type="submit" class="btn btn-success">
					<i class="fas fa-search-dollar"></i>
				</button>

			</form>
		</div>

		<a href="/Nonaolga/ventas/list.do"><button type="button"
				class="btn btn-success">Ventas historicas</button></a>


	</section>
	<footer></footer>
</body>
</html>