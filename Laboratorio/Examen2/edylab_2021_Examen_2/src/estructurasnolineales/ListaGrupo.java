package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.NodoDoble;
import herramientas.comunes.Herramientas;

/**
 * Lista que contiene cabezas y grupos por cada cabeza
 * @author Jesus
 * @version 1.0
 */
public class ListaGrupo {
    protected NodoDoble frente;

    public ListaGrupo(){
        frente = null;
    }

    /**
     * Agrega un elemento al final de las cabezas de la lista
     * @param elemento Elemento a agregar
     * @return True si lo agrego, false en caso contrario
     */
    public boolean agregarCabeza(Object elemento){
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(nuevoNodo != null){
            if(frente == null){
                frente = nuevoNodo;
            }else if(frente.getDirMemDer() == null){
                frente.setDirMemDer(nuevoNodo);
            }else{
                NodoDoble tmp = frente;
                while(tmp.getDirMemDer() != null){
                    tmp = tmp.getDirMemDer();
                }
                tmp.setDirMemDer(nuevoNodo);
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Agrega un elemento al principio de las cabezas del grupo
     * @param elemento Elemento a agregar
     * @return true si lo hace, false en caso contrario
     */
    public boolean agregarCabezaInicio(Object elemento){
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(nuevoNodo != null){
            if(frente == null){
                frente = nuevoNodo;
            }else{
                nuevoNodo.setDirMemDer(frente);
                frente = nuevoNodo;
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Elimina el inicio de las cabezas
     * @return El elemento eliminado, null en caso contrario
     */
    public Object eliminarInicioCabeza(){
        if(frente == null){
            return null;
        }else{
            Object elemBorr = frente.getDato();;
            if(frente.getDirMemDer() != null){
                frente = frente.getDirMemDer();
            }else{
                frente = null;
            }
            return elemBorr;
        }
    }

    /**
     * Elimina la cabeza del final de la lista
     * @return El elmento que elimino, null en caso contrario
     */
    public Object eliminarFinalCabeza(){
        if(frente != null){
            NodoDoble tmp = frente;
            Object elemBorrado = null;
            while(tmp.getDirMemDer() != null){
                tmp = tmp.getDirMemDer();
            }
            elemBorrado = tmp.getDato();
            NodoDoble tmp2 = frente;
            while(tmp2.getDirMemDer() != tmp){
                tmp2 = tmp2.getDirMemDer();
            }
            tmp2.setDirMemDer(null);
            return elemBorrado;
        }else{
            return null;
        }
    }

    /**
     * Elimina el elemento indicado de la cabeza, dejando a su hijo de en su lugar,
     * si no tiene hijo deja el nodo derecho
     * @param elemento Elemento a eliminar
     * @return El elemento eliminado, null en caso contrario
     */
    public Object eliminarCabeza(Object elemento){
        if(frente != null){
            NodoDoble tmp = frente;
            while(tmp != null && Herramientas.compararObjetos(tmp.getDato(),elemento) != 0){
                tmp = tmp.getDirMemDer();
            }
            Object elementoBorrado = null;
            if(tmp == null){
                return null;//no se encontro
            }else{
                elementoBorrado = tmp.getDato();
                if(tmp.getDirMemIzq() != null){
                    if(tmp == frente){
                        NodoDoble t = frente.getDirMemDer();
                        frente = frente.getDirMemIzq();
                        frente.setDirMemDer(t);
                    }else{
                        NodoDoble tmp2 = frente;
                        while(tmp2.getDirMemDer() != tmp){
                            tmp2 = tmp2.getDirMemDer();
                        }
                        NodoDoble t = tmp.getDirMemDer();
                        tmp2.setDirMemDer(tmp.getDirMemIzq());
                        tmp2.getDirMemDer().setDirMemDer(t);
                    }
                }else{
                    if(frente == tmp){
                        frente = frente.getDirMemDer();
                    }else{
                        NodoDoble tmp2 = frente;
                        while(tmp2.getDirMemDer() != tmp){
                            tmp2 = tmp2.getDirMemDer();
                        }
                        tmp2.setDirMemDer(tmp.getDirMemDer());
                    }
                }
                return elementoBorrado;
            }
        }else{
            return null;
        }
    }

    /**
     * Busca el elemento indicado en las cabezas de la lista
     * @param elemento Elemento a buscar
     * @return El elemento que encontro, null en caso contrario
     */
    public Object buscarCabeza(Object elemento){
        if(frente != null) {
            NodoDoble tmp = frente;
            while (tmp != null) {
                if(Herramientas.compararObjetos(elemento,tmp.getDato()) == 0){
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
     * Llama al metodo recursivo imprimirCabezas
     */
    public void imprimirCabezas(){
        imprimirCabezas(frente);
    }

    /**
     * Imprime las cabezas de la lista
     * @param tmp Nodo actual
     */
    private void imprimirCabezas(NodoDoble tmp){
        if(tmp != null){
            SalidaTerminal.consola(tmp.toString()+" -> ");
            imprimirCabezas(tmp.getDirMemDer());
        }else{
            SalidaTerminal.consola("null");
        }
    }

    /**
     * Imprime la cabeza indicada y su grupo de elementos
     * @param cabeza Cabeza a imprimir junto con sus elementos
     */
    public void imprimirCabezaYElementos(Object cabeza){
        NodoDoble tmp = frente;
        if(tmp != null){
            while(tmp != null && Herramientas.compararObjetos(cabeza,tmp.getDato()) != 0){
                tmp = tmp.getDirMemDer();
            }
            if(tmp == null){
                SalidaTerminal.consola("null");
            }else{
                SalidaTerminal.consola("Cabeza: "+tmp.toString()+"\nElementos: ");
                if(tmp.getDirMemIzq() != null){
                    tmp = tmp.getDirMemIzq();
                    while(tmp != null){
                        SalidaTerminal.consola(tmp.getDato().toString()+" <-> ");
                        tmp = tmp.getDirMemIzq();
                    }
                }
                SalidaTerminal.consola("null");
            }
        }
    }

    /**
     * Agrega el elemento al final del grupo de la cabeza indicada
     * @param cabeza Cabeza del grupo en el que se va agregar el elemento
     * @param elemento Elemento a agregar
     * @return True si lo hizo, false en caso contrario
     */
    public boolean agregarAGrupo(Object cabeza,Object elemento){
        NodoDoble nuevoNodo = new NodoDoble(elemento);
        if(nuevoNodo != null){
            NodoDoble tmp = frente;
            if(tmp != null){
                while(tmp != null && Herramientas.compararObjetos(cabeza,tmp.getDato()) != 0){
                    tmp = tmp.getDirMemDer();
                }
                if(tmp == null){
                    return false;
                }else{
                    if(tmp.getDirMemIzq() != null){
                        while(tmp.getDirMemIzq() != null){
                            tmp = tmp.getDirMemIzq();
                        }
                        tmp.setDirMemIzq(nuevoNodo);
                        nuevoNodo.setDirMemDer(tmp);
                    }else{
                        tmp.setDirMemIzq(nuevoNodo);
                        nuevoNodo.setDirMemDer(tmp);
                    }
                    return true;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Elimina un elemento del final del grupo de la cabeza indicada
     * @param cabeza Cabeza del grupo al que se le va a eliminar el final
     * @return El elemento eliminado, null en caso conrario
     */
    public Object eliminarFinalGrupo(Object cabeza){
        NodoDoble tmp = frente;
        if(tmp != null) {
            while (tmp != null && Herramientas.compararObjetos(cabeza, tmp.getDato()) != 0) {
                tmp = tmp.getDirMemDer();
            }
            if (tmp == null) {
                return null;
            } else {
                if(tmp.getDirMemIzq() != null){
                    while(tmp.getDirMemIzq() != null){
                        tmp = tmp.getDirMemIzq();
                    }
                    Object elemBorrado = tmp.getDato();
                    tmp = tmp.getDirMemDer();
                    tmp.setDirMemIzq(null);
                    return elemBorrado;
                }else{
                    return null;
                }
            }
        }else{
            return null;
        }
    }

    /**
     * Busca un elemento en el grupo de la cabeza indicada
     * @param cabeza Cabeza del grupo a buscar el elemento
     * @param elemento Elemento a buscar
     * @return El elemento encontrado, null en caso contrario
     */
    public Object buscarGrupo(Object cabeza,Object elemento){
        NodoDoble tmp = frente;
        if(tmp != null) {
            while (tmp != null && Herramientas.compararObjetos(cabeza, tmp.getDato()) != 0) {
                tmp = tmp.getDirMemDer();
            }
            if (tmp == null) {
                return null;
            } else {
                tmp = tmp.getDirMemIzq();
                while(tmp != null && Herramientas.compararObjetos(elemento,tmp.getDato()) != 0){
                    tmp = tmp.getDirMemIzq();
                }
                if(tmp == null){
                    return null;
                }else{
                    return tmp.getDato();
                }
            }
        }else{
            return null;
        }
    }

    /**
     * Imprime los elementos de la cabeza indicada
     * @param cabeza Cabeza de los elementos a imprimir
     */
    public void imprimirElementos(Object cabeza){
        NodoDoble tmp = frente;
        if(tmp != null){
            while(tmp != null && Herramientas.compararObjetos(cabeza,tmp.getDato()) != 0){
                tmp = tmp.getDirMemDer();
            }
            if(tmp == null){
                SalidaTerminal.consola("null");
            }else{
                SalidaTerminal.consola("Elementos: ");
                if(tmp.getDirMemIzq() != null){
                    tmp = tmp.getDirMemIzq();
                    while(tmp != null){
                        SalidaTerminal.consola(tmp.getDato().toString()+" <-> ");
                        tmp = tmp.getDirMemIzq();
                    }
                }
                SalidaTerminal.consola("null");
            }
        }
    }

    /**
     * Imprime todas las cabezas y sus elementos
     */
    public void imprimir(){
        NodoDoble tmp = frente;
        if(tmp != null){
            while(tmp != null){
                SalidaTerminal.consola("Cabeza: "+tmp.toString()+"\nElementos: ");
                if(tmp.getDirMemIzq() != null){
                    NodoDoble tmp2 = tmp.getDirMemIzq();
                    while(tmp2 != null){
                        SalidaTerminal.consola(tmp2.getDato().toString()+" <-> ");
                        tmp2 = tmp2.getDirMemIzq();
                    }
                }
                SalidaTerminal.consola("null");
                SalidaTerminal.consola("\n");
                tmp = tmp.getDirMemDer();
            }
        }
    }

    /**
     * Elimina un elemento de la lista independientemente si es cabeza o forma parte de un grupo
     * @param elemento Elemento a eliminar
     * @return El elemento eliminado, null en caso contrario
     */
    public Object eliminar(Object elemento){
        NodoDoble tmp = frente;
        if(tmp != null) {
            while (tmp != null) {
                if(Herramientas.compararObjetos(tmp.getDato(),elemento) == 0){
                    Object elemBorrado = tmp.getDato();
                    if(tmp.getDirMemIzq() != null){
                        if(tmp == frente){
                            frente = frente.getDirMemIzq();
                            frente.setDirMemDer(tmp.getDirMemDer());
                        }else{
                            NodoDoble tmp2 = frente;
                            while(tmp2.getDirMemDer() != tmp){
                                tmp2 = tmp2.getDirMemDer();
                            }
                            tmp2.setDirMemDer(tmp.getDirMemIzq());
                            tmp2.getDirMemDer().setDirMemDer(tmp.getDirMemDer());
                        }
                    }else{
                        if(tmp.getDirMemDer() != null){
                            if(tmp == frente){
                                frente = frente.getDirMemDer();
                            }else{
                                NodoDoble tmp2 = frente;
                                while(tmp2.getDirMemDer() != tmp){
                                    tmp2 = tmp2.getDirMemDer();
                                }
                                tmp2.setDirMemDer(tmp.getDirMemDer());
                            }
                        }else{
                            NodoDoble tmp2 = frente;
                            while(tmp2.getDirMemDer() != tmp){
                                tmp2 = tmp2.getDirMemDer();
                            }
                            tmp2.setDirMemDer(null);
                        }
                    }
                    return elemBorrado;
                }else{
                    if(tmp.getDirMemIzq() != null){
                        NodoDoble tmp2 = tmp.getDirMemIzq();
                        while(tmp2 != null && Herramientas.compararObjetos(tmp2.getDato(),elemento) != 0){
                            tmp2 = tmp2.getDirMemIzq();
                        }
                        if(tmp2 != null){
                            if(tmp2.getDirMemIzq() != null){
                                Object elemBorrado = tmp2.getDato();
                                tmp2 = tmp2.getDirMemDer();
                                tmp2.setDirMemIzq(tmp2.getDirMemIzq().getDirMemIzq());
                                return elemBorrado;
                            }else{
                                tmp2 = tmp2.getDirMemDer();
                                tmp2.setDirMemIzq(null);
                            }
                        }
                    }
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }

    /**
     * Busca un elemento indicado sin importar si es cabeza o forma parte de un grupo,
     * ademas de indicar cual es su cabeza si es que peetenece a un grupo
     * @param elemento Elemento a buscar
     * @return El elemento encontrado, null en caso contrario
     */
    public Object buscar(Object elemento){
        NodoDoble tmp = frente;
        if(tmp != null) {
            while (tmp != null) {
                if (Herramientas.compararObjetos(tmp.getDato(), elemento) == 0) {
                    SalidaTerminal.consola("Es cabeza: "+tmp.getDato());
                    return tmp.getDato();
                }else{
                    if(tmp.getDirMemIzq() != null){
                        NodoDoble tmp2 = tmp.getDirMemIzq();
                        while(tmp2 != null && Herramientas.compararObjetos(elemento,tmp2.getDato()) != 0){
                            tmp2 = tmp2.getDirMemIzq();
                        }
                        if(tmp2 != null){
                            SalidaTerminal.consola("Cabeza: "+tmp.getDato()+"\nElemento: "+tmp2.getDato());
                            return tmp2.getDato();
                        }
                    }
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }
}
