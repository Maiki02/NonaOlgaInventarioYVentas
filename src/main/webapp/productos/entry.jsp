
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
			<form action="/Nonaolga/productos/create.do" method="post"
				style="width: 80%; margin: auto;">

				<div class="mb-3">
					<label>Productos:</label> <select class="form-select"
						aria-label="Default select example" name="tipo-producto" required>

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
					<input type="number" class="form-control input-sm" name="stock"
						step="1" min=0 placeholder="Cantidad">
				</div>

				<div>
					<button type="submit" class="btn btn-success">Ingresar</button>
				</div>

			</form>



		</div>
	</section>



	<footer></footer>
</body>
</html>