package herramientas.texto;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;

/**
 * Clase que hace el menu, con el cual se podra elegir que es lo que se quiere hacer
 */
public class MenuTexto {

    /**
     * Menu que contiene opciones para evaluar el balanceo de una cadena y un archvio
     */
    public static void menu(){
        int op = 0;
        while(op != 3){
            String m = "1.- Verificar balanceo de una cadena ((-), [-], {-} y /*-*/)\n" +
                    "2.- Verificar balanceo de un archivo ((-), [-], {-} y /*-*/)\n" +
                    "3.- Salir";
            SalidaTerminal.consola(m+"\n" +
                    "Ingresa el numero de la opcion deseada: ");
            op = EntradaTerminal.consolaInteger();
            if(op == 1){
                SalidaTerminal.consola("Ingresa la cadena a evaluar: ");
                String cadena = EntradaTerminal.consolaCadena();
                Balanceo.balanceoCadena(cadena);
            }else if(op == 2){
                SalidaTerminal.consola("Ingresa el nombre del archivo a evaluar: ");
                String archivo = EntradaTerminal.consolaCadena();
                Balanceo.balanceoArchivo(archivo);
            }
        }
    }
    //Math.exp(-(Math.pow[x-media,2)/{2*Math.pow(desv,2)})     Cadena
    //texto.txt             Archivo
}
