package registros.productos;

public class Campesino {
    protected String clave;
    protected String nombre;
    protected int edad;

    public Campesino(String clave, String nombre, int edad){
        this.clave=clave;
        this.nombre=nombre;
        this.edad=edad;
    }

    @Override
    public String toString(){
        return clave;
    }

    public String datosGenerales(){
        return "Clave: " + clave + "\n"+ "Nombre: "+ nombre + "\n" + "Edad: "+ edad;
    }
}
