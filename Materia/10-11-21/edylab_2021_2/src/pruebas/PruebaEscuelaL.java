package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenada;
import registros.escuela.AlumnoL;
import registros.escuela.EscuelaL;

public class PruebaEscuelaL {
    public static  void  main(String argumentos[]){
        EscuelaL escuela1=new EscuelaL("Víctimas del Señor Doctor Profesor Aldonso");

        //alumno 1
        ListaEncadenada califs1=new ListaEncadenada();
        califs1.agregar(5.0);
        califs1.agregar(8.0);
        califs1.agregar(10.0);
        califs1.agregar(9.0);
        AlumnoL alumno1=new AlumnoL("45654322","Pepe",23,califs1);

        escuela1.agregarAlumno(alumno1);

        //alumno 2
        ListaEncadenada califs2=new ListaEncadenada();
        califs2.agregar(7.0);
        califs2.agregar(8.5);
        califs2.agregar(9.0);
        califs2.agregar(8.0);
        califs2.agregar(9.5);
        AlumnoL alumno2=new AlumnoL("98456544","Maria",21,califs2);

        escuela1.agregarAlumno(alumno2);

        //alumno 3
        ListaEncadenada califs3=new ListaEncadenada();
        califs3.agregar(7.5);
        califs3.agregar(5.5);
        califs3.agregar(4.5);
        califs3.agregar(5.4);
        AlumnoL alumno3=new AlumnoL("89454321","Rocio",20,califs3);

        escuela1.agregarAlumno(alumno3);

        SalidaTerminal.consola("La escuela: "+ escuela1.getNombre() + " tiene los alumnos: \n");
        escuela1.imprimirAlumnos();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("El promedio de 98456544 es: "+
                escuela1.obtenerPromedio("98456544"));
        SalidaTerminal.consola("\n");

        //--
        SalidaTerminal.consola("La escuela: "+ escuela1.getNombre() + " tiene los alumnos: \n");
        escuela1.imprimirDatosAlumnos();
        SalidaTerminal.consola("\n");
    }
}
