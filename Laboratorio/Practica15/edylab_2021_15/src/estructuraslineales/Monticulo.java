package estructuraslineales;

import entradasalida.SalidaTerminal;
import herramientas.comunes.Herramientas;
import registros.proceso.Proceso;
import registros.proceso.TipoProceso;

public class Monticulo implements LoteDatos{
    ArregloDatos datos;
    protected TipoOrden orden;

    public Monticulo(TipoOrden orden, int tam){
        datos = new ArregloDatos(TipoProceso.values().length);
        this.orden = orden;
        ingresarPrioridad(tam);
    }

    /**
     * Agrega colas a la cola para simular las prioridades
     * @param tam Es el tamaño que tomara cada cola agregada
     */
    private void ingresarPrioridad(int tam){
        for(int i=0;i<datos.CAPACIDAD;i++){
            datos.agregar(new ArregloCola(tam));
        }
    }

    /**
     * Verifica si es que todas las colas dentro del arreglo estan vacias
     * @return true si lo estan, false en caso contrario
     */
    @Override
    public boolean vacio() {
        for(int pos=0;pos<datos.cantidadElementos();pos++){
            if(!((ArregloCola)datos.obtener(pos)).vacio()){
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica si es que todas las colas dentro del arreglo estan llenas
     * @return true si lo estan, false en caso contrario
     */
    @Override
    public boolean lleno() {
        for(int pos=0;pos<datos.cantidadElementos();pos++){
            if(!((ArregloCola)datos.obtener(pos)).lleno()){
                return false;
            }
        }
        return true;
    }

    /**
     * Agrega un objeto a la posicion que le corresponde segun la prioridad que tiene y el orden
     * @param info Obajeto a poner
     * @return true si lo agrego, false en caso contrario
     */
    @Override
    public boolean poner(Object info){
        int posicion = -1;
        if(TipoOrden.ASCENDENTE == orden){
            for(int pos=0;pos< datos.CAPACIDAD;pos++){
                if((pos+1) == ((Proceso)info).getTipo().getPrioridad()){
                    posicion = pos;
                }
            }
        }else{
            for(int pos=datos.capacidad()-1,cont=0;pos>=0 ;pos--,cont++){
                if((cont+1) == ((Proceso)info).getTipo().getPrioridad()){
                    posicion = pos;
                }
            }
        }

        if(!(posicion == -1)){
            ArregloCola col = (ArregloCola) datos.obtener(posicion);
            if(!col.lleno()){
                col.poner(info);
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    /**
     * Quita el objeto que sigue segun la prioridad que tiene y el orden
     * @return Regresa el objeto quitado.
     */
    @Override
    public Object quitar(){
        if(TipoOrden.ASCENDENTE == orden){
            ArregloCola col;
            for(int pos=0;pos<datos.cantidadElementos();pos++){
                col = (ArregloCola) datos.obtener(pos);
                if(!col.vacio()){
                    return col.quitar();
                }
            }
            return null;
        }else{
            ArregloCola col;
            for(int pos=datos.cantidadElementos()-1;pos>=0;pos--){
                col = (ArregloCola) datos.obtener(pos);
                if(!col.vacio()){
                    return col.quitar();
                }
            }
            return null;
        }
    }

    /**
     * Imprime los datos conforme al orden
     */
    @Override
    public void imprimir() {
        if(TipoOrden.ASCENDENTE == orden) {
            for (int posicion = datos.cantidadElementos() - 1; posicion >= 0; posicion--) {
                SalidaTerminal.consola("Prioridad "+(posicion +1)+": \n");
                ((ArregloCola) datos.obtener(posicion)).imprimir();
                SalidaTerminal.consola("\n");
            }
        }else{
            for (int posicion=0; posicion< datos.cantidadElementos(); posicion++) {
                ((ArregloCola) datos.obtener(posicion)).imprimir();
                SalidaTerminal.consola("\n");
            }
        }
    }

    /**
     * Regresa el ultimo dato agregado segun el orden y la prioridad
     * @return El ultimo dato
     */
    @Override
    public Object verTope() {
        if(TipoOrden.ASCENDENTE == orden){
            ArregloCola col;
            for(int pos=0;pos<datos.cantidadElementos();pos++){
                col = (ArregloCola)datos.obtener(pos);
                if(!col.vacio()){
                    return col.verTope();
                }
            }
            return null;
        }else{
            ArregloCola col;
            for(int pos=datos.cantidadElementos();pos>=0;pos--){
                col = (ArregloCola) datos.obtener(pos);
                if(!col.vacio()){
                    return col.verTope();
                }
            }
            return null;
        }
    }
}
