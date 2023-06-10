package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;
import estructurasnolineales.GrafoListaAdyacencia;

public class PruebaComConexos {
    public static void main(String[] args) {
        GrafoListaAdyacencia grafo = new GrafoListaAdyacencia();
        grafo.agregarVertice("a");
        grafo.agregarVertice("b");
        grafo.agregarVertice("c");
        grafo.agregarVertice("d");
        grafo.agregarVertice("e");
        grafo.agregarVertice("f");
        grafo.agregarVertice("g");

        grafo.agregarArista("a","b");
        grafo.agregarArista("b","a");

        grafo.agregarArista("a","c");
        grafo.agregarArista("c","a");

        grafo.agregarArista("b","c");
        grafo.agregarArista("c","b");

        grafo.agregarArista("c","d");
        grafo.agregarArista("d","c");


        grafo.agregarArista("e","f");
        grafo.agregarArista("f","e");

        grafo.agregarArista("f","g");
        grafo.agregarArista("g","f");

        grafo.imprimir();
        SalidaTerminal.consola("Componentes conexos:\n");
        ListaEncadenada compCon = (ListaEncadenada) grafo.componenetesConexos("A");
        ((ListaEncadenada)compCon.obtener(0)).imprimir();
        SalidaTerminal.consola("\n");
        ((ListaEncadenada)compCon.obtener(1)).imprimir();

        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("\n");

        //---------------- SEGUNDO EJEMPLO
        GrafoListaAdyacencia grafo1 = new GrafoListaAdyacencia();

        grafo1.agregarVertice("A");
        grafo1.agregarVertice("B");
        grafo1.agregarVertice("C");
        grafo1.agregarVertice("D");
        grafo1.agregarVertice("H");
        grafo1.agregarVertice("T");
        grafo1.agregarVertice("R");

        grafo1.agregarArista("H","A");
        grafo1.agregarArista("H","T");
        grafo1.agregarArista("H","D");

        grafo1.agregarArista("R","H");

        grafo1.agregarArista("B","H");

        grafo1.agregarArista("D","B");
        grafo1.agregarArista("D","C");

        grafo1.agregarArista("C","R");

        grafo1.imprimir();

        SalidaTerminal.consola("Componentes conexos:\n");
        ListaEncadenada componenetesConexos = (ListaEncadenada)grafo1.componenetesConexos("A");
        ((ListaEncadenada)componenetesConexos.obtener(0)).imprimir();
        SalidaTerminal.consola("\n");
        ((ListaEncadenada)componenetesConexos.obtener(1)).imprimir();
    }
}
