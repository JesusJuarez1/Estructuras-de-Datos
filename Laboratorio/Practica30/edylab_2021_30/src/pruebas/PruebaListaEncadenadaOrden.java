package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenadaOrden;
import herramientas.comunes.TipoOrden;
import estructurasnolineales.Tabla2D;
import estructurasnolineales.TipoTabla;
import registros.escuela.Alumno;

public class PruebaListaEncadenadaOrden {
    public static void main(String[] args) {
        ListaEncadenadaOrden lista1 = new ListaEncadenadaOrden(TipoOrden.ASCENDENTE);
        lista1.agregar(15);
        lista1.agregar("H");
        lista1.agregar(2);
        lista1.agregar("I");
        lista1.agregar("A");
        lista1.agregar(1);
        lista1.agregar("ADIOS");
        lista1.agregar("S");
        lista1.agregar("K");
        lista1.agregar(new Alumno("12345678","Juan",20,null));
        lista1.imprimir();
        SalidaTerminal.consola("\nImprimri inverso \n");
        lista1.imprimirOrdenInverso();
        Tabla2D t1 = new Tabla2D(2,2);
        t1.asignarCelda(0,0,"Ñ");
        t1.asignarCelda(1,0,"0");
        t1.asignarCelda(0,1,0);
        t1.asignarCelda(1,1,24);
        SalidaTerminal.consola("\nAgregar una tabla2D: "+lista1.agregarTabla2D(t1, TipoTabla.COLUMNA)+"\n");
        lista1.imprimir();
        ArregloDatos arr1 = new ArregloDatos(3);
        arr1.agregar("Q");
        arr1.agregar("E");
        arr1.agregar("EZZ");
        SalidaTerminal.consola("\nAgregar arreglo: "+lista1.agregarLista(arr1)+"\n");
        lista1.imprimir();
        SalidaTerminal.consola("\nAgregar un elemento en una posicion indicada: "+
                lista1.cambiar(5,"B")+"\n");
        lista1.imprimir();
        SalidaTerminal.consola("\nEs igual: "+lista1.esIgual(lista1.clonar())+"\n");
        SalidaTerminal.consola("Cambiar viejo por nuevo: "+
                lista1.cambiar("ADIOS","HOLA",5)+"\n");
        lista1.imprimir();
        SalidaTerminal.consola("\nInvertir lista:\n");
        lista1.invertir();
        lista1.imprimir();
        SalidaTerminal.consola("\nRellenar:\n");
        lista1.rellenar("#",50);
        lista1.imprimir();
        ArregloDatos arr2 = new ArregloDatos(3);
        arr2.agregar(1);
        arr2.agregar(3);
        arr2.agregar(5);
        ArregloDatos arr3 = new ArregloDatos(3);
        arr3.agregar(1);
        arr3.agregar(3);
        arr3.agregar(5);
        SalidaTerminal.consola("\nCambiar lista: "+lista1.cambiarLista(arr2,arr3)+"\n");
        lista1.imprimir();


        SalidaTerminal.consola("\n\n------------------------------------------------------" +
                "\nLISTA CON ORDEN DESCENDENTE\n");
        ListaEncadenadaOrden lista2 = new ListaEncadenadaOrden(TipoOrden.DESCENDENTE);
        lista2.agregar(15);
        lista2.agregar("H");
        lista2.agregar(2);
        lista2.agregar("I");
        lista2.agregar("A");
        lista2.agregar(1);
        lista2.agregar("ADIOS");
        lista2.agregar("S");
        lista2.agregar("K");
        lista2.agregar(new Alumno("12345678","Juan",20,null));
        lista2.imprimir();
        SalidaTerminal.consola("\nImprimri inverso \n");
        lista2.imprimirOrdenInverso();
        SalidaTerminal.consola("\nAgregar una tabla2D: "+lista2.agregarTabla2D(t1, TipoTabla.FILA)+"\n");
        lista2.imprimir();
        SalidaTerminal.consola("\nAgregar arreglo: "+lista2.agregarLista(arr1)+"\n");
        lista2.imprimir();
        SalidaTerminal.consola("\nAgregar un elemento en una posicion indicada: "+
                lista2.cambiar(5,"B")+"\n");
        lista2.imprimir();
        SalidaTerminal.consola("\nEs igual: "+lista2.esIgual(lista2.clonar())+"\n");
        SalidaTerminal.consola("Cambiar viejo por nuevo: "+
                lista2.cambiar("ADIOS","HOLA",5)+"\n");
        lista2.imprimir();
        SalidaTerminal.consola("\nInvertir lista:\n");
        lista2.invertir();
        lista2.imprimir();
        SalidaTerminal.consola("\nRellenar:\n");
        lista2.rellenar("#",50);
        lista2.imprimir();
        SalidaTerminal.consola("\nCambiar lista: "+lista2.cambiarLista(arr2,arr3)+"\n");
        lista2.imprimir();
    }
}
