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
	<section class="fondo">

		<div class="d-grid gap-2 col-lg-5 mx-auto p-3 py-md-5">
			<input type="button" value="Agregar Venta"
				class="btn btn-lg btn-success"
				onclick="location='/Nonaolga/ventas/create.do'" /> <input
				type="button" value="Agregar Producto"
				class="btn btn-lg btn-success"
				onclick="location='/Nonaolga/productos/create.do'" />

			<!-- Modal -->
			<button type="button" class="btn btn-lg btn-success"
				data-toggle="modal" data-target="#exampleModalCenter">
				Ingreso de mercaderías</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModalCenter" tabindex="-1"
				role="dialog" aria-labelledby="exampleModalCenterTitle"
				aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLongTitle">Modal
								title</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<form action="/Nonaolga/productos/entry.do" method="get"
								style="width: 80%; margin: auto;">

								<div class="mb-3">
									<label>Productos:</label> <select class="form-select"
										aria-label="Default select example" name="producto"
										required>

										<c:forEach items="${productos}" var="producto">

											<option value="${producto}">${producto}</option>

										</c:forEach>

									</select>
								</div>

								<div class="mb-3">
									<input type="number" class="form-control input-sm"
										name="costo-producto" step="0.01" min=0 placeholder="Costo">
								</div>


								<div class="mb-3">
									<input type="number" class="form-control input-sm" name="cantidad"
										step="1" min=0 placeholder="Cantidad">
								</div>

								<div>
									<button type="submit" class="btn btn-success">Ingresar</button>
								</div>

							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
				</div>
			</div>



		</div>
	</section>


</body>
</html>
