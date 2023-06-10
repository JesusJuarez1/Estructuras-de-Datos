package estructurasnolineales;

import estructuraslineales.ArregloPila;
import estructuraslineales.registros.Nodo;
import estructuraslineales.registros.NodoDoble;
import herramientas.matematicas.ExpresionAritmetica;

public class ArbolExpresionAritmetica extends ArbolBinario{
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
}
