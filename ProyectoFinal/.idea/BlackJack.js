let sumaCrupier = 0;
let tuSuma = 0;
let asesCrupier = 0;
let tusAses = 0;
let cartaOculta;
let mazo = [];
let cartasCrupier = [];
let cartasJugador = [];
let puedePedir = true;

window.onload = function () {
    construirMazo();
    barajarMazo();
    iniciarJuego();
};

function construirMazo() {
    let valores = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    let tipos = ["C", "D", "H", "S"];

    for (let tipo of tipos) {
        for (let valor of valores) {
            mazo.push(`${valor}-${tipo}`);
        }
    }
}

function barajarMazo() {
    for (let i = mazo.length - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        [mazo[i], mazo[j]] = [mazo[j], mazo[i]];
    }
    console.log("Mazo barajado:", mazo);
}

function iniciarJuego() {

    cartaOculta = mazo.pop();
    sumaCrupier += obtenerValor(cartaOculta);
    asesCrupier += verificarAs(cartaOculta);

    while (sumaCrupier < 17) {
        let carta = mazo.pop();
        sumaCrupier += obtenerValor(carta);
        asesCrupier += verificarAs(carta);
        cartasCrupier.push(carta);
    }


    for (let carta of cartasCrupier) {
        let imagenCarta = document.createElement("img");
        imagenCarta.src = `./cards/${carta}.png`;
        document.getElementById("cartas-crupier").append(imagenCarta);
    }

    for (let i = 0; i < 2; i++) {
        let carta = mazo.pop();
        tuSuma += obtenerValor(carta);
        tusAses += verificarAs(carta);
        cartasJugador.push(carta);

        let imagenCarta = document.createElement("img");
        imagenCarta.src = `./cards/${carta}.png`;
        document.getElementById("tus-cartas").append(imagenCarta);
    }

    document.getElementById("robar").addEventListener("click", pedirCarta);
    document.getElementById("quedarse").addEventListener("click", quedarse);
}

function pedirCarta() {
    if (!puedePedir) {
        return;
    }

    let carta = mazo.pop();
    tuSuma += obtenerValor(carta);
    tusAses += verificarAs(carta);
    cartasJugador.push(carta);

    let imagenCarta = document.createElement("img");
    imagenCarta.src = `./cards/${carta}.png`;
    document.getElementById("tus-cartas").append(imagenCarta);

    if (reducirAs(tuSuma, tusAses) > 21) {
        puedePedir = false;
    }

    console.log(`Tu suma actual: ${tuSuma}`);
}

function quedarse() {
    sumaCrupier = reducirAs(sumaCrupier, asesCrupier);
    tuSuma = reducirAs(tuSuma, tusAses);

    puedePedir = false;
    document.getElementById("oculta").src = `./cards/${cartaOculta}.png`;

    let mensaje = "";
    if (tuSuma > 21) {
        mensaje = "¡Perdiste!";
    } else if (sumaCrupier > 21) {
        mensaje = "¡Ganaste!";
    } else if (tuSuma == sumaCrupier) {
        mensaje = "¡Empate!";
    } else if (tuSuma > sumaCrupier) {
        mensaje = "¡Ganaste!";
    } else {
        mensaje = "¡Perdiste!";
    }

    document.getElementById("suma-crupier").innerText = sumaCrupier;
    document.getElementById("tu-suma").innerText = tuSuma;
    document.getElementById("resultados").innerText = mensaje;
}

function obtenerValor(carta) {
    let valor = carta.split("-")[0];
    if (isNaN(valor)) {
        return valor === "A" ? 11 : 10;
    }
    return parseInt(valor);
}

function verificarAs(carta) {
    return carta.startsWith("A") ? 1 : 0;
}

function reducirAs(sumaJugador, cantidadAses) {
    while (sumaJugador > 21 && cantidadAses > 0) {
        sumaJugador -= 10;
        cantidadAses -= 1;
    }
    return sumaJugador;
}

