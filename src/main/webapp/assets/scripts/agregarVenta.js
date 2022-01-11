let ventas = document.getElementById('ventas');
let precioVenta = document.getElementById('precio-venta-total');
let productosVendidos = document.getElementById('productos-vendidos');

function agregarVenta(id) {
	let filaTabla = document.getElementById('fila-tabla' + id);
	let celdas = filaTabla.cells;

	let tipoProducto = celdas[0].textContent;
	let marca = celdas[1].textContent;
	let nombre = celdas[2].textContent;
	let precioVenta = celdas[3].textContent;

	ventas.insertAdjacentHTML('beforeend', agregarProducto(tipoProducto, marca, nombre, precioVenta, id));
}

function agregarProducto(tipoProducto, marca, nombre, precioVenta, id) {
	return '<div class="mb-3 d-flex flex-row producto' + id + '">'
		+ '<input type="text" class="form-control col-md-6" readonly value="' + tipoProducto + ", " + marca + ", " + nombre + '"/>'
		+ '<input type="number" class="form-control col-md-1" value="1" min="1" step="1" onclick="actualizarPrecioIndividual(' + id + ')"/>'
		+ '<input type="number" class="form-control col-md-2" value="' + precioVenta + '" min="0" step="0.1" onclick="actualizarPrecioIndividual(' + id + ')"/>'
		+ '<input type="number" class="form-control col-md-2" value="' + precioVenta + '" min="0" step="0.1" />'
		+ '<input type="button" class="btn btn-danger" onclick=eliminarVenta(' + id + ') value="Eliminar"/></div>';
}

function eliminarVenta(id) {
	let producto = document.getElementsByClassName('producto' + id);
	for (let i = 0; i < producto.length; i++) {
		producto[i].remove();
	}
}

function actualizarPrecioIndividual(id) {
	let producto = document.getElementsByClassName('producto' + id);
	producto[0].children[3].value = producto[0].children[1].value * producto[0].children[2].value
}

function actualizarPrecioTotal() {
	let precioFinal = 0;
	productosVendidos.value="";
	
	for (let i = 0; i < ventas.children.length; i++) {
		precioFinal += Number(ventas.children[i].children[3].value);
		productosVendidos.value+= ventas.children[i].children[0].value + ", "; //Agregamos el producto
		productosVendidos.value+= ventas.children[i].children[1].value + ";"; //Agregamos la cantidad
		
	}
	precioVenta.value = precioFinal;
}



