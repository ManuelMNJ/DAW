//Hacerlo con un forEach

let frutas = ["manzana", "pera", "platano"];

let frutaString = "";

frutas.forEach(fruta =>{
    console.log(fruta);
    frutaString += fruta + ", ";
})

document.getElementById('resultado').innerHTML = frutaString;