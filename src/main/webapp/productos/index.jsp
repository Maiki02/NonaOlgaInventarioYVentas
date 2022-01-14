
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/table.jsp"></jsp:include>

</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<br>
	<section>
		<div class="fondo">
			<div class="botones" style="width: 80%; margin: auto;">
				<a href="#"><button type="submit" class="btn btn-success">Agregar
						producto</button> </a> <a href="#"><button type="submit"
						class="btn btn-warning">Registrar pedido</button> </a> <a href="#"><button
						type="submit" class="btn btn-danger">Registrar perdida</button> </a>
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
													type="submit" class="btn btn-danger">
													<i class="fas fa-trash"></i>
												</button> </a> <a
												href="/Nonaolga/productos/edit.do?id=${producto.getId() }"><button
													type="submit" class="btn btn-success">
													<i class="fas fa-edit"></i>
												</button> </a>
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