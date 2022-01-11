
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>



</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<br>

	<c:if test="${flash != null}">
		<div class="alert alert-danger">
			<p>
				<c:out value="${flash}" />
			</p>
		</div>
	</c:if>
	<section>
		<div class="container my-3">
			<form action="/Nonaolga/productos/edit.do" method="post"
				style="width: 80%; margin: auto;">
				
				<div class="mb-3">
					<input class="form-control input-lg" name="id"
						placeholder="ID" value="${producto.getId()}" style="visibility:hidden; display:none;">
				</div>
				
				<div class="mb-3">
					<input class="form-control input-lg" name="nombre"
						placeholder="Nombre producto" value="${producto.getNombre()}" required>
				</div>

				<div class="mb-3">
					<label>Tipo de producto:</label> <select class="form-select"
						aria-label="Default select example" name="tipo-producto" required>

						<c:forEach items="${tipoProductos}" var="tipoProducto">

							<option value="${tipoProducto}" 
								<c:if test="${producto.getTipoProducto().equals(tipoProducto)}">selected</c:if>>
								${tipoProducto}</option>

						</c:forEach>

					</select>
				</div>

				<div class="mb-3">
					<label>Marca:</label> <select class="form-select"
						aria-label="Default select example" name="marca" required>

						<c:forEach items="${marcas}" var="marca">

							<option value="${marca}"
							<c:if test="${producto.getMarca().equals(marca)}">selected</c:if>>${marca}</option>

						</c:forEach>

					</select>

				</div>

				<div class="mb-3">
					<input type="number" class="form-control input-sm"
						name="costo-producto" step="0.01" min=0 placeholder="Costo" value="${ producto.getPrecioCompra()}">
				</div>

				<div class="mb-3">
					<input type="number" class="form-control input-sm"
						name="precio-venta" step="0.01" min=0
						placeholder="Precio de Venta" value="${ producto.getPrecioVenta()}">
				</div>

				<div class="mb-3">
					<input type="number" class="form-control input-sm" name="stock"
						step="1" min=0 placeholder="Cantidad en stock" value="${ producto.getCantidadEnStock()}">
				</div>

				<div>
					<button type="submit" class="btn btn-success">Editar</button>
				</div>

			</form>



		</div>
	</section>



	<footer></footer>
</body>
</html>