package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.*;
import registros.Arista;
import registros.Vertice;

public class GrafoListaAdyacencia {
    protected ListaEncadenada listaAdyacencia; //es la lista que va a guardar listas

    public GrafoListaAdyacencia(){
        listaAdyacencia=new ListaEncadenada();
    }

    private ListaEncadenada buscarVerticeEnListaA(Object datoVertice){
        //Recorrer la lista de Adyacencia para buscar si cada sublista  (en su primer elemento)
        //es el v�rtice que queremos encontrar

        listaAdyacencia.inicializarIterador();

        while(listaAdyacencia.hayElementos()==true){ //recorrer todos los elementos de LA
            //sacar un elemento de la LA
            ListaEncadenada listaCadaVertice=(ListaEncadenada)listaAdyacencia.obtenerElemento();
            //checar si el primer elemento de esa lista de cada v�rtice es el datoVertice a buscar
            Vertice primerVerticeCadaLista=(Vertice)listaCadaVertice.regresarFrente(); //sacamos el primer elemento de la sublista
            //verificar si es el que busco
            if(primerVerticeCadaLista.toString().equalsIgnoreCase(datoVertice.toString())==true){ //lo encontramos
                return listaCadaVertice;
            }
        }
        //si llega el apuntador de la MVJ a este punto, significa que no lo encontr�
        return null;
    }

    public boolean agregarVertice(Object datoVertice){
        //Antes de agregar un v�rtice, debemos checar si no existe
        //Para eso debemos buscar en la primera posici�n de cada sublista si existe o no.
        ListaEncadenada listaVerticeAAgregar=buscarVerticeEnListaA(datoVertice);

        if(listaVerticeAAgregar==null){ //no existe ese v�rtice, podemos agregarlo
            ListaEncadenada listaNuevoVertice=new ListaEncadenada(); //creamos la lista del nuevo v�rtice
            Vertice nuevoVertice=new Vertice(); //creamos un v�rtice
            nuevoVertice.setDescripcion(datoVertice); //asignamos su dato
            //lo agregamos como cabeza de la lista nueva
            listaNuevoVertice.agregar(nuevoVertice); //agregamos ese v�rticen uevo como cabeza de su lista

            int valorRetornoA=listaAdyacencia.agregar(listaNuevoVertice);//agregar esa lista de ese v�rtice a la lista de adyacencia
            if(valorRetornoA>0) { //si se s pudo agregar
                return true;
            }else{ //no se pudo agregar
                return false;
            }
        }else{ //ya existe ese v�rtice
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        //Primero checar que estos v�rtices existan
        ListaEncadenada listaOrigen=buscarVerticeEnListaA(origen);
        ListaEncadenada listaDestino=buscarVerticeEnListaA(destino);

        if(listaOrigen!=null && listaDestino!=null){ //existen ambos
            //sacar el v�rtice destino de la lista destino
            Vertice verticeDestino=(Vertice)listaDestino.regresarFrente(); //sacamos el v�rtice destino de la lsat destino
            //agregar ese v�rtice destino en la lista origen
            int valorRetornoA=listaOrigen.agregar(verticeDestino);
            if(valorRetornoA>0){ //si se pudo agregar
                return true;
            }else{ //no se pudo agregar
                return false;
            }
        }else{ //no existen
            return false;
        }
    }

    //---------- Recorrido en profundidad

    //paso 3 de recorrido en profundidad
    private void marcarYEnpilarVerticesAdyacentes(ListaEncadenada marcados, ListaPila pila,
                                                  ListaEncadenada listaVerticeActualmenteProceado){
        //recorremos la lista del v�rtice actualmente procesado, n donde vienen ya su adyacentes
        listaVerticeActualmenteProceado.inicializarIterador(); //inicalizamos el iterador
        listaVerticeActualmenteProceado.obtenerElemento(); //brincarme el primero, ya que ese no es arista

        //empezamos a partir de lsegundo (aristas)
        while(listaVerticeActualmenteProceado.hayElementos()==true){
            Vertice verticeAdyacente=(Vertice) listaVerticeActualmenteProceado.obtenerElemento(); //sacamos un adyacente
            //checar que no est� marcado,
            if(marcados.buscar(verticeAdyacente.getDescripcion())==null){ //no est� en el lisado de marcados
                marcados.agregar(verticeAdyacente); //lo marcamos
                pila.poner(verticeAdyacente); //lo metemos en la pila
            }
        }
    }

    public ListaEncadenada recorridoProfundidad(Object origen){
        ListaEncadenada recorridoProfundidad=new ListaEncadenada();
        ListaPila pila=new ListaPila();
        ListaEncadenada marcados=new ListaEncadenada();

        //Pasos:
        //0.- Verificar que el origen si exista
        ListaEncadenada listaOrigen=buscarVerticeEnListaA(origen);

        if(listaOrigen==null){ //el origen no existem no se puede hacer un recorrido
            return null;
        }else{ //si existe el origen
            //1.- Partiremos de un v�rtice origen. Este v�rtice se marca y se
            //mete en una pila.
            //Extraer el v�rtice para poderlo procesar en las fases
            Vertice verticeOrigen=(Vertice)listaOrigen.regresarFrente();
            //Mqrcar este v�rtice
            marcados.agregar(verticeOrigen);
            //Metemos en la pila este v�rtice
            pila.poner(verticeOrigen);

            while(pila.vacio()==false) {
                //2.- Mientras existan v�rtices en la pila, se van a extraer de uno por uno y se procesar�n (imprimirlos).
                Vertice verticeActualmenteProcesado=(Vertice)pila.quitar(); //sacar de la pila el que sigue
                recorridoProfundidad.agregar(verticeActualmenteProcesado.getDescripcion()); //obtengo su descripci�n

                //3.- Los v�rtices adyacentes (no marcados) al nodo que actualmente se procesa (del paso 2)
                // se marcan y se meten en la pila.
                //PRIMERO OBTENER LA LISTA DEL VERTICE ACTUALMENTE PROCESADO
                ListaEncadenada listaVErticeActualmenteProcesado=buscarVerticeEnListaA(verticeActualmenteProcesado.getDescripcion());
                marcarYEnpilarVerticesAdyacentes(marcados, pila, listaVErticeActualmenteProcesado);
            }
            return recorridoProfundidad;
        }
    }
    //----------


    public void imprimir(){
        //Recorrer la lsita principal e ir sacando las sublistas
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayElementos()==true){
            ListaEncadenada listaCadaVertice=(ListaEncadenada) listaAdyacencia.obtenerElemento();
            listaCadaVertice.imprimir();
            SalidaTerminal.consola("\n");
        }
    }

    /**
     * Obtiene todos los componentes conexos del grafo comenzando sobre un vertice dado
     * Cada componente conexo es una ListaEncadenada la cual se agrega a la lista que se regresa.
     * @param origen Nodo del cual se quiere comenzar
     * @return Una ListaEncadenada la cual contiene todos los componentes conexos (ListasEncadenadas), null en caso contrario
     */
    public ListaEncadenada componenetesConexos(Object origen){
        ListaEncadenada componentesConexos=new ListaEncadenada();
        ListaPila pila=new ListaPila();
        ListaEncadenada marcados=new ListaEncadenada();

        //Pasos:
        //0.- Verificar que el origen si exista
        ListaEncadenada listaOrigen=buscarVerticeEnListaA(origen);

        if(listaOrigen==null){ //el origen no existem no se puede hacer un recorrido
            return null;
        }else{ //si existe el origen
            //1.- Partiremos de un v�rtice origen. Este v�rtice se marca y se
            //mete en una pila.
            //Extraer el v�rtice para poderlo procesar en las fases
            Vertice verticeOrigen=(Vertice)listaOrigen.regresarFrente();
            //Mqrcar este v�rtice
            marcados.agregar(verticeOrigen);
            //Metemos en la pila este v�rtice
            pila.poner(verticeOrigen);
            ListaEncadenada componente = new ListaEncadenada();
            while(pila.vacio()==false) {
                //2.- Mientras existan v�rtices en la pila, se van a extraer de uno por uno y se procesar�n (imprimirlos).
                Vertice verticeActualmenteProcesado=(Vertice)pila.quitar(); //sacar de la pila el que sigue
                componente.agregar(verticeActualmenteProcesado.getDescripcion()); //obtengo su descripci�n

                //3.- Los v�rtices adyacentes (no marcados) al nodo que actualmente se procesa (del paso 2)
                // se marcan y se meten en la pila.
                //PRIMERO OBTENER LA LISTA DEL VERTICE ACTUALMENTE PROCESADO
                ListaEncadenada listaVErticeActualmenteProcesado=buscarVerticeEnListaA(verticeActualmenteProcesado.getDescripcion());
                marcarYEnpilarVerticesAdyacentes(marcados, pila, listaVErticeActualmenteProcesado);
                if(pila.vacio()){
                    componentesConexos.agregar(componente);
                    componente = new ListaEncadenada();
                    verificarVerticesNoMarcados(marcados,pila);//Si se agrega un vertice a la pila, se toma como el nuevo origen
                                                               //del cual se sacara otro componente conexo.
                }
            }
            return componentesConexos;
        }
    }

    /**
     * Verifica si es que todos los vertices estan marcados, si no es asi agrega el primero que encuentra
     * que no esta marcado a la pila y lo marca, si todos estan marcados no agrega nada.
     * @param marcados lista de marcados
     * @param pila pila a la que se le va agregar el primer vertice encontrado no marcado.
     */
    private void verificarVerticesNoMarcados(ListaEncadenada marcados,ListaPila pila){
        listaAdyacencia.inicializarIterador();
        while(listaAdyacencia.hayElementos()){
            ListaEncadenada listaCadaVertice = (ListaEncadenada)listaAdyacencia.obtenerElemento();
            Vertice verticeActual = (Vertice) listaCadaVertice.regresarFrente();
            if(marcados.buscar(verticeActual) == null){
                marcados.agregar(verticeActual);
                pila.poner(verticeActual);
                break;
            }
        }
    }
}

