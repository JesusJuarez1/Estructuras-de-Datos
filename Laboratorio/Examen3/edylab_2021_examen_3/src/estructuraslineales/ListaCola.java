package estructuraslineales;

public class ListaCola implements LoteDatos{
    protected ListaEncadenada cola;

    public ListaCola(){
        cola = new ListaEncadenada();
    }

    @Override
    public boolean vacio() {
        return cola.vacia();
    }

    @Override
    public boolean lleno() {
        return false;
    }

    @Override
    public boolean poner(Object elemento) {
        int retorno = cola.agregar(elemento);
        if(retorno == -1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object quitar() {
        return cola.eliminarInicio();
    }

    @Override
    public void imprimir() {
        cola.imprimir();
    }

    @Override
    public Object verTope() {
        return cola.frente;
    }
}
