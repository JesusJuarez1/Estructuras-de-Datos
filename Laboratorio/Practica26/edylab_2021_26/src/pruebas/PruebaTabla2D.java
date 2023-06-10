package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla2D;
import estructurasnolineales.Tabla3D;
import estructurasnolineales.TipoColumna;
import estructurasnolineales.TipoRenglon;

public class PruebaTabla2D {
    public static void main(String[] args) {
        Tabla2D m = new Tabla2D(3,4,50);
        SalidaTerminal.consola("Obtener "+m.obtenerCelda(1,3));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Cambiar "+m.asignarCelda(2,3,45));
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Imprimir Renglones \n");
        m.imprimirR();
        SalidaTerminal.consola("Imorimir columna \n");
        m.imprimirC();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Traspuesta:  \n");
        m.transpuesta();
        m.imprimirR();
        SalidaTerminal.consola("Rellenar con 99: \n");
        Tabla2D t = new Tabla2D(3,3);
        t.rellenar(99);
        t.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Clonar: \n");
        Tabla2D m2 = m.clonar();
        m2.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Es igual: "+m.esIgual(m2));
        SalidaTerminal.consola("\n");
        Tabla2D m3 = new Tabla2D(3,3,0);
        SalidaTerminal.consola("Vector columna: "+m3.vectorColumna(3,33)+"\n");
        m3.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Vector renglon "+m3.vectorRenglon(3,77)+"\n");
        m3.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Redifinir "+m3.redefinirTabla(t));
        SalidaTerminal.consola("\n");
        m3.imprimirR();
        SalidaTerminal.consola("\n");
        ArregloDatos a = new ArregloDatos(3);
        a.agregar(34);
        a.agregar(24);
        a.agregar(15);
        SalidaTerminal.consola("Agregar renglon "+m3.agregarFila(a));
        SalidaTerminal.consola("\n");
        m3.imprimirR();
        SalidaTerminal.consola("Agregar columna "+m3.agregarColumna(a));
        SalidaTerminal.consola("\n");
        m3.imprimirR();
        SalidaTerminal.consola("Agregar tabla por columna: "+m2.agregarTablaxColumna(m2));
        SalidaTerminal.consola("\n");
        m2.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Agregar tabla por renglon: "+m3.agregarTablaxRenglon(m3));
        SalidaTerminal.consola("\n");
        m3.imprimirR();
        SalidaTerminal.consola("\n");
        Tabla2D m4 = new Tabla2D(3,3,1);
        ArregloDatos a2 = new ArregloDatos(3);
        a2.agregar(new Tabla2D(3,3,2));
        a2.agregar(new Tabla2D(3,3,3));
        a2.agregar(new Tabla2D(3,3,4));
        SalidaTerminal.consola("Sacar matriz 3D: \n");
        Tabla3D m3d = m4.tabla2DaTabla3D(a2);
        m3d.imprimirxColumnas();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Vector columna: \n");
        Tabla2D vectorColumna = m3.aVectorColumna();
        vectorColumna.imprimirR();
        SalidaTerminal.consola("Vector renglon: \n");
        Tabla2D vectorRenglon = m2.aVectorRenglon();
        vectorRenglon.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Eliminar columna derecha: "+m.quitarColumna(TipoColumna.DERECHA));
        SalidaTerminal.consola("\n");
        m.imprimirR();
        SalidaTerminal.consola("Eliminar renglon superior: "+m.quitarFila(TipoRenglon.SUPERIOR));
        SalidaTerminal.consola("\n");
        m.imprimirR();
        SalidaTerminal.consola("Eliminar un renglon: "+m.quitarFila(1)+"\n");
        m.imprimirR();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("Eliminar una columna: "+m.quitarColumna(1)+"\n");
        m.imprimirR();
    }
}
