package estructurasnolineales;

import estructuraslineales.registros.NodoDoble;
import herramientas.generales.Utilerias;

import javax.security.auth.Subject;

public class ABB extends ArbolBinario{

    public boolean agregar(Object elemento){
        if(raiz==null){ // no hay nada en el árbol
            NodoDoble nuevoNodo=new NodoDoble(elemento);
            if(nuevoNodo!=null){ //si hay espacio
                raiz=nuevoNodo;
                return true;
            }else{ //se asume que no hay espacio
                raiz=null;
                return false;
            }
        }else{ //ya hay algo en el árbol
            return agregar(raiz, elemento);
        }
    }

    private boolean agregar(NodoDoble subRaiz, Object elemento){
        //Verificar que el elemento proporcionado sea

        if(Utilerias.compararObjetos(elemento,subRaiz.getDato())>0){ //elemento > subRaiz.dato
            //Mayor a la información de la subRaiz
            if(subRaiz.getDirMemDer()==null){ // no tiene hijo derecho, ahí le toca insertarse a elemento
                NodoDoble nuevoNodo=new NodoDoble(elemento);
                if (nuevoNodo!=null){ //si hay espacio
                    subRaiz.setDirMemDer(nuevoNodo);
                    return true;
                }else{ //no hay espacio
                    return false;
                }
            }else{ //ya tiene un hijo derecho esta subRaiz, nos dirigimos hacia esa Rama,
                return agregar(subRaiz.getDirMemDer(), elemento);
            }
        } else if(Utilerias.compararObjetos(elemento,subRaiz.getDato())<0){ //elemento < subRaiz.dato
            // Menor a la información de la subRaiz
            if(subRaiz.getDirMemIzq()==null){ // no tiene hijo izquierdo, ahí le toca insertarse a elemento
                NodoDoble nuevoNodo=new NodoDoble(elemento);
                if (nuevoNodo!=null){ //si hay espacio
                    subRaiz.setDirMemIzq(nuevoNodo);
                    return true;
                }else{ //no hay espacio
                    return false;
                }
            }else{ //ya tiene un hijo izquiedo esta subRaiz, nos dirigimos hacia esa Rama,
                return agregar(subRaiz.getDirMemIzq(), elemento);
            }
        }else {
            //Igual a la información de la subRaiz, no lo insertamos
            return false;
        }
    }

    public Object buscar(Object elemento){
        return buscar(raiz,elemento);
    }

    private Object buscar(NodoDoble subRaiz, Object elemento){
        if(subRaiz!=null){ //estamos en un nodo con algún contenido
            if(Utilerias.compararObjetos(elemento,subRaiz.getDato())>0){ //elemento>subRaiz
                return buscar(subRaiz.getDirMemDer(), elemento);
            } else if(Utilerias.compararObjetos(elemento, subRaiz.getDato())<0){ //elemento<subRaiz
                return buscar(subRaiz.getDirMemIzq(), elemento);
            }else{ //elemento=subRaiz, lo encontré
                return subRaiz.getDato();
            }
        }else{ //estamos en un nodo que apunta a null
            //no está el elemento
            return null;
        }
    }
}
