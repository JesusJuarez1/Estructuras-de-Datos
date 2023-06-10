package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ABB;

public class PruebaABB {
    public static  void main(String[] argumentos){
        ABB arbol=new ABB();

        arbol.agregar(5);
        arbol.agregar(3);
        arbol.agregar(9);
        arbol.agregar(12);
        arbol.agregar(15);
        arbol.agregar(1);
        arbol.agregar(2);
        arbol.agregar(4);
        arbol.agregar(14);
        arbol.agregar(3);

        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("InOrden: ");
        arbol.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol.postOrden();

        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Buscando a 14: "+ arbol.buscar(14)+ "\n");
        SalidaTerminal.consola("Buscando a 29: "+ arbol.buscar(29)+ "\n");
    }
}
