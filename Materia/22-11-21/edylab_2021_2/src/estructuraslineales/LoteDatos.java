package estructuraslineales;

public interface LoteDatos {
    public boolean vacio();

    public boolean lleno();

    public boolean poner(Object elemento);

    public Object quitar();

    public void imprimir();

    public Object verTope();
}
