package estructuraslineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.NodoDoble;
import herramientas.comunes.Herramientas;

public class ListaEncadenadaDoble implements ListaDatos{
    protected NodoDoble frente;
    protected NodoDoble fin;
    protected NodoDoble iterador;
    protected NodoDoble iteradorOI;

    public ListaEncadenadaDoble(){
        frente=null;
        fin=null;
        iterador = null;
        iteradorOI = null;
    }

    @Override
    public boolean vacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }

    @Override
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

    @Override
    public void imprimir(){
        if(vacia()==true){
            SalidaTerminal.consola("null");
        }else{ //hay datos
            NodoDoble temporal=frente;
            SalidaTerminal.consola("null <- ");
            while(temporal!=fin){
                SalidaTerminal.consola(temporal.getDato()+ " <--> ");
                temporal=temporal.getDirMemDer();
            }
            SalidaTerminal.consola(temporal.getDato() + " -> null");
        }
    }

    @Override
    public void imprimirOrdenInverso(){
        if(vacia()==true){
            SalidaTerminal.consola("null");
        }else{ //hay datos
            NodoDoble temporal=fin;
            SalidaTerminal.consola("null <- ");
            while(temporal!=frente){
                SalidaTerminal.consola(temporal.getDato()+ " <--> ");
                temporal=temporal.getDirMemIzq();
            }
            SalidaTerminal.consola(temporal.getDato() + " -> null");
        }
    }

    @Override
    public Object buscar(Object elemento){
        NodoDoble encontrado = frente;
        while (encontrado!=null && !encontrado.getDato().toString().equalsIgnoreCase(elemento.toString())){
            encontrado=encontrado.getDirMemDer();
        }
        if (encontrado==null){ //no esta
            return null;
        }else{ //si esta
            return encontrado.getDato();
        }
    }

    @Override
    public Object eliminar(Object elemento){
        if(vacia()==true){
            return null;
        }else{
            NodoDoble encontrado=frente;
            while(encontrado!=null && !encontrado.toString().equalsIgnoreCase(elemento.toString())){
                encontrado=encontrado.getDirMemDer();
            }
            if(encontrado==null){//no esta, f
                return null;
            }else{ //si esta, pero en algun lado
                Object datoEliminado=encontrado.getDato(); //1
                if(frente==fin){ //b, unico
                    frente=null;//2
                    fin=null;
                }else if(encontrado==frente){ //frente, c
                    frente=frente.getDirMemDer(); //2
                    frente.setDirMemIzq(null);
                }else if(encontrado==fin){ //final, d
                    fin = fin.getDirMemIzq();
                    fin.setDirMemDer(null);
                }else{ //esta en medio, e
                    encontrado.getDirMemIzq().setDirMemDer(encontrado.getDirMemDer());
                    encontrado.getDirMemIzq().getDirMemDer().setDirMemIzq(encontrado.getDirMemIzq());
                    encontrado.setDirMemIzq(null);
                    encontrado.setDirMemDer(null);
                }
                return datoEliminado;
            }
        }
    }

    @Override
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

    /**
     * Inicia el iterador en el frente
     */
    public void inicializarIterador(){
        iterador=frente;
    }

    /**
     * Varifica si el iterador es null
     * @return True si no es null, false en caso contrario
     */
    public boolean hayElementos(){
        if (iterador==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Obtiene el elemento del iterador
     * @return El objeto almacenado en el iterador
     */
    public Object obtenerElemento(){
        if(hayElementos()==true){
            Object elementoExtraido=iterador.getDato();
            iterador=iterador.getDirMemDer();
            return elementoExtraido;
        }else{ //no hay elementos
            return null;
        }
    }

    /**
     * Inicia el iteradorOI en el fin
     */
    public void inicializarIteradorOI(){
        iterador=fin;
    }

    /**
     * Varifica si el iteradorOI es null
     * @return True si no es null, false en caso contrario
     */
    public boolean hayElementosOI(){
        if (iterador==null){
            return false;
        }else{
            return true;
        }
    }

    /**
     * Obtiene el elemento del iteradorOI
     * @return El objeto almacenado en el iteradorOI
     */
    public Object obtenerElementoOI(){
        if(hayElementos()==true){
            Object elementoExtraido=iterador.getDato();
            iterador=iterador.getDirMemIzq();
            return elementoExtraido;
        }else{ //no hay elementos
            return null;
        }
    }

    /**
     * Atrasa los iteradores una vez si es que estos estan iniciados
     */
    public void atrasarIterador(){
        if(iterador != null){
            iterador = iterador.getDirMemIzq();
        }
        if(iteradorOI != null){
            iteradorOI = iteradorOI.getDirMemDer();
        }
    }

    /**
     * Inserta al inicio de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa un 1 en caso de que se agregue el elemento, o -1 en caso contrario.
     */
    public int agregarInicio(Object elemento){
        NodoDoble nuevoNodo=new NodoDoble(elemento);
        if(nuevoNodo!=null){
            if(vacia()==true){
                frente=nuevoNodo;
                fin=nuevoNodo;
            }else{
                nuevoNodo.setDirMemDer(frente);
                frente.setDirMemIzq(nuevoNodo);
                frente=nuevoNodo;
            }
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * Elimina el elemento del inicio si es que hay elementos en la lista
     * @return El elemento eliminado, null en caso contrario
     */
    public Object eliminarInicio(){
        Object datoEliminado=null;
        if (vacia()==true){
            return null;
        }else{
            datoEliminado=frente.getDato();
            if(frente==fin){
                frente=null;
                fin=null;
            }else{
                frente=frente.getDirMemDer();
                frente.setDirMemIzq(null);
            }
            return datoEliminado;
        }
    }

    /**
     * Busca un elemento comenzando a buscar por el final
     * @param elemento Elemento a buscar
     * @return El elemento a buscar, null en caso que no lo haya encontrado
     */
    public Object buscarOI(Object elemento){
        NodoDoble encontrado = fin;
        while (encontrado!=null && !encontrado.getDato().toString().equalsIgnoreCase(elemento.toString())){
            encontrado=encontrado.getDirMemIzq();
        }
        if (encontrado==null){
            return null;
        }else{
            return encontrado.getDato();
        }
    }

    /**
     * Ingresa los elementos de la lista actual en una lista que separa los elementos por numeros, cadenas y otros
     * @return Regresa una ListaEncadenadaDoble con 3 listas ligadas con elementos separados
     */
    public ListaEncadenadaDoble separarElementos(){
        if(!vacia()){
            ListaEncadenadaDoble lista = new ListaEncadenadaDoble();
            ListaEncadenadaDoble listaNum = new ListaEncadenadaDoble();
            ListaEncadenadaDoble listaCad = new ListaEncadenadaDoble();
            ListaEncadenadaDoble listaObj = new ListaEncadenadaDoble();
            NodoDoble tmp = frente;
            while(tmp != null){
                if(tmp.getDato() instanceof Number){
                    listaNum.agregar(tmp.getDato());
                }else if(tmp.getDato() instanceof String){
                    listaCad.agregar(tmp.getDato());
                }else{
                    listaObj.agregar(tmp.getDato());
                }
                tmp = tmp.getDirMemDer();
            }
            lista.agregar(listaNum);
            lista.agregar(listaCad);
            lista.agregar(listaObj);
            return lista;
        }else{
            return null;
        }
    }

    @Override
    public boolean esIgual(Object listaDatos2) {
        if(listaDatos2 instanceof ListaEncadenadaDoble){
            ListaEncadenadaDoble lista = (ListaEncadenadaDoble)listaDatos2;
            NodoDoble n1 = frente;
            NodoDoble n2 = lista.frente;
            while(n1 != null && n2 != null){
                if(Herramientas.compararObjetos(n1.getDato(),n2.getDato()) != 0){
                    return false;
                }
                n1 = n1.getDirMemDer();
                n2 = n2.getDirMemDer();
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces) {
        if(numVeces > 0 && vacia() == false){
            if(buscar(elementoViejo) == null){
                return false;
            }else{
                NodoDoble recorrer = frente;
                int cont = 0;
                while(recorrer!=null && cont != numVeces){
                    if(Herramientas.compararObjetos(elementoViejo,recorrer.getDato()) == 0){
                        recorrer.setDato(elementoNuevo);
                        cont++;
                    }
                    recorrer=recorrer.getDirMemDer();
                }
                return true;
            }
        }else{
            return false;
        }
    }

    @Override
    public ArregloDatos buscarValores(Object elemento) {
        if(vacia()==false){
            int cont = 0;
            NodoDoble recorrer=frente;
            while(recorrer!=null){
                if(Herramientas.compararObjetos(recorrer.getDato(),elemento) == 0){
                    cont++;
                }
                recorrer = recorrer.getDirMemDer();
            }
            ArregloDatos arr = new ArregloDatos(cont);
            recorrer=frente;
            while(recorrer!=null){
                if(Herramientas.compararObjetos(recorrer.getDato(),elemento) == 0){
                    arr.agregar(recorrer.getDato());
                }
                recorrer = recorrer.getDirMemDer();
            }
            return arr;
        }else{
            return null;
        }
    }

    @Override
    public void vaciar() {
        frente = null;
        fin = null;
    }

    @Override
    public boolean agregarLista(Object listaDatos2) {
        if(listaDatos2 instanceof ListaEncadenadaDoble) {
            ListaEncadenadaDoble lista = (ListaEncadenadaDoble) listaDatos2;
            NodoDoble tmp = lista.frente;
            while (tmp != null) {
                if (agregar(tmp.getDato()) == -1) {
                    return false;
                }
                tmp = tmp.getDirMemDer();
            }
            return true;
        }else if(listaDatos2 instanceof ArregloDatos){
            ArregloDatos arr = (ArregloDatos) listaDatos2;
            for(int posicion=0;posicion<arr.cantidadElementos();posicion++){
                if(agregar(arr.obtener(posicion)) == -1){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void invertir() {
        if(!vacia()){
            ListaEncadenadaDoble lista = new ListaEncadenadaDoble();
            while(!vacia()){
                lista.agregar(eliminar());
            }
            frente = lista.frente;
            fin = lista.fin;
        }
    }

    @Override
    public int contar(Object elemento) {
        if(vacia()==false){
            int cont = 0;
            NodoDoble recorrer=frente;
            while(recorrer!=null) {
                if (Herramientas.compararObjetos(recorrer.getDato(), elemento) == 0) {
                    cont++;
                }
                recorrer = recorrer.getDirMemDer();
            }
            return cont;
        }else{
            return 0;
        }
    }

    @Override
    public boolean eliminarLista(Object listaDatos2) {
        if(!vacia()){
            if(listaDatos2 instanceof ListaEncadenadaDoble){
                ListaEncadenadaDoble lista = (ListaEncadenadaDoble) listaDatos2;
                NodoDoble recorrer = lista.frente;
                while(recorrer != null){
                    eliminar(recorrer.getDato());
                    recorrer = recorrer.getDirMemDer();
                }
                return true;
            }else if(listaDatos2 instanceof ArregloDatos){
                ArregloDatos arr = (ArregloDatos) listaDatos2;
                for(int posicion=0;posicion<arr.cantidadElementos();posicion++){
                    eliminar(arr.obtener(posicion));
                }
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    @Override
    public void rellenar(Object elemento, int cantidad) {
        if(cantidad>0){
            int cont=0;
            while(cont != cantidad){
                agregar(elemento);
                cont++;
            }
        }
    }

    @Override
    public Object clonar() {
        ListaEncadenadaDoble lista = new ListaEncadenadaDoble();
        inicializarIterador();
        while(iterador != null){
            lista.agregar(obtenerElemento());
        }
        return lista;
    }

    @Override
    public Object subLista(int indiceInicial, int indiceFinal) {
        if(!vacia()){
            if(indiceInicial>=0 || indiceFinal>=0 || indiceFinal>indiceInicial){
                int indice = 0;
                NodoDoble recorrer = frente;
                ListaEncadenadaDoble lista = new ListaEncadenadaDoble();
                while(recorrer != null){
                    if(indice >= indiceInicial && indice <= indiceFinal){
                        lista.agregar(recorrer.getDato());
                    }else if(indice > indiceFinal){
                        break;
                    }
                    recorrer = recorrer.getDirMemDer();
                    indice++;
                }
                if(indice > indiceFinal){
                    return lista;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public void rellenar(Object elemento) {
        return;
    }

    @Override
    public boolean esSublista(Object listaDatos2) {
        if(!vacia()){
            if(listaDatos2 instanceof ListaEncadenada){
                NodoDoble recorrer = frente;
                ListaEncadenadaDoble lista = (ListaEncadenadaDoble) listaDatos2;
                while(recorrer != null){
                    if(Herramientas.compararObjetos(recorrer.getDato(),lista.frente) == 0){
                        NodoDoble recorrerL = lista.frente.getDirMemDer();
                        recorrer = recorrer.getDirMemDer();
                        while(recorrer != null && recorrerL != null){
                            if(Herramientas.compararObjetos(recorrer.getDato(),recorrerL.getDato()) != 0){
                                return false;
                            }
                            recorrer = recorrer.getDirMemDer();
                            recorrerL = recorrerL.getDirMemDer();
                        }
                        if(recorrerL == null){
                            return true;
                        }else if(recorrerL != null){
                            return false;
                        }
                    }
                    recorrer = recorrer.getDirMemDer();
                }
                return false;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiarLista(ArregloDatos listaDatos2, ArregloDatos listaDatos2Nuevos) {
        if(!vacia()){
            if(listaDatos2.cantidadElementos() == listaDatos2Nuevos.cantidadElementos()){
                for(int posicion=0;posicion<listaDatos2.cantidadElementos();posicion++){
                    cambiar(listaDatos2.obtener(posicion),listaDatos2Nuevos.obtener(posicion),1);
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean retenerLista(ArregloDatos listaDatos2) {
        if(!vacia()){
            ListaEncadenadaDoble lista = new ListaEncadenadaDoble();
            for(int posicion=0;posicion<listaDatos2.cantidadElementos();posicion++){
                Object elem = eliminar(listaDatos2.obtener(posicion));
                if(elem != null){
                    lista.agregar(elem);
                }
            }
            if(!lista.vacia()){
                frente = lista.frente;
                fin = lista.fin;
                iterador = null;
                iteradorOI = null;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean insertar(int indice, Object elemento) {
        if(!vacia()){
            int i = 0;
            NodoDoble r = frente;
            while(r != null){
                if(i == indice){
                    r.setDato(elemento);
                    break;
                }
                r = r.getDirMemDer();
                i++;
            }
            if(r != null){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public boolean copiarLista(ArregloDatos listaDatos2) {
        if(!listaDatos2.vacia()){
            vaciar();
            for(int pos=0;pos<listaDatos2.cantidadElementos();pos++){
                agregar(listaDatos2.obtener(pos));
            }
            return true;
        }else{
            return false;
        }
    }
}
