let frutas = ["manzana", "platano", "cereza", "naranja"];

for (let i = 0; i < frutas.length; i++) {
    console.log(frutas[i]);
}
let frutaBuscada = prompt("Ingresa una fruta:").toLowerCase();

let encontrada = false;
for (let i = 0; i < frutas.length; i++) {
    if (frutas[i] === frutaBuscada) {
        console.log ( `La fruta ${frutaBuscada} se encuentra en la posicion ${i}`);
        encontrada = true;
        break;
    }
}
if (!encontrada) {
    console.log(`La fruta ${frutaBuscada} no se encuentra en el array`);
}