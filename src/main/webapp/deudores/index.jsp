
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
		<div class="container my-3">
			<div class="table-responsive">
				<table class="datatable table table-bordered table-striped"
					class="display" style="width: 100%">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Total a pagar</th>
							<th>Total pagado</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${deudores}" var="deudor">
							<tr>
								<td>${deudor.getNombre()}</td>
								<td>${deudor.getTotalAPagar()}</td>
								<td>${deudor.getTotalPagado()}</td>
								<td>
									<form action="/Nonaolga/deudores/pago.do" action="get" class="form-inline">
										<input type="number" readonly value="${deudor.getId()}"
											class="form-control col-md-3" name="id" required /> 
											<input type="number" class="form-control col-md-3"
											name="importe-pagado" value="0" required max="${deudor.getDeudaRestante()}"/>
										<button type="submit" class="btn btn-success">Registrar pago</button>
									</form>
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