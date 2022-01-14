<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

<script type="text/javascript" src="../assets/scripts/agregarVenta.js"
	defer></script>
<jsp:include page="/partials/table.jsp"></jsp:include>



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
			<form action="/Nonaolga/ventas/create.do" method="post">

				<div class="mb-3">
					<label>Metodo de pago:</label> <select class="form-select"
						aria-label="Default select example" name="metodo-pago" required>

						<c:forEach items="${metodosDePago}" var="metodo">

							<option value="${metodo}">${metodo}</option>

						</c:forEach>

					</select>
				</div>


				<div id="ventas"></div>

				<div class="mb-3 d-flex flex-row">
					<input type="number" class="form-control col-md-6"
						name="precio-venta" id="precio-venta-total" step="0.01" min=0
						placeholder="Precio de Venta"> <input type="button"
						class="btn btn-success form-control col-md-2"
						onclick="actualizarPrecioTotal()" value="Calcular" />
				</div>
				<input type="text" class="form-control col-md-6"
						name="productos-vendidos" id="productos-vendidos" readonly style="display:none; visibility:hidden;">
						
						<label>(Recomendamos completar en caso de que la venta sea a cobrar)</label>
						<input type="text" class="form-control col-md-6"						
						name="nombre-cliente" id="nombre-cliente" placeholder="Nombre del cliente">
				<div>
					<button type="submit" class="btn btn-success">Vender</button>
				</div>
			</form>

		</div>

		<div class="container my-3">
			<div class="table-responsive">
				<table class="datatable table table-bordered table-striped"
					class="display" style="width: 100%">
					<thead>
						<tr>
							<th>Producto</th>
							<th>Marca</th>
							<th>Nombre</th>
							<th>Precio Venta</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="producto">
							<tr id="fila-tabla${producto.getId()}">
								<td>${producto.getTipoProducto()}</td>
								<td>${producto.getMarca()}</td>
								<td>${producto.getNombre()}</td>
								<td>${producto.getPrecioVenta()}</td>
								<td>
									<button class="boton-agregar btn btn-sm btn-success"
										type="button" onclick='agregarVenta(${producto.getId()})'
										<c:if test="${producto.getCantidadEnStock() == 0}">
		disabled
	</c:if>><i class="fas fa-plus"></i></button>


								</td>
							</tr>
						</c:forEach>
					</tbody>
					<tfoot>

					</tfoot>
				</table>
			</div>
		</div>
	</section>

	<footer></footer>
</body>
</html>