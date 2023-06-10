package estructuraslineales.registros;

public class Nodo {
    protected Object dato;
    protected Nodo dirMemDer;

    public Nodo(Object dato){
        this.dato=dato;
        dirMemDer=null;
    }

    public Object getDato() {
        return dato;
    }

    public Nodo getDirMemDer() {
        return dirMemDer;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setDirMemDer(Nodo dirMemDer) {
        this.dirMemDer = dirMemDer;
    }

    @Override
    public String toString(){
        return dato.toString();
    }
}
