package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.NodoDoble;
import herramientas.comunes.Herramientas;

public class ABB extends ArbolBinario {

    public boolean agregar(Object elemento) {
        if (raiz == null) { // no hay nada en el árbol
            NodoDoble nuevoNodo = new NodoDoble(elemento);
            if (nuevoNodo != null) { //si hay espacio
                raiz = nuevoNodo;
                return true;
            } else { //se asume que no hay espacio
                raiz = null;
                return false;
            }
        } else { //ya hay algo en el árbol
            return agregar(raiz, elemento);
        }
    }

    private boolean agregar(NodoDoble subRaiz, Object elemento) {
        //Verificar que el elemento proporcionado sea

        if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) > 0) { //elemento > subRaiz.dato
            //Mayor a la información de la subRaiz
            if (subRaiz.getDirMemDer() == null) { // no tiene hijo derecho, ahí le toca insertarse a elemento
                NodoDoble nuevoNodo = new NodoDoble(elemento);
                if (nuevoNodo != null) { //si hay espacio
                    subRaiz.setDirMemDer(nuevoNodo);
                    return true;
                } else { //no hay espacio
                    return false;
                }
            } else { //ya tiene un hijo derecho esta subRaiz, nos dirigimos hacia esa Rama,
                return agregar(subRaiz.getDirMemDer(), elemento);
            }
        } else if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) < 0) { //elemento < subRaiz.dato
            // Menor a la información de la subRaiz
            if (subRaiz.getDirMemIzq() == null) { // no tiene hijo izquierdo, ahí le toca insertarse a elemento
                NodoDoble nuevoNodo = new NodoDoble(elemento);
                if (nuevoNodo != null) { //si hay espacio
                    subRaiz.setDirMemIzq(nuevoNodo);
                    return true;
                } else { //no hay espacio
                    return false;
                }
            } else { //ya tiene un hijo izquiedo esta subRaiz, nos dirigimos hacia esa Rama,
                return agregar(subRaiz.getDirMemIzq(), elemento);
            }
        } else {
            //Igual a la información de la subRaiz, no lo insertamos
            return false;
        }
    }

    public Object buscar(Object elemento) {
        return buscar(raiz, elemento);
    }

    private Object buscar(NodoDoble subRaiz, Object elemento) {
        if (subRaiz != null) { //estamos en un nodo con algún contenido
            if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) > 0) { //elemento>subRaiz
                return buscar(subRaiz.getDirMemDer(), elemento);
            } else if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) < 0) { //elemento<subRaiz
                return buscar(subRaiz.getDirMemIzq(), elemento);
            } else { //elemento=subRaiz, lo encontré
                return subRaiz.getDato();
            }
        } else { //estamos en un nodo que apunta a null
            //no está el elemento
            return null;
        }
    }

    /**
     * Llama al metodo recursivo eliminar con los parametros de raiz, null y el elemento a eliminar
     * @param elemento Elemento que se quiere eliminar del arbol
     * @return Lo que regresa el metodo llamado
     */
    public Object eliminar(Object elemento){
        return eliminar(raiz,null,elemento);
    }
    /**
     * Elimina el elemento del arbol
     * @param actual Nodo actual
     * @param anterior Nodo anterior al actual
     * @param elemento Elemento a eliminar
     * @return El elemento que elimino, null en caso que no lo encontrara
     */
    private Object eliminar(NodoDoble actual,NodoDoble anterior,Object elemento){
        if(actual != null){
            if(Herramientas.compararObjetos(elemento,actual.getDato()) < 0){
                return eliminar(actual.getDirMemIzq(),actual,elemento);
            }else{
                if(Herramientas.compararObjetos(elemento,actual.getDato()) > 0){
                    return eliminar(actual.getDirMemDer(),actual,elemento);
                }else{
                    Object elementoEliminado = actual.getDato();
                    if(actual.getDirMemIzq() != null && actual.getDirMemDer() != null){
                        NodoDoble aux = actual.getDirMemIzq();
                        boolean bol = false;
                        NodoDoble aux1 = null;
                        while(aux.getDirMemDer() != null){
                            aux1 = aux;
                            aux = aux.getDirMemDer();
                            bol = true;
                        }
                        actual.setDato(aux.getDato());
                        if(bol == true){
                            aux1.setDirMemDer(aux.getDirMemIzq());
                        }else{
                            actual.setDirMemIzq(aux.getDirMemIzq());
                        }
                    }else{
                        NodoDoble otro = actual;
                        if(otro.getDirMemDer() == null){
                            if(otro.getDirMemIzq() != null){
                                otro = actual.getDirMemIzq();
                                if(anterior != null){
                                    if(Herramientas.compararObjetos(elemento,anterior.getDato()) < 0){
                                        anterior.setDirMemIzq(otro);
                                    }else{
                                        anterior.setDirMemDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }else{
                                if(anterior == null){
                                    raiz = null;
                                }else{
                                    if(Herramientas.compararObjetos(elemento,anterior.getDato()) < 0){
                                        anterior.setDirMemIzq(null);
                                    }else{
                                        anterior.setDirMemDer(null);
                                    }
                                }
                            }
                        }else{
                            if(otro.getDirMemIzq() == null){
                                otro = actual.getDirMemDer();
                                if(anterior != null){
                                    if(Herramientas.compararObjetos(elemento,anterior.getDato()) < 0){
                                        anterior.setDirMemIzq(otro);
                                    }else{
                                        anterior.setDirMemDer(otro);
                                    }
                                }else{
                                    raiz = otro;
                                }
                            }
                        }
                    }
                    return elementoEliminado;
                }
            }
        }else{
            return null;
        }
    }
}
