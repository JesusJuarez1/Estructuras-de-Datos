package herramientas.texto;

import entradasalida.SalidaTerminal;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloPila;

public class Palindromo {

    /**
     * Imprime las palabras dentro del archvo que son palindromas
     * @param archivo Nombre del archivo del que se va a leer
     */
    public static void palindromosEnArchivo(String archivo){
        ArregloDatos arr = ArchivoTexto.leer(archivo);
        for(int posicion=0;posicion<arr.cantidadElementos();posicion++){
            String cadena = arr.obtener(posicion).toString();
            for(int pos=0;pos<cadena.length();pos++){
                String palabra = "";
                while(pos < cadena.length() && cadena.charAt(pos) != ' '){
                    palabra += cadena.charAt(pos);
                    pos++;
                }
                if(esPalindroma(palabra)){
                    SalidaTerminal.consola(palabra+"\n");
                }
            }
        }
    }


    /**
     * Mete la cadena en dos pilas, una de forma normal y otra en forma invertida y evalua los datos para ver si son iguales
     * @param cadena La cadena que se evaluara
     * @return true si la cadena es palindroma, false en caso contrario
     */
    public static boolean esPalindroma(String cadena){
        ArregloPila cadNor = new ArregloPila(cadena.length());
        cadena.toLowerCase();
        for(int posicion=0;posicion<cadena.length();posicion++){
            if(cadena.charAt(posicion) != ' '){
                cadNor.poner(cadena.charAt(posicion));
            }
        }
        ArregloPila cadInv = new ArregloPila(cadena.length());
        for(int posicion=cadena.length()-1;posicion>=0;posicion--){
            if(cadena.charAt(posicion) != ' '){
                cadInv.poner(cadena.charAt(posicion));
            }
        }
        while(!cadNor.vacio()){
            if(!cadNor.quitar().toString().equalsIgnoreCase(cadInv.quitar().toString())){
                return false;
            }
        }
        return true;
    }
}
