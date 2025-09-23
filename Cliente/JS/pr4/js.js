let edad = prompt("Ingresa tu edad:");
let mayor = edad >= 18 && edad <=120? `${edad} esta en el rango de edad` : `${edad} no esta en el rango de edad`;

document.querySelector("p").innerHTML = mayor ;