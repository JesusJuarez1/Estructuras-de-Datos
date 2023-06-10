package registros.escuela;

import estructuraslineales.ArregloDatos;

public class Escuela {
    protected String nombre;
    protected ArregloDatos alumnos;

    public Escuela(String nombre, int numAlumnosMaximos){
        this.nombre=nombre;
        alumnos=new ArregloDatos(numAlumnosMaximos);
    }

    public boolean agregarAlumno(Alumno alumno){
        int valorRetorno=alumnos.agregar(alumno);
        if(valorRetorno==-1){ //hubo algún error
            return false;
        }else{
            return true;
        }
    }

    public void imprimirAlumnos(){
        alumnos.imprimirOrdenInverso();
    }

    public Double obtenerPromedio(String matricula){
        //Necesitamos saber cual alumno
        Integer posicion=(Integer)alumnos.buscar(matricula);

        if(posicion==null){ //no existe ese alumno
            return null;
        }else{ //si esta el alumno
            Alumno alumnoElegido= (Alumno)alumnos.obtener(posicion);
            return alumnoElegido.sacarPromedioCalifs();
        }
    }

    public String getNombre() {
        return nombre;
    }
}
