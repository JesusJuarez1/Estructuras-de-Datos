package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.NodoDoble;
import herramientas.comunes.Herramientas;

public class ABB extends ArbolBinario {

    public boolean agregar(Object elemento) {
        if (raiz == null) { // no hay nada en el �rbol
            NodoDoble nuevoNodo = new NodoDoble(elemento);
            if (nuevoNodo != null) { //si hay espacio
                raiz = nuevoNodo;
                return true;
            } else { //se asume que no hay espacio
                raiz = null;
                return false;
            }
        } else { //ya hay algo en el �rbol
            return agregar(raiz, elemento);
        }
    }

    private boolean agregar(NodoDoble subRaiz, Object elemento) {
        //Verificar que el elemento proporcionado sea

        if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) > 0) { //elemento > subRaiz.dato
            //Mayor a la informaci�n de la subRaiz
            if (subRaiz.getDirMemDer() == null) { // no tiene hijo derecho, ah� le toca insertarse a elemento
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
            // Menor a la informaci�n de la subRaiz
            if (subRaiz.getDirMemIzq() == null) { // no tiene hijo izquierdo, ah� le toca insertarse a elemento
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
            //Igual a la informaci�n de la subRaiz, no lo insertamos
            return false;
        }
    }

    public Object buscar(Object elemento) {
        return buscar(raiz, elemento);
    }

    private Object buscar(NodoDoble subRaiz, Object elemento) {
        if (subRaiz != null) { //estamos en un nodo con alg�n contenido
            if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) > 0) { //elemento>subRaiz
                return buscar(subRaiz.getDirMemDer(), elemento);
            } else if (Herramientas.compararObjetos(elemento, subRaiz.getDato()) < 0) { //elemento<subRaiz
                return buscar(subRaiz.getDirMemIzq(), elemento);
            } else { //elemento=subRaiz, lo encontr�
                return subRaiz.getDato();
            }
        } else { //estamos en un nodo que apunta a null
            //no est� el elemento
            return null;
        }
    }
}
