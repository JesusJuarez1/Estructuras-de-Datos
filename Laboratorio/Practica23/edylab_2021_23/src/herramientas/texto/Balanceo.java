package herramientas.texto;

import entradasalida.SalidaTerminal;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaCola;
import estructuraslineales.ListaPila;
import herramientas.comunes.Herramientas;

import java.net.ServerSocket;

/**
 * Clase que evalua los balanceos en una cadena o archivo
 */
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
    } //Metodo que ya estaba creado

    /**
     * Verifica que el archivo tenga un balanceo adecuado
     * @param archivo nombre del archivo a evaluar
     * @return true si tiene el balanceo adecuando, false en caso contrario
     */
    public static boolean balanceoArchivo(String archivo){
        ArregloDatos arr = ArchivoTexto.leer(archivo);
        if(!arr.vacia()){
            ListaPila pilaPar = new ListaPila();
            ListaPila pilaCor = new ListaPila();
            ListaPila pilaLla = new ListaPila();
            ListaPila pilaCom = new ListaPila();
            ListaCola cola = new ListaCola();
            for(int i=0;i<arr.cantidadElementos();i++){
                String linea = ""+arr.obtener(i);
                for(int j=0;j<linea.length();j++){
                    if ((""+linea.charAt(j)).equals("(")) {
                        pilaPar.poner(new Simbolo("" + linea.charAt(j), i+1, j+1));
                    }else if((""+linea.charAt(j)).equals("[")){
                        pilaCor.poner(new Simbolo(""+linea.charAt(j),i+1,j+1));
                    }else if((""+linea.charAt(j)).equals("{")) {
                        pilaLla.poner(new Simbolo(""+linea.charAt(j),i+1,j+1));
                    } else if(""+linea.charAt(j) == "/") {
                        if(""+linea.charAt(j+1) == "*"){
                            pilaCom.poner(new Simbolo("/*",i+1,j+1));
                            j++;
                        }
                    }else{
                        if ((""+linea.charAt(j)).equals(")")) {
                            pilaPar.quitar();
                        } else {
                            if ((""+linea.charAt(j)).equals("]")) {
                                pilaCor.quitar();
                            } else {
                                if ((""+linea.charAt(j)).equals("}")) {
                                    pilaLla.quitar();
                                }else{
                                    if((""+linea.charAt(j)).equals("*") && (""+linea.charAt(j+1)).equals("/")){
                                        pilaCom.quitar();
                                        i++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (!pilaPar.vacio() || !pilaLla.vacio() || !pilaCor.vacio() || !pilaCom.vacio()) {
                while(!pilaPar.vacio() || !pilaLla.vacio() || !pilaCor.vacio() || !pilaCom.vacio()){
                    if(!pilaPar.vacio()){
                        cola.poner(pilaPar.quitar());
                    }else if(!pilaLla.vacio()){
                        cola.poner(pilaLla.quitar());
                    }else if(!pilaCor.vacio()){
                        cola.poner(pilaCor.quitar());
                    }else if(!pilaCom.vacio()){
                        cola.poner(pilaCom.quitar());
                    }
                }
                while(!cola.vacio()){
                    Simbolo s = (Simbolo)cola.quitar();
                    SalidaTerminal.consola(""+arr.obtener(s.linea-1)+"\n");
                    String espacios = "";
                    for(int i=0;i<s.caracter;i++){
                        espacios += " ";
                    }
                    SalidaTerminal.consola(espacios+"^ Error caracter: "+(s.simbolo)+
                            ", linea: "+(s.linea)+", columna: "+s.caracter+"\n");
                }
                return false;
            } else {
                SalidaTerminal.consola("Balanceado correcto\n");
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Verifica que la cadena ingresada tenga un balanceo adecuado
     * @param cadena Cadena a evaluar
     * @return true si tiene el balanceo adecuado, false en caso contrario
     */
    public static boolean balanceoCadena(String cadena){
        ListaPila pilaPar = new ListaPila();
        ListaPila pilaCor = new ListaPila();
        ListaPila pilaLla = new ListaPila();
        ListaPila pilaCom = new ListaPila();
        for (int i=0;i<cadena.length();i++){
            if ((""+cadena.charAt(i)).equals("(")) {
                pilaPar.poner(new Simbolo("" + cadena.charAt(i), 1, i));
            }else if((""+cadena.charAt(i)).equals("[")){
                pilaCor.poner(new Simbolo(""+cadena.charAt(i),1,i));
            }else if((""+cadena.charAt(i)).equals("{")) {
                pilaLla.poner(new Simbolo(""+cadena.charAt(i),1,i));
            } else if(""+cadena.charAt(i) == "/") {
                if(""+cadena.charAt(i+1) == "*"){
                    pilaCom.poner(new Simbolo("/*",1,i));
                    i++;
                }
            }else{
                if ((""+cadena.charAt(i)).equals(")")) {
                    pilaPar.quitar();
                } else {
                    if ((""+cadena.charAt(i)).equals("]")) {
                        pilaCor.quitar();
                    } else {
                        if ((""+cadena.charAt(i)).equals("}")) {
                            pilaLla.quitar();
                        }else{
                            if((""+cadena.charAt(i)).equals("*") && (""+cadena.charAt(i+1)).equals("/")){
                                pilaCom.quitar();
                                i++;
                            }
                        }
                    }
                }
            }
        }
        if (pilaPar.vacio() && pilaLla.vacio() && pilaCor.vacio() && pilaCom.vacio()) {
            SalidaTerminal.consola("Balanceo correcto\n");
            return true;
        } else {
            while(!pilaPar.vacio() || !pilaLla.vacio() || !pilaCor.vacio() || !pilaCom.vacio()){
                SalidaTerminal.consola(cadena+"\n");
                Simbolo s = null;
                if(!pilaPar.vacio()){
                    s = (Simbolo)pilaPar.quitar();
                }else if(!pilaLla.vacio()){
                    s = (Simbolo) pilaLla.quitar();
                }else if(!pilaCor.vacio()){
                    s = (Simbolo) pilaCor.quitar();
                }else if(!pilaCom.vacio()){
                    s = (Simbolo) pilaCom.quitar();
                }
                String espacios = "";
                for(int i=0;i<s.caracter;i++){
                    espacios += " ";
                }
                SalidaTerminal.consola(espacios+"^ Error en el simbolo: "+
                        s.simbolo+", columna: "+(s.caracter)+"\n");
            }
            SalidaTerminal.consola("?????");
            return false;
        }
    }
}
