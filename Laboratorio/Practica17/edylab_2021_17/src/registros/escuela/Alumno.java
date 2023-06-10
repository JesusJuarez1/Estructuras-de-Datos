package registros.escuela;

import estructuraslineales.ArregloDatos;

public class Alumno {
    protected String matricula;
    protected String nombre;
    protected int edad;
    protected ArregloDatos calificaciones;

    public Alumno(String matricula, String nombre, int edad, ArregloDatos calificaciones){
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

    public ArregloDatos getCalificaciones() {
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

    public void setCalificaciones(ArregloDatos calificaciones) {
        this.calificaciones = calificaciones;
    }

    public Double sacarPromedioCalifs(){
        double sumaCalifs=0.0;
        double promedioCalifs=0.0;

        if (calificaciones.vacia()==false) {  //si hay calificaciones agregadas
            for (int posicion = 0; posicion<calificaciones.cantidadElementos();posicion++) {
                sumaCalifs= sumaCalifs + (double)calificaciones.obtener(posicion);
            }
            promedioCalifs=sumaCalifs / calificaciones.cantidadElementos();
            return promedioCalifs;
        }else{ //no hay calificaciones agregadas
            return null;
        }
    }

    @Override
    public String toString(){
        return matricula;
    }
}
