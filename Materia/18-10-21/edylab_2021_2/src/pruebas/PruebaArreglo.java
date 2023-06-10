package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

public class PruebaArreglo {
    public static void main(String argumentos[]){
        ArregloDatos arreglo=new ArregloDatos(4);

        arreglo.agregar("A");
        arreglo.agregar("B");
        arreglo.agregar("D");
        arreglo.agregar("E");
        arreglo.agregar("H");

        arreglo.imprimir();
        SalidaTerminal.consola("\n");
        arreglo.imprimirOrdenInverso();
        SalidaTerminal.consola("\n");

        arreglo.eliminar("B");
        arreglo.imprimirOrdenInverso();
        SalidaTerminal.consola("\n");

        Integer resultadoB= (Integer)arreglo.buscar("E");
        SalidaTerminal.consola("Posicion de E: "+resultadoB+"\n");

        Integer resultadoB2= (Integer)arreglo.buscar("G");
        SalidaTerminal.consola("Posicion de G: "+resultadoB2+"\n");
    }
}
