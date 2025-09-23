const p = document.querySelector("p");
let nota1;
let nota2;
let nota3;
let nota4;

function pedirNotas() {
    while (isNaN(nota1) || nota1 === "" || nota1 === null || nota1 < 0 || nota1 > 10) {
        nota1 = prompt("Ingresa la primera nota:");
    }

    while (isNaN(nota2) || nota2 === "" || nota2 === null || nota2 < 0 || nota2 > 10) {
        nota2 = prompt("Ingresa la segunda nota:");
    }
    while (isNaN(nota3) || nota3 === "" || nota3 === null || nota3 < 0 || nota3 > 10) {
        nota3 = prompt("Ingresa la tercera nota:");
    }
    while (isNaN(nota4) || nota4 === "" || nota4 === null || nota4 < 0 || nota4 > 10) {
        nota4 = prompt("Ingresa la cuarta nota:");
    }

}


function calcularMedia(n1, n2, n3, n4) {
    let media = (parseFloat(nota1) + parseFloat(nota2) + parseFloat(nota3) + parseFloat(nota4)) / 4;

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
    }
}

pedirNotas();
calcularMedia(nota1, nota2, nota3, nota4);