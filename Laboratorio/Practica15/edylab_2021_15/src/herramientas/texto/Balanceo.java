package herramientas.texto;

import estructuraslineales.ListaPila;
import herramientas.comunes.Herramientas;

public class Balanceo {

    public static boolean estaBalanceadoParentesis(String cadena){
        ListaPila pila = new ListaPila();
        for(int posicion=0;posicion<cadena.length();posicion++){
            pila.poner(cadena.charAt(posicion));
        }
        int abre = 0;
        int cierra = 0;
        while(!pila.vacio()){
            char o = (char)pila.quitar();
            if(Herramientas.compararObjetos(o,')') == 0){
                cierra++;
            }else if(Herramientas.compararObjetos(o,'(') == 0){
                abre++;
            }
        }
        if(abre == cierra){
            return true;
        }else{
            return false;
        }
    }
}
