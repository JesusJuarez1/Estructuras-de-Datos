package pruebas;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import registros.escuela.Alumno;
import registros.escuela.Escuela;

public class PruebaEscuela {
    public static  void  main(String argumentos[]){
        Escuela escuela1=new Escuela("Víctimas del Señor Doctor Profesor Aldonso",10);

        //alumno 1
        ArregloDatos califs1=new ArregloDatos(4);
        califs1.agregar(5.0);
        califs1.agregar(8.0);
        califs1.agregar(10.0);
        califs1.agregar(9.0);
        Alumno alumno1=new Alumno("45654322","Pepe",23,califs1);

        escuela1.agregarAlumno(alumno1);

        //alumno 2
        ArregloDatos califs2=new ArregloDatos(5);
        califs2.agregar(7.0);
        califs2.agregar(8.5);
        califs2.agregar(9.0);
        califs2.agregar(8.0);
        califs2.agregar(9.5);
        Alumno alumno2=new Alumno("98456544","Maria",21,califs2);

        escuela1.agregarAlumno(alumno2);

        //alumno 3
        ArregloDatos califs3=new ArregloDatos(4);
        califs3.agregar(7.5);
        califs3.agregar(5.5);
        califs3.agregar(4.5);
        califs3.agregar(5.4);
        Alumno alumno3=new Alumno("89454321","Rocio",20,califs3);

        escuela1.agregarAlumno(alumno3);

        SalidaTerminal.consola("La escuela: "+ escuela1.getNombre() + " tiene los alumnos: \n");
        escuela1.imprimirAlumnos();
        SalidaTerminal.consola("\n");
        SalidaTerminal.consola("El promedio de 98456544 es: "+escuela1.obtenerPromedio("98456544"));
        SalidaTerminal.consola("\n");


    }
}
