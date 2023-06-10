package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.*;
import herramientas.comunes.TipoOrden;
import registros.Vertice;

public class GrafoMatriz {
    //Dónde guardar los vértices
    protected ArregloDatos vertices;
    //Dónde guardar las aristas
    protected Tabla2D aristas;
    //Define el orden de importancia de los pesos
    protected TipoOrden orden;

    public GrafoMatriz(int cantidadVertices){
        vertices=new ArregloDatos(cantidadVertices);
        aristas=new Tabla2D(cantidadVertices,cantidadVertices,0.0);
    }

    public GrafoMatriz(int cantVertices, TipoOrden orden){
        vertices=new ArregloDatos(cantVertices);
        this.orden=orden;
        if(this.orden==TipoOrden.DESCENDENTE){ //menor es mejor
            aristas=new Tabla2D(cantVertices,cantVertices,Double.MAX_VALUE); //+ infinito
        }else{ //mayor es mejor, ASC
            aristas=new Tabla2D(cantVertices,cantVertices,Double.MIN_VALUE); //- infinito
        }
        aristas.diagonal(0.0); //ponemos la diagonal en ceros
    }

    public boolean agregarVertice(Object datoVertice){
        //Cuando se desea agregar un nuevo vértice, se debe verificar que ese dato no exista ya.
        //Para eso nos basaremos en el toString de datoVertice comparado contra lo que está guardado en
        // el arreglo de vértices.
        Integer posicionVertice=(Integer)vertices.buscar(datoVertice);

        if (posicionVertice == null) { //no existe
            //crear el vértice y agregarlo
            Vertice verticeNuevo=new Vertice();

            verticeNuevo.setDescripcion(datoVertice);
            verticeNuevo.setIndice(vertices.cantidadElementos()); //posicion de cada vertice en el arreglo
            //y por lo tanto en la matriz
            int retornoInsercion=vertices.agregar(verticeNuevo);
            if (retornoInsercion>=0){ //si se pudo agregar, porque me regresó la psoción de agregado
                return true;
            }else{ //no se pudo agregar, fue un -1
                return false;
            }
        }else{ //si existe
            return false; // ya existe un vértice con esa descripción
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen,destino,1.0);
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        //verificar que existan esos dos vértices
        Integer posicionOrigen=(Integer)vertices.buscar(origen);
        Integer posicionDestino=(Integer)vertices.buscar(destino);

        if(posicionOrigen!=null && posicionDestino!=null){ //si existen los dos
            //si ya existen, podemos agregar la arista
            return aristas.asignarCelda(posicionOrigen,posicionDestino,peso);
        }else{ //por lo menos uno no existe
            return false;
        }
    }

    public void imprimir(){
        SalidaTerminal.consola("Listado de vértices: \n");
        vertices.imprimir();

        SalidaTerminal.consola("La tabla de aristas: \n");
        aristas.imprimirR();
    }


    //----------Métodos de la ordenación topológica

    //Método auxiliar para el paso 1
    private int dependenciasXVertice(int verticeDestino){
        int dependencias=0;
        //Recorrer todos los renglones (orígenes) que puede ser que lleguen al destino
        for(int cadaOrigen=0;cadaOrigen<aristas.getFilas();cadaOrigen++){
            //con base en la matriz (aristas) sabremos si hay o no flecha  que llegue al destino
            Double flecha=(Double)aristas.obtenerCelda(cadaOrigen, verticeDestino);
            if(flecha!=null && flecha.doubleValue()>0){ //hay flecha válida del origen a este destino
                dependencias++;
            }
        }
        return dependencias;
    }

    //Método del paso 1
    private void inicializarDependencias(ArregloDatos dependencias){
        //Recorrer todos los posibles vértices (destinos en la matriz), para calcular en cada uno de ellos
        //el número de dependencias que tiene (flechas que le llegan)
        for(int cadaDestino=0;cadaDestino<aristas.getColumnas();cadaDestino++){
            //para cada uno de estos destinos, calculamos las incidencias, recorrer todos los renglones (origenes)
            //que mandan flechas a este vértice destino.
            int dependenciasXDestino= dependenciasXVertice(cadaDestino);
            dependencias.agregar(dependenciasXDestino); //se agregan al arreglo, que estaba vacío
            //se guardan en la misma posición que el vértice definido por cadaDestino
        }
    }

    //paso 2, 5
    private void marcarYEncolarVerticesDepdencia0(ArregloDatos dependencias, ArregloDatos marcados, ArregloCola colaProcesamiento){
        for(int cadaVertice=0;cadaVertice<dependencias.cantidadElementos();cadaVertice++){
            //marcar y encolar solo los vértices con "dependencias en 0 y que no estén marcados"
            if((int)dependencias.obtener(cadaVertice)==0 && (boolean)marcados.obtener(cadaVertice)==false){
                marcados.cambiar(cadaVertice,true); //marcamos ese vértice con dependencia en 0
                colaProcesamiento.poner(cadaVertice); //se mete en la cola
            }
        }
    }

    //paso 4
    private void recalcularDependenciasVertice(ArregloDatos dependencias, ArregloDatos marcados, int indiceVerticeActualmenteProcesado){
        for(int cadaDestino=0; cadaDestino<aristas.getColumnas(); cadaDestino++){
            //recorremos todos los destinos posibles que son susceptibles que tener una flecha a partir de el origen
            //del vértice actualmente procesado

            //obtener la celda de la tabla2d que me diga si hay flecha o no (solo vértices no marcados).
            Double flecha=(Double)aristas.obtenerCelda(indiceVerticeActualmenteProcesado, cadaDestino);
            if(flecha!=null && flecha.doubleValue()>0 && (boolean)marcados.obtener(cadaDestino)==false){
                //en caso que si haya flecha a ese vértice destino
                //actualizamos sus depedencias, reduciendo su valor en 1
                int dependenciaVerticeDestino=(int)dependencias.obtener(cadaDestino); //obtenemos su valor de dependencia
                dependencias.cambiar(cadaDestino, dependenciaVerticeDestino - 1 ); //lo reducimos en 1
            }
        }
    }

    //Métdo principal
    public ListaEncadenada ordenacionTopologica(){
        //Recordar que para que una ordenación topológica funcione, se requiere que
        //el grafo en cuestión no tenga ciclos.
        //Lo recomendado es que antes de invocar a este método, se debe validar con algún otro
        //método, la no existencia de ciclos.
        ListaEncadenada ordenacionTopologica=new ListaEncadenada();
        ArregloCola colaProcesamiento=new ArregloCola(vertices.cantidadElementos());
        ArregloDatos dependencias=new ArregloDatos(vertices.cantidadElementos());
        ArregloDatos marcados=new ArregloDatos(vertices.cantidadElementos());

        //Pasos:

        //0.- Checar no existencia de ciclos.

        //1.- Inicializar dependencias (incidencias).
        inicializarDependencias(dependencias);
        //2.- Los procesos con dependencias en 0 (no marcados)* se
        //colocan en una cola de procesamiento y se marcan como ya analizados.

        //Inicializar el arreglo de marcados con valores en FALSE
        marcados.rellenar(false,vertices.cantidadElementos());
        //Invocar al método que realice la función de marcar y encolar vértices con depedencia en 0
        marcarYEncolarVerticesDepdencia0(dependencias, marcados, colaProcesamiento);

        while(colaProcesamiento.vacio()==false) {
            //3.- Sacar un proceso de la cola y ejecutarlo
            //        (mientras haya datos en la cola).
            int indiceVerticeActualmenteProcesado=(int)colaProcesamiento.quitar();
            Vertice verticeActualmenteProcesado=(Vertice)vertices.obtener(indiceVerticeActualmenteProcesado);
            ordenacionTopologica.agregar(verticeActualmenteProcesado.getDescripcion()); //ejecutarlo significa agregarlo a nuestra ordenación topológica (lista)

            //4.- Recalcular dependencia dado el paso 3.
            recalcularDependenciasVertice(dependencias, marcados, indiceVerticeActualmenteProcesado);

            //5.- Los procesos con dependencias en 0 (no marcados) se colocan en la cola y se
            // marcan como analizados.
            marcarYEncolarVerticesDepdencia0(dependencias, marcados, colaProcesamiento);
        }
        return ordenacionTopologica;
    }
    //----------

    //---------- Recorrido en profundidad

    //paso 3 de recorrido en profundidad
    private void marcarYEnpilarVerticesAdyacentes(ArregloDatos marcados, ArregloPila pila, int indiceVerticeActualmenteProceado){
        for(int cadaDestino=0;cadaDestino<aristas.getColumnas();cadaDestino++){
            //checamos si hay flecha de adyacencia y además no está marcado ese vecino
            Double flecha= (Double)aristas.obtenerCelda(indiceVerticeActualmenteProceado,cadaDestino);
            if(flecha!=null && flecha.doubleValue()>0 && ((boolean)marcados.obtener(cadaDestino))==false){
                marcados.cambiar(cadaDestino,true); //lo marcamos
                pila.poner(cadaDestino); //lo enpilamos
            }
        }
    }

    public ListaEncadenada recorridoProfundidad(Object origen){
        ListaEncadenada recorridoProfundidad=new ListaEncadenada();
        ArregloPila pila=new ArregloPila(vertices.cantidadElementos());
        ArregloDatos marcados=new ArregloDatos(vertices.cantidadElementos());

        //Pasos:
        //0.- Verificar que el origen si exista
        Integer indiceVerticeOrigen=(Integer)vertices.buscar(origen);

        if(indiceVerticeOrigen==null){ //el origen no existem no se puede hacer un reocrrido
            return null;
        }else{
            //1.- Partiremos de un vértice origen. Este vértice se marca y se
            //mete en una pila.
            //Crear un lote de marcados con todo en falso
            marcados.rellenar(false,vertices.cantidadElementos());
            //Mqrcar este vértice
            marcados.cambiar(indiceVerticeOrigen, true);
            //Metemos en la pila este vértice
            pila.poner(indiceVerticeOrigen);

            while(pila.vacio()==false) {
                //2.- Mientras existan vértices en la pila, se van a extraer de uno por uno y se procesarán (imprimirlos).
                int indiceVerticeActualmenteProceado=(int)pila.quitar(); //sacar de la pila el que sigue
                Vertice verticeActualmenteProcesado=(Vertice)vertices.obtener(indiceVerticeActualmenteProceado); //obtengo el vértice
                recorridoProfundidad.agregar(verticeActualmenteProcesado.getDescripcion()); //obtengo su descripción

                //3.- Los vértices adyacentes (no marcados) al nodo que actualmente se procesa (del paso 2)
                // se marcan y se meten en la pila.
                marcarYEnpilarVerticesAdyacentes(marcados, pila, indiceVerticeActualmenteProceado);
            }
            return recorridoProfundidad;
        }
    }
    //----------

    //----------Código de Primero la ruta más corta: Dijkstra
    public Double metricaOptima(Object origen, Object Destino){

        return 0.0;
    }

    public ListaEncadenada rutaOptima(Object origen, Object destino){

        return null;
    }

    //Método que calcula las etiquetas
    private ArregloDatos etiquetasOptimas(Object origen){
        ArregloDatos etiquetasOptimas=new ArregloDatos(vertices.cantidadElementos());
        ArregloDatos marcadosPermanentes=new ArregloDatos(vertices.cantidadElementos());

        //0. Validar que el vértice origen exista
        //1.- Inicializar etiquetas, partiendo de un nodo origen, marcar como permanente ese nodo.

        //Repetir pasos 2 y 3
        //2.-Calcular los nuevos valores de las etiquetas a partir de las métricas acumuladas hacia los vecinos
        //no marcados como permanentes, partiendo del vértice actual (Si se mejora la métrica, se actualiza la etiqueta).
        //3.- Elegir el vértice con la mejor métrica acumulada, se marca y se vuelve el vértice actual.

        return null;
    }

    //----------


    //--------------------

    /**
     * Elimina un vertice del grafo
     * @param vertice Vertice a eliminar
     * @return true si lo elimino, false en caso contrario
     */
    public boolean eliminarVertice(Object vertice){
        Integer pos = (Integer) vertices.buscar(vertice);
        if(pos != null){
            Vertice vert = (Vertice) vertices.obtener(pos);
            if(aristas.quitarFila(vert.getIndice()) && aristas.quitarColumna(vert.getIndice())){
                ArregloDatos tmp = new ArregloDatos(vertices.capacidad()-1);
                for(int i=0;i<vertices.cantidadElementos();i++){
                    if(i != vert.getIndice()){
                        tmp.agregar(vertices.obtener(i));
                    }
                }
                vertices = tmp;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Verifica si dos nodos son adyacentes
     * @param origen Origen
     * @param destino Destino
     * @return True si lo son, false en caso contrario
     */
    public boolean esAdyacente(Object origen,Object destino){
        Vertice vOrigen = buscarVertice(origen);
        Vertice vDestino = buscarVertice(destino);
        if(vOrigen != null && vDestino != null){
            if((Double)aristas.obtenerCelda(vOrigen.getIndice(),vDestino.getIndice()) != 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /**
     * Elimina una arista entre dos nodos
     * @param origen Origen de la arista
     * @param destino Destino de la arista
     * @return True si lo hace, false en caso contrario
     */
    public boolean eliminarArista(Object origen,Object destino){
        Vertice vOrigen = buscarVertice(origen);
        Vertice vDestino = buscarVertice(destino);
        if(vOrigen != null && vDestino != null){
            return aristas.asignarCelda(vOrigen.getIndice(),vDestino.getIndice(),0.0);
        }else{
            return false;
        }
    }

    /**
     * Busca un nodo en un grafo
     * @param vertice Vertice a buscar
     * @return El vertice encontrado
     */
    public Vertice buscarVertice(Object vertice){
        Integer posicion = (Integer) vertices.buscar(vertice);
        if(posicion != null){
            return (Vertice)vertices.obtener(posicion);
        }else{
            return null;
        }
    }

    /**
     * Verifica si el grafo contiene lazos o bucles
     * @return True si tiene, false en caso contrario
     */
    public boolean esPseudografo(){
        for(int posicion=0;posicion<vertices.cantidadElementos();posicion++){
            Vertice vertice = (Vertice) vertices.obtener(posicion);
            if((Double)aristas.obtenerCelda(vertice.getIndice(),vertice.getIndice()) != 0.0){
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica si al menos dos de sus vertices estan conectados entre si por dos aristas paralelas
     * @return True si lo estan, false en caso contrario
     */
    public boolean esMultigrafo(){
        for(int posicion=0;posicion<vertices.cantidadElementos();posicion++){
            Vertice vertice = (Vertice) vertices.obtener(posicion);
            for(int posicion2=0;posicion2<vertices.cantidadElementos();posicion2++){
                if(posicion != posicion2){
                    Vertice v = (Vertice) vertices.obtener(posicion2);
                    if((Double)aristas.obtenerCelda(vertice.getIndice(),v.getIndice()) != 0.0 &&
                            (Double)aristas.obtenerCelda(v.getIndice(),vertice.getIndice()) != 0.0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Obtiene el numero de aristas de un vertice
     * @param vertice Vertice a obtener sus aristas
     * @return El numero de vertices que contiene el vertice, -1 si no existe el vertice
     */
    public int gradoVertice(Object vertice){
        Vertice ver = buscarVertice(vertice);
        if(ver != null){
            int grado = 0;
            for(int col=0;col<aristas.getColumnas();col++){
                if((Double)aristas.obtenerCelda(ver.getIndice(),col) != 0.0){
                    grado++;
                }
            }
            return grado;
        }else{
            return -1;
        }
    }


    /**
     * Determina si el grafo es dirigido o no
     * @return True si lo es, false en caso contrario
     */
    public boolean esDirigido(){
        int cont=0;
        int contador=0;
        for(int filas=0;filas<aristas.getFilas();filas++){
            for(int columnas=0;columnas< aristas.getColumnas();columnas++){
                if((Double)aristas.obtenerCelda(filas,columnas) != 0.0 && (Double)aristas.obtenerCelda(columnas,filas) != 0.0){
                    cont++;
                }
                contador++;
            }
        }
        if(cont == contador){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Lista todas aristas del grafo
     */
    public void listarAristas(){
        SalidaTerminal.consola("[");
        for(int posicion=0;posicion<vertices.cantidadElementos();posicion++){
            listarAristas(vertices.obtener(posicion));
            if(posicion < vertices.cantidadElementos()-1){
                SalidaTerminal.consola(", ");
            }
        }
        SalidaTerminal.consola("]");
    }

    /**
     * Lista todas las aristas del vertice dado en formato (origen, destino, peso)
     * @param vertice Vertice a imprimir las aristas
     */
    public void listarAristas(Object vertice){
        Integer posicion = (Integer) vertices.buscar(vertice);
        if(posicion != null){
            Vertice origen = (Vertice) vertices.obtener(posicion);
            for(int pos=0;pos<vertices.cantidadElementos();pos++){
                Vertice destino = (Vertice)vertices.obtener(pos);
                if((Double)aristas.obtenerCelda(origen.getIndice(),destino.getIndice()) != 0.0){
                    SalidaTerminal.consola("("+origen.toString()+","+destino.toString()+","+
                            aristas.obtenerCelda(origen.getIndice(),destino.getIndice())+")");
                    if(pos < vertices.cantidadElementos()-1){
                        SalidaTerminal.consola(",");
                    }
                }
            }
        }
    }

    /**
     * Muestra los vertices del grafo
     */
    public void listarVertices(){
        vertices.imprimir();
    }
}

