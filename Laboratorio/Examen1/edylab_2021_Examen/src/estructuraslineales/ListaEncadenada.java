package estructuraslineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.Nodo;

public class ListaEncadenada implements ListaDatos{
    protected Nodo frente;
    protected Nodo fin;

    public ListaEncadenada(){
        frente=null;
        fin=null;
    }

    @Override
    public boolean vacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Inserta al final de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa un 1 en caso de que se agregue el elemento, o -1 en caso contrario.
     */
    @Override
    public int agregar(Object elemento){
        Nodo nuevoNodo=new Nodo(elemento); //1
        if(nuevoNodo!=null){ //si hay espacio
            if(vacia()==true){ //a
                frente=nuevoNodo;//2
                fin=nuevoNodo;
            }else{ //b y c
                fin.setDirMemDer(nuevoNodo);//2
                fin=nuevoNodo;//3
            }
            return 1;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Inserta al inicio de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa un 1 en caso de que se agregue el elemento, o -1 en caso contrario.
     */
    public int agregarInicio(Object elemento){
        Nodo nuevoNodo=new Nodo(elemento); //1
        if(nuevoNodo!=null){ //si hay espacio
            if(vacia()==true){ //a
                frente=nuevoNodo;//2
                fin=nuevoNodo;
            }else{  //b
                nuevoNodo.setDirMemDer(frente);//2
                frente=nuevoNodo;//3
            }
            return 1;
        }else{ //no hay espacio
            return -1;
        }
    }

    @Override
    public void imprimir(){
        Nodo temp=frente;
        while(temp!=null){
            SalidaTerminal.consola(temp.getDato()+ " -> ");
            temp=temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
    }

    @Override
    public void imprimirOrdenInverso(){

    }

    @Override
    public Object buscar(Object elemento){
        return null;
    }

    @Override
    public Object eliminar(Object elemento){
        return null;
    }

    public Object eliminarInicio(){
        Object datoEliminado=null;

        if (vacia()==true){ //a
            return null;
        }else{   //si hay algo
            datoEliminado=frente.getDato(); //1
            if(frente==fin){  //b, único
                //datoEliminado=frente.getDato(); //1
                frente=null;//2
                fin=null;
            }else{   //c, varios
                //datoEliminado=frente.getDato(); //1
                frente=frente.getDirMemDer();//2
            }
            return datoEliminado;
        }
    }
    @Override
    public Object eliminar(){
        Object datoEliminado=null;

        if(vacia()==true){ //a, esta vacia
            return null;
        }else{ //hay algo
            datoEliminado = fin.getDato();//1
            if(frente==fin) { //b, único
                //datoEliminado = fin.getDato();//1
                frente=null;//2
                fin=null;//2
            }else{ //c, varios elementos
                //datoEliminado = fin.getDato();//1
                //buscar el penultimo
                Nodo penultimo=frente;
                while (penultimo.getDirMemDer()!=fin) {
                    penultimo = penultimo.getDirMemDer();  //i=i+1
                }
                fin=penultimo;//2
                fin.setDirMemDer(null);//3
            }
            return datoEliminado;
        } //
    }

    @Override
    public boolean esIgual(Object listaDatos2) {
        return false;
    }

    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces) {
        return false;
    }

    @Override
    public ArregloDatos buscarValores(Object elemento) {
        return null;
    }

    @Override
    public void vaciar() {

    }

    @Override
    public boolean agregarLista(Object listaDatos2) {
        return false;
    }

    @Override
    public void invertir() {

    }

    @Override
    public int contar(Object elemento) {
        return 0;
    }

    @Override
    public boolean eliminarLista(Object listaDatos2) {
        return false;
    }

    @Override
    public void rellenar(Object elemento, int cantidad) {

    }

    @Override
    public Object clonar() {
        return null;
    }

    @Override
    public Object subLista(int indiceInicial, int indiceFinal) {
        return null;
    }

    @Override
    public void rellenar(Object elemento) {

    }

    @Override
    public boolean esSublista(Object listaDatos2) {
        return false;
    }

    @Override
    public boolean cambiarLista(ArregloDatos listaDatos2, ArregloDatos listaDatos2Nuevos) {
        return false;
    }

    @Override
    public boolean retenerLista(ArregloDatos listaDatos2) {
        return false;
    }

    @Override
    public boolean insertar(int indice, Object elemento) {
        return false;
    }

    @Override
    public boolean copiarLista(ArregloDatos listaDatos2) {
        return false;
    }
}
