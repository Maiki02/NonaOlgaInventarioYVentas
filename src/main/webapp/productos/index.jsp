
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>



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
			"order" : [ [ 2, "asc" ], [ 5, "desc" ] ]
		});
	});
</script>

<script src="https://kit.fontawesome.com/555dcb9a92.js" crossorigin="anonymous"></script>

</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<br>
	<section>
		<div class="fondo">


			<div class="container my-3">
				<div class="table-responsive">
					<table class="datatable table table-bordered table-striped"
						class="display" style="width: 100%">
						<thead>
							<tr>
								<th>Tipo de producto</th>
								<th>Marca</th>
								<th>Nombre</th>
								<th>Precio Compra</th>
								<th>Precio Venta</th>
								<th>Stock</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${productos}" var="producto">
								<tr>
									<td>${producto.getTipoProducto()}</td>
									<td>${producto.getMarca()}</td>
									<td>${producto.getNombre()}</td>
									<td>${producto.getPrecioCompra()}</td>
									<td>${producto.getPrecioVenta()}</td>
									<td>${producto.getCantidadEnStock()}</td>
									<td>
										<div>
											<a
												href="/Nonaolga/productos/delete.do?id=${producto.getId() }"><button
													type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> </button> </a>
										
											<a href="/Nonaolga/productos/edit.do?id=${producto.getId() }"><button
													type="submit" class="btn btn-success"><i class="fas fa-edit"></i></button> </a>
										</div>

										
									</td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot>

						</tfoot>
					</table>
				</div>
			</div>
		</div>



	</section>
	<footer></footer>
</body>
</html>