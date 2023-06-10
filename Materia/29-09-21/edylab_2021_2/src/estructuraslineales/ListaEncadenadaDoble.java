package estructuraslineales;

import estructuraslineales.registros.Nodo;
import estructuraslineales.registros.NodoDoble;

public class ListaEncadenadaDoble implements ListaDatos{
    protected NodoDoble frente;
    protected NodoDoble fin;

    public ListaEncadenadaDoble(){
        frente=null;
        fin=null;
    }

    public boolean vacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }

    public int agregar(Object elemento){
        NodoDoble nuevoNodo=new NodoDoble(elemento); //1
        if(nuevoNodo==null){ //esta lleno
            return -1;
        }else{ //no esta lleno
            if(vacia()==true){ //a, vacia
                frente=nuevoNodo; //2
                fin=nuevoNodo;
            }else{ //hay varios, b
                fin.setDirMemDer(nuevoNodo);//2
                nuevoNodo.setDirMemIzq(fin);//3
                fin=nuevoNodo;//4
            }
            return 1;
        }
    }

    public void imprimir(){

    }

    public void imprimirOrdenInverso(){

    }

    public Object buscar(Object elemento){
        return null;
    }

    public Object eliminar(Object elemento){
        return null;
    }

    public Object eliminar(){
        if(vacia()==true){ //no hay nada, a
            return null;
        }else{ //si hay algo
            Object elementoBorrado=fin.getDato();//1
            if(frente==fin){ //b, unico
                frente=null; //2
                fin=null;
            }else{ //c, har varios
                fin=fin.getDirMemIzq();//2
                fin.setDirMemDer(null);//3
            }
            return elementoBorrado;
        }
    }
}
