package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;

public class PruebaArreglo {
    public static void main(String argumentos[]){
        ArregloDatos arreglo=new ArregloDatos(4);

        arreglo.agregar("A");
        arreglo.agregar("B");
        arreglo.agregar("D");
        arreglo.agregar("E");
        arreglo.agregar("H");

        arreglo.imprimir();
        SalidaTerminal.consola("\n");
        arreglo.imprimirOrdenInverso();
        SalidaTerminal.consola("\n");

        arreglo.eliminar("B");
        arreglo.imprimirOrdenInverso();
        SalidaTerminal.consola("\n");

        Integer resultadoB= (Integer)arreglo.buscar("E");
        SalidaTerminal.consola("Posicion de E: "+resultadoB+"\n");

        Integer resultadoB2= (Integer)arreglo.buscar("G");
        SalidaTerminal.consola("Posicion de G: "+resultadoB2+"\n");

        //------------------------------------------------

        ArregloDatos arreglo1= new ArregloDatos(5);
        ArregloDatos arreglo2= new ArregloDatos(5);

        arreglo1.agregar("A");
        arreglo1.agregar("G");
        arreglo1.agregar("D");
        arreglo1.agregar("S");
        arreglo1.agregar("A");
        SalidaTerminal.consola("Arreglo1: \n");
        arreglo1.imprimir();


        arreglo2.agregar("A");
        arreglo2.agregar("G");
        arreglo2.agregar("S");
        arreglo2.agregar("S");
        arreglo2.agregar("r");

        SalidaTerminal.consola("\nArreglo2: \n");
        arreglo2.imprimir();
        SalidaTerminal.consola("\n¿arreglo1 es igual a arreglo2? "+ arreglo1.esIgual(arreglo2));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Buscar en arreglo2 "+arreglo2.obtener(3));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Cambiar A->S en arreglo2 "+arreglo2.cambiar("A","S",1)+"\n");
        arreglo2.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Cambiar G->L en arreglo2 "+arreglo2.cambiar(1,"L")+"\n");
        arreglo2.imprimir();
        SalidaTerminal.consola("\n");
        ArregloDatos arrInd = new ArregloDatos(3);
        arrInd.agregar(0);
        arrInd.agregar(2);
        arrInd.agregar(4);
        ArregloDatos arrEle = new ArregloDatos(3);
        arrEle.agregar("V");
        arrEle.agregar("Z");
        arrEle.agregar("X");
        SalidaTerminal.consola("Cambiar arregloDatos "+arreglo2.cambiarArregloDatos(arrInd,arrEle));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Buscar s");
        ArregloDatos arreglo3 = arreglo2.buscarValores("S");
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Eliminar la primera posicion en arreglo2"+arreglo2.eliminar(0)+"\n");
        SalidaTerminal.consola("\n");
        arreglo2.imprimir();
        SalidaTerminal.consola("Eliminar ultimo dato "+arreglo2.eliminar()+"\n");
        SalidaTerminal.consola("\n");
        arreglo2.imprimir();
        SalidaTerminal.consola("\nVaciar arreglo1");
        arreglo1.vaciar();
        SalidaTerminal.consola("\n");
        arreglo1.imprimir();
        SalidaTerminal.consola("\n");

        ArregloDatos arreglo4= new ArregloDatos(10);
        arreglo4.agregar("A");
        arreglo4.agregar("G");
        arreglo4.agregar("S");
        arreglo4.agregar("S");
        arreglo4.agregar("r");
        SalidaTerminal.consola("Lista 4: \n");
        arreglo4.imprimir();
        SalidaTerminal.consola("\nAgregar lista 2 a arreglo 4"+arreglo4.agregarLista(arreglo2)+"\n");
        arreglo4.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Invertir arreglo 4\n");
        arreglo4.invertir();
        arreglo4.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Contar S en arreglo4: "+arreglo4.contar("S"));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Eliminar arreglo2 de arreglo4 "+arreglo4.eliminarLista(arreglo2)+"\n");
        arreglo4.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Rellenar arreglo4 con 3 A\n");
        arreglo4.rellenar("A",3);
        arreglo4.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Clonar arreglo4 \n");
        ArregloDatos arreglo5 = (ArregloDatos)arreglo4.clonar();
        arreglo5.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Sub lista \n");
        ArregloDatos sublista = (ArregloDatos) arreglo4.subLista(2,5);
        sublista.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Redimencionar arreglo4 a 5 posiciones\n");
        arreglo4.redimensionar(5);
        arreglo4.imprimir();
    }
}
