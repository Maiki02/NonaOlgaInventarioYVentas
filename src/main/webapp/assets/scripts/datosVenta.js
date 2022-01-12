let costoFinal = 0;
let precioVentaFinal= 0;
let ganancia=0;

let tabla = document.getElementById('tabla');
let info = document.getElementById('info');


//El primer valor representa la suma del precio de costo
//El segundo representa la suma del precio de venta
//El tercero representa la diferencia entre los dos primeros valores (ganancia)
function sumarValores() {
	let fila=tabla.rows;
	for (let i = 1; i < fila.length; i++) {
		costoFinal += Number(fila[i].children[1].textContent);
		precioVentaFinal += Number(fila[i].children[2].textContent);
	}
	ganancia=obtenerGanancia(precioVentaFinal, costoFinal);
}

function obtenerGanancia(precioVenta, costo) {
	return precioVenta - costo;
}

function ponerDatos() {

	info.insertAdjacentHTML('beforeend', "<p>Costo: " + costoFinal + "</p>" +
		"<p>Precio total: " + precioVentaFinal + "</p>" +
		"<p>Ganancia: " + ganancia + "</p>");
}

ponerDatos();