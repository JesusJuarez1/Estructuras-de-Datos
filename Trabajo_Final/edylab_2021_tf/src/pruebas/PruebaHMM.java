package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla2D;
import estructurasnolineales.Tabla2DNumeros;
import herramientas.comunes.Herramientas;
import registros.mom.HMM;

public class PruebaHMM {
    public static void main(String[] args) {
        ArregloDatos estados = new ArregloDatos(3);// 3 estados (Urna 1, Urna 2, Urna 3)
        estados.agregar("Urna 1");
        estados.agregar("Urna 2");
        estados.agregar("Urna 3");

        ArregloDatos observaciones = new ArregloDatos(3);// 3 observaciones (Negro,Verde, Rojo)
        observaciones.agregar("Negro");
        observaciones.agregar("Verde");
        observaciones.agregar("Rojo");
        // 3 estados, 3 probabilidades iniciales
        ArregloDatos probabilidadInicial = new ArregloDatos(3); // {"Urna 1" .3, "Urna 2" .1, "Urna 3".6}
        probabilidadInicial.agregar(.3);
        probabilidadInicial.agregar(.5);
        probabilidadInicial.agregar(.2);

        Tabla2DNumeros probabilidadTransicion = new Tabla2DNumeros(3, 3);// 3 probabilidades de transicion para cada estado
        probabilidadTransicion.asignarCelda(0, 0, .2);//urna 1 a urna 1
        probabilidadTransicion.asignarCelda(0, 1, .5);//urna 1 a urna 2
        probabilidadTransicion.asignarCelda(0, 2, .3);//urna 1 a urna 3
        probabilidadTransicion.asignarCelda(1, 0, .3);//urna 2 a urna 1
        probabilidadTransicion.asignarCelda(1, 1, .2);//urna 2 a urna 2
        probabilidadTransicion.asignarCelda(1, 2, .5);//urna 2 a urna 3
        probabilidadTransicion.asignarCelda(2, 0, .5);//urna 3 a urna 1
        probabilidadTransicion.asignarCelda(2, 1, .3);//urna 3 a urna 2
        probabilidadTransicion.asignarCelda(2, 2, .2);//urna 3 a urna 3

        Tabla2DNumeros probabilidadEmision = new Tabla2DNumeros(3, 3);//3 estados - 3 observaciones
        probabilidadEmision.asignarCelda(0, 0, .3);// Urna 1 - negro
        probabilidadEmision.asignarCelda(0, 1, .5);// Urna 1 - verde
        probabilidadEmision.asignarCelda(0, 2, .2);// Urna 1 - rojo
        probabilidadEmision.asignarCelda(1, 0, .2);// Urna 2 - negro
        probabilidadEmision.asignarCelda(1, 1, .3);// Urna 2 - verde
        probabilidadEmision.asignarCelda(1, 2, .5);// Urna 2 - rojo
        probabilidadEmision.asignarCelda(2, 0, .6);// Urna 3 - negro
        probabilidadEmision.asignarCelda(2, 1, .2);// Urna 3 - verde
        probabilidadEmision.asignarCelda(2, 2, .2);// Urna 3 - rojo

        HMM hmm = new HMM(estados, observaciones, probabilidadInicial, probabilidadTransicion, probabilidadEmision);

        SalidaTerminal.consola("• Probabilidad de que inicie en una Urna en particular:\n");
        SalidaTerminal.consola("\tCual es la probabilidad de iniciar en Urna 1: " + hmm.probabilidadIniciar("Urna 1") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de iniciar en Urna 2: " + hmm.probabilidadIniciar("Urna 2") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de iniciar en Urna 3: " + hmm.probabilidadIniciar("Urna 3") + "%\n");

        SalidaTerminal.consola("• Probabilidad de que saque una bola de un color específico:\n");
        SalidaTerminal.consola("\tCual es la probabilidad de sacar Negro: \n");
        SalidaTerminal.consola("\t\tUrna 1: " + hmm.probabilidadObtener("Urna 1", "Negro") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2: " + hmm.probabilidadObtener("Urna 2", "Negro") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3: " + hmm.probabilidadObtener("Urna 3", "Negro") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de sacar Verde: \n");
        SalidaTerminal.consola("\t\tUrna 1: " + hmm.probabilidadObtener("Urna 1", "Verde") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2: " + hmm.probabilidadObtener("Urna 2", "Verde") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3: " + hmm.probabilidadObtener("Urna 3", "Verde") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de sacar Rojo: \n");
        SalidaTerminal.consola("\t\tUrna 1: " + hmm.probabilidadObtener("Urna 1", "Rojo") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2: " + hmm.probabilidadObtener("Urna 2", "Rojo") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3: " + hmm.probabilidadObtener("Urna 3", "Rojo") + "%\n");

        SalidaTerminal.consola("• Probabilidad de cambiar de Urna: \n");
        SalidaTerminal.consola("\tCual es la probabilidad de Cambiar a Urna 1:\n");
        SalidaTerminal.consola("\t\tUrna 1 a Urna 1: " + hmm.probabilidadCambiar("Urna 1", "Urna 1") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2 a Urna 1: " + hmm.probabilidadCambiar("Urna 2", "Urna 1") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3 a Urna 1: " + hmm.probabilidadCambiar("Urna 3", "Urna 1") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de Cambiar a Urna 2:\n");
        SalidaTerminal.consola("\t\tUrna 1 a Urna 2: " + hmm.probabilidadCambiar("Urna 1", "Urna 2") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2 a Urna 2: " + hmm.probabilidadCambiar("Urna 2", "Urna 2") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3 a Urna 2: " + hmm.probabilidadCambiar("Urna 3", "Urna 2") + "%\n");
        SalidaTerminal.consola("\tCual es la probabilidad de Cambiar a Urna 3:\n");
        SalidaTerminal.consola("\t\tUrna 1 a Urna 3: " + hmm.probabilidadCambiar("Urna 1", "Urna 3") + "%\n");
        SalidaTerminal.consola("\t\tUrna 2 a Urna 3: " + hmm.probabilidadCambiar("Urna 2", "Urna 3") + "%\n");
        SalidaTerminal.consola("\t\tUrna 3 a Urna 3: " + hmm.probabilidadCambiar("Urna 3", "Urna 3") + "%\n");

        ArregloDatos secuencia = new ArregloDatos(6);
        secuencia.agregar("Urna 2");
        secuencia.agregar("Urna 1");
        secuencia.agregar("Urna 2");
        secuencia.agregar("Urna 1");
        secuencia.agregar("Urna 3");
        secuencia.agregar("Urna 3");
        //Cada que se ejecuta da un resultado diferente debido al esto inicial en el que comienza
        SalidaTerminal.consola("Probabilidad de obtener la siguiente secuencia:\n");
        secuencia.imprimir();
        SalidaTerminal.consola(hmm.probabilidadObtenerSecuenciaEstados(secuencia)+"%\n");
        ArregloDatos secuencia2 = new ArregloDatos(6);
        secuencia2.agregar("Rojo");
        secuencia2.agregar("Verde");
        secuencia2.agregar("Verde");
        secuencia2.agregar("Negro");
        secuencia2.agregar("Rojo");
        secuencia2.agregar("Negro");
        SalidaTerminal.consola("Probabilidad de obtener la siguiente secuencia: \n");
        secuencia2.imprimir();
        SalidaTerminal.consola(hmm.probabilidadObtenerSecuenciaObservaciones(secuencia2)+"%");
        /*
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola(Herramientas.obtenerAleatorioProbabildad(estados,probabilidadInicial)+"");
         */
    }
}
