package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.GrafoMatriz;

public class PruebaRecorridoProf {
    public  static  void  main(String argumentos[]){
        GrafoMatriz grafo=new GrafoMatriz(6);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");

        grafo.agregarArista("A","B");
        grafo.agregarArista("A","C");
        grafo.agregarArista("B","D");
        grafo.agregarArista("D","A");
        grafo.agregarArista("D","E");
        grafo.agregarArista("D","F");

        grafo.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("El recorrido en profundidad partiendo de A es: ");
        grafo.recorridoProfundidad("A").imprimir();
        SalidaTerminal.consola("\n");
    }
}
