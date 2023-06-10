package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ArregloOrden;
import herramientas.comunes.TipoOrden;
import registros.escuela.Alumno;

public class PruebaArregloOrden {
    public static void main(String[] args) {
        ArregloOrden arr1 = new ArregloOrden(7, TipoOrden.ASCENDENTE);
        arr1.agregar("B");
        arr1.agregar("A");
        arr1.agregar("D");
        arr1.agregar("C");
        arr1.agregar("E");

        SalidaTerminal.consola("Arreglo1: \n");
        arr1.imprimir();

        SalidaTerminal.consola("Buscar C: "+arr1.buscar("C")+"\n");
        SalidaTerminal.consola("Cambiar D->G: "+arr1.cambiar("D","G",1)+"\n");
        arr1.imprimir();
        SalidaTerminal.consola("Cambiar F en 4: "+ arr1.cambiar(4,"F")+"\n");
        arr1.imprimir();
        SalidaTerminal.consola("Eliminar A: "+arr1.eliminar("A")+"\n");
        arr1.imprimir();
        ArregloDatos arr2 = new ArregloDatos(3);
        arr2.agregar("H");
        arr2.agregar("X");
        arr2.agregar("I");

        SalidaTerminal.consola("Agregar lista: "+arr1.agregarLista(arr2)+"\n");
        arr1.imprimir();
        SalidaTerminal.consola("Invertir arreglo: \n");
        arr1.invertir();
        arr1.imprimir();
        SalidaTerminal.consola("\n");

        ArregloOrden arr3 = new ArregloOrden(10,TipoOrden.ASCENDENTE);
        SalidaTerminal.consola("NUEVO ARREGLO VACIO\nRellenar con numeros hasta el 3: \n");
        arr3.rellenar(3);
        SalidaTerminal.consola("Rellenar con letras hasta la C: \n");
        arr3.rellenar("C");
        SalidaTerminal.consola("Rellenar con objetos (Objeto alumno): \n");
        arr3.rellenar(new Alumno("62345678","Juan",23,null));
        arr3.imprimir();
        SalidaTerminal.consola("Arreglo desordenado: \n");
        ((ArregloDatos)arr3.arregloDesordenado()).imprimir();
        ArregloDatos arr4 = new ArregloDatos(3);
        arr4.agregar(1);
        arr4.agregar(2);
        arr4.agregar(3);
        SalidaTerminal.consola("Arreglo4: \n");
        arr4.imprimir();
        SalidaTerminal.consola("Es subLista: "+arr3.esSublista(arr4)+"\n");
        SalidaTerminal.consola("Cambiar lista: "+arr3.cambiarLista(arr4,arr2)+"\n");
        SalidaTerminal.consola("Retener lista: "+arr3.retenerLista(arr2)+"\n");
        SalidaTerminal.consola("Insertar: "+arr3.insertar(6,"D")+"\n");
        SalidaTerminal.consola("Copiar lista arreglo1 en arreglo3: "+arr3.copiarLista(arr1)+"\n");
        arr3.imprimir();

        SalidaTerminal.consola("Pruebas de los metodos agregados a la clase ArregloDatos: \n");
        ArregloDatos arrD = new ArregloDatos(5);
        arrD.agregar("J");
        arrD.agregar("A");
        arrD.agregar("F");
        arrD.agregar("H");
        arrD.agregar("X");
        SalidaTerminal.consola("ArregloDatos: \n");
        arrD.imprimir();
        SalidaTerminal.consola("Insertar en indice 3 Ñ: "+arrD.insertar(3,"Ñ")+" \n");
        arrD.imprimir();
        SalidaTerminal.consola("Copiar lista: "+arrD.copiarLista(arr4)+"\n");
        arrD.imprimir();
    }
}
