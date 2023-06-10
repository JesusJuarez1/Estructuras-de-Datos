package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import registros.matematicas.Monomio;
import registros.matematicas.Polinomio;

public class PruebaPolinomio {
    public static void main(String[] args) {
        Polinomio p = new Polinomio();
        p.agregarMonomios();
        p.imprimirPolinomio();
        p.determinarGrado();
        SalidaTerminal.consola("\nGrado: "+p.getGrado()+"\n");
        SalidaTerminal.consola("Ingresa escalar: ");
        int escalar = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Polinomio por escalar: \n");
        p.xEscalar(escalar);
        p.imprimirPolinomio();
        SalidaTerminal.consola("\nPolinomio por monomio: \n");
        p.xMonomio(new Monomio(2,"x",3));
        p.imprimirPolinomio();
        SalidaTerminal.consola("\nPolinomio por polinomio: \n");
        p.xPolinomio(p);
        p.imprimirPolinomio();
        SalidaTerminal.consola("\nPolinomio mas polinomio:\n");
        p.sumaPolinomio(p);
        p.imprimirPolinomio();

    }
}
