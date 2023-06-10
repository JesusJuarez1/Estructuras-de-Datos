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