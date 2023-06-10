package estructuraslineales;

public class ArregloPila implements LoteDatos{
    protected ArregloDatos pila;

    public ArregloPila(int capacidad){
        pila=new ArregloDatos(capacidad);
    }

    @Override
    public boolean vacio(){
        return pila.vacia();
    }

    @Override
    public boolean lleno(){
        return pila.lleno();
    }

    @Override
    public boolean poner(Object elemento){
        int valorRetorno=pila.agregar(elemento);
        if(valorRetorno>=0) {
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Object quitar(){
        return pila.eliminar();
    }

    @Override
    public void imprimir(){
        pila.imprimirOrdenInverso();
    }

    @Override
    public Object verTope(){
        return pila.verTope();
    }
}
