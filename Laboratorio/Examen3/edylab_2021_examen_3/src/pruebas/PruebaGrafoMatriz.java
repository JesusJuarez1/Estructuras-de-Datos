package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.GrafoMatriz;

public class PruebaGrafoMatriz {
    public static void main(String[] args) {
        GrafoMatriz grafo1 = new GrafoMatriz(4);
        grafo1.agregarVertice("A");
        grafo1.agregarVertice("B");
        grafo1.agregarVertice("C");
        grafo1.agregarVertice("D");

        grafo1.agregarArista("A","B");
        grafo1.agregarArista("B","A");
        grafo1.agregarArista("A","D");
        grafo1.agregarArista("D","A");
        grafo1.agregarArista("B","C");
        grafo1.agregarArista("C","B");
        grafo1.agregarArista("B","D");
        grafo1.agregarArista("D","B");
        grafo1.agregarArista("D","C");
        grafo1.agregarArista("C","D");

        grafo1.imprimir();
        SalidaTerminal.consola("Eliminar vertice (A):\n");
        grafo1.eliminarVertice("A");
        grafo1.imprimir();

        //Se vuelve hacer el grafo
        grafo1 = new GrafoMatriz(4);
        grafo1.agregarVertice("A");
        grafo1.agregarVertice("B");
        grafo1.agregarVertice("C");
        grafo1.agregarVertice("D");

        grafo1.agregarArista("A","B");
        grafo1.agregarArista("B","A");
        grafo1.agregarArista("A","D");
        grafo1.agregarArista("D","A");
        grafo1.agregarArista("B","C");
        grafo1.agregarArista("C","B");
        grafo1.agregarArista("B","D");
        grafo1.agregarArista("D","B");
        grafo1.agregarArista("D","C");
        grafo1.agregarArista("C","D");
        grafo1.agregarArista("C","C");
        SalidaTerminal.consola("\nEs Adyacente (A,D): "+grafo1.esAdyacente("A","D"));
        SalidaTerminal.consola("\nEs Adyacente (A,C): "+grafo1.esAdyacente("A","C")+"\n");
        SalidaTerminal.consola("Eliminar arista (A,D): "+grafo1.eliminarArista("A","D"));
        grafo1.imprimir();
        SalidaTerminal.consola("Buscar vertice: "+grafo1.buscarVertice("C").obtenerDatos()+"\n");

        SalidaTerminal.consola("Es Pseudografo: "+grafo1.esPseudografo()+"\n");
        SalidaTerminal.consola("Es multigrafo: "+grafo1.esMultigrafo()+"\n");
        SalidaTerminal.consola("Grado vertice (B): "+grafo1.gradoVertice("B")+"\n");
        SalidaTerminal.consola("Es dirigido: "+grafo1.esDirigido()+"\n");
        SalidaTerminal.consola("Listar Aristas: \n");
        grafo1.listarAristas();
        SalidaTerminal.consola("\nListar Aristas (C): \n");
        grafo1.listarAristas("C");
        SalidaTerminal.consola("\nListar Vertices: \n");
        grafo1.listarVertices();
    }
}
