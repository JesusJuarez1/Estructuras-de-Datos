package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;
import estructuraslineales.ListaEncadenadaHash;
import estructurasnolineales.ArbolBinario;

public class PruebaArbolBinario {
    public static  void  main(String args[]){
        /*ArbolBinario arbol=new ArbolBinario();

        arbol.crearArbol(); //crear un árbol a petición del usuario

        SalidaTerminal.consola("\nImpresión en inOrden: \n");
        arbol.inOrden();

        SalidaTerminal.consola("\nImpresión en preOrden: \n");
        arbol.preOrden();

        SalidaTerminal.consola("\nImpresión en postOrden: \n");
        arbol.postOrden();*/
        //-------------------------------------------------------//
        /*
        ArbolBinario arbol = new ArbolBinario();
        arbol.crearArbol();
        ListaEncadenada lista = arbol.sacarOperadoresYOperandos();
        SalidaTerminal.consola("Operadores:\n");
        ((ListaEncadenada)lista.obtener(0)).imprimir();
        SalidaTerminal.consola("\nOperandos:\n");
        ((ListaEncadenadaHash)lista.obtener(1)).imprimir();
        SalidaTerminal.consola("\nNuevo arbol: \n");
        ArbolBinario a = arbol.suplantarVariables();
        SalidaTerminal.consola("Arbol original: \n");
        SalidaTerminal.consola("PreOrden: \n");
        arbol.preOrden();
        SalidaTerminal.consola("\nPostOrden: \n");
        arbol.postOrden();
        SalidaTerminal.consola("\nInOrden: \n");
        arbol.inOrden();

        SalidaTerminal.consola("\n\nArbol con variables suplantadas: \n");
        SalidaTerminal.consola("PreOrden: \n");
        a.preOrden();
        SalidaTerminal.consola("\nPostOrden: \n");
        a.postOrden();
        SalidaTerminal.consola("\nInOrden: \n");
        a.inOrden();

        SalidaTerminal.consola("\n\n\n" +
                "Metodos recursivos en arbol binario:\n");
        SalidaTerminal.consola("Altura del arbol: "+arbol.altura()+"\n");
        SalidaTerminal.consola("Ingresa el nodo a buscar (arbol original): ");
        String nodo = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("\nAltura del nodo("+nodo+"): "+arbol.alturaNodo(nodo)+"\n");
        SalidaTerminal.consola("Numero de elementos por nivel: \n");
        ListaEncadenadaHash list = arbol.numElementosXNivel();
        list.imprimir();
        SalidaTerminal.consola("\nIngresa el nodo a evaluar: ");
        String n2 = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("\nTipo nodo("+n2+"): "+arbol.raizIntermedioHoja(n2)+"\n");
         */

        ArbolBinario arbol = new ArbolBinario();
        arbol.crearArbol();
        SalidaTerminal.consola("PostOrden: \n");
        arbol.postOrden();
        SalidaTerminal.consola("\nPreOrden: \n");
        arbol.preOrden();
        SalidaTerminal.consola("\nInOrden con recursion: \n");
        arbol.inOrden();
        SalidaTerminal.consola("\nInOrden sin recursion: \n");
        arbol.inOrdenNoRec();
        SalidaTerminal.consola("\nAmplitud: \n");
        arbol.amplitud();
        SalidaTerminal.consola("\nAmplitud utilizando una pila: \n");
        arbol.amplitudPila();
    }
}