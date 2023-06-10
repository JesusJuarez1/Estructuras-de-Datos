package registros.proceso;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;

public class Proceso {
    protected String nombre;
    protected String comando;
    protected String archvio;
    protected String ruta;
    protected String propietario;
    protected TipoProceso tipo;

    public Proceso(String nombre, String comando, String archivo,String ruta, String propietario){
        this.nombre = nombre;
        this.comando = comando;
        this.archvio = archivo;
        this.ruta = ruta;
        this.propietario = propietario;
        this.tipo = determinarTipo();
    }

    /**
     * Da la opcion al usuario de escoger el tipo de proceso para agregar la prioridad
     * @return El tipo de proceso escogido
     */
    private TipoProceso determinarTipo(){
        TipoProceso[] tp = TipoProceso.values();
        int prio = 0;
        while(prio > tp.length || prio < 1){
            SalidaTerminal.consola("Escoge la prioridad del Proceso "+nombre+"\n");
            for(int pos=0;pos<tp.length;pos++){
                SalidaTerminal.consola((pos+1)+".- "+tp[pos].name()+", prioridad-> "+tp[pos].getPrioridad()+"\n");
            }
            prio = EntradaTerminal.consolaInteger();
        }
        return tp[prio-1];
    }

    /**
     * Obtiene el tipo de proceso que es
     * @return Obtiene la prioridad al saber de que tipo de proceso es
     */
    public TipoProceso getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Proceso:\n" +
                "\tnombre = " + nombre +
                "\n\tcomando = " + comando +
                "\n\tarchvio = " + archvio +
                "\n\truta = " + ruta +
                "\n\tpropietario = " + propietario +
                "\n\ttipo = " + tipo.toString();
    }
}
