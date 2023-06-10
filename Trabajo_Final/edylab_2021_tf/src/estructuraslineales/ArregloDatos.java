package estructuraslineales;

import entradasalida.SalidaTerminal;
import herramientas.comunes.Herramientas;

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

    /**
     * Metodo que llama al metodo con la posicion
     */
    public void imprimirRR(){
        imprimirRR(0);
    }

    /**
     * Imprime el arreglo en forma natrual usando recursion
     * @param posicion Posicion del dato que se va impirmir
     */
    private void imprimirRR(int posicion){
        if(posicion <= tope){
            SalidaTerminal.consola(lote[posicion]+"\n");
            imprimirRR(++posicion);
        }
    }

    public void imprimirOrdenInverso(){
        for(int posicion=tope;posicion>=0;posicion--){
            SalidaTerminal.consola(lote[posicion]+"\n");
        }
    }

    /**
     * Metodo que llama al metodo con la posicion
     */
    public void imprimirOrdenInversoRR(){
        imprimirOrdenInversoRR(cantidadElementos()-1);
    }

    /**
     * Imprime el arreglo en forma natrual usando recursion
     * @param posicion Posicion del dato que se va impirmir
     */
    private void imprimirOrdenInversoRR(int posicion){
        if(posicion >= 0){
            SalidaTerminal.consola(lote[posicion]+"\n");
            imprimirOrdenInversoRR(--posicion);
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

    /**
     * Manda llamar el metodo buscarRR
     * @param elemento Elemento a buscar
     * @return Regresa lo que regresa el metodo buscarRR
     */
    public Object buscarRR(Object elemento){
        return buscarRR(elemento,0);
    }

    /**
     * Busca un elemento en la lista usando recursion
     * @param elemento dato a buscar
     * @param posicion posicion en la que se evalua si el dato es igual a info
     * @return la posicion en la que se encontro el dato, null en caso que no lo encontrara
     */
    private Object buscarRR(Object elemento, int posicion){
        if(posicion<=tope){
            if(Herramientas.compararObjetos(elemento,lote[posicion]) == 0 && posicion<=tope){
                return posicion;
            }else {
                return buscarRR(elemento,++posicion);
            }
        }
        return null;
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

    /**
     * Llama al metodo eliminarRR
     * @param elemento Elemento a eliminar
     * @return Lo que regrese el metodo eliminarRR
     */
    public Object eliminarRR(Object elemento){
        return eliminarRR(elemento,0);
    }

    /**
     * Elimina el dato pasado como parametro
     * @param elemento dato a eliminar del arreglo
     * @param posicion posicion de la cual empieza a buscar
     * @return el elemento eliminado, null en caso contrario
     */
    private Object eliminarRR(Object elemento, int posicion){
        if(posicion<=tope){
            if(Herramientas.compararObjetos(elemento,lote[posicion]) == 0 && posicion<=tope){
                Object o = lote[posicion];
                for (int movs=posicion; movs<=tope;movs++){
                    lote[movs]=lote[movs+1];
                }
                tope--;
                return o;
            }else {
                return eliminarRR(elemento,posicion+1);
            }
        }
        return null;
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

    /**
     * Vacia la lista haciendo uso de la recursividad
     */
    public void vaciarRR(){
        if(!vacia()){
            eliminar();
            vaciarRR();
        }
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

    /**
     * Agrega datos de una lista a la lista actual
     * @param listaDatos2 lista a agregar a la lista actual
     * @return true si lo hace, false en caso contrario
     */
    public boolean agregarListaRR(Object listaDatos2){
        if(listaDatos2 instanceof ArregloDatos){
            ArregloDatos arr = (ArregloDatos) listaDatos2;
            if(!arr.vacia()){
                agregar(arr.eliminar());
                return agregarListaRR(arr);
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    @Override
    public void invertir(){
        ArregloDatos temporal = new ArregloDatos(CAPACIDAD);
        for (int posicion=tope-1;posicion>-1;posicion--){
            temporal.agregar(obtener(posicion));
        }
        lote = temporal.lote;
    }

    /**
     * Llama al metodo invertirRR
     */
    public void invertirRR(){
        ArregloDatos tmp = new ArregloDatos(CAPACIDAD);
        invertirRR(tmp);
        lote = tmp.lote;
        tope = tmp.tope;
    }

    /**
     * Invierte el arreglo usando recursion
     * @param tmp Arreglo temporal en el que se estaran almacenando los datos
     */
    private void invertirRR(ArregloDatos tmp){
        if(!vacia()){
            tmp.agregar(eliminar());
            invertirRR(tmp);
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

    /**
     * Llama al metodo contarRR
     * @param elemento Elemento a contar
     * @return El numero de veces que lo encontro, 0 si no encontro ninguna coicidencia
     */
    public int contarRR(Object elemento){
        return contarRR(elemento, 0);
    }

    /**
     * Cuenta el numero de veces que aparece el elemento dado utilizando recursion
     * @param elemento Elemento a contar
     * @param posicion Posicion en la que se encuentra
     * @return El numero de veces que encontro el elemento, 0 si no encontro ninguno
     */
    private int contarRR(Object elemento, int posicion){
        if(posicion <= tope){
            if(Herramientas.compararObjetos(elemento,lote[posicion]) == 0 && posicion <= tope){
                return (1+contarRR(elemento,++posicion));
            }else{
                return contarRR(elemento,++posicion);
            }
        }else{
            return 0;
        }
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

    /**
     * Rellena el arreglo con un dato duplicado la cantidad de veces indicada
     * @param elemento dato a agregar
     * @param cantidad cantidad de veces a agregar el dato
     */
    public void rellenarRR(Object elemento, int cantidad){
        if(cantidad < (CAPACIDAD-tope) && cantidad > 0){
            agregar(elemento);
            rellenarRR(elemento,--cantidad);
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

    /**
     * Llama al metodo clonarRR
     * @return Lo que regrese el metodo clonarRR
     */
    public Object clonarRR(){
        ArregloDatos arr = new ArregloDatos(CAPACIDAD);
        return clonarRR(0,arr);
    }

    /**
     * Clona el arreglo usando recursividad
     * @param posicion posicion en la que esta
     * @return El arreglo
     */
    private Object clonarRR(int posicion,ArregloDatos arr){
        if(posicion <= tope && posicion >= 0){
            arr.agregar(obtener(posicion));
            return clonarRR(++posicion,arr);
        }
        return arr;
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
    public void rellenar(Object elemento) {
        while(!lleno()){
            agregar(elemento);
        }
    }

    /**
     * Rellena el arreglo con el elemento dado, utiliznaod recursion
     * @param elemento Elemento a agregar hasta que se llene el arreglo
     */
    public void rellenarRR(Object elemento){
        if(!lleno()){
            agregar(elemento);
            rellenarRR(elemento);
        }
    }

    @Override
    public boolean esSublista(Object listaDatos2) {
        ArregloDatos lista = (ArregloDatos)listaDatos2;
        int contador = 0;
        if(lista.tope <= tope && lista.tope!=-1){
            Integer pos = (Integer) buscar(lista.obtener(0));
            if(pos!=null){
                int posicion=pos;
                while(posicion <= lista.tope){
                    if(Herramientas.compararObjetos(lista.obtener(posicion),obtener(posicion)) == 0){
                        posicion++;
                    }else{
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean cambiarLista(ArregloDatos listaDatos2, ArregloDatos listaDatos2Nuevos) {
        return false;
    }

    @Override
    public boolean retenerLista(ArregloDatos listaDatos2) {
        return false;
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

    @Override
    public boolean insertar(int indice, Object elemento){
        if(indice > -1 && indice < CAPACIDAD){
            if(obtener(indice) != null){
                lote[indice] = elemento;
            }else{
                tope++;
                lote[indice] = elemento;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean copiarLista(ArregloDatos listaDatos2){
        if(listaDatos2.tope < CAPACIDAD){
            vaciar();
            for(int pos=0;pos< listaDatos2.tope+1;pos++){
                agregar(listaDatos2.obtener(pos));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Debe regresar un arreglo conteniendo los elementos del arreglo
     * actual que se obtienen del arreglo de índices “arregloIndices”
     * @param arregloIndices Arreglo que contiene los indices a obtener
     * @return Un arreglo con los datos obtenidos, null en caso contrario
     */
    public ArregloDatos subLista(ArregloNumeros arregloIndices){
        if(!vacia()){
            ArregloDatos arreglo = new ArregloDatos(arregloIndices.cantidadElementos());
            for(int posicion=0;posicion<arregloIndices.cantidadElementos();posicion++){
                arreglo.agregar(obtener((Integer)arregloIndices.obtener(posicion)));
            }
            return arreglo;
        }else{
            return null;
        }
    }

    @Override
    public Object verTope(){
        if (vacia()==false){
            return lote[tope];
        }else{
            return null;
        }
    }

    /**
     * Llama al metodo arregloAListaRR
     * @return La lista encadenada que regresa el metodo
     */
    public ListaEncadenada arregloAListaRR(){
        return arregloAListaRR(0,new ListaEncadenada());
    }

    /**
     * Agrega los datos del arreglo a una lista enlazada
     * @param posicion posicion que se va estar agregando al arreglo
     * @return la Lista ligada con los datos
     */
    private ListaEncadenada arregloAListaRR(int posicion,ListaEncadenada lista){
        if(posicion < tope){
            lista.agregar(obtener(posicion));
            arregloAListaRR(++posicion,lista);
        }
        return lista;
    }
}
