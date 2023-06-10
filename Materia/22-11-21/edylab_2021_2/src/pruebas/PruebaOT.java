package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.GrafoMatriz;

public class PruebaOT {
    public  static  void  main(String args[]){
        GrafoMatriz grafoOT=new GrafoMatriz(6);

        grafoOT.agregarVertice("P1");
        grafoOT.agregarVertice("P2");
        grafoOT.agregarVertice("P3");
        grafoOT.agregarVertice("P4");
        grafoOT.agregarVertice("P5");
        grafoOT.agregarVertice("P6");

        grafoOT.agregarArista("P1","P3");
        grafoOT.agregarArista("P2","P3");
        grafoOT.agregarArista("P3","P4");
        grafoOT.agregarArista("P3","P6");
        grafoOT.agregarArista("P4","P5");
        grafoOT.agregarArista("P4","P6");
        grafoOT.agregarArista("P5","P6");

        grafoOT.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Ordenación topológica: ");
        grafoOT.ordenacionTopologica().imprimir();
    }
}
