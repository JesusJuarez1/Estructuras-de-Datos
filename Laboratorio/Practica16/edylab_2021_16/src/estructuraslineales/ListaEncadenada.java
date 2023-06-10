package estructuraslineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.registros.Nodo;
import estructurasnolineales.Tabla2D;
import estructurasnolineales.TipoTabla;
import herramientas.comunes.Herramientas;

public class ListaEncadenada implements ListaDatos{
    protected Nodo frente;
    protected Nodo fin;
    protected Nodo iterador;

    public ListaEncadenada(){
        frente=null;
        fin=null;
        iterador = null;
    }

    @Override
    public boolean vacia(){
        if(frente==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Inserta al final de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa un 1 en caso de que se agregue el elemento, o -1 en caso contrario.
     */
    @Override
    public int agregar(Object elemento){
        Nodo nuevoNodo=new Nodo(elemento); //1
        if(nuevoNodo!=null){ //si hay espacio
            if(vacia()==true){ //a
                frente=nuevoNodo;//2
                fin=nuevoNodo;
            }else{ //b y c
                fin.setDirMemDer(nuevoNodo);//2
                fin=nuevoNodo;//3
            }
            return 1;
        }else{ //no hay espacio
            return -1;
        }
    }

    /**
     * Inserta al inicio de la lista un elemento proporcionado.
     * @param elemento Es el dato que se desea agregar a la lista.
     * @return Regresa un 1 en caso de que se agregue el elemento, o -1 en caso contrario.
     */
    public int agregarInicio(Object elemento){
        Nodo nuevoNodo=new Nodo(elemento); //1
        if(nuevoNodo!=null){ //si hay espacio
            if(vacia()==true){ //a
                frente=nuevoNodo;//2
                fin=nuevoNodo;
            }else{  //b
                nuevoNodo.setDirMemDer(frente);//2
                frente=nuevoNodo;//3
            }
            return 1;
        }else{ //no hay espacio
            return -1;
        }
    }

    @Override
    public void imprimir(){
        Nodo temp=frente;
        while(temp!=null){
            SalidaTerminal.consola(temp.getDato()+ " -> ");
            temp=temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
    }

    @Override
    public void imprimirOrdenInverso(){
        ListaPila pila = new ListaPila();
        Nodo temp=frente;
        while (temp!=null){
            pila.poner(temp.getDato());
            temp = temp.getDirMemDer();
        }
        SalidaTerminal.consola("null");
        while(!pila.vacio()){
            SalidaTerminal.consola(" <- "+pila.quitar().toString());
        }
    }

    @Override
    public Object buscar(Object elemento){
        Nodo encontrado=frente;
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
        if(vacia()==true){ //no hay datos, a
            return null;
        }else{ //si hay datos
            Nodo anterior=frente;
            Nodo encontrado=frente;
            while(encontrado!=null && !encontrado.toString().equalsIgnoreCase(elemento.toString())){
                anterior=encontrado;
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
                }else if(encontrado==fin){ //final, d
                    anterior.setDirMemDer(null);//2
                    fin=anterior; //3
                }else{ //esta en medio, e
                    Nodo posterior=encontrado.getDirMemDer(); //2
                    anterior.setDirMemDer(posterior);//3
                }
                return datoEliminado;
            }
        }
    }

    public Object eliminarInicio(){
        Object datoEliminado=null;

        if (vacia()==true){ //a
            return null;
        }else{   //si hay algo
            datoEliminado=frente.getDato(); //1
            if(frente==fin){  //b, único
                //datoEliminado=frente.getDato(); //1
                frente=null;//2
                fin=null;
            }else{   //c, varios
                //datoEliminado=frente.getDato(); //1
                frente=frente.getDirMemDer();//2
            }
            return datoEliminado;
        }
    }
    @Override
    public Object eliminar(){
        Object datoEliminado=null;

        if(vacia()==true){ //a, esta vacia
            return null;
        }else{ //hay algo
            datoEliminado = fin.getDato();//1
            if(frente==fin) { //b, único
                //datoEliminado = fin.getDato();//1
                frente=null;//2
                fin=null;//2
            }else{ //c, varios elementos
                //datoEliminado = fin.getDato();//1
                //buscar el penultimo
                Nodo penultimo=frente;
                while (penultimo.getDirMemDer()!=fin) {
                    penultimo = penultimo.getDirMemDer();  //i=i+1
                }
                fin=penultimo;//2
                fin.setDirMemDer(null);//3
            }
            return datoEliminado;
        } //
    }

    public void inicializarIterador(){
        iterador=frente;
    }

    public boolean hayElementos(){
        if (iterador==null){
            return false;
        }else{
            return true;
        }
    }

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
     * Agrega todos los elementos de la lista a un arreglo
     * @return Todos el arreglo con todos los elementos de la lista
     */
    public ArregloDatos aArreglo(){
        if(!vacia()){
            inicializarIterador();
            int cont = 1;
            while(obtenerElemento() != null){
                cont++;
            }
            ArregloDatos arr = new ArregloDatos(cont);
            Nodo temp = frente;
            while (temp!=null) {
                arr.agregar(temp.getDato());
                temp = temp.getDirMemDer();
            }
            return arr;
        }else{
            return null;
        }
    }

    /**
     * Agrega todos los elementos de la lista que no se encuentren en el arreglo
     * @param arregloADescartar Arreglo que contiene los datos que no se van agregar al arreglo
     * @return El arreglo con los datos agregados
     */
    public ArregloDatos aArreglo(ArregloDatos arregloADescartar){
        if(!vacia()){
            inicializarIterador();
            int cont = 1;
            while(obtenerElemento() != null){
                cont++;
            }
            ArregloDatos arr = new ArregloDatos(cont);
            Nodo temp = frente;
            while (temp!=null) {
                int coinsidencias = 0;
                for(int posicion=0;posicion<arregloADescartar.cantidadElementos();posicion++){
                    if(Herramientas.compararObjetos(arregloADescartar.obtener(posicion),temp.getDato()) == 0){
                        coinsidencias++;
                    }
                }
                if(coinsidencias == 0){
                    arr.agregar(temp.getDato());
                }
                temp = temp.getDirMemDer();
            }
            return arr;
        }else{
            return null;
        }
    }

    /**
     * Pasa los datos de la lista a una matriz2D, si faltan datos para rellenar la matriz se agregan null
     * @param filas numero de renglones que va a tener la matriz
     * @param columnas numero de columnas que va a tener la matriz
     * @return La matriz resultante
     */
    public Tabla2D aTabla2D(int filas, int columnas){
        Tabla2D m2d = new Tabla2D(filas,columnas);
        inicializarIterador();
        for(int renglon=0;renglon<filas;renglon++){
            for(int columna=0;columna<columnas;columna++){
                m2d.asignarCelda(renglon,columna,obtenerElemento());
            }
        }
        return m2d;
    }

    /**
     * Agrega la matriz columna por columna o fila por fila segun la opcion del enumerado
     * @param tabla matriz que contiene los datos que se van agregar
     * @param enumTipoTabla enumerado que contiene las opciones de como agregar la matriz
     * @return true si lo hizo, false en caso contrario
     */
    public boolean agregarTabla2D(Tabla2D tabla, TipoTabla enumTipoTabla){
        if(TipoTabla.COLUMNA == enumTipoTabla){
            for(int fila=0;fila< tabla.getFilas();fila++){
                for(int columna=0;columna< tabla.getColumnas();columna++){
                    agregar(tabla.obtenerCelda(fila,columna));
                }
            }
            return true;
        }else if(TipoTabla.FILA == enumTipoTabla){
            for(int columna=0;columna< tabla.getColumnas();columna++){
                for(int fila=0;fila< tabla.getFilas();fila++){
                    agregar(tabla.obtenerCelda(fila,columna));
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Cambia un objeto dada una posicion en la lista
     * @param indice posicion en la que se va hacer el cambio
     * @param elemento Nuevo valor que tendra la posicion
     * @return Trtue si encontro la posicion deseada, false en caso contrario
     */
    public boolean cambiar(int indice, Object elemento) {
        if(indice >= 0){
            int cont = 0;
            Nodo recorrer = frente;
            while(recorrer != null){
                if(cont == indice){
                    recorrer.setDato(elemento);
                    return true;
                }
                recorrer = recorrer.getDirMemDer();
                cont++;
            }
            return false;
        }else{
            return false;
        }
    }

    /**
     * Obtiene el elemento del indice indicado
     * @param indice indice del cual obtendra el elemento
     * @return el elemento encontrado, null si no lo encontro
     */
    public Object obtener(int indice){
        if(indice>=0){
            int cont = 0;
            Nodo recorrer = frente;
            while(recorrer!=null){
                if(cont == indice){
                    return recorrer.getDato();
                }
                recorrer = recorrer.getDirMemDer();
                cont++;
            }
            return null;
        }else{
            return null;
        }
    }

    /**
     * Agrega o quita elementos de la lista
     * @param maximo numero de elementos que tiene que tener la lista
     * @return True si lo hizo, false en caso contrario
     */
    public boolean redimensionar(int maximo){
        if(maximo>=0){
            if(maximo == 0){
                vaciar();
                return false;
            }else{
                int cont = 1;
                Nodo recorrer = frente;
                while(recorrer!=null){
                    if(cont == maximo-1){
                        fin = recorrer.getDirMemDer();
                        fin.setDirMemDer(null);
                        recorrer.setDirMemDer(fin);
                        return true;
                    }
                    recorrer = recorrer.getDirMemDer();
                    cont++;
                }
                while(cont != maximo){
                    agregar(null);
                    cont++;
                }
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Elimina el elemento que se encuentra en la posicion dada
     * @param indice posicion a eliminar elemento
     * @return elemento borrado
     */
    public Object eliminar(int indice){
        if(vacia()){
            return null;
        }
        if(indice>=0){
            Nodo recorrer = frente;
            int cont = 0;
            while(recorrer != null){
                if(indice == 0){
                    Object elemBorr = frente.getDato();
                    frente = frente.getDirMemDer();
                    return elemBorr;
                }else if(indice == cont){
                    if(recorrer == fin){
                        return eliminar();
                    }else{
                        Object elemBorr = recorrer.getDato();
                        Nodo anterior = frente;
                        while(anterior.getDirMemDer() != recorrer){
                            anterior = anterior.getDirMemDer();
                        }
                        anterior.setDirMemDer(recorrer.getDirMemDer());
                        return elemBorr;
                    }
                }
                recorrer = recorrer.getDirMemDer();
                cont++;
            }
            return null;
        }else{
            return null;
        }
    }

    @Override
    public boolean esIgual(Object listaDatos2) {
        if(listaDatos2 instanceof ListaEncadenada){
            ListaEncadenada lista = (ListaEncadenada)listaDatos2;
            Nodo n1 = frente;
            Nodo n2 = lista.frente;
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
            Nodo recorrer=frente;
            int cont = 0;
            while(recorrer!=null){
                if(cont == numVeces){
                    return true;
                }
                if(Herramientas.compararObjetos(elementoViejo,recorrer.getDato()) == 0){
                    recorrer.setDato(elementoNuevo);
                    cont++;
                }
                recorrer=recorrer.getDirMemDer();
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public ArregloDatos buscarValores(Object elemento) {
        if(vacia()==false){
            int cont = 0;
            Nodo recorrer=frente;
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
        iterador = null;
    }

    @Override
    public boolean agregarLista(Object listaDatos2) {
        if(listaDatos2 instanceof ListaEncadenada){
            ListaEncadenada lista = (ListaEncadenada) listaDatos2;
            Nodo tmp = lista.frente;
            while(tmp != null){
                if(agregar(tmp.getDato()) == -1){
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
            ListaEncadenada lista = new ListaEncadenada();
            while(!vacia()){
                lista.agregar(eliminar());
            }
            frente = lista.frente;
            fin = lista.fin;
            iterador = null;
        }
    }

    @Override
    public int contar(Object elemento) {
        if(vacia()==false){
            int cont = 0;
            Nodo recorrer=frente;
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
            if(listaDatos2 instanceof ListaEncadenada){
                ListaEncadenada lista = (ListaEncadenada) listaDatos2;
                Nodo recorrer = lista.frente;
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
            while(cont!=cantidad){
                agregar(elemento);
                cont++;
            }
        }
    }

    @Override
    public Object clonar() {
        ListaEncadenada lista = new ListaEncadenada();
        inicializarIterador();
        while(iterador != null){
            lista.agregar(obtenerElemento());
        }
        return lista;
    }

    /**
     * Hace una sub lista de la lista actual, indicando de que posicion a que posicion seran los datos
     * de la nueva lista
     * @param indiceInicial Indica el inicio del rango
     * @param indiceFinal Indica el final del rango
     * @return Regresa una lista con los datos agregados, null en caso que los indices esten fuera de los limites
     */
    @Override
    public Object subLista(int indiceInicial, int indiceFinal) {
        if(!vacia()){
            if(indiceInicial>=0 || indiceFinal>=0 || indiceFinal>indiceInicial){
                int indice = 0;
                Nodo recorrer = frente;
                ListaEncadenada lista = new ListaEncadenada();
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
                Nodo recorrer = frente;
                ListaEncadenada lista = (ListaEncadenada) listaDatos2;
                while(recorrer != null){
                    if(Herramientas.compararObjetos(recorrer.getDato(),lista.frente) == 0){
                        Nodo recorrerL = lista.frente.getDirMemDer();
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
            ListaEncadenada lista = new ListaEncadenada();
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
            Nodo r = frente;
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
