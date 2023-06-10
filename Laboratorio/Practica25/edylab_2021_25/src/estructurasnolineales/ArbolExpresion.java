package estructurasnolineales;

import estructuraslineales.ListaPila;
import estructuraslineales.registros.NodoDoble;
import herramientas.matematicas.ExpresionAritmetica;

/**
 * Arbol el cual contendra expresiones aritmenticas
 */
public class ArbolExpresion extends ArbolBinario{

    public ArbolExpresion(){
        super();
    }

    /**
     * Crea el arbol a partir de una expresion priorizada con parentesis
     * @param expresion Expresion priorizada con la cual se creara el arbol
     */
    public void expresionPriorizada(String expresion){
        int pos = 0;
        NodoDoble nodoActual = null;
        ListaPila pila = new ListaPila();
        while(pos < expresion.length()){
            char token = expresion.charAt(pos);
            if(token != ')' && token != ' '){
                if(token == '('){
                    if(nodoActual == null){
                        raiz = new NodoDoble(null);
                        pila.poner(raiz);
                        nodoActual = raiz;
                    }else{
                        NodoDoble nuevo = new NodoDoble(null);
                        if(nodoActual.getDirMemIzq() == null){
                            nodoActual.setDirMemIzq(nuevo);
                        }else{
                            nodoActual.setDirMemDer(nuevo);
                        }
                        nodoActual = nuevo;
                        pila.poner(nodoActual);
                    }
                }else if(ExpresionAritmetica.esOperando(token)){
                    NodoDoble nuevo = new NodoDoble(token);
                    if(nodoActual.getDirMemIzq() == null){
                        nodoActual.setDirMemIzq(nuevo);
                    }else{
                        nodoActual.setDirMemDer(nuevo);
                    }
                }else if(!ExpresionAritmetica.esOperando(token)){
                    NodoDoble nodo = (NodoDoble)pila.quitar();
                    nodo.setDato(token);
                    nodoActual = nodo;
                }
            }
            pos++;
        }
    }
}
