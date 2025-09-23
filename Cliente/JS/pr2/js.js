let num1 = prompt("Ingresa un numero:");
let num2 = prompt("Ingresa el segundo numero:");
let resultadoSuma = parseInt(num1) + parseInt(num2);
let resultadoResta = parseInt(num1) - parseInt(num2);
let resultadoMultiplicacion = parseInt(num1) * parseInt(num2);
let resultadoDivision = parseInt(num1) / parseInt(num2);
let comparacion = parseInt(num1) > parseInt(num2);
let igualdad = parseInt(num1) === parseInt(num2);



document.body.innerHTML =  `
${num1} mas ${num2} = ${resultadoSuma}<br>
${num1} menos ${num2} = ${resultadoResta}<br>
${num1} por ${num2} = ${resultadoMultiplicacion}<br>
${num1} entre ${num2} = ${resultadoDivision}<br>
¿${num1} es mayor que ${num2}? ${comparacion}<br>
¿${num1} es igual que  ${num2}? ${igualdad}
`;

console.log(
    `${num1} mas ${num2} = ${resultadoSuma}\n` +
    `${num1} menos ${num2} = ${resultadoResta}\n` +
    `${num1} por ${num2} = ${resultadoMultiplicacion}\n` +
    `${num1} entre ${num2} = ${resultadoDivision}\n` +
    `¿${num1} es mayor que ${num2}? ${comparacion}\n` +
    `¿${num1} es igual que  ${num2}? ${igualdad}`
);
