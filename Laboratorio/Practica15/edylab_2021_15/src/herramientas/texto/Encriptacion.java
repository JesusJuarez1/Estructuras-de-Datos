package herramientas.texto;

import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloPila;

import java.util.Random;

public class Encriptacion {

    /**
     * Encripta un mensaje donde el numero de partes a encriptar, las posiciones
     * donde encriptara y sus longitudes son aleatorias
     * @param mensaje Mensaje a encriptar
     * @return Mensaje encriptado
     */
    public static String encriptarMensaje(String mensaje){
        Random rand = new Random();
        int numAgrup = rand.nextInt(((int)mensaje.length()/2)+1)+1;
        String mensajeEncriptado = "";
        int posMin = 0;
        for(int pos=0;pos<numAgrup;pos++){
            if(posMin < mensaje.length()){
                int posicion = posMin+rand.nextInt((mensaje.length()-posMin+1));
                int ancho = rand.nextInt((mensaje.length()-posicion)+1);
                if(posicion+ancho <= mensaje.length()){
                    ArregloPila pila = new ArregloPila(ancho);
                    for(int p=posMin;p<(posicion+ancho);p++){
                        if(p<posicion){
                            mensajeEncriptado += mensaje.charAt(p);
                        }else if(p==posicion){
                            mensajeEncriptado += "Ç";
                            pila.poner(mensaje.charAt(p));
                        }else if(p < (posicion+ancho)){
                            pila.poner(mensaje.charAt(p));
                        }
                    }
                    if(!pila.vacio()){
                        while(!pila.vacio()){
                            mensajeEncriptado += pila.quitar();
                        }
                        mensajeEncriptado += "Ç";
                        posMin = (posicion+ancho);
                    }
                }
            }
        }
        return mensajeEncriptado;
    }

    /**
     * Desencripta un archivo de texto y escribe un archivo nuevo
     * @param archivo Nombre del archivo encriptado
     * @return True si lo hace, false en caso contrario
     */
    public static boolean desencriptarArchivo(String archivo){
        ArregloDatos encriptado = ArchivoTexto.leer(archivo);
        ArregloDatos desencriptado = new ArregloDatos(encriptado.capacidad());
        if(!encriptado.vacia()){
            for(int posicion=0;posicion<encriptado.cantidadElementos();posicion++){
                desencriptado.agregar(desencriptar(encriptado.obtener(posicion).toString()));
            }
            ArchivoTexto.escribir(desencriptado,"desencriptado.txt");
            return true;
        }else{
            return false;
        }
    }

    /**
     * Desencripta un mensaje dado
     * @param mensaje Mensaje a desencriptar
     * @return El mensaje desencriptado
     */
    public static String desencriptar(String mensaje){
        String mensajeDesencriptado = "";
        for(int pos=0;pos<mensaje.length();pos++){
            if(mensaje.charAt(pos) == 'Ç'){
                ArregloPila pila = new ArregloPila(mensaje.length());
                pos++;
                while(mensaje.charAt(pos) != 'Ç' && pos < mensaje.length()){
                    pila.poner(mensaje.charAt(pos));
                    pos++;
                }
                while(!pila.vacio()){
                    mensajeDesencriptado += pila.quitar();
                }
            }else{
                mensajeDesencriptado += mensaje.charAt(pos);
            }
        }
        return mensajeDesencriptado;
    }
}
