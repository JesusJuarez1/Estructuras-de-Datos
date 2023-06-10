package estructurasnolineales;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.registros.NodoDoble;

/**
 * Esta clase crear un árbol binario a petición del usuario.
 * @author Clase ED.
 * @version 1.0.
 */

public class ArbolBinario {
    protected NodoDoble raiz;

    public ArbolBinario(){
        raiz=null;
    }

    public boolean crearArbol(){
        SalidaTerminal.consola("Introduce la raíz del árbol: ");
        String datoNodo=EntradaTerminal.consolaCadena();
        NodoDoble nuevoNodo=new NodoDoble(datoNodo);
        if(nuevoNodo!=null){ //hay espacio
            raiz=nuevoNodo;
            crearArbol(raiz); //La raiz se vuelve subraiz para comenzar a agegar los hijos de ella
            return true;
        }else{ //no hay espacio
            return false;
        }
    }

    private void crearArbol(NodoDoble subRaiz) {
        //Agregar hijo izquierdo
        SalidaTerminal.consola("¿El nodo " + subRaiz.getDato() + " tiene hijo izquierdo? [S/N] ");
        String respuestaHijoIzquierdo = EntradaTerminal.consolaCadena();
        if (respuestaHijoIzquierdo.equalsIgnoreCase("S")) { //quiere agregar un hijo izquierdo
            SalidaTerminal.consola("Introduce el dato del hijo izquierdo de "+ subRaiz.getDato()+" : ");
            String datoNodo = EntradaTerminal.consolaCadena();
            NodoDoble nuevoNodoIzquierdo = new NodoDoble(datoNodo);
            if (nuevoNodoIzquierdo != null) { //si hay espacio
                subRaiz.setDirMemIzq(nuevoNodoIzquierdo);
                crearArbol(subRaiz.getDirMemIzq());
            }
        } //si no entra, no quiere agregar hijo izquierdo

        //Agregar hijo derecho
        SalidaTerminal.consola("¿El nodo " + subRaiz.getDato() + " tiene hijo derecho? [S/N] ");
        String respuestaHijoDerecho = EntradaTerminal.consolaCadena();
        if (respuestaHijoDerecho.equalsIgnoreCase("S")) { //quiere agregar un hijo derecho
            SalidaTerminal.consola("Introduce el dato del hijo derecho de "+ subRaiz.getDato()+": ");
            String datoNodo = EntradaTerminal.consolaCadena();
            NodoDoble nuevoNodoDerecho = new NodoDoble(datoNodo);
            if (nuevoNodoDerecho != null) { //si hay espacio
                subRaiz.setDirMemDer(nuevoNodoDerecho);
                crearArbol(subRaiz.getDirMemDer());
            }
        } //si no entra, no quiere agregar hijo derecho
    }

    public void inOrden(){
        inOrden(raiz);
    }

    private void inOrden(NodoDoble subRaiz){
        //IRD
        if(subRaiz!=null){ //hay alguna subRaiz válida
            //I
            inOrden(subRaiz.getDirMemIzq());
            //R
            SalidaTerminal.consola(subRaiz.getDato() + " ");
            //D
            inOrden(subRaiz.getDirMemDer());
        } //en caso contrario, es deci la subRaiz es nula, no hacemos nada, CASO BASE
    }

    public void preOrden(){
        preOrden(raiz);
    }

    private void preOrden(NodoDoble subRaiz){
        //RID
        if(subRaiz!=null){ //hay alguna subRaiz válida
            //R
            SalidaTerminal.consola(subRaiz.getDato() + " ");
            //I
            preOrden(subRaiz.getDirMemIzq());
            //D
            preOrden(subRaiz.getDirMemDer());
        } //en caso contrario, es deci la subRaiz es nula, no hacemos nada, CASO BASE
    }

    public void postOrden(){
        postOrden(raiz);
    }
    private void postOrden(NodoDoble subRaiz){
        //IDR
        if(subRaiz!=null){ //hay alguna subRaiz válida
            //I
            postOrden(subRaiz.getDirMemIzq());
            //D
            postOrden(subRaiz.getDirMemDer());
            //R
            SalidaTerminal.consola(subRaiz.getDato() + " ");
        } //en caso contrario, es deci la subRaiz es nula, no hacemos nada, CASO BASE
    }

}
