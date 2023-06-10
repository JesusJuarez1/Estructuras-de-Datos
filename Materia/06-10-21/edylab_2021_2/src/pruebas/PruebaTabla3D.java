package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla2D;
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

        invocarMetodosTablas(tabla);
    }
    public static void invocarMetodosTablas(Tabla3D tabla){
        SalidaTerminal.consola("Imprimir tablas2d extraidas del cubo: \n");
        ArregloDatos tablas2d=tabla.pasarATabla2DxColumnas();
        //tablas2d.imprimir(); no se puede

        for(int porCadaTabla=0;porCadaTabla<tablas2d.cantidadElementos();porCadaTabla++){
            Tabla2D tabla2dTemp=(Tabla2D)tablas2d.obtener(porCadaTabla);
            tabla2dTemp.imprimir();
            SalidaTerminal.consola("\n");
        }
    }
}
