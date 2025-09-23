let nota1 = prompt("Ingresa la primera nota:");
let nota2 = prompt("Ingresa la segunda nota:");
let nota3 = prompt("Ingresa la tercera nota:");
let nota4 = prompt("Ingresa la cuarta nota:");

let media = (parseFloat(nota1) + parseFloat(nota2) + parseFloat(nota3) + parseFloat(nota4)) / 4;
const p = document.querySelector("p");

if (media >= 0 && media < 5) {
    p.innerHTML = `El alumno ha sacado un: <br/>${media} (Insuficiente)`;
} else if (media >= 5 && media < 6) {
    p.innerHTML = `El alumno ha sacado un: <br/>${media} (Suficiente)`;
} else if (media >= 6 && media < 7) {
    p.innerHTML = `El alumno ha sacado un: <br/>${media} (Bien)`;
} else if (media >= 7 && media < 9) {
    p.innerHTML = `El alumno ha sacado un: <br/>${media} (Notable)`;
} else if (media >= 9 && media <= 10) {
    p.innerHTML = `El alumno ha sacado un: <br/>${media} (Sobresaliente)`;
} else {
   p.innerHTML = `Error, nota no válida`;
}