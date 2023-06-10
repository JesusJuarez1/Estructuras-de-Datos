package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.*;
import herramientas.comunes.EtiquetaGrafoPonderado;
import herramientas.comunes.Herramientas;
import herramientas.comunes.TipoOrden;
import registros.Arista;
import registros.Vertice;

public class GrafoMatriz {
    //D�nde guardar los v�rtices
    protected ArregloDatos vertices;
    //D�nde guardar las aristas
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
        //Cuando se desea agregar un nuevo v�rtice, se debe verificar que ese dato no exista ya.
        //Para eso nos basaremos en el toString de datoVertice comparado contra lo que est� guardado en
        // el arreglo de v�rtices.
        Integer posicionVertice=(Integer)vertices.buscar(datoVertice);

        if (posicionVertice == null) { //no existe
            //crear el v�rtice y agregarlo
            Vertice verticeNuevo=new Vertice();

            verticeNuevo.setDescripcion(datoVertice);
            verticeNuevo.setIndice(vertices.cantidadElementos()); //posicion de cada vertice en el arreglo
            //y por lo tanto en la matriz
            int retornoInsercion=vertices.agregar(verticeNuevo);
            if (retornoInsercion>=0){ //si se pudo agregar, porque me regres� la psoci�n de agregado
                return true;
            }else{ //no se pudo agregar, fue un -1
                return false;
            }
        }else{ //si existe
            return false; // ya existe un v�rtice con esa descripci�n
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        return agregarArista(origen,destino,1.0);
    }

    public boolean agregarArista(Object origen, Object destino, double peso){
        //verificar que existan esos dos v�rtices
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
        SalidaTerminal.consola("Listado de v�rtices: \n");
        vertices.imprimir();

        SalidaTerminal.consola("La tabla de aristas: \n");
        aristas.imprimirR();
    }


    //----------M�todos de la ordenaci�n topol�gica

    //M�todo auxiliar para el paso 1
    private int dependenciasXVertice(int verticeDestino){
        int dependencias=0;
        //Recorrer todos los renglones (or�genes) que puede ser que lleguen al destino
        for(int cadaOrigen=0;cadaOrigen<aristas.getFilas();cadaOrigen++){
            //con base en la matriz (aristas) sabremos si hay o no flecha  que llegue al destino
            Double flecha=(Double)aristas.obtenerCelda(cadaOrigen, verticeDestino);
            if(flecha!=null && flecha.doubleValue()>0){ //hay flecha v�lida del origen a este destino
                dependencias++;
            }
        }
        return dependencias;
    }

    //M�todo del paso 1
    private void inicializarDependencias(ArregloDatos dependencias){
        //Recorrer todos los posibles v�rtices (destinos en la matriz), para calcular en cada uno de ellos
        //el n�mero de dependencias que tiene (flechas que le llegan)
        for(int cadaDestino=0;cadaDestino<aristas.getColumnas();cadaDestino++){
            //para cada uno de estos destinos, calculamos las incidencias, recorrer todos los renglones (origenes)
            //que mandan flechas a este v�rtice destino.
            int dependenciasXDestino= dependenciasXVertice(cadaDestino);
            dependencias.agregar(dependenciasXDestino); //se agregan al arreglo, que estaba vac�o
            //se guardan en la misma posici�n que el v�rtice definido por cadaDestino
        }
    }

    //paso 2, 5
    private void marcarYEncolarVerticesDepdencia0(ArregloDatos dependencias, ArregloDatos marcados, ArregloCola colaProcesamiento){
        for(int cadaVertice=0;cadaVertice<dependencias.cantidadElementos();cadaVertice++){
            //marcar y encolar solo los v�rtices con "dependencias en 0 y que no est�n marcados"
            if((int)dependencias.obtener(cadaVertice)==0 && (boolean)marcados.obtener(cadaVertice)==false){
                marcados.cambiar(cadaVertice,true); //marcamos ese v�rtice con dependencia en 0
                colaProcesamiento.poner(cadaVertice); //se mete en la cola
            }
        }
    }

    //paso 4
    private void recalcularDependenciasVertice(ArregloDatos dependencias, ArregloDatos marcados, int indiceVerticeActualmenteProcesado){
        for(int cadaDestino=0; cadaDestino<aristas.getColumnas(); cadaDestino++){
            //recorremos todos los destinos posibles que son susceptibles que tener una flecha a partir de el origen
            //del v�rtice actualmente procesado

            //obtener la celda de la tabla2d que me diga si hay flecha o no (solo v�rtices no marcados).
            Double flecha=(Double)aristas.obtenerCelda(indiceVerticeActualmenteProcesado, cadaDestino);
            if(flecha!=null && flecha.doubleValue()>0 && (boolean)marcados.obtener(cadaDestino)==false){
                //en caso que si haya flecha a ese v�rtice destino
                //actualizamos sus depedencias, reduciendo su valor en 1
                int dependenciaVerticeDestino=(int)dependencias.obtener(cadaDestino); //obtenemos su valor de dependencia
                dependencias.cambiar(cadaDestino, dependenciaVerticeDestino - 1 ); //lo reducimos en 1
            }
        }
    }

    //M�tdo principal
    public ListaEncadenada ordenacionTopologica(){
        //Recordar que para que una ordenaci�n topol�gica funcione, se requiere que
        //el grafo en cuesti�n no tenga ciclos.
        //Lo recomendado es que antes de invocar a este m�todo, se debe validar con alg�n otro
        //m�todo, la no existencia de ciclos.
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
        //Invocar al m�todo que realice la funci�n de marcar y encolar v�rtices con depedencia en 0
        marcarYEncolarVerticesDepdencia0(dependencias, marcados, colaProcesamiento);

        while(colaProcesamiento.vacio()==false) {
            //3.- Sacar un proceso de la cola y ejecutarlo
            //        (mientras haya datos en la cola).
            int indiceVerticeActualmenteProcesado=(int)colaProcesamiento.quitar();
            Vertice verticeActualmenteProcesado=(Vertice)vertices.obtener(indiceVerticeActualmenteProcesado);
            ordenacionTopologica.agregar(verticeActualmenteProcesado.getDescripcion()); //ejecutarlo significa agregarlo a nuestra ordenaci�n topol�gica (lista)

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
            //checamos si hay flecha de adyacencia y adem�s no est� marcado ese vecino
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
            //1.- Partiremos de un v�rtice origen. Este v�rtice se marca y se
            //mete en una pila.
            //Crear un lote de marcados con todo en falso
            marcados.rellenar(false,vertices.cantidadElementos());
            //Mqrcar este v�rtice
            marcados.cambiar(indiceVerticeOrigen, true);
            //Metemos en la pila este v�rtice
            pila.poner(indiceVerticeOrigen);

            while(pila.vacio()==false) {
                //2.- Mientras existan v�rtices en la pila, se van a extraer de uno por uno y se procesar�n (imprimirlos).
                int indiceVerticeActualmenteProceado=(int)pila.quitar(); //sacar de la pila el que sigue
                Vertice verticeActualmenteProcesado=(Vertice)vertices.obtener(indiceVerticeActualmenteProceado); //obtengo el v�rtice
                recorridoProfundidad.agregar(verticeActualmenteProcesado.getDescripcion()); //obtengo su descripci�n

                //3.- Los v�rtices adyacentes (no marcados) al nodo que actualmente se procesa (del paso 2)
                // se marcan y se meten en la pila.
                marcarYEnpilarVerticesAdyacentes(marcados, pila, indiceVerticeActualmenteProceado);
            }
            return recorridoProfundidad;
        }
    }
    //----------

    //----------C�digo de Primero la ruta m�s corta: Dijkstra
    public Double metricaOptima(Object origen, Object destino){
        Integer indiceDestino=(Integer)vertices.buscar(destino);
        ArregloDatos etiquetasOptimas=(ArregloDatos)etiquetasOptimas(origen);
        if(indiceDestino==null ||  etiquetasOptimas==null){ //no existe el destino o el origen
            return null; //no se puede calcular
        }else{ //sacamos la m�trica �ptima hacia ese destino
            EtiquetaGrafoPonderado etiquetaDestino=(EtiquetaGrafoPonderado) etiquetasOptimas.obtener(indiceDestino);
            return etiquetaDestino.getMetricaAcumulada();
        }
    }

    public ListaEncadenada rutaOptima(Object origen, Object destino){
        ListaEncadenada ruta=new ListaEncadenada();

        Integer indiceDestino=(Integer)vertices.buscar(destino);
        ArregloDatos etiquetasOptimas=(ArregloDatos)etiquetasOptimas(origen);
        if(indiceDestino==null ||  etiquetasOptimas==null){ //no existe el destino o el origen
            return null; //no se puede calcular
        }else{ //sacamos la ruta �ptima hacia ese destino usando el backtrace

            int indiceVerticeProcesado=indiceDestino; //es dodne empezamos de acuerdo al backtrace, empezando al �ltimo

            do {
                Vertice verticeProcesado = (Vertice) vertices.obtener(indiceVerticeProcesado);
                ruta.agregarInicio(verticeProcesado.getDescripcion()); //agregamos a la ruta la descripc�n del v�rtice procesado

                EtiquetaGrafoPonderado etiquetaVerticeProcesado = (EtiquetaGrafoPonderado) etiquetasOptimas.obtener(indiceVerticeProcesado);
                //actualizamos el nuevo v�rtice procesado al anterior del vertice procesado actual
                indiceVerticeProcesado = etiquetaVerticeProcesado.getVerticeAnterior();
            }while(indiceVerticeProcesado!=-1); //el -1 significa la ausencia de v�rticeAnterior (-), ese solo lo tiene le v�rticeOrigen
            return ruta;
        }
    }
    //paso 1
    private void inicializarEtiquetasOptimas(ArregloDatos etiquetasOptimas,int indiceVerticeOrigen, double metricaOrigen,
                                             double metricaVertices, int verticeAnteriorVertices ){
        for(int cadaVertice=0;cadaVertice<vertices.cantidadElementos();cadaVertice++){
            EtiquetaGrafoPonderado etiquetaNueva=new EtiquetaGrafoPonderado();
            etiquetaNueva.setIteracion(0);
            etiquetaNueva.setMetricaAcumulada(metricaVertices); //por ejemplo ponerles infinito
            etiquetaNueva.setVerticeAnterior(verticeAnteriorVertices); //por ejemplo ponerle el -
            etiquetasOptimas.agregar(etiquetaNueva); //agregamos al etiqueta
        }
        //al final, solo al v�rtice origen, cambiarle el valor de m�trica acumulada a 0, por ejemplo
        EtiquetaGrafoPonderado etiquetaVerticeOrigen= (EtiquetaGrafoPonderado) etiquetasOptimas.obtener(indiceVerticeOrigen);
        etiquetaVerticeOrigen.setMetricaAcumulada(metricaOrigen); //por ejmeplo 0
    }

    //paso 2, Calcular los nuevos valores de las etiquetas a partir de las m�tricas acumuladas hacia los vecinos
    //no marcados como permanentes, partiendo del v�rtice actual (si se mejora la m�trica, se actualiza la etiqueta).
    private void actualizarMetriculasAcumuladasOptimas(ArregloDatos etiquetasOptimas, ArregloDatos marcadosPermanentes,
                                                       int verticeActual, int iteracion, double infinito){
        for(int cadaVestino=0; cadaVestino<aristas.getColumnas();cadaVestino++){
            //recorrer todos los nodos del grafo y checar qui�n es adyacente al v�rttice actual y que no est� marcado
            Double metricaOrigenActualDestino=(Double) aristas.obtenerCelda(verticeActual, cadaVestino);
            if(metricaOrigenActualDestino!=null && metricaOrigenActualDestino!=0 && metricaOrigenActualDestino!=infinito &&
                    ((boolean)marcadosPermanentes.obtener(cadaVestino))==false){
                //dado que es vecino adyacente y no marcado, calcularemos las m�tricas acumuladas desde el v�rtice actual
                //a ese adyacente y si resulta mejor que la m�trica que tiene acumulada ese v�rtice adyacente, se substituye

                //sacamos la m�trica acumulada del v�rtice actual
                EtiquetaGrafoPonderado etiquetaVerticeActual= (EtiquetaGrafoPonderado) etiquetasOptimas.obtener(verticeActual);
                double metricaVerticeActual=etiquetaVerticeActual.getMetricaAcumulada();
                //sumamos la m�trica del v�rtice actual + la m�trica del vertice actual hacia el destino
                double metricaAcumuladaOrigenActualDestino=metricaVerticeActual+metricaOrigenActualDestino;

                //Obtener la m�trica de la etiqueta del destino
                EtiquetaGrafoPonderado etiquetaVerticeDestino=(EtiquetaGrafoPonderado) etiquetasOptimas.obtener(cadaVestino);
                double metricaVerticeDestino=etiquetaVerticeDestino.getMetricaAcumulada();
                //Comparar si es mejor la metrica acumulada del origen actual hacia el destino que la m�trica del detino
                //Solo checar a partir de si es DESC o ASC
                boolean actualizarEtiquetaDestino=false;
                if(orden==TipoOrden.DESCENDENTE){ //significa que mientras m�s peque�o es mejor
                    if(metricaAcumuladaOrigenActualDestino<metricaVerticeDestino){
                        // es m�s �ptima, se debe actualizar la etiqueta del destino
                        actualizarEtiquetaDestino=true;
                    }
                }else{ //ASC, significa que el valor m�s grande es mejor
                    if(metricaAcumuladaOrigenActualDestino>metricaVerticeDestino){
                        // es m�s �ptima, se debe actualizar la etiqueta del destino
                        actualizarEtiquetaDestino=true;
                    }
                }
                if (actualizarEtiquetaDestino==true){ //actualizar etiqueta destino
                    etiquetaVerticeDestino.setMetricaAcumulada(metricaAcumuladaOrigenActualDestino);
                    etiquetaVerticeDestino.setVerticeAnterior(verticeActual);
                    etiquetaVerticeDestino.setIteracion(iteracion);
                } //if
            }//if de adycencia y no marcado
        } //del ciclo for
    }

    //paso 3
    private int obtenerVerticeMetricaOptima(ArregloDatos etiquetasOptimas, ArregloDatos marcadosPermanentes, double infinito){
        //Lo primero que se hace cuando se quiere obtener el m�s chico o el m�s grande de un arreglo
        //es asumir que el PRIMERO (que el infinito va a ser el �ptimo inicial) es el m�s chico o m�s grande y
        // despu�s todos los comparamos con ese
        //si es mejor alguno de ellos, este se vuelve el nuevo mejor
        double mejorMetrica=infinito; //es la m�trica inicial �ptima
        int verticeOptimo=-1; //no lo conozco por ahora

        //Obtener el mejor (m�s peque�o o grande) del arreglo de TODAS las etiquetas no marcadas
        for(int cadaVertice=0;cadaVertice<vertices.cantidadElementos();cadaVertice++){
            if(((boolean)marcadosPermanentes.obtener(cadaVertice))==false){ //no est� marcado es destino
                EtiquetaGrafoPonderado etiquetaCadaVertice=(EtiquetaGrafoPonderado) etiquetasOptimas.obtener(cadaVertice);
                double metricCadaVertice=etiquetaCadaVertice.getMetricaAcumulada(); //obtengo la m�trica del destino
                //comapramos esta m�trica paraver si es mejor que la que yo ya tenia como la mejor
                //no olvidar considerar el DESC o ASC
                if(orden==TipoOrden.DESCENDENTE){ //m�s chico es mejor
                    if(metricCadaVertice<mejorMetrica){ //significa que la m�trica del v�rtice es mejor que la de antes
                        mejorMetrica=metricCadaVertice; //cambiamos la mejor m�trica
                        verticeOptimo=cadaVertice;//cambiamos el v�rtice �ptimo
                    }
                }else{ //ASC, m�s grande es mejor
                    if(metricCadaVertice>mejorMetrica){ //significa que la m�trica del v�rtice es mejor que la de antes
                        mejorMetrica=metricCadaVertice; //cambiamos la mejor m�trica
                        verticeOptimo=cadaVertice;//cambiamos el v�rtice �ptimo
                    }
                }
            }
        } //del for
        return verticeOptimo; //regresamos el v�rtice on la m�trica m�s chica o m�s grande seg�n TipoOrden
    }

    //M�todo que calcula las etiquetas
    public ArregloDatos etiquetasOptimas(Object origen){
        ArregloDatos etiquetasOptimas=new ArregloDatos(vertices.cantidadElementos());
        ArregloDatos marcadosPermanentes=new ArregloDatos(vertices.cantidadElementos());
        double infinito=0.0;

        if(orden==TipoOrden.DESCENDENTE){ //quiere decir que mientras m�s chico mejor, por ejemplo tiempo o distancia
            infinito= Double.MAX_VALUE; //+ infinito
        }else{ //ASC, quiere decir que mientras m�s grande mejor, por ejemplo la velocidad en un enlace de una red de comp.
            infinito=Double.MIN_VALUE; // -infinito
        }

        //0. Validar que el v�rtice origen exista
        Integer indiceVerticeOrigen=(Integer)vertices.buscar(origen);
        if(indiceVerticeOrigen==null){ //no existe ese v�rtice
            return null;
        }else { //si existe el v�rtice origen
            //1.- Inicializar etiquetas, partiendo de un nodo origen, marcar como permanente ese nodo.
            inicializarEtiquetasOptimas(etiquetasOptimas,indiceVerticeOrigen, 0.0, infinito, -1 );
            int verticeActual=indiceVerticeOrigen; //donde comenzamos
            marcadosPermanentes.rellenar(false,marcadosPermanentes.capacidad()); //rellenamos todo como no marcado
            marcadosPermanentes.cambiar(indiceVerticeOrigen,true); //marcamos el v�rtice origen

            for(int iteracion=1; iteracion<vertices.cantidadElementos(); iteracion++) { //el n�mero de v�rtices -1
                //Repetir pasos 2 y 3
                //2.-Calcular los nuevos valores de las etiquetas a partir de las m�tricas acumuladas hacia los vecinos
                //no marcados como permanentes, partiendo del v�rtice actual (si se mejora la m�trica, se actualiza la etiqueta).
                actualizarMetriculasAcumuladasOptimas(etiquetasOptimas, marcadosPermanentes, verticeActual, iteracion, infinito);

                //3.- Elegir el v�rtice con la mejor m�trica acumulada que no est� marcado,
                // se marca y se vuelve el v�rtice actual.
                verticeActual=obtenerVerticeMetricaOptima(etiquetasOptimas, marcadosPermanentes, infinito); //el �ptimo se vuelve el actual
                marcadosPermanentes.cambiar(verticeActual, true); //lo marcamos
            }
            return etiquetasOptimas;
        }
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



    public GrafoMatriz kruskal(){
        GrafoMatriz grafo = new GrafoMatriz(vertices.cantidadElementos(),orden);
        for(int vertice=0;vertice<vertices.cantidadElementos();vertice++){//Se agregan los vertices al nuevo grafo
            grafo.agregarVertice(((Vertice)vertices.obtener(vertice)).getDescripcion());
        }
        double infinito = 0.0;
        if(orden==TipoOrden.DESCENDENTE){
            infinito= Double.MAX_VALUE;
        }else{
            infinito=Double.MIN_VALUE;
        }
        Tabla2D marcadas = new Tabla2D(aristas.getFilas(),aristas.getColumnas(),false);
        ArregloDatos marcados = new ArregloDatos(vertices.cantidadElementos());
        marcados.rellenar(false);
        while(true){
            Arista aristaMenorNoMarcada = obtenerAristaMenor(marcadas,marcados,infinito);
            if(aristaMenorNoMarcada == null){
                return grafo;
            }
            SalidaTerminal.consola(aristaMenorNoMarcada.toString()+"\n");
        }
    }

    private Arista obtenerAristaMenor(Tabla2D marcadas,ArregloDatos marcados,double infinito){
        Arista menor = null;
        for(int origen=0;origen<aristas.getFilas();origen++){
            for(int destino=0;destino<aristas.getColumnas();destino++){
                if((Boolean)marcadas.obtenerCelda(origen,destino)==false){//Si no esta marcada entra
                    if((Boolean)marcados.obtener(origen)==false){//Si el origen no esta marcado
                        Double peso = (Double) aristas.obtenerCelda(origen,destino);
                        if(peso!=null && peso!= 0.0 && peso!=infinito){
                            if(menor == null) {
                                menor = new Arista(origen, destino, peso);
                            }else{
                                if(orden==TipoOrden.DESCENDENTE) {
                                    if ((Double) aristas.obtenerCelda(menor.getOrigen(), menor.getDestino()) > peso) {
                                        menor = new Arista(origen, destino, peso);
                                    }
                                }else{
                                    if ((Double) aristas.obtenerCelda(menor.getOrigen(), menor.getDestino()) < peso) {
                                        menor = new Arista(origen, destino, peso);
                                    }
                                }
                            }
                        }
                    }else{
                        if((Boolean)marcados.obtener(destino)==false){//Si el origen esta marcado y el destino no lo esta
                            Double peso = (Double) aristas.obtenerCelda(origen,destino);
                            if(peso!=null && peso!= 0.0 && peso!=infinito){
                                if(menor == null) {
                                    menor = new Arista(origen, destino, peso);
                                }else{
                                    if(orden==TipoOrden.DESCENDENTE) {
                                        if ((Double) aristas.obtenerCelda(menor.getOrigen(), menor.getDestino()) > peso) {
                                            menor = new Arista(origen, destino, peso);
                                        }
                                    }else{
                                        if ((Double) aristas.obtenerCelda(menor.getOrigen(), menor.getDestino()) < peso) {
                                            menor = new Arista(origen, destino, peso);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(menor != null){
            marcadas.asignarCelda(menor.getOrigen(),menor.getDestino(),true);//Marcamos la arista O-D
            marcadas.asignarCelda(menor.getDestino(),menor.getDestino(),true);//Marcamos la arista D-O
            marcados.cambiar(menor.getOrigen(),true);//Marcamos el origen
            marcados.cambiar(menor.getDestino(),true);//Marcamos el destino
            return menor;
        }else{
            return null;
        }
    }






    public GrafoMatriz prim(){
        GrafoMatriz grafo = new GrafoMatriz(vertices.cantidadElementos(),orden);
        ArregloDatos marcados=new ArregloDatos(vertices.cantidadElementos());
        double infinito=0.0;
        //Se agregan los vertices al nuevo grafo
        for(int posicion=0;posicion<vertices.cantidadElementos();posicion++){
            grafo.agregarVertice(((Vertice)vertices.obtener(posicion)).getDescripcion());
        }
        if(orden==TipoOrden.DESCENDENTE){
            infinito= Double.MAX_VALUE;
        }else{
            infinito=Double.MIN_VALUE;
        }
        marcados.rellenar(false);
        marcados.cambiar(0,true);
        int actual = 0;
        while(true){
            Double menor = null;
            int dest = -1;
            for(int destino=0;destino<aristas.getColumnas();destino++){
                Double peso = (Double) aristas.obtenerCelda(actual,destino);
                if(peso!=null && peso!=0.0 && peso!=infinito){
                    if((Boolean)marcados.obtener(destino)==false){
                        if(menor==null){
                            menor = peso;
                            dest = destino;
                        }else{
                            if(orden==TipoOrden.DESCENDENTE){
                                if(menor > peso){
                                    menor = peso;
                                    dest = destino;
                                }
                            }else{
                                if(menor < peso){
                                    menor = peso;
                                    dest = destino;
                                }
                            }
                        }
                    }
                }
            }
            if(menor == null){
                return grafo;
            }else{
                grafo.agregarArista(actual,dest,menor);
                grafo.agregarArista(dest,actual,menor);
                marcados.cambiar(dest,true);
                actual = dest;
            }
        }
    }
}

