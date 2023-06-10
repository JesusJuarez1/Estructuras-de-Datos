package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloPila;

public class PruebaPila {
    public static void main(String argumentos[]){
        ArregloPila pila=new ArregloPila(4);

        pila.poner("F");
        pila.poner("H");
        pila.poner("D");
        pila.poner("J");
        pila.poner("K");

        pila.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Sacando de la pila: " + pila.quitar()+ "\n");

        pila.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Viendo el tope de la pila: " + pila.verTope()+ "\n");

    }

}
