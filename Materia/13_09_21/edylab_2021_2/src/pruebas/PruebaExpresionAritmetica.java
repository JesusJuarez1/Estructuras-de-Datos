package pruebas;

import entradasalida.SalidaTerminal;
import herramientas.matematicas.ExpresionAritmetica;

public class PruebaExpresionAritmetica {
    public static void main(String args[]){
        //-  x  *  /  y  +  f  g  ^  h  q
        //Asignar valores a las variables: x=2, y=1, f=2, g=1, h=2, q=2
        SalidaTerminal.consola("La evaluación de la expresión artimética en notación prefija -2*/1+21^22 es "+
                ExpresionAritmetica.evaluarEPrefija("-2*/1+21^22")+ "\n");
    }
}
