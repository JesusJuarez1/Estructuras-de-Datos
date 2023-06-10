package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloNumeros;
import estructurasnolineales.Tabla2DNumeros;
import estructurasnolineales.TipoLogaritmo;

public class PruebaTabla2DNumeros {
    public static void main(String[] args) {
        Tabla2DNumeros t1 = new Tabla2DNumeros(3,4,5.0);
        SalidaTerminal.consola("Por escalar (7): "+t1.xEscalar(7.0)+"\n");
        t1.imprimirR();
        ArregloNumeros an = new ArregloNumeros(3);
        an.agregar(4.0);
        an.agregar(3.0);
        an.agregar(2.0);
        SalidaTerminal.consola("Por escalares: "+t1.xEscalares(an)+"\n");
        t1.imprimirR();
        SalidaTerminal.consola("Sumar escalar (9): "+t1.sumarEscalar(9.0)+"\n");
        t1.imprimirR();
        SalidaTerminal.consola("Sumar escalares: "+t1.sumarEscalares(an)+"\n");
        t1.imprimirR();
        Tabla2DNumeros t2 = new Tabla2DNumeros(4,3,2.0);
        SalidaTerminal.consola("Multiplicar tablas: "+t1.multiplicar(t2)+"\n");
        t1.imprimirR();
        SalidaTerminal.consola("Sumar tablas: "+t1.sumar(t2)+"\n");
        t1.imprimirR();
        SalidaTerminal.consola("Potencia ExE (3): "+t1.potenciaExE(3.0)+"\n");
        t1.imprimirR();
        Tabla2DNumeros t3 = new Tabla2DNumeros(3,3,3.0);
        Tabla2DNumeros t4 = new Tabla2DNumeros(3,3,3.0);
        Tabla2DNumeros t5 = new Tabla2DNumeros(3,3,3.0);
        SalidaTerminal.consola("Logaritmo natural: "+t3.logaritmo(TipoLogaritmo.NATURAL)+"\n");
        t3.imprimirR();
        SalidaTerminal.consola("Logaritmo base 10: "+t4.logaritmo(TipoLogaritmo.BASE10)+"\n");
        t4.imprimirR();
        SalidaTerminal.consola("Logaritmo base 2: "+t5.logaritmo(TipoLogaritmo.BASE2)+"\n");
        t5.imprimirR();
        Tabla2DNumeros t6 = new Tabla2DNumeros(3,3,0.0);
        SalidaTerminal.consola("Matriz diagonal (9): "+t6.matrizDiagonal(9.0)+"\n");
        t6.imprimirR();
        SalidaTerminal.consola("Es diagonal superior?: "+t6.esDiagonalSup()+"\n");
        SalidaTerminal.consola("Es diagonal inferior?: "+t6.esDiagonalInf()+"\n");
        t2 = new Tabla2DNumeros(3,3,2.0);
        SalidaTerminal.consola("Potencia: "+t2.potencia(3)+"\n");
        t2.imprimirR();
        Tabla2DNumeros t7 = new Tabla2DNumeros(8,9,5.0);

        t7.imprimirR();
        SalidaTerminal.consola("Doblar filas: "+t7.doblarFilas()+"\n");
        t7.imprimirR();
        SalidaTerminal.consola("Doblar columnas: "+t7.doblarColumnas()+"\n");
        t7.imprimirR();

    }
}
