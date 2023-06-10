package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ArbolBinario;

public class PruebaArbolBinario {
    public static  void  main(String args[]){
        ArbolBinario arbol=new ArbolBinario();

        arbol.crearArbol(); //crear un árbol a petición del usuario

        SalidaTerminal.consola("\nImpresión en inOrden: \n");
        arbol.inOrden();

        SalidaTerminal.consola("\nImpresión en preOrden: \n");
        arbol.preOrden();

        SalidaTerminal.consola("\nImpresión en postOrden: \n");
        arbol.postOrden();
    }
}
