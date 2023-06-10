package registros.escuela;

import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructuraslineales.ListaEncadenada;

public class AlumnoL {
    protected String matricula;
    protected String nombre;
    protected int edad;
    protected ListaEncadenada calificaciones;

    public AlumnoL(String matricula, String nombre, int edad, ListaEncadenada calificaciones){
        this.matricula=matricula;
        this.nombre=nombre;
        this.edad=edad;
        this.calificaciones=calificaciones;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public ListaEncadenada getCalificaciones() {
        return calificaciones;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCalificaciones(ListaEncadenada calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Double sacarPromedioCalifs(){
        double sumaCalifs=0.0;
        double promedioCalifs=0.0;
        int numCalificaciones=0;

        calificaciones.inicializarIterador();
        if(calificaciones.hayElementos()==false){ //no hay elementos
            return null;
        }
        while(calificaciones.hayElementos()==true) {
            sumaCalifs= sumaCalifs + (double)calificaciones.obtenerElemento();
            numCalificaciones++;
        }
        //por lo menos hubo algún elemento
        promedioCalifs = sumaCalifs / numCalificaciones;
        return promedioCalifs;
    }

    public void imprimirCalificaciones(){
        int contadorC=0;
        SalidaTerminal.consola("Listado de calificaciones parciales: ");
        calificaciones.inicializarIterador();
        while(calificaciones.hayElementos()==true){
            double califTemporal=(double)calificaciones.obtenerElemento();
            SalidaTerminal.consola("parcial (" + (++contadorC)+ ") "+califTemporal+ ", ");
            //parcial (1) 9.5, parcial (2) 4.5, parcial (3) 9.4 ...
        }
    }

    @Override
    public String toString(){
        return matricula;
    }
}
