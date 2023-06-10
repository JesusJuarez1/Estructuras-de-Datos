package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ListaGrupo;

public class PruebaListaGrupo {
    public static void main(String[] args) {
        ListaGrupo lista = new ListaGrupo();
        lista.agregarCabeza("F");
        lista.agregarCabeza("A");
        lista.agregarCabeza("L");
        lista.agregarCabeza("J");
        SalidaTerminal.consola("Lista: ");
        lista.imprimirCabezas();
        SalidaTerminal.consola("\nAgregar cabeza inicio: \n");
        lista.agregarCabezaInicio("C");
        lista.agregarCabezaInicio("X");
        lista.imprimirCabezas();
        SalidaTerminal.consola("\nEliminar cabeza inicio: "+lista.eliminarInicioCabeza()+"\n");
        lista.imprimirCabezas();
        SalidaTerminal.consola("\nEliminar cabeza final: "+lista.eliminarFinalCabeza()+"\n");
        lista.imprimirCabezas();
        SalidaTerminal.consola("\nEliminar cabeza C: "+lista.eliminarCabeza("C")+"\n");
        lista.imprimirCabezas();

        SalidaTerminal.consola("\nBuscar cabeza L: "+lista.buscarCabeza("L")+"\n");
        SalidaTerminal.consola("Imprimir cabeza y sus elementos (F):\n");
        lista.imprimirCabezaYElementos("F");
        SalidaTerminal.consola("\nAgregar a grupo: \n");
        lista.agregarAGrupo("F","H");
        lista.agregarAGrupo("F","Z");
        lista.agregarAGrupo("A","Q");
        lista.agregarAGrupo("A","G");
        lista.agregarAGrupo("L","M");
        lista.agregarAGrupo("L","N");
        lista.imprimir();
        SalidaTerminal.consola("\nEliminar final de grupo L: "+lista.eliminarFinalGrupo("L")+"\n");
        lista.imprimir();
        SalidaTerminal.consola("\nBuscar en el grupo A,G: "+lista.buscarGrupo("A","G")+"\n");
        SalidaTerminal.consola("Imprimir elementos del grupo F: \n");
        lista.imprimirElementos("F");
        SalidaTerminal.consola("\nEliminar elemento grneral Q: "+lista.eliminar("Q")+"\n");
        lista.imprimir();
        SalidaTerminal.consola("\nBuscar elemento general Q: \n");
        lista.buscar("Z");
    }
}
