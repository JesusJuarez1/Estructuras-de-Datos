package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ArbolExpresion;

public class PruebaArbolExpresion {
    public static void main(String[] args) {
        SalidaTerminal.consola("Arbol expresion priorizada: \n");
        ArbolExpresion ae = new ArbolExpresion();
        ae.expresionPriorizada("(((a*c)+(e/g))-(b+d))");
        SalidaTerminal.consola("Inorden: \n");
        ae.inOrden();
        SalidaTerminal.consola("\nPostorden: \n");
        ae.postOrden();
        SalidaTerminal.consola("\nPreorden: \n");
        ae.preOrden();
    }
}
