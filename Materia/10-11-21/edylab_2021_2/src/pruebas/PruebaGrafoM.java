package pruebas;

import estructurasnolineales.GrafoMatriz;

public class PruebaGrafoM {
    public  static void  main(String[] argumentos){
        GrafoMatriz grafo1= new GrafoMatriz(4);

        grafo1.agregarVertice("A");
        grafo1.agregarVertice("B");
        grafo1.agregarVertice("C");
        grafo1.agregarVertice("D");

        grafo1.agregarArista("A","C");
        grafo1.agregarArista("A","B");
        grafo1.agregarArista("B","A");
        grafo1.agregarArista("C","C");
        grafo1.agregarArista("C","D");
        grafo1.agregarArista("D","A");
        grafo1.agregarArista("D","B");

        grafo1.imprimir();
    }
}
