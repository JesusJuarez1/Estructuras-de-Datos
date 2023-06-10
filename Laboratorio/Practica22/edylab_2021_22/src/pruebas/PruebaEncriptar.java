package pruebas;

import entradasalida.SalidaTerminal;
import entradasalida.archivos.ArchivoTexto;
import estructuraslineales.ArregloDatos;
import herramientas.texto.Encriptacion;
import herramientas.texto.Palindromo;

public class PruebaEncriptar {
    public static void main(String[] args) {
        String mensajeEncriptado = Encriptacion.encriptarMensaje("Estructuras de Datos");
        SalidaTerminal.consola(mensajeEncriptado+"\n");
        ArregloDatos arr = new ArregloDatos(5);
        arr.agregar(mensajeEncriptado);
        arr.agregar("o«os«");
        ArchivoTexto.escribir(arr,"encriptado.txt");
        SalidaTerminal.consola("Desencriptar archvio de texto: "+ Encriptacion.desencriptarArchivo("encriptado.txt")+"\n");
        ArregloDatos des = ArchivoTexto.leer("desencriptado.txt");
        des.imprimir();
        SalidaTerminal.consola("Palabras palindromas en el archivo desencriptado:\n");
        Palindromo.palindromosEnArchivo("desencriptado.txt");
    }
}
