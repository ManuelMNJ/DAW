let mes = Number(prompt("Ingresa un numero del 1 al 12:"));

if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
    document.querySelector("p").innerHTML = "El mes tiene 31 dias";
} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
    document.querySelector("p").innerHTML = "El mes tiene 30 dias";
} else if (mes == 2) {
    document.querySelector("p").innerHTML = "El mes tiene 28 dias"
} else {
    document.querySelector("p").innerHTML = "El numero ingresado no es valido o no es un numero";
}