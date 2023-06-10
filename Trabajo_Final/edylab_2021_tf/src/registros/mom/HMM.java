package registros.mom;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.GrafoMatriz;
import estructurasnolineales.Tabla2DNumeros;
import herramientas.comunes.Herramientas;
import herramientas.comunes.TipoOrden;

/**
 * Clase que simulara ser un MOM
 * @author Jesus
 * @version 1.0
 */
public class HMM {
    protected GrafoMatriz grafo;
    protected ArregloDatos estados;
    protected ArregloDatos observaciones;
    protected ArregloDatos probabilidadInicial;
    protected Tabla2DNumeros probabilidadTransicion;
    protected Tabla2DNumeros probabilidadEmision;

    public HMM(ArregloDatos estados, ArregloDatos observaciones, ArregloDatos probabilidadInicial,
               Tabla2DNumeros probabilidadTransicion, Tabla2DNumeros probabilidadEmision){
        this.estados=estados;
        grafo = new GrafoMatriz(estados.cantidadElementos(), TipoOrden.ASCENDENTE);
        agregarEstados();
        this.observaciones = observaciones;
        this.probabilidadInicial=probabilidadInicial;
        this.probabilidadTransicion=probabilidadTransicion;
        this.probabilidadEmision=probabilidadEmision;
        agregarProbabilidades();
        grafo.imprimir();
    }

    /**
     * Agrega los estados (Vertices) al grafo
     */
    private void agregarEstados(){
        for(int posicion=0;posicion<estados.cantidadElementos();posicion++){
            grafo.agregarVertice(estados.obtener(posicion));
        }
    }

    /**
     * Agrega las probabilidades de transicion (arostas) al grafo
     */
    private void agregarProbabilidades(){
        for(int filaEstado=0;filaEstado<probabilidadTransicion.getFilas();filaEstado++){
            for(int columEstado=0;columEstado<probabilidadTransicion.getColumnas();columEstado++){
                Double probabilidad = (Double)probabilidadTransicion.obtenerCelda(filaEstado,columEstado);
                grafo.agregarArista(estados.obtener(filaEstado),estados.obtener(columEstado),probabilidad);
            }
        }
    }

    /**
     * Obtiene la probabilidad de obtener un estado inicial
     * @param estado Estado del cual se va sacar el estado inical
     * @return La probabilidad obtenida sobre 100%
     */
    public Double probabilidadIniciar(Object estado){
        Integer posicionEstado = (Integer)estados.buscar(estado);
        if(posicionEstado != null){
            Double probabilidad = (Double) probabilidadInicial.obtener(posicionEstado);
            return probabilidad*100;
        }else{
            return null;
        }
    }

    /**
     * Obtiene la probabilidad de obtener una observacion en un estado actual
     * @param estado Estado del cual se obtiene la probabilidad de la observacion
     * @param observacion Observacion a obtener su probabilidad
     * @return La probabilidad obtenida sobre 100%
     */
    public Double probabilidadObtener(Object estado,Object observacion){
        Integer posicionEstado = (Integer)estados.buscar(estado);
        Integer posicionObservacion = (Integer) observaciones.buscar(observacion);
        if(posicionEstado!=null && posicionObservacion!=null){
            Double probabilidad = (Double) probabilidadEmision.obtenerCelda(posicionEstado,posicionObservacion);
            return probabilidad*100;
        }else{
            return null;
        }
    }

    /**
     * Obtiene la probabilidad de cambiar de un estado a otro
     * @param estadoIncial Estado en el que se esta
     * @param estadoACambiar Estado al que se quiere cambiar
     * @return La probabilidad obtenida sobre 100%
     */
    public Double probabilidadCambiar(Object estadoIncial,Object estadoACambiar){
        Integer posicionEstadoInicial = (Integer) estados.buscar(estadoIncial);
        Integer posicionEstadoACambiar = (Integer) estados.buscar(estadoACambiar);
        if(posicionEstadoInicial!=null && posicionEstadoACambiar!=null){
            Double probabilidad = (Double) probabilidadTransicion.obtenerCelda(posicionEstadoInicial,posicionEstadoACambiar);
            return probabilidad*100;
        }else{
            return null;
        }
    }

    /**
     * Obtiene la probabilidad de obtener una secuencia de estados dada
     * @param secuencia Secuencia de estados
     * @return La probabilidad calculada sobre 100%, null en caso contrario
     */
    public Double probabilidadObtenerSecuenciaEstados(ArregloDatos secuencia){

        Double probabilidad = 0.0;//Variable donde se estaran sumando sus probabilidades
        //Se elige el estado inicial aleatorio de acuerdo a su probabilidad inicial
        Object estadoActual = Herramientas.obtenerAleatorioProbabildad(estados,probabilidadInicial);
        SalidaTerminal.consola("Estado inicial: "+estadoActual+"\n");
        for(int posEstado=0;posEstado<secuencia.cantidadElementos();posEstado++){
            if(estados.buscar(secuencia.obtener(posEstado)) == null){//Un elemento de la secuencia no es valida¿
                return null;
            }else{
                probabilidad += (probabilidadCambiar(estadoActual,secuencia.obtener(posEstado))/100);
                estadoActual = secuencia.obtener(posEstado);
            }
        }
        return 100*(probabilidad/secuencia.cantidadElementos());
    }

    /**
     * Obtiene la probabilidad de obtener una secuencia de observaciones, cuando los estados se eligen aleatoriamente por su probabilidad
     * @param secuencia Secuencia de observaciones
     * @return La probabilidad obtenida sobre 100%, null en caso contrario
     */
    public Double probabilidadObtenerSecuenciaObservaciones(ArregloDatos secuencia){
        Double probabilidad = 0.0;//Variable donde se estaran sumando sus probabilidades
        //Se elige el estado inicial aleatorio de acuerdo a su probabilidad inicial
        Object estadoActual = Herramientas.obtenerAleatorioProbabildad(estados,probabilidadInicial);
        for(int posObservacion=0;posObservacion<secuencia.cantidadElementos();posObservacion++){
            if(observaciones.buscar(secuencia.obtener(posObservacion)) == null){//Un elemento de la secuencia no es valida
                return null;
            }else{
                Integer posEstado = (Integer) estados.buscar(estadoActual);
                Integer posObs = (Integer)observaciones.buscar(secuencia.obtener(posObservacion));
                probabilidad += (Double)probabilidadEmision.obtenerCelda(posEstado,posObs);
                ArregloDatos probabilidadesEstadoActual = new ArregloDatos(estados.cantidadElementos());
                for(int p=0;p<probabilidadTransicion.getColumnas();p++){
                    probabilidadesEstadoActual.agregar(probabilidadTransicion.obtenerCelda(posEstado,p));
                }
                estadoActual = Herramientas.obtenerAleatorioProbabildad(estados,probabilidadesEstadoActual);
            }
        }
        return 100*(probabilidad/secuencia.cantidadElementos());
    }
}
