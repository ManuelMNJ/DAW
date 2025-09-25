let frutas = ["manzana", "platano", "cereza", "naranja"];

for (let i = 0; i < frutas.length; i++) {
    console.log(frutas[i]);
}
let frutaBuscada = prompt("Ingresa una fruta:").toLowerCase();

let encontrada = false;

frutas.forEach((fruta, i) => {
    if (!encontrada && fruta === frutaBuscada) {

        console.log(`La fruta ${frutaBuscada} se encuentra en la posicion ${i}`);
        document.getElementById("respuesta").innerHTML = `La fruta ${frutaBuscada} se encuentra en la posicion ${i}`;

        encontrada = true;

    }
});

if (!encontrada) {
    console.log(`La fruta ${frutaBuscada} no se encuentra en el array`);
}