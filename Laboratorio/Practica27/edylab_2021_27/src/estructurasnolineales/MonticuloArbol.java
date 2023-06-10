package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.ListaCola;
import estructuraslineales.TipoOrden;
import estructuraslineales.registros.NodoTriple;
import herramientas.comunes.Herramientas;

public class MonticuloArbol{
    protected NodoTriple raiz;
    protected TipoOrden orden;

    public MonticuloArbol(TipoOrden orden){
        raiz=null;
        this.orden=orden;
    }

    /**
     * Determina si el arbol esta vacio o no
     * @return true si lo esta, false en caso contrario
     */
    public boolean vacio(){
        if(raiz == null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Agrega un elemento al final del arbol, luego acomoda ese elemento agregado con forme al orden establecido para el monticulo
     * @param elemento Elemento a agregar
     * @return True si lo hace, false en caso contrario
     */
    public boolean agregar(Object elemento){
        NodoTriple nuevo = new NodoTriple(elemento);
        if(nuevo != null){
            if(raiz == null){
                raiz = nuevo;
                return true;
            }else{
                ListaCola cola = new ListaCola();
                NodoTriple actual = null;
                cola.poner(raiz);
                while(!cola.vacio()){
                    actual = (NodoTriple)cola.quitar();
                    if(actual.getHijoIzq() != null){
                        cola.poner(actual.getHijoIzq());
                    }else{
                        nuevo.setPadre(actual);
                        actual.setHijoIzq(nuevo);
                        actual = actual.getHijoIzq();
                        break;
                    }
                    if(actual.getHijoDer() != null){
                        cola.poner(actual.getHijoDer());
                    }else{
                        nuevo.setPadre(actual);
                        actual.setHijoDer(nuevo);
                        actual = actual.getHijoDer();
                        break;
                    }
                }
                while(actual.getPadre() != null){
                    NodoTriple padre = actual.getPadre();
                    if(orden == TipoOrden.ASCENDENTE){
                        if(Herramientas.compararObjetos(actual.getElemento(),padre.getElemento()) < 0){
                            Object dato = padre.getElemento();
                            padre.setElemento(actual.getElemento());
                            actual.setElemento(dato);
                        }else{
                            break;
                        }
                    }else{
                        if(Herramientas.compararObjetos(actual.getElemento(),padre.getElemento()) > 0){
                            Object dato = padre.getElemento();
                            padre.setElemento(actual.getElemento());
                            actual.setElemento(dato);
                        }else{
                            break;
                        }
                    }
                    actual = padre;
                }
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Elimina el ultimo elemento del arbol
     * @return El elemento eliminado, null en caso contrario
     */
    public Object quitar(){
        if(raiz != null){
            if(raiz.getHijoIzq() == null && raiz.getHijoDer() == null){
                Object elemBorrado = raiz.getElemento();
                raiz = null;
                return elemBorrado;
            }
            Object elemBorrado = raiz.getElemento();
            ListaCola cola = new ListaCola();
            cola.poner(raiz);
            NodoTriple actual = null;
            while(!cola.vacio()){
                actual = (NodoTriple) cola.quitar();
                if(actual.getHijoIzq() != null){
                    cola.poner(actual.getHijoIzq());
                }
                if(actual.getHijoDer() != null){
                    cola.poner(actual.getHijoDer());
                }
            }
            raiz.setElemento(actual.getElemento());
            actual = actual.getPadre();
            if(actual.getHijoDer() != null){
                actual.setHijoDer(null);
            }else{
                actual.setHijoIzq(null);
            }
            actual = raiz;
            while(actual.getHijoIzq() != null){
                NodoTriple hijo = actual.getHijoIzq();
                if(orden == TipoOrden.ASCENDENTE){
                    if(Herramientas.compararObjetos(actual.getElemento(),hijo.getElemento()) > 0){
                        Object o = hijo.getElemento();
                        hijo.setElemento(actual.getElemento());
                        actual.setElemento(o);
                        actual = actual.getHijoIzq();
                    }else{
                        if(actual.getHijoDer() != null){
                            hijo = actual.getHijoDer();
                            if(Herramientas.compararObjetos(actual.getElemento(),hijo.getElemento()) > 0){
                                Object o = hijo.getElemento();
                                hijo.setElemento(actual.getElemento());
                                actual.setElemento(o);
                                actual = actual.getHijoDer();
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }else{
                    if(Herramientas.compararObjetos(actual.getElemento(),hijo.getElemento()) < 0){
                        Object o = hijo.getElemento();
                        hijo.setElemento(actual.getElemento());
                        actual.setElemento(o);
                        actual = actual.getHijoIzq();
                    }else{
                        if(actual.getHijoDer() != null){
                            hijo = actual.getHijoDer();
                            if(Herramientas.compararObjetos(actual.getElemento(),hijo.getElemento()) < 0){
                                Object o = hijo.getElemento();
                                hijo.setElemento(actual.getElemento());
                                actual.setElemento(o);
                                actual = actual.getHijoDer();
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
            return elemBorrado;
        }else{
            return null;
        }
    }

    /**
     * Imprime el monticulo haciendo el recorrido por amplitud
     */
    public void amplitud(){
        ListaCola cola = new ListaCola();
        cola.poner(raiz);
        while(!cola.vacio()){
            NodoTriple actual = (NodoTriple) cola.quitar();
            SalidaTerminal.consola(actual.getElemento()+" ");
            if(actual.getHijoIzq() != null){
                cola.poner(actual.getHijoIzq());
            }
            if(actual.getHijoDer() != null){
                cola.poner(actual.getHijoDer());
            }
        }
    }
}
