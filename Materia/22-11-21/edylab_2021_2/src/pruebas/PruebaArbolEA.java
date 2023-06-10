package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ArbolExpresionAritmetica;

public class PruebaArbolEA {
    public static  void main(String args[]){
        ArbolExpresionAritmetica arbol =new ArbolExpresionAritmetica();

        arbol.crearArbolExpPostfija("xyfg/*+3-");
        SalidaTerminal.consola("Inorden: ");
        arbol.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Preorden: ");
        arbol.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol.postOrden();
        SalidaTerminal.consola("\n");
    }
}
