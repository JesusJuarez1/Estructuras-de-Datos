package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloCola;

public class PruebaCola {
    public static  void  main(String args[]){
        ArregloCola cola=new ArregloCola(4);

        cola.poner("A");
        cola.poner("B");
        cola.poner("C");
        cola.poner("D");
        cola.poner("E");

        cola.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Sacando del frente: "+ cola.quitar()+ "\n");
        cola.imprimir();
        SalidaTerminal.consola("\n");
        cola.poner("E");
        cola.imprimir();
        SalidaTerminal.consola("\n");
    }
}
