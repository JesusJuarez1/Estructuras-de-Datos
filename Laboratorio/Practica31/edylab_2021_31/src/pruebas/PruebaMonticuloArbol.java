package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import herramientas.comunes.TipoOrden;
import estructurasnolineales.MonticuloArbol;
import registros.proceso.Proceso;

public class PruebaMonticuloArbol {
    public static void main(String[] args) {
        //Prueba para el verificar el funcionamiento del monticulo
        /*MonticuloArbol m = new MonticuloArbol(TipoOrden.ASCENDENTE);
        m.agregar(5);
        m.agregar(7);
        m.agregar(6);
        m.agregar(1);
        m.agregar(3);
        m.agregar(-2);
        m.agregar(4);
        SalidaTerminal.consola("\nImpresion por amplitud: \n");
        m.amplitud();

        MonticuloArbol m2 = new MonticuloArbol(TipoOrden.DESCENDENTE);
        m2.agregar(5);
        m2.agregar(7);
        m2.agregar(6);
        m2.agregar(1);
        m2.agregar(3);
        m2.agregar(-2);
        m2.agregar(4);
        SalidaTerminal.consola("\nImpresion por amplitud: \n");
        m2.amplitud();*/

        MonticuloArbol monticulo = new MonticuloArbol(TipoOrden.ASCENDENTE);
        SalidaTerminal.consola("Ingresa el numero de procesos a ingresar: ");
        Integer can = EntradaTerminal.consolaInteger();
        ingresarDatos(monticulo,can);
        SalidaTerminal.consola("\nImpresion del monticulo recorrido por amplitud (Solo se ve la prioridad del proceso):\n");
        monticulo.amplitud();
        SalidaTerminal.consola("\nSalida de los procesos:\n");
        sacarDatos(monticulo);
    }

    /**
     * Agrega los datos al monticulo
     * @param monticulo Monticulo al que se le agregan los datos
     * @param can Cantidad de elementos a agregar
     * @return El monticulo con los datos agregados
     */
    private static MonticuloArbol ingresarDatos(MonticuloArbol monticulo,int can){
        for(int i=0;i<can;i++){
            //La prioridad se pedira cada que se crea un nuevo proceso, la prioridad define el lugar que le toca en el monticulo
            monticulo.agregar(new Proceso("p"+(i+1),"c"+(i+1),"a"+(i+1),"r"+(i+1),"p"+(i+1)));
        }
        return monticulo;
    }

    /**
     * Saca los datos del monticulo y los imprime
     * @param monticulo Monticulo donde se sacan los datos
     */
    private static void sacarDatos(MonticuloArbol monticulo){
        while(!monticulo.vacio()){
            SalidaTerminal.consola(((Proceso)monticulo.quitar()).proceso()+"\n");
        }
    }
}
