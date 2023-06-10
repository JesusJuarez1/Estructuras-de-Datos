package registros;

public class Vertice {
    protected int indice;
    protected Object descripcion;

    public int getIndice() {
        return indice;
    }

    public Object getDescripcion() {
        return descripcion;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public void setDescripcion(Object descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString(){
        return descripcion.toString();
    }

    public String obtenerDatos(){
        return descripcion + "(" + indice+ ")";
    }
}
