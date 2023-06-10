package estructuraslineales;

public interface VectorDatos extends ListaDatos{

    public boolean lleno();

    public int capacidad();

    public int cantidadElementos();

    public Object obtener(int indice);

    public Object verTope();
}
