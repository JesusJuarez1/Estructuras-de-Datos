package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.GrafoMatriz;
import herramientas.generales.TipoOrden;
import sun.security.x509.IssuerAlternativeNameExtension;

public class PruebaPRMC {
    public static  void main(String[] argumentos){
        GrafoMatriz grafo=new GrafoMatriz(8, TipoOrden.DESC);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");
        grafo.agregarVertice("E");
        grafo.agregarVertice("F");
        grafo.agregarVertice("G");
        grafo.agregarVertice("H");

        grafo.agregarArista("A","B",7);
        grafo.agregarArista("B","A",7);

        grafo.agregarArista("A","c",5);
        grafo.agregarArista("c","A",5);

        grafo.agregarArista("B","D",2);
        grafo.agregarArista("D","B",2);

        grafo.agregarArista("C","D",9);
        grafo.agregarArista("D","C",9);

        grafo.agregarArista("B","F",6);
        grafo.agregarArista("F","B",6);

        grafo.agregarArista("D","E",1);
        grafo.agregarArista("E","D",1);

        grafo.agregarArista("C","G",3);
        grafo.agregarArista("G","C",3);

        grafo.agregarArista("E","G",3);
        grafo.agregarArista("G","E",3);

        grafo.agregarArista("E","F",8);
        grafo.agregarArista("F","E",8);

        grafo.agregarArista("F","H",4);
        grafo.agregarArista("H","F",4);

        grafo.agregarArista("G","H",7);
        grafo.agregarArista("H","G",7);

        SalidaTerminal.consola("El grafo: \n");
        grafo.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Inicia el proceso de Dijkstra \n\n");
        grafo.etiquetasOptimas("A").imprimir();

        SalidaTerminal.consola("La métrica óptima de A->H es: ");
        Double metricaOptima=grafo.metricaOptima("A","H");
        if (metricaOptima==null){
            SalidaTerminal.consola("<el origen o el destino no existen>");
        }else{
            SalidaTerminal.consola(""+metricaOptima);
        }
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("La ruta óptima de A->H es: ");
        grafo.rutaOptima("A","H").imprimir();
    }
}
