package pruebas;

import entradasalida.SalidaTerminal;
import registros.diccionario.Diccionario;
import registros.diccionario.Palabra;
import registros.diccionario.TipoPalabra;

public class PruebaDiccionario {
    public static void main(String[] args) {

        Diccionario diccionario = new Diccionario(30);
        diccionario.agregarPalabra("Abrir","Descubrir o hacer patente lo que está cerrado u oculto.", TipoPalabra.VERBO);
        diccionario.agregarPalabra("Grande","Que supera en tamaño, importancia, dotes, intensidad, etc., a lo común y regular.",TipoPalabra.ADJETIVO);
        diccionario.agregarPalabra("Pronto","Veloz, acelerado, ligero.",TipoPalabra.ADVERBIO);
        diccionario.agregarPalabra("Sobre","Encima de.",TipoPalabra.PREPOSICION);
        diccionario.agregarPalabra("Contra","Denota la oposición y contrariedad de una cosa con otra.",TipoPalabra.PREPOSICION);
        diccionario.agregarPalabra("Aquí","En este lugar.",TipoPalabra.ADVERBIO);
        diccionario.agregarPalabra("Correr","Ir deprisa.",TipoPalabra.VERBO);
        diccionario.agregarPalabra("Caballo","Mamífero de tamaño grande y extremidades largas, cuello y cola poblados de cerdas largas y abundantes.",TipoPalabra.SUSTANTIVO);
        diccionario.agregarPalabra("Nadar","Trasladarse en el agua, ayudándose de los movimientos necesarios.",TipoPalabra.VERBO);
        diccionario.agregarPalabra("Desde","Denota el punto, en tiempo o lugar, de que se origina una cosa, un hecho o una distancia.",TipoPalabra.PREPOSICION);
        diccionario.imprimirDiccionario();
        // palabras agregadas pa el facil manejo del programa
        SalidaTerminal.consola("\n\n");

        diccionario.menu();

    }
}
