package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenadaDoble;

public class PruebaListaEDoble {
    public  static void main(String cadena[]){
        ListaEncadenadaDoble lista=new ListaEncadenadaDoble();

        lista.agregar("F");
        lista.agregar("H");
        lista.agregar("A");

        lista.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Borrando elementos al final: "+ lista.eliminar()+ "\n");

        lista.imprimir();
        SalidaTerminal.consola("\n");
    }
}
