package estructurasnolineales;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloPila;
import estructuraslineales.ListaEncadenada;
import estructuraslineales.ListaEncadenadaHash;
import estructuraslineales.ListaPila;
import estructuraslineales.registros.NodoDoble;
import herramientas.matematicas.ExpresionAritmetica;
import herramientas.matematicas.Matematicas;

/**
 * Arbol el cual contendra expresiones aritmenticas
 */
public class ArbolExpresion extends ArbolBinario{

    public ArbolExpresion(){
        super();
    }

    //Se asume que como heredamos de ArbolBinario, aquí van los atributos y métodos heredados.

    public void crearArbolExpInfija(String inFija) {
        //1.- Se parte de una expresión infija, la cual debe convertirse a postfija (prefija).
        //Invocar al método que convierte una expresión infija en postfija
        //el resultado de este paso lo metemos como argumento para invocar al método de
        //crearArbolExpPostfija(String postfija)
    }

    public void crearArbolExpPostfija(String postFija){
        ArregloPila pila=new ArregloPila(postFija.length());

        //Pasos:

        for(int posToken=0;posToken<postFija.length();posToken++) {
            //2.- Tokenizar la expresión postfija izq -> der.
            char token= postFija.charAt(posToken);
            //3.- Comparar
            if(ExpresionAritmetica.esOperando(token)==true) { //es operando
                //   3.1.- Si el token es un operando: crear un NodoDoble con el token y meterlo en la pila.
                NodoDoble nuevoNodo=new NodoDoble(token);
                pila.poner(nuevoNodo);
            }else { //es operador
                //   3.2.- Si el token es un operador: crear un NodoDoble con el token, sacando dos operandos de
                //         la pila (la primera extracción es op2, la segunda es op1) y los enlazamos
                //         a la subRaiz (operador); el nuevoNodo (el operador) se mete en la pila.
                NodoDoble nuevoNodo=new NodoDoble(token);
                NodoDoble operando2= (NodoDoble) pila.quitar(); //hijo derecho
                NodoDoble operando1= (NodoDoble) pila.quitar(); //hijo izquierdo
                nuevoNodo.setDirMemIzq(operando1); //I
                nuevoNodo.setDirMemDer(operando2); //D
                pila.poner(nuevoNodo);
            }
        }
        //4.- Al final, el nodo que queda encima de la pila, es el nodo raíz del árbol.
        NodoDoble nodoRaiz=(NodoDoble) pila.quitar();
        if(nodoRaiz!=null){
            raiz=nodoRaiz;
        } //en caso contrario, pudieramos no hacer nada
    }

    /**
     * Crea una lista encadenada con una lista encadenada y una lista hash y llama al metodo sacarOperadoresYOperandos
     * @return Lo que regresa el metodo llamado
     */
    public ListaEncadenada sacarOperadoresYOperandos(){
        ListaEncadenada lista = new ListaEncadenada();
        lista.agregar(new ListaEncadenada());
        lista.agregar(new ListaEncadenadaHash());
        return sacarOperadoresYOperandos(raiz,lista);
    }

    /**
     * Saca los operadores y operandos, en una lista encadenada y una lista hash respectivamente
     * @param tmp Nodo en el que se encuentra
     * @param lista Lista que contiene las listas donde se van agregar los elementos
     * @return La lista con los operandos y operadores separados dentro de la lista
     */
    private ListaEncadenada sacarOperadoresYOperandos(NodoDoble tmp,ListaEncadenada lista){
        if(tmp != null){
            if(tmp.getDirMemDer() == null && tmp.getDirMemIzq() == null){//Es operando
                if(Matematicas.esNumero(tmp.getDato()+"")){
                    ((ListaEncadenadaHash)lista.obtener(1)).insertar(tmp.getDato(),
                            Double.parseDouble(tmp.getDato()+""));
                }else{
                    SalidaTerminal.consola("Ingresa el valor para "+tmp.getDato()+": ");
                    Double valor = EntradaTerminal.consolaDouble();
                    ((ListaEncadenadaHash)lista.obtener(1)).insertar(tmp.getDato(),valor);
                }
                return lista;
            }else {//Es operador
                lista = sacarOperadoresYOperandos(tmp.getDirMemIzq(),lista);
                ((ListaEncadenada)lista.obtener(0)).agregar(tmp.getDato());
                return sacarOperadoresYOperandos(tmp.getDirMemDer(),lista);
            }
        }else{
            return lista;
        }
    }

    /**
     * Crea un arbol binario y llama al metodo suplantarVariables
     * @return El arbol creado
     */
    public ArbolBinario suplantarVariables(){
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new NodoDoble(null);
        suplantarVariables(raiz, arbol.raiz);
        return arbol;
    }

    /**
     * Rellena el arbol creado con el actual, suplantando variables
     * @param tmp Nodo del arbol actual
     * @param tmp2 Nodo del arbol creado
     */
    private void suplantarVariables(NodoDoble tmp, NodoDoble tmp2){
        if(tmp != null){
            if(tmp.getDirMemDer() == null && tmp.getDirMemIzq() == null){
                if(Matematicas.esNumero(tmp.getDato()+"")){
                    tmp2.setDato(Double.parseDouble(tmp.getDato()+""));
                }else{
                    SalidaTerminal.consola("Introduce el valor de "+tmp.getDato().toString()+": ");
                    Double valor = EntradaTerminal.consolaDouble();
                    tmp2.setDato(valor);
                }
            }else{
                tmp2.setDato(tmp.getDato());
                tmp2.setDirMemIzq(new NodoDoble(null));
                suplantarVariables(tmp.getDirMemIzq(),tmp2.getDirMemIzq());
                tmp2.setDirMemDer(new NodoDoble(null));
                suplantarVariables(tmp.getDirMemDer(),tmp2.getDirMemDer());
            }
        }
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
