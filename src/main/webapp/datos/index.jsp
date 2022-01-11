<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<div class="contenedor d-grid gap-2 col-lg-5 mx-auto p-3 py-md-5"
		style="width: 80%">
		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
				</p>
			</div>
		</c:if>



		<div class="mb-4">
			<form action="/Nonaolga/datos/create-marca.do" method="post">
				<div class="mb-1">
					<input class="form-control input-sm" name="marca-nueva"
						placeholder="Nombre de la marca nueva" value="" required>
				</div>

				<div class="mb-1">
					<button type="submit" class="btn btn-sm btn-success">Agregar
						Marca</button>
				</div>


			</form>
		</div>
		<div class="mb-6">
			<form action="/Nonaolga/datos/create-tipo-producto.do" method="post">
				<div class="mb-1">
					<input class="form-control input-sm" name="tipo-producto-nuevo"
						placeholder="Nombre del tipo de producto nuevo" value="" required>
				</div>

				<div class="mb-1">
					<button type="submit" class="btn btn-sm btn-success">Agregar
						tipo de producto</button>
				</div>

			</form>
		</div>
		<input type="button" value="Ver datos" class="btn btn-sm btn-success" />
		<input type="button" value="Productos escasos"
			class="btn btn-sm btn-success" />

	</div>
</body>
</html>
