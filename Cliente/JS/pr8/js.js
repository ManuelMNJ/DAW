/*function pedirDiasMes() {
    let dias = Number(prompt("Introduce el numero de dias del mes (28, 30, 31):"));
    if (dias !== 28 && dias !== 30 && dias !== 31) {
        console.log("Numero de dias no valido");
        document.getElementById("respuesta").innerHTML = "Numero de dias no valido";
        return null;
    }

    dias = Number(dias);
    return dias;
}*/
const meses = [
    {nombre: "Enero", dias: 31},
    {nombre: "Febrero", dias: 28},
    {nombre: "Marzo", dias: 31},
    {nombre: "Abril", dias: 30},
    {nombre: "Mayo", dias: 31},
    {nombre: "Junio", dias: 30},
    {nombre: "Julio", dias: 31},
    {nombre: "Agosto", dias: 31},
    {nombre: "Septiembre", dias: 30},
    {nombre: "Octubre", dias: 31},
    {nombre: "Noviembre", dias: 30},
    {nombre: "Diciembre", dias: 31}
];

//let diasIntroducidos = pedirDiasMes();

let div30 = document.getElementById("30dias");
let div31 = document.getElementById("31dias");


let mesesEncontrados30 = meses.filter(mes => mes.dias === 30);
let mesesEncontrados31 = meses.filter(mes => mes.dias === 31);
let mesesEncontrados28 = meses.filter(mes => mes.dias === 28);

if (mesesEncontrados30.length > 0) {
    let nombresMeses = mesesEncontrados30.map(mes => mes.nombre).join(", ");
    console.log(`Los meses con ${30} dias son: ${nombresMeses}`);

    mesesEncontrados30.forEach(mes => {
        let p = document.createElement("p");
        p.textContent = mes.nombre;
        div30.appendChild(p);
    })


}

if (mesesEncontrados31.length > 0) {
    let nombresMeses = mesesEncontrados31.map(mes => mes.nombre).join(", ");
    console.log(`Los meses con ${31} dias son: ${nombresMeses}`);

    mesesEncontrados31.forEach(mes => {
        let p = document.createElement("p");
        p.textContent = mes.nombre;
        div31.appendChild(p);
    })
}