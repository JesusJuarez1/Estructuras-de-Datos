package pruebas;

import entradasalida.SalidaTerminal;
import registros.diccionario.Diccionario;
import registros.diccionario.Palabra;
import registros.diccionario.TipoPalabra;

public class PruebaDiccionario {
    public static void main(String[] args) {

        Diccionario diccionario = new Diccionario(30);
        diccionario.agregarPalabra("Abrir","Descubrir o hacer patente lo que est� cerrado u oculto.", TipoPalabra.VERBO);
        diccionario.agregarPalabra("Grande","Que supera en tama�o, importancia, dotes, intensidad, etc., a lo com�n y regular.",TipoPalabra.ADJETIVO);
        diccionario.agregarPalabra("Pronto","Veloz, acelerado, ligero.",TipoPalabra.ADVERBIO);
        diccionario.agregarPalabra("Sobre","Encima de.",TipoPalabra.PREPOSICION);
        diccionario.agregarPalabra("Contra","Denota la oposici�n y contrariedad de una cosa con otra.",TipoPalabra.PREPOSICION);
        diccionario.agregarPalabra("Aqu�","En este lugar.",TipoPalabra.ADVERBIO);
        diccionario.agregarPalabra("Correr","Ir deprisa.",TipoPalabra.VERBO);
        diccionario.agregarPalabra("Caballo","Mam�fero de tama�o grande y extremidades largas, cuello y cola poblados de cerdas largas y abundantes.",TipoPalabra.SUSTANTIVO);
        diccionario.agregarPalabra("Nadar","Trasladarse en el agua, ayud�ndose de los movimientos necesarios.",TipoPalabra.VERBO);
        diccionario.agregarPalabra("Desde","Denota el punto, en tiempo o lugar, de que se origina una cosa, un hecho o una distancia.",TipoPalabra.PREPOSICION);
        diccionario.imprimirDiccionario();
        // palabras agregadas pa el facil manejo del programa
        SalidaTerminal.consola("\n\n");

        diccionario.menu();

    }
}
