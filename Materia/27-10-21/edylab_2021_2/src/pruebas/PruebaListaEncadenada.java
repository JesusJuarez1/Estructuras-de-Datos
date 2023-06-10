package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;

public class PruebaListaEncadenada {
    public static void main(String[] argumentos){
        ListaEncadenada lista =new ListaEncadenada();

        lista.agregar("F");
        lista.agregar("H");
        lista.agregar("K");
        lista.agregar("N");

        lista.imprimir();
        SalidaTerminal.consola("\n");

        lista.agregarInicio("B");
        lista.agregarInicio("A");

        lista.imprimir();
        SalidaTerminal.consola("\n");

        //---

        SalidaTerminal.consola("Eliminando al inicio: "+ lista.eliminarInicio()+ "\n");

        lista.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Eliminando al final: "+ lista.eliminar()+ "\n");

        lista.imprimir();
        SalidaTerminal.consola("\n");

        //---
        SalidaTerminal.consola("Buscando el elemento H: " + lista.buscar("H")+ "\n");
        SalidaTerminal.consola("Buscando el elemento Z: " + lista.buscar("Z")+ "\n");

        SalidaTerminal.consola("Eliminando H: " + lista.eliminar("H")+ "\n");
        lista.imprimir();
        SalidaTerminal.consola("\n");
    }
}
