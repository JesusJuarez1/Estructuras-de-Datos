package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenada;

public class PruebaArregloListaRR {
    public static void main(String[] args) {
        ArregloDatos a1 = new ArregloDatos(10);
        a1.agregar("A");
        a1.agregar("B");
        a1.agregar("C");
        a1.agregar("D");
        a1.agregar("E");

        SalidaTerminal.consola("PRUEBA ARREGLORR: \n");

        SalidaTerminal.consola("Imprimir: \n");
        a1.imprimirRR();
        SalidaTerminal.consola("Imprimir orden inverso: \n");
        a1.imprimirOrdenInversoRR();
        SalidaTerminal.consola("Buscar D: "+ a1.buscarRR("D")+" \n");
        SalidaTerminal.consola("Eliminar C: "+a1.eliminarRR("C")+"\n");
        a1.imprimirRR();
        SalidaTerminal.consola("Vaciar: \n");
        a1.vaciarRR();
        a1.imprimirRR();

        a1.agregar("A");
        a1.agregar("B");
        a1.agregar("C");
        a1.agregar("D");
        ArregloDatos a2 = new ArregloDatos(5);
        a2.agregar("A");
        a2.agregar("A");
        SalidaTerminal.consola("\nAgregar arreglo: "+a1.agregarListaRR(a2)+"\n");
        a1.imprimirRR();
        SalidaTerminal.consola("Invertir: \n");
        a1.invertirRR();
        a1.imprimirRR();
        SalidaTerminal.consola("Contar: "+a1.contarRR("A")+"\n");
        SalidaTerminal.consola("Rellenar: \n");
        a1.rellenarRR("X",2);
        a1.imprimirRR();
        SalidaTerminal.consola("Clonar: \n");
        ((ArregloDatos)a1.clonarRR()).imprimirRR();
        SalidaTerminal.consola("Rellenar: \n");
        a1.rellenarRR("V");
        a1.imprimirRR();
        SalidaTerminal.consola("Arreglo a lista: \n");
        a1.arregloAListaRR().imprimir();

        SalidaTerminal.consola("\n\nPRUEBA LISTARR: \n");
        ListaEncadenada l1 = new ListaEncadenada();
        l1.agregar("A");
        l1.agregar("B");
        l1.agregar("C");
        l1.agregar("D");
        l1.agregar("E");

        SalidaTerminal.consola("Imprimir: \n");
        l1.imprimirRR();
        SalidaTerminal.consola("\nImprimir orden inverso: \n");
        l1.imprimirOrdenInversoRR();
        SalidaTerminal.consola("\nBuscar: "+l1.buscarRR("D")+"\n");
        SalidaTerminal.consola("Eliminar final: "+l1.eliminarFinalRR()+"\n");
        l1.imprimirRR();
        SalidaTerminal.consola("\nCambiar: "+l1.cambiarRR(2,"X")+"\n");
        l1.imprimir();
        SalidaTerminal.consola("\nObtener: "+l1.obtenerRR(1)+"\n");
        SalidaTerminal.consola("Clonar: \n");
        ListaEncadenada l2 = (ListaEncadenada) l1.clonarRR();
        l2.imprimirRR();
        SalidaTerminal.consola("\nSon iguales: "+l1.esIgualRR(l2)+"\n");
        ArregloDatos arr = new ArregloDatos(2);
        arr.agregar("B");
        arr.agregar("H");
        SalidaTerminal.consola("Agregar lista: "+l1.agregarListaRR(arr)+"\n");
        l1.imprimirRR();
        SalidaTerminal.consola("\nInvertir: \n");
        l1.invertirRR();
        l1.imprimirRR();
        SalidaTerminal.consola("\nContar: "+l1.contarRR("B"));
        SalidaTerminal.consola("\nRellenar: \n");
        l1.rellenarRR("L",3);
        l1.imprimirRR();
    }
}
