package pruebas;

import entradasalida.SalidaTerminal;
import estructurasnolineales.ABB;

public class PruebaABB {
    public static  void main(String[] argumentos){
        /*ABB arbol=new ABB();

        arbol.agregar(5);
        arbol.agregar(3);
        arbol.agregar(9);
        arbol.agregar(12);
        arbol.agregar(15);
        arbol.agregar(1);
        arbol.agregar(2);
        arbol.agregar(4);
        arbol.agregar(14);
        arbol.agregar(3);
        arbol.agregar(8);
        arbol.agregar(6);

        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("InOrden: ");
        arbol.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol.postOrden();

        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Buscando a 14: "+ arbol.buscar(14)+ "\n");
        SalidaTerminal.consola("Buscando a 29: "+ arbol.buscar(29)+ "\n");
         */


        SalidaTerminal.consola("Caso 1:");
        ABB arbol1 = new ABB();
        arbol1.agregar(10);
        arbol1.agregar(5);
        arbol1.agregar(15);
        arbol1.agregar(2);
        arbol1.agregar(6);
        arbol1.agregar(14);
        arbol1.agregar(17);
        SalidaTerminal.consola("\nInOrden: ");
        arbol1.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol1.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol1.postOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("\nEliminar 6: "+arbol1.eliminar(6)+"\n");
        SalidaTerminal.consola("InOrden: ");
        arbol1.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol1.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol1.postOrden();


        SalidaTerminal.consola("\n\nCaso 2: ");
        ABB arbol2 = new ABB();
        arbol2.agregar(4);
        arbol2.agregar(2);
        arbol2.agregar(6);
        arbol2.agregar(1);
        arbol2.agregar(5);
        arbol2.agregar(7);
        SalidaTerminal.consola("\nInOrden: ");
        arbol2.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol2.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol2.postOrden();

        SalidaTerminal.consola("\n\nEliminar 2: "+arbol2.eliminar(2)+"\n");
        SalidaTerminal.consola("InOrden: ");
        arbol2.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol2.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol2.postOrden();

        SalidaTerminal.consola("\n\nCaso 3: ");
        ABB arbol3 = new ABB();
        arbol3.agregar(16);
        arbol3.agregar(8);
        arbol3.agregar(24);
        arbol3.agregar(3);
        arbol3.agregar(11);
        arbol3.agregar(20);
        arbol3.agregar(30);
        arbol3.agregar(1);
        arbol3.agregar(7);
        arbol3.agregar(9);
        arbol3.agregar(13);
        arbol3.agregar(19);
        arbol3.agregar(21);
        arbol3.agregar(28);
        arbol3.agregar(33);
        SalidaTerminal.consola("\nInOrden: ");
        arbol3.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol3.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol3.postOrden();

        SalidaTerminal.consola("\n\nEliminar 24: "+arbol3.eliminar(24)+"\n");
        SalidaTerminal.consola("InOrden: ");
        arbol3.inOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("PreOrden: ");
        arbol3.preOrden();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Postorden: ");
        arbol3.postOrden();
    }
}