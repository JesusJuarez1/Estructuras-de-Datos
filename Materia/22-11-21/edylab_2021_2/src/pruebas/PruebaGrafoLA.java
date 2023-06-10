package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.GrafoListaAdyacencia;

public class PruebaGrafoLA {
    public  static  void main(String args[]){
        GrafoListaAdyacencia grafo= new GrafoListaAdyacencia();

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");

        grafo.agregarArista("A","B");
        grafo.agregarArista("A","E");

        grafo.agregarArista("B","D");
        grafo.agregarArista("B","E");

        grafo.agregarArista("C","A");

        grafo.agregarArista("E","C");
        grafo.agregarArista("E","D");

        grafo.imprimir();

        SalidaTerminal.consola("El recorrido en profundidad del grafo es: ");
        grafo.recorridoProfundidad("A").imprimir();
    }
}
