package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ListaCola;
import estructuraslineales.ListaPila;
import estructuraslineales.Monticulo;
import estructuraslineales.TipoOrden;
import herramientas.texto.Balanceo;
import registros.proceso.Proceso;

public class PruebaListaPilaCola {
    public static void main(String[] args) {
        SalidaTerminal.consola("PRUEBA LISTA PILA:\n");
        ListaPila pila =new ListaPila();

        pila.poner("V");
        pila.poner("H");
        pila.poner("F");
        pila.poner("D");
        pila.poner("S");
        pila.imprimir();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Sacando de pila: "+ pila.quitar());
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Ver tope: "+pila.verTope()+"\n");
        pila.imprimir();

        SalidaTerminal.consola("\n----------------------------\n" +
                "PRUEBA LISTA COLA:\n");

        ListaCola cola= new ListaCola();

        cola.poner("R");
        cola.poner("G");
        cola.poner("D");
        cola.poner("S");
        cola.poner("X");


        cola.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("Eliminando: "+cola.quitar()+ "\n");
        SalidaTerminal.consola("Eliminando: "+cola.quitar()+ "\n");
        SalidaTerminal.consola("Ver tope: "+cola.verTope()+ "\n");

        cola.imprimir();
        SalidaTerminal.consola("\n");

        cola.poner("F");
        cola.poner("D");

        cola.imprimir();
        SalidaTerminal.consola("\n");

        SalidaTerminal.consola("\n---------------------------\n" +
                "PRUEBA ACTIVIDAD 4:\n");

        SalidaTerminal.consola("Prueba balanceo de parentesis: "+
                Balanceo.estaBalanceadoParentesis("90 + h * (h - 2) + ((a / b) – c)")+"\n");

        SalidaTerminal.consola("Ingresa el numero de procesos a ingresar: ");
        int n = EntradaTerminal.consolaInteger();
        Monticulo m = new Monticulo(TipoOrden.ASCENDENTE,n);
        //Para que el programa sea mucho mas eficiente a la hora de usarlo, los valores de los procesos seran indicados por
        // p(nombre), c(comando), a(archvio),r(ruta) y p(propietario)
        for(int i=0;i<n;i++){
            m.poner(new Proceso("p"+(i+1),"c"+(i+1),"a"+(i+1),"r"+(i+1),"p"+(i+1)));
        }
        ListaCola cola1 = new ListaCola();
        while(!m.vacio()){
            cola1.poner(m.quitar());
        }

        cola1.imprimir();
    }
}
