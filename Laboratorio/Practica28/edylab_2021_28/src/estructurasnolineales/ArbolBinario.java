package estructurasnolineales;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaCola;
import estructuraslineales.ListaEncadenada;
import estructuraslineales.ListaEncadenadaHash;
import estructuraslineales.ListaPila;
import estructuraslineales.registros.Nodo;
import estructuraslineales.registros.NodoDoble;
import herramientas.comunes.Herramientas;
import herramientas.matematicas.ExpresionAritmetica;
import herramientas.matematicas.Matematicas;

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

    /**
     * Imprime el arbol en inOrden sin utilizar la recursion
     */
    public void inOrdenNoRec(){
        ListaPila pila = new ListaPila();
        NodoDoble actual = raiz;
        while(actual != null || !pila.vacio()){
            if(actual != null){
                pila.poner(actual);
                actual = actual.getDirMemIzq();
            }
            if(actual == null && !pila.vacio()){
                NodoDoble tmp = (NodoDoble) pila.quitar();
                SalidaTerminal.consola(tmp.getDato()+" ");
                actual = tmp.getDirMemDer();
            }
        }
    }

    /**
     * Imprime el arbol haciendo el recorrido por amplitud
     */
    public void amplitud(){
        ListaCola cola = new ListaCola();
        cola.poner(raiz);
        while(!cola.vacio()){
            NodoDoble actual = (NodoDoble)cola.quitar();
            SalidaTerminal.consola(actual.getDato()+" ");
            if(actual.getDirMemIzq() != null){
                cola.poner(actual.getDirMemIzq());
            }
            if(actual.getDirMemDer() != null){
                cola.poner(actual.getDirMemDer());
            }
        }
    }

    /**
     * Imprime el arbol utilizando el recorrido por amplitud utilizando una pila en vez de una cola
     */
    public void amplitudPila(){
        ListaPila pila = new ListaPila();
        pila.poner(raiz);
        while(!pila.vacio()){
            NodoDoble actual = (NodoDoble)pila.quitar();
            SalidaTerminal.consola(actual.getDato()+" ");
            if(actual.getDirMemIzq() != null){
                pila.poner(actual.getDirMemIzq());
            }
            if(actual.getDirMemDer() != null){
                pila.poner(actual.getDirMemDer());
            }
        }
    }

    /**
     * Invoca el metodo altura pasandole el parametro raiz
     * @return lo que regrese el metodo altura
     */
    public int altura(){
        return altura(raiz,0);
    }

    /**
     * Saca la altura que tiene el arbol
     * @param subArbol subArbol en el que se esta
     * @param altura altura a la que se esta
     * @return la altura resultante
     */
    private int altura(NodoDoble subArbol, int altura){
        if(subArbol != null){
            int aIz = altura(subArbol.getDirMemIzq(),altura+1);
            int aDer = altura(subArbol.getDirMemDer(),altura+1);
            if(aIz > aDer){
                altura = aIz;
            }else{
                altura = aDer;
            }
        }
        return altura;
    }

    /**
     * Manda llamar al metodo alturaNodo con los parametros elemento, raiz y 1
     * @param elemento Nodo a buscar
     * @return Lo que regresa el metodo alturaNodo
     */
    public int alturaNodo(Object elemento){
        return alturaNodo(elemento,raiz,1);
    }

    /**
     * Busca la altura del nodo que contenga a elemento
     * @param elemento Nodo a buscar el nivel
     * @param subArbol SubArbol en el que se esta
     * @param altura nivel en el que se esta
     * @return el nivel en el que se encontro el nodo, 0 en caso que no se halla encontrado
     */
    private int alturaNodo(Object elemento, NodoDoble subArbol, int altura){
        if(subArbol != null){
            if(Herramientas.compararObjetos(elemento,subArbol.getDato()) == 0){
                return altura;
            }else{
                int a = alturaNodo(elemento,subArbol.getDirMemIzq(),(altura+1));
                if(a > 0){
                    return a;
                }else{
                    return alturaNodo(elemento,subArbol.getDirMemDer(),(altura+1));
                }
            }
        }else{
            return 0;
        }
    }

    /**
     * Crea una lista hash a la cual le agrega un elemento por cada nivel del arbol, con la clave "Altura x" y el valor 0
     * @return La lista hash que regresa la llamada al metodo numElementosXNivel
     */
    public ListaEncadenadaHash numElementosXNivel(){
        if(raiz != null){
            ListaEncadenadaHash lista = new ListaEncadenadaHash();
            int altura = altura();
            for(int i=0;i<altura;i++){
                lista.insertar("Altura "+(i+1),0);
            }
            return numElementosXNivel(raiz,1,lista);
        }else{
            return new ListaEncadenadaHash();
        }
    }

    /**
     * Le va sumando uno a la altura en la lista hash en la posicion correspondiente
     * @param tmp Nodo actual
     * @param altura Altura actual
     * @param lista Lista hash que contiene los contadores
     * @return La lista hash
     */
    private ListaEncadenadaHash numElementosXNivel(NodoDoble tmp, int altura,ListaEncadenadaHash lista){
        if(tmp != null){
            lista.insertar(("Altura "+altura),((int)lista.obtener("Altura "+altura))+1);
            lista = numElementosXNivel(tmp.getDirMemIzq(),1+altura,lista);
            return numElementosXNivel(tmp.getDirMemDer(),1+altura,lista);
        }else{
            return lista;
        }
    }

    /**
     * Evalua si la raiz es igual al elemento y dice que es el nodo raiz y no tiene padre
     * si no son iguales llama al metodo raizIntermedioHoja
     * @param elemento Elemento a evaluar
     * @return Lo que regrese el metodo llamado
     */
    public String raizIntermedioHoja(Object elemento){
        if(raiz != null){
            if(Herramientas.compararObjetos(elemento,raiz.getDato()) == 0){
                return "Nodo raiz, no tiene padre";
            }else{
                return raizIntermedioHoja(elemento,raiz);
            }
        }else{
            return "";
        }
    }

    /**
     * Busca el nodo con el elemento dado y regresa una cadena diciendo si es nodo intermedio o hoja y cual es su padre
     * @param elemento Elemento a evaluar
     * @param tmp Nodo actual
     * @return Una cadena donde se dice que tipo de nodo es y cual es su padre
     */
    private String raizIntermedioHoja(Object elemento,NodoDoble tmp){
        if(tmp != null){
            if(tmp.getDirMemIzq() != null){
                if(Herramientas.compararObjetos(tmp.getDirMemIzq().getDato(),elemento) == 0) {
                    if (tmp.getDirMemIzq().getDirMemIzq() != null || tmp.getDirMemIzq().getDirMemDer() != null) {
                        return "Nodo intermedio, y su padre es: " + tmp.getDato().toString();
                    } else {
                        return "Nodo hoja, y su padre es: " + tmp.getDato().toString();
                    }
                }
            }
            if(tmp.getDirMemDer() != null){
                if(Herramientas.compararObjetos(tmp.getDirMemDer().getDato(),elemento) == 0) {
                    if (tmp.getDirMemDer().getDirMemIzq() != null || tmp.getDirMemDer().getDirMemDer() != null) {
                        return "Nodo intermedio, y su padre es: " + tmp.getDato().toString();
                    } else {
                        return "Nodo hoja, y su padre es: " + tmp.getDato().toString();
                    }
                }
            }
            String s = raizIntermedioHoja(elemento,tmp.getDirMemIzq());
            if(s.equals("")){
                return raizIntermedioHoja(elemento,tmp.getDirMemDer());
            }else{
                return s;
            }
        }else{
            return "";
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
