package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.Monticulo;
import herramientas.comunes.TipoOrden;
import registros.proceso.Proceso;

public class PruebaMonticulo {
    public static void main(String[] args) {
        SalidaTerminal.consola("Ingresa el numero de procesos a ingresar: ");
        int n = EntradaTerminal.consolaInteger();
        Monticulo m = new Monticulo(TipoOrden.ASCENDENTE,n);
        //Para que el programa sea mucho mas eficiente a la hora de usarlo, los valores de los procesos seran indicados por
        // p(nombre), c(comando), a(archvio),r(ruta) y p(propietario)
        for(int i=0;i<n;i++){
            m.poner(new Proceso("p"+(i+1),"c"+(i+1),"a"+(i+1),"r"+(i+1),"p"+(i+1)));
        }
        SalidaTerminal.consola("Impresion del monticulo con todos los datos agregados\n");
        m.imprimir();
        // Se hace un for para facilitar sacar los datos
        SalidaTerminal.consola("\n \n"+"SALIDA DE PROCESOS: ");
        for(int i=0;i<n;i++){
            SalidaTerminal.consola("\n"+m.quitar().toString()+"\n");
        }
        SalidaTerminal.consola("Procesos terminados");
    }
}
