package pruebas;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import herramientas.matematicas.Matematicas;

public class PruebaMatematicas {
    public static void main(String[] args) {
        SalidaTerminal.consola("Introduce un numero a multiplicar: ");
        double num1 = EntradaTerminal.consolaDouble();
        SalidaTerminal.consola("Introduce un numero por el cual se va multiplicar ("+num1+"): ");
        int num2 = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola(Matematicas.multiplicacion(num1,num2)+"\n");

        SalidaTerminal.consola("Ingresa X: ");
        double x = EntradaTerminal.consolaDouble();
        SalidaTerminal.consola("Ingresa N: ");
        int n = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Ingresa M: ");
        double m = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Resultado de la serie: "+Matematicas.serie(x,n,m)+"\n");

        SalidaTerminal.consola("Introduce el numero a convertir a hexadecimal: ");
        n = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Decimal a Hexadecimal (Base 16): "+Matematicas.aHexadecimal(n)+"\n");

        SalidaTerminal.consola("Introduce el numero a convertir a hexadecimal: ");
        n = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Introduce la base a la que se va a convertir el numero: ");
        int b = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Decimal a Hexadecimal (Base "+b+"): "+Matematicas.aHexadecimal(n,b)+"\n");

        SalidaTerminal.consola("Introduce el primer numero para sacar el maximo comun divisor: ");
        int n1 = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Ingresa el segundo numero para sacar el maximo comun divisor: ");
        int n2 = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Maximo comun divisor: "+Matematicas.euclides(n1,n2)+"\n");

        SalidaTerminal.consola("Introduce le numero a convertir a binario: ");
        n = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola(""+Matematicas.aBinario(n));
    }
}
