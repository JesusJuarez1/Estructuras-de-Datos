package estructuraslineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.Nodo;
import estructuraslineales.registros.NodoHash;
import estructurasnolineales.Tabla2D;
import herramientas.comunes.Herramientas;

public class ListaEncadenadaHash implements IListaHash{
    protected NodoHash frente;
    protected NodoHash fin;

    public ListaEncadenadaHash(){
        frente = null;
        fin = null;
    }

    @Override
    public boolean vacia(){
        if (frente == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insertar(Object clave,Object valor){
        NodoHash nuevoNodo = new NodoHash(clave,valor);
        if(nuevoNodo != null){
            if(vacia()){
                frente = nuevoNodo;
                fin = frente;
            }else{
                NodoHash tmp = frente;
                while(tmp != null){
                    if(Herramientas.compararObjetos(tmp.getClave(),clave) == 0){
                        tmp.setValor(valor);
                        return true;
                    }
                    tmp = tmp.getDirMemDer();
                }
                fin.setDirMemDer(nuevoNodo);
                fin = nuevoNodo;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object eliminar(Object clave) {
        if (!vacia()) {
            Object elementoBorrado = null;
            if (frente == fin) {
                if (Herramientas.compararObjetos(frente.getClave(),clave) == 0) {
                    elementoBorrado = frente.getValor();
                    frente = null;
                    fin = null;
                } else {
                    return null;
                }
            } else if (Herramientas.compararObjetos(frente.getClave(),clave) == 0) {
                elementoBorrado = frente.getValor();
                frente = frente.getDirMemDer();
            } else if (Herramientas.compararObjetos(fin.getClave(),clave) == 0) {
                elementoBorrado = fin.getValor();
                NodoHash penultimo = frente;
                while (penultimo.getDirMemDer() != fin) {
                    penultimo = penultimo.getDirMemDer();
                }
                fin = penultimo;
                fin.setDirMemDer(null);
            } else {
                NodoHash tmp = frente;
                while (tmp != null) {
                    if (Herramientas.compararObjetos(tmp.getDirMemDer().getClave(),clave) == 0){
                        elementoBorrado = tmp.getDirMemDer().getValor();
                        tmp.setDirMemDer(tmp.getDirMemDer().getDirMemDer());
                        return elementoBorrado;
                    }
                    tmp = tmp.getDirMemDer();
                }
            }
            return elementoBorrado;
        } else {
            return null;
        }
    }

    @Override
    public Object eliminarValor(Object valor){
        if(!vacia()){
            Object elementoBorrado = null;
            if(frente == fin){
                if(Herramientas.compararObjetos(frente.getValor(),valor) == 0){
                    elementoBorrado = frente.getValor();
                    frente = null;
                    fin = null;
                }else{
                    return null;
                }
            }else if(Herramientas.compararObjetos(frente.getValor(),valor) == 0) {
                elementoBorrado = frente.getValor();
                frente = frente.getDirMemDer();
            }else if(Herramientas.compararObjetos(fin.getValor(),valor) == 0) {
                elementoBorrado = fin.getValor();
                NodoHash penultimo = frente;
                while (penultimo.getDirMemDer() != fin) {
                    penultimo = penultimo.getDirMemDer();
                }
                fin = penultimo;
                fin.setDirMemDer(null);
            }else{
                NodoHash tmp = frente;
                while(tmp != null){
                    if(tmp.getDirMemDer() != null) {
                        if (Herramientas.compararObjetos(tmp.getDirMemDer().getValor(), valor) == 0) {
                            elementoBorrado = tmp.getDirMemDer().getValor();
                            tmp.setDirMemDer(tmp.getDirMemDer().getDirMemDer());
                            return elementoBorrado;
                        }
                    }else{
                        break;
                    }
                    tmp = tmp.getDirMemDer();
                }
            }
            return elementoBorrado;
        }else{
            return null;
        }
    }

    @Override
    public Object buscar(Object clave){
        if(!vacia()){
            NodoHash tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getClave(),clave) == 0){
                    return tmp.getValor();
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public Object buscarValor(Object valor){
        if(!vacia()){
            NodoHash tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getValor(),valor) == 0){
                    return tmp.getValor();
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public boolean substituir(Object clave, Object valorNuevo){
        if(!vacia()){
            NodoHash tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getClave(),clave)==0){
                    tmp.setValor(valorNuevo);
                    return true;
                }
                tmp = tmp.getDirMemDer();
            }
            return false;
        }else{
            return false;
        }
    }

    @Override
    public boolean substituirValor(Object valor, Object valorNuevo){
        if(!vacia()){
            NodoHash tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getValor(),valor) == 0){
                    tmp.setValor(valorNuevo);
                    return true;
                }
                tmp = tmp.getDirMemDer();
            }
            return false;
        }else{
            return false;
        }
    }

    @Override
    public void imprimir(){
        NodoHash temp=frente;
        while (temp!=null){
            SalidaTerminal.consola(temp.getClave().toString()+"-"+temp.getValor().toString()+" -> ");
            temp=temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
    }

    @Override
    public void imprimirClaves(){
        NodoHash temp=frente;
        while (temp!=null){
            SalidaTerminal.consola(temp.getClave().toString()+" -> ");
            temp=temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
    }

    @Override
    public void imprimirValores(){
        NodoHash temp=frente;
        while (temp!=null){
            SalidaTerminal.consola(temp.getValor().toString()+" -> ");
            temp=temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
    }

    @Override
    public ListaEncadenada aArreglos(){
        if(!vacia()){
            ListaEncadenada lista = new ListaEncadenada();
            NodoHash tmp = frente;
            int lon = cantidadElementos();
            ArregloDatos claves = new ArregloDatos(lon);
            ArregloDatos valores = new ArregloDatos(lon);
            while(tmp != null){
                claves.agregar(tmp.getClave());
                valores.agregar(tmp.getValor());
                tmp = tmp.getDirMemDer();
            }
            lista.agregar(claves);
            lista.agregar(valores);
            return lista;
        }else{
            return null;
        }
    }

    @Override
    public ListaEncadenada aListas(){
        if(!vacia()){
            ListaEncadenada lista = new ListaEncadenada();
            ListaEncadenada claves = new ListaEncadenada();
            ListaEncadenada valores = new ListaEncadenada();
            NodoHash tmp = frente;
            while(tmp != null){
                claves.agregar(tmp.getClave());
                valores.agregar(tmp.getValor());
                tmp = tmp.getDirMemDer();
            }
            lista.agregar(claves);
            lista.agregar(valores);
            return lista;
        }else{
            return null;
        }
    }

    @Override
    public Tabla2D aTabla(){
        if(!vacia()){
            NodoHash tmp = frente;
            Tabla2D m2d = new Tabla2D(cantidadElementos(),2);
            for(int renglon=0;renglon< m2d.getFilas();renglon++){
                m2d.asignarCelda(renglon,0,tmp.getClave());
                m2d.asignarCelda(renglon,1,tmp.getValor());
                tmp = tmp.getDirMemDer();
            }
            return m2d;
        }else{
            return null;
        }
    }

    @Override
    public void vaciar(){
        frente = null;
        fin = null;
    }

    @Override
    public Object obtener(Object clave){
        if(!vacia()){
            NodoHash tmp = frente;
            while(tmp != null){
                if(Herramientas.compararObjetos(tmp.getClave(),clave) == 0){
                    return tmp.getValor();
                }
                tmp = tmp.getDirMemDer();
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public boolean agregarLista(ListaEncadenadaHash lista2){
        if(!lista2.vacia()){
            NodoHash tmp = lista2.frente;
            while(tmp != null){
                if(insertar(tmp.getClave(),tmp.getValor()) == false){
                    return false;
                }
                tmp = tmp.getDirMemDer();
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int cantidadElementos(){
        int cont = 0;
        NodoHash tmp = frente;
        while(tmp != null){
            cont++;
            tmp = tmp.getDirMemDer();
        }
        return cont;
    }

    @Override
    public boolean agregarArreglos(ArregloDatos arregloClaves, ArregloDatos arregloValores){
        if(arregloClaves.cantidadElementos() == arregloValores.cantidadElementos()
                && !arregloClaves.vacia() && !arregloValores.vacia()){
            for(int i=0;i<arregloClaves.cantidadElementos();i++){
                if(insertar(arregloClaves.obtener(i),arregloValores.obtener(i)) == false){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarListas(ListaEncadenada listaClaves, ListaEncadenada listaValores){
        if(!listaClaves.vacia() && !listaValores.vacia()){
            Nodo tmp = listaClaves.frente;
            Nodo tmp2 = listaValores.frente;
            while(tmp != null){
                if(!insertar(tmp.getDato(),tmp2.getDato())){
                    return false;
                }
                tmp = tmp.getDirMemDer();
                tmp2 = tmp2.getDirMemDer();
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean agregarTabla(Tabla2D tabla){
        if(tabla.getColumnas() == 2){
            for(int renglon=0;renglon<tabla.getFilas();renglon++){
                if(!insertar(tabla.obtenerCelda(renglon,0),tabla.obtenerCelda(renglon,1))){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
