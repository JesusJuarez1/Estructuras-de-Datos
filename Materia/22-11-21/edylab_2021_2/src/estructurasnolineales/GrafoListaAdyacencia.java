package estructurasnolineales;

import entradasalida.SalidaTerminal;
import estructuraslineales.*;
import registros.Vertice;

public class GrafoListaAdyacencia {
    protected ListaEncadenada listaAdyacencia; //es la lista que va a guardar listas

    public GrafoListaAdyacencia(){
        listaAdyacencia=new ListaEncadenada();
    }

    private ListaEncadenada buscarVerticeEnListaA(Object datoVertice){
        //Recorrer la lista de Adyacencia para buscar si cada sublista  (en su primer elemento)
        //es el vértice que queremos encontrar

        listaAdyacencia.inicializarIterador();

        while(listaAdyacencia.hayElementos()==true){ //recorrer todos los elementos de LA
            //sacar un elemento de la LA
            ListaEncadenada listaCadaVertice=(ListaEncadenada)listaAdyacencia.obtenerElemento();
            //checar si el primer elemento de esa lista de cada vértice es el datoVertice a buscar
            Vertice primerVerticeCadaLista=(Vertice)listaCadaVertice.regresarFrente(); //sacamos el primer elemento de la sublista
            //verificar si es el que busco
            if(primerVerticeCadaLista.toString().equalsIgnoreCase(datoVertice.toString())==true){ //lo encontramos
                return listaCadaVertice;
            }
        }
        //si llega el apuntador de la MVJ a este punto, significa que no lo encontró
        return null;
    }

    public boolean agregarVertice(Object datoVertice){
        //Antes de agregar un vértice, debemos checar si no existe
        //Para eso debemos buscar en la primera posición de cada sublista si existe o no.
        ListaEncadenada listaVerticeAAgregar=buscarVerticeEnListaA(datoVertice);

        if(listaVerticeAAgregar==null){ //no existe ese vértice, podemos agregarlo
            ListaEncadenada listaNuevoVertice=new ListaEncadenada(); //creamos la lista del nuevo vértice
            Vertice nuevoVertice=new Vertice(); //creamos un vértice
            nuevoVertice.setDescripcion(datoVertice); //asignamos su dato
            //lo agregamos como cabeza de la lista nueva
            listaNuevoVertice.agregar(nuevoVertice); //agregamos ese vérticen uevo como cabeza de su lista

            int valorRetornoA=listaAdyacencia.agregar(listaNuevoVertice);//agregar esa lista de ese vértice a la lista de adyacencia
            if(valorRetornoA>0) { //si se s pudo agregar
                return true;
            }else{ //no se pudo agregar
                return false;
            }
        }else{ //ya existe ese vértice
            return false;
        }
    }

    public boolean agregarArista(Object origen, Object destino){
        //Primero checar que estos vértices existan
        ListaEncadenada listaOrigen=buscarVerticeEnListaA(origen);
        ListaEncadenada listaDestino=buscarVerticeEnListaA(destino);

        if(listaOrigen!=null && listaDestino!=null){ //existen ambos
            //sacar el vértice destino de la lista destino
            Vertice verticeDestino=(Vertice)listaDestino.regresarFrente(); //sacamos el vértice destino de la lsat destino
            //agregar ese vértice destino en la lista origen
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
        //recorremos la lista del vértice actualmente procesado, n donde vienen ya su adyacentes
        listaVerticeActualmenteProceado.inicializarIterador(); //inicalizamos el iterador
        listaVerticeActualmenteProceado.obtenerElemento(); //brincarme el primero, ya que ese no es arista

        //empezamos a partir de lsegundo (aristas)
        while(listaVerticeActualmenteProceado.hayElementos()==true){
            Vertice verticeAdyacente=(Vertice) listaVerticeActualmenteProceado.obtenerElemento(); //sacamos un adyacente
            //checar que no esté marcado,
            if(marcados.buscar(verticeAdyacente.getDescripcion())==null){ //no está en el lisado de marcados
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
            //1.- Partiremos de un vértice origen. Este vértice se marca y se
            //mete en una pila.
            //Extraer el vértice para poderlo procesar en las fases
            Vertice verticeOrigen=(Vertice)listaOrigen.regresarFrente();
            //Mqrcar este vértice
            marcados.agregar(verticeOrigen);
            //Metemos en la pila este vértice
            pila.poner(verticeOrigen);

            while(pila.vacio()==false) {
                //2.- Mientras existan vértices en la pila, se van a extraer de uno por uno y se procesarán (imprimirlos).
                Vertice verticeActualmenteProcesado=(Vertice)pila.quitar(); //sacar de la pila el que sigue
                recorridoProfundidad.agregar(verticeActualmenteProcesado.getDescripcion()); //obtengo su descripción

                //3.- Los vértices adyacentes (no marcados) al nodo que actualmente se procesa (del paso 2)
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


}
