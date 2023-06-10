package registros.escuela;

import entradasalida.SalidaTerminal;
import estructuraslineales.ListaEncadenada;

public class EscuelaL {
    protected String nombre;
    protected ListaEncadenada alumnos;

    public EscuelaL(String nombre){
        this.nombre=nombre;
        alumnos=new ListaEncadenada();
    }

    public boolean agregarAlumno(AlumnoL alumno){
        int valorRetorno=alumnos.agregar(alumno);
        if(valorRetorno==-1){ //hubo algún error
            return false;
        }else{
            return true;
        }
    }

    public void imprimirAlumnos(){
        alumnos.imprimir();
    }

    public void imprimirDatosAlumnos(){
        //iterador de lista de alumnos
        alumnos.inicializarIterador();

        while(alumnos.hayElementos()==true){
            AlumnoL alumnoTemporal=(AlumnoL)alumnos.obtenerElemento();
            SalidaTerminal.consola(alumnoTemporal.getNombre() +", "+ alumnoTemporal.matricula+ ", "+
                    alumnoTemporal.edad + ", ");
            alumnoTemporal.imprimirCalificaciones();
            SalidaTerminal.consola("\n");
        }
    }


    public Double obtenerPromedio(String matricula){
        //Necesitamos saber cual alumno
        AlumnoL alumnoBuscado=(AlumnoL)alumnos.buscar(matricula);

        if(alumnoBuscado==null){ //no existe ese alumno
            return null;
        }else{ //si esta el alumno
            return alumnoBuscado.sacarPromedioCalifs();
        }
    }

    public String getNombre() {
        return nombre;
    }
}
