
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>

<script type="text/javascript" src="../assets/scripts/agregarVenta.js"
	defer></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.css" />

<script defer
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script defer
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script defer type="text/javascript"
	src="https://cdn.datatables.net/v/bs5/dt-1.11.3/datatables.min.js"></script>

<script type="text/javascript">
	// Para más ejemplos de uso y documentación
	// https://www.datatables.net/examples/index
	window.addEventListener('DOMContentLoaded', function() {
		$('.datatable').DataTable({
			// Opciones
			"order" : [ [ 2, "desc" ], [ 5, "desc" ] ]
		});
	});
</script>



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
				'<input type="text" class="form-control col-md-6"
						name="productos-vendidos" id="productos-vendidos" readonly style="display:none; visibility:hidden;">
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
							<th>Tipo de producto</th>
							<th>Marca</th>
							<th>Nombre</th>
							<th>Precio Venta</th>
							<th>Acciones</th>
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
	</c:if>>Agregar</button>


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