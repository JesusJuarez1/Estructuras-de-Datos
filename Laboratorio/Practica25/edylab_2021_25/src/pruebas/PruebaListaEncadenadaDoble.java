package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenadaDoble;
import registros.diccionario.Palabra;
import registros.diccionario.TipoPalabra;
import registros.escuela.Alumno;

public class PruebaListaEncadenadaDoble {
    public static void main(String[] args) {
        ListaEncadenadaDoble lista1 = new ListaEncadenadaDoble();
        lista1.agregar("A");
        lista1.agregar("B");
        lista1.agregar("C");
        lista1.agregar("D");
        lista1.imprimir();
        SalidaTerminal.consola("\nImprimir en orden inverso:\n");
        lista1.imprimirOrdenInverso();
        SalidaTerminal.consola("\nBusca un elemento: "+lista1.buscar("C")+"\n");
        //Se agregan mas elementos
        lista1.agregar("E");
        lista1.agregar("F");
        lista1.agregar("G");
        ListaEncadenadaDoble l1 = new ListaEncadenadaDoble();
        l1.agregar("H");
        l1.agregar("X");
        l1.agregar("A");
        SalidaTerminal.consola("Agregar los datos de una lista: \n");
        lista1.agregarLista(l1);
        lista1.imprimir();
        SalidaTerminal.consola("\nCopia de la lista: \n");
        ListaEncadenadaDoble lista2 = (ListaEncadenadaDoble) lista1.clonar();
        lista2.imprimir();
        SalidaTerminal.consola("\nVaciar la lista: \n");
        lista1.vaciar();
        lista1.imprimir();
        SalidaTerminal.consola("\nRellenar lista: \n");
        lista1.rellenar("X",5);
        lista1.imprimir();
        SalidaTerminal.consola("\nContar coincidencias: "+lista1.contar("X")+"\n");
        SalidaTerminal.consola("invertir:\n");
        lista2.invertir();
        lista2.imprimir();
        SalidaTerminal.consola("\nCambiar: "+lista1.cambiar("X","K",3)+"\n");
        lista1.imprimir();
        SalidaTerminal.consola("Comparar listas: "+lista1.esIgual(lista1)+"\n");
        SalidaTerminal.consola("\nEliminar elemento: "+lista2.eliminar("K")+"\n");
        lista2.imprimir();
        SalidaTerminal.consola("\nBuscar valores: \n");
        ArregloDatos arr2 = lista1.buscarValores("X");
        arr2.imprimir();
        ListaEncadenadaDoble lista3 = new ListaEncadenadaDoble();
        lista3.agregar("J");
        lista3.agregar("E");
        lista3.agregar("A");
        lista3.agregar("S");
        lista3.agregar("F");
        lista3.agregar("G");
        ArregloDatos arr3 = new ArregloDatos(3);
        arr3.agregar("F");
        arr3.agregar("A");
        arr3.agregar("E");
        lista3.imprimir();
        SalidaTerminal.consola("\nEliminar lista: "+lista3.eliminarLista(arr3)+"\n");
        lista3.imprimir();
        lista3.agregar("E");
        lista3.agregar("A");
        lista3.agregar("F");
        SalidaTerminal.consola("\nSub lista: \n");
        ListaEncadenadaDoble lista4 = (ListaEncadenadaDoble) lista3.subLista(1,3);
        lista4.imprimir();
        SalidaTerminal.consola("\nEs sublista?: "+lista3.esSublista(lista4)+"\n");
        ArregloDatos arr4 = new ArregloDatos(3);
        arr4.agregar("X");
        arr4.agregar("Y");
        arr4.agregar("Z");
        SalidaTerminal.consola("Cambiar lista: "+lista3.cambiarLista(arr3,arr4)+"\n");
        lista3.imprimir();
        SalidaTerminal.consola("\nRetener lista: "+lista3.retenerLista(arr4)+"\n");
        lista3.imprimir();
        SalidaTerminal.consola("\nInsertar: "+lista3.insertar(1,"K")+"\n");
        lista3.imprimir();
        SalidaTerminal.consola("\nCopiar lista: "+lista3.copiarLista(arr3)+"\n");
        lista3.imprimir();

        ListaEncadenadaDoble lista5 = new ListaEncadenadaDoble();
        lista5.agregar("X");
        lista5.agregar(1);
        lista5.agregar(new Alumno("987656","Juan",25,null));
        lista5.agregar(54);
        lista5.agregar("Y");
        lista5.agregar(new Palabra("Palabra","Definicion", TipoPalabra.VERBO));
        lista5.agregar(123);
        lista5.agregar("Hola");
        SalidaTerminal.consola("\n");
        lista5.imprimir();
        SalidaTerminal.consola("\nEliminar primer elemento: "+lista5.eliminarInicio()+"\n");
        lista5.imprimir();
        SalidaTerminal.consola("\nBuscar comenzando del final: "+lista5.buscarOI(54));
        SalidaTerminal.consola("\nSeparar elementos de la lista: \n");
        ListaEncadenadaDoble l = lista5.separarElementos();
        l.inicializarIterador();
        ((ListaEncadenadaDoble)l.obtenerElemento()).imprimir();
        SalidaTerminal.consola("\n");
        ((ListaEncadenadaDoble)l.obtenerElemento()).imprimir();
        SalidaTerminal.consola("\n");
        ((ListaEncadenadaDoble)l.obtenerElemento()).imprimir();
    }
}
