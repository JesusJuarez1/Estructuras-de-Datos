package estructuraslineales;

public class ListaPila implements LoteDatos {
    protected ListaEncadenada pila;

    public ListaPila(){
        pila=new ListaEncadenada();
    }

    @Override
    public boolean vacio(){
        return pila.vacia();
    }

    @Override
    public boolean lleno(){
        return false;
    }

    @Override
    public boolean poner(Object info){
        int retorno=pila.agregar(info);
        if(retorno==-1){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object quitar(){
        return pila.eliminar();
    }

    @Override
    public void imprimir(){
        pila.imprimir();
    }

    @Override
    public Object verTope(){
        return pila.regresarFin();
    }
}
