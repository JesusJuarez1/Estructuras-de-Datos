package estructuraslineales;

import entradasalida.SalidaTerminal;

public class ArregloDatos implements VectorDatos{
    protected int CAPACIDAD;
    protected int tope;
    protected Object lote[];

    public ArregloDatos(int capacidad){
        CAPACIDAD=capacidad;
        lote=new Object[CAPACIDAD];
        tope=-1;
    }

    @Override
    public boolean vacia(){
        if(tope==-1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean lleno(){
        if(tope== (CAPACIDAD - 1)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int agregar(Object elemento){
        if(lleno()==false){  //esta llena la lista
            tope=tope+1;
            lote[tope]=elemento;
            return tope;
        }else{   //no esta llena la lista
            return -1;
        }
    }

    public void imprimir(){
        for(int posicion=0;posicion<=tope;posicion++){
            SalidaTerminal.consola(lote[posicion]+"\n");
        }
    }

    public void imprimirOrdenInverso(){
        for(int posicion=tope;posicion>=0;posicion--){
            SalidaTerminal.consola(lote[posicion]+"\n");
        }
    }

    public Object buscar(Object elemento){
        int posicion=0;
        while(posicion<=tope && !elemento.toString().equalsIgnoreCase(lote[posicion].toString())){
            posicion++;
        }
        if (posicion > tope) { //significa que no lo encontro
            return null;
        }else{
            return posicion;
        }
    }

    public Object eliminar(Object elemento){
        Integer posicion=(Integer)buscar(elemento);
        if(posicion!=null){ //si esta
            Object elementoBorrado=lote[posicion];
            tope= tope -1;
            for (int movs=posicion; movs<=tope;movs++){
                lote[movs]=lote[movs+1];
            }
            return elementoBorrado;
        }else{ //no esta
            return  null;
        }
    }

    public int capacidad(){
        return CAPACIDAD;
    }

    public int cantidadElementos(){
        return tope+1;
    }

    @Override
    public boolean esIgual(Object listaDatos2){
        if(!(listaDatos2 instanceof ArregloDatos)) {
            return false;
        }else {
            ArregloDatos arreglo = (ArregloDatos)listaDatos2;
            int contador = 0;
            if(arreglo.CAPACIDAD == CAPACIDAD) {
                for(int posicion=0; posicion<CAPACIDAD;posicion++) {
                    if(lote[posicion].toString().equalsIgnoreCase(arreglo.lote[posicion].toString())){
                        contador++;
                    }
                }
                if(contador == CAPACIDAD){
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public Object obtener(int indice){
        if(indice<0 || indice>tope){
            return null;
        }else{
            if(lote[indice] != null){
                return lote[indice];
            }else{
                return null;
            }
        }
    }

    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces){
        if(numVeces<1 || numVeces>CAPACIDAD){
            return false;
        }else{
            Integer posicion = (Integer)buscar(elementoViejo);
            if(posicion != null){
                while(numVeces > 0){
                    if(posicion != null){
                        lote[posicion] = elementoNuevo;
                    }
                    posicion = (Integer)buscar(elementoViejo);
                    numVeces--;
                }
                return true;
            }
            return false;
        }

    }

    @Override
    public boolean cambiar(int indice, Object elemento){
        if(indice<0 || indice>tope){
            return false;
        }else{
            if(lote[indice] != null){
                lote[indice]=elemento;
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean cambiarArregloDatos(ArregloDatos indicesBusqueda, ArregloDatos elementosNuevos){
        if(indicesBusqueda.tope == elementosNuevos.tope){
            if(indicesBusqueda.tope == tope){
                for(int pos=0;pos< indicesBusqueda.tope;pos++){
                    if(indicesBusqueda.obtener(pos) instanceof Integer){
                        if((Integer)indicesBusqueda.obtener(pos) < 0 || (Integer)indicesBusqueda.obtener(pos) > tope){
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                for(int pos=0;pos< indicesBusqueda.tope;pos++){
                    cambiar((Integer)indicesBusqueda.obtener(pos),elementosNuevos.obtener(pos));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public ArregloDatos buscarValores(Object elemento){
        int lim = 0;
        for(int pos=0;pos<tope;pos++){
            if(elemento.toString().equalsIgnoreCase(lote[pos].toString())){
                lim++;
            }
        }
        ArregloDatos arreglo = new ArregloDatos(lim);
        for(int posicion=0;posicion<tope;posicion++){
            if(elemento.toString().equalsIgnoreCase(lote[posicion].toString())){
                arreglo.agregar(lote[posicion]);
            }
        }
        return arreglo;
    }

    @Override
    public Object eliminar(int indice){
        if(indice<0 || indice>tope){
            return null;
        }else{
            Object elementoBorrado=lote[indice];
            tope = tope - 1;
            for(int mov=indice; mov <= tope; mov ++){
                lote[mov]=lote[mov+1];
            }
            return elementoBorrado;
        }
    }

    @Override
    public Object eliminar(){
        if (vacia()==false){
            Object infoBorrado=lote[tope];
            lote[tope]=null;
            tope = tope -1;
            return infoBorrado;
        }else{
            return null;
        }
    }

    @Override
    public void vaciar(){
        for(int posicion=0; posicion<tope+1;posicion++){
            lote[posicion] = null;
        }
        tope = -1;
    }

    @Override
    public boolean agregarLista(Object listaDatos2){
        int agregados = 0;
        if(listaDatos2 instanceof ArregloDatos){
            if(((ArregloDatos) listaDatos2).tope <= (CAPACIDAD-tope)){
                for (int posicion=0;posicion<((ArregloDatos) listaDatos2).tope;posicion++){
                    agregados = agregar(((ArregloDatos) listaDatos2).lote[posicion]);
                }
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public void invertir(){
        Object temporal[] = lote;
        int inverso = tope;
        for (int posicion=0;posicion<tope;posicion++,inverso--){
            lote[posicion] = temporal[inverso];
        }
    }

    @Override
    public int contar(Object elemento){
        int contador = 0;
        for(int posicion=0;posicion<tope;posicion++){
            if(elemento.toString().equalsIgnoreCase(lote[posicion].toString())){
                contador+=1;
            }
        }
        return contador;
    }

    @Override
    public boolean eliminarLista(Object listaDatos2){
        if(listaDatos2 instanceof ArregloDatos){
            for (int posicion=0;posicion<((ArregloDatos)listaDatos2).tope;posicion++){
                eliminar(((ArregloDatos)listaDatos2).lote[posicion]);
            }
            return true;
        }
        return false;
    }

    @Override
    public void rellenar(Object elemento, int cantidad){
        if(cantidad > 0){
            if((cantidad > (CAPACIDAD-tope))){
                cantidad = (CAPACIDAD-tope);
            }
            while(cantidad>0){
                agregar(elemento);
                cantidad--;
            }
        }
    }

    @Override
    public Object clonar(){
        ArregloDatos clon = new ArregloDatos(CAPACIDAD);
        for(int posicion=0;posicion<=tope;posicion++){
            clon.agregar(lote[posicion]);
        }
        return clon;
    }

    @Override
    public Object subLista(int indiceInicial, int indiceFinal){
        if (indiceInicial < indiceFinal){
            if(indiceInicial>-1 && indiceFinal<CAPACIDAD) {
                ArregloDatos subLista;
                subLista = new ArregloDatos(indiceFinal+1);
                for (int posicion=indiceInicial;posicion<indiceFinal;posicion++){
                    subLista.agregar(lote[posicion]);
                }
                return subLista;
            }
        }
        return null;
    }

    @Override
    public Object redimensionar(int maximo){
        ArregloDatos red = new ArregloDatos(maximo);
        if(maximo > tope){
            for(int posicion=0;posicion<tope;posicion++){
                red.agregar(lote[posicion]);
            }
            CAPACIDAD = red.CAPACIDAD;
            tope = red.tope;
            lote = red.lote;
            return red;
        }else{
            for(int posicion=0;posicion<maximo;posicion++){
                red.agregar(lote[posicion]);
            }
            CAPACIDAD = red.CAPACIDAD;
            tope = red.tope;
            lote = red.lote;
            return red;
        }
    }
}
