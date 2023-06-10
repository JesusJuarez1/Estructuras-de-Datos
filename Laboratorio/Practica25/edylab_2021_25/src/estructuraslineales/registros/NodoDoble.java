package estructuraslineales.registros;

public class NodoDoble {
    protected NodoDoble dirMemIzq;
    protected Object dato;
    protected NodoDoble dirMemDer;

    public NodoDoble(Object dato){
        this.dato=dato;
        dirMemIzq=null;
        dirMemDer=null;
    }

    public NodoDoble getDirMemIzq() {
        return dirMemIzq;
    }

    public Object getDato() {
        return dato;
    }

    public NodoDoble getDirMemDer() {
        return dirMemDer;
    }

    public void setDirMemIzq(NodoDoble dirMemIzq) {
        this.dirMemIzq = dirMemIzq;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setDirMemDer(NodoDoble dirMemDer) {
        this.dirMemDer = dirMemDer;
    }

    @Override
    public String toString(){
        return dato.toString();
    }
}
