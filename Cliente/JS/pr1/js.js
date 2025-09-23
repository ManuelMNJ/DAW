let num1 = prompt("Ingresa un numero:");
let num2 = prompt("Ingresa el segundo numero:");

let resultado = parseInt(num1) + parseInt(num2);

console.log(resultado);

alert("El resultado de la suma es: \n " + resultado);
document.querySelector("p").innerHTML = "El resultado es: <br/>" + resultado;
