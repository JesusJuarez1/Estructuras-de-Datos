package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.Tabla3D;

public class PruebaTabla3D {
    public static void  main(String []arguments){
        Tabla3D tabla=new Tabla3D(3,3,2,0);

        tabla.imprimirxColumnas();
        SalidaTerminal.consola("\n");
        tabla.asignarCelda(0,1,1,9);
        tabla.asignarCelda(1,0,0,4);

        tabla.imprimirxColumnas();
        SalidaTerminal.consola("\n");
    }
}
