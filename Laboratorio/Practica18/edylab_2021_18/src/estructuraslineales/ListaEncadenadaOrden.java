package estructuraslineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.Nodo;
import herramientas.comunes.Herramientas;

/**
 * Clase que hace una lista con orden Ascendente o Descendente, segun se indique en su constructor
 * @author Jesus
 * @version 1.0
 */
public class ListaEncadenadaOrden extends ListaEncadenada{
    protected TipoOrden orden;

    public ListaEncadenadaOrden(TipoOrden orden){
        super();
        this.orden = orden;
    }

    /**
     * Agrega de forma ordenada el dato, dependiendo de el tipo de orden que se escoja
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return 1 si se agrego, -1 si no lo hizo
     */
    @Override
    public int agregar(Object elemento){
        if(buscar(elemento) == null){
            Nodo nuevo = new Nodo(elemento);
            if(nuevo != null){
                if(frente == null){ //Esta vacia
                    frente = nuevo;
                    fin = nuevo;
                }else if(Herramientas.compararObjetos(frente.getDato(),fin.getDato()) == 0){//Solo hay un dato en la lista
                    if(orden == TipoOrden.ASCENDENTE){
                        if(Herramientas.compararObjetos(frente.getDato(),elemento) < 0){
                            frente.setDirMemDer(nuevo);
                            fin = nuevo;
                        }else{
                            nuevo.setDirMemDer(frente);
                            frente = nuevo;
                        }
                    }else{
                        if(Herramientas.compararObjetos(frente.getDato(),elemento) > 0){
                            frente.setDirMemDer(nuevo);
                            fin = nuevo;
                        }else{
                            nuevo.setDirMemDer(frente);
                            frente = nuevo;
                        }
                    }
                }else{//Hay mas de un dato en la lista
                    Nodo tmp = frente;
                    if(Herramientas.compararObjetos(tmp.getDato(),elemento) > 0){
                        if(orden == TipoOrden.ASCENDENTE){
                            nuevo.setDirMemDer(frente);
                            frente = nuevo;
                            return 1;
                        }
                    }
                    if(Herramientas.compararObjetos(tmp.getDato(),elemento) < 0){
                        if(orden == TipoOrden.DESCENDENTE){
                            nuevo.setDirMemDer(frente);
                            frente = nuevo;
                            return 1;
                        }
                    }
                    while(tmp.getDirMemDer() != null) {
                        if(orden == TipoOrden.ASCENDENTE){
                            if(Herramientas.compararObjetos(tmp.getDirMemDer().getDato(),elemento) > 0){
                                nuevo.setDirMemDer(tmp.getDirMemDer());
                                tmp.setDirMemDer(nuevo);
                                return 1;
                            }
                        }else{
                            if(Herramientas.compararObjetos(tmp.getDirMemDer().getDato(),elemento) < 0){
                                nuevo.setDirMemDer(tmp.getDirMemDer());
                                tmp.setDirMemDer(nuevo);
                                return 1;
                                /*Nodo aux = frente;
                                while(aux.getDirMemDer() != null){
                                    if(Herramientas.compararObjetos(aux.getDirMemDer().getDato(),tmp.getDato()) == 0){
                                        nuevo.setDirMemDer(tmp);
                                        aux.setDirMemDer(nuevo);
                                        return 1;
                                    }
                                    aux = aux.getDirMemDer();
                                }*/
                            }
                        }
                        tmp = tmp.getDirMemDer();
                    }
                    tmp.setDirMemDer(nuevo);
                    fin = nuevo;
                    return 1;
                }
                return 1;
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    /**
     * No agrega nada ya que perderia el orden
     * @param elemento Es el dato que se desea agregar a la lista(No se agrega).
     * @return -1 todo el tiempo
     */
    @Override
    public int agregarInicio(Object elemento){
        return -1;
    }

    /**
     * Busca un dato en la lista
     * @param elemento Elemento a buscar
     * @return El elemento que encontro, null en caso contrario
     */
    @Override
    public Object buscar(Object elemento){
        if(!vacia()){
            Nodo tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getDato(),elemento) == 0){
                    return tmp.getDato();
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }

    /**
     * Elimina el elemento de la posicion indicada y agraga el elemento de forma ordenada
     * @param indice posicion del elemento a eliminar
     * @param elemento Elemento a agregar
     * @return true si lo hace, false en caso contrario
     */
    @Override
    public boolean cambiar(int indice, Object elemento){
        if(!vacia()){
            if(eliminar(indice) != null){
                if(agregar(elemento) == 1){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

    /**
     * Elimina el elemento viejo y agrega el nuevo de forma ordenada
     * @param elementoViejo Elemento a eliminar
     * @param elementoNuevo Elemento a agregar
     * @param numVeces No importa ya que solo lo hace una vez
     * @return true si lo hace, false en caso contrario
     */
    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces){
        if(!vacia()){
            if(eliminar(elementoViejo) != null){
                if(agregar(elementoNuevo) == 1){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

    /**
     * Invierte la lista asi como el orden que tiene
     */
    @Override
    public void invertir(){
        if(!vacia()){
            ListaEncadenadaOrden lista = null;
            if(orden == TipoOrden.ASCENDENTE){
                lista = new ListaEncadenadaOrden(TipoOrden.DESCENDENTE);
            }else{
                lista = new ListaEncadenadaOrden(TipoOrden.ASCENDENTE);
            }
            while(!vacia()){
                lista.agregar(eliminar());
            }
            frente = lista.frente;
            fin = lista.fin;
            iterador = null;
        }
    }

    /**
     * Agrega el elemento una sola vez sin importar la cantidad
     * @param elemento Elemento a agregar
     * @param cantidad No importa
     */
    @Override
    public void rellenar(Object elemento, int cantidad){
        agregar(elemento);
    }

    /**
     * Agrega el elemento ordenadamente una sola vez
     * @param elemento Elemento a agregar
     */
    @Override
    public void rellenar(Object elemento){
        agregar(elemento);
    }

    /**
     * Agrega un dato en la lista, sin importar la posicion en la que se quiera
     * @param indice No importa el indice
     * @param elemento Elemento que se va agregar ordenadamente
     * @return true si lo hizo, false en caso contrario
     */
    @Override
    public boolean insertar(int indice, Object elemento){
        if(agregar(elemento) == 1){
            return true;
        }else{
            return false;
        }
    }
}
