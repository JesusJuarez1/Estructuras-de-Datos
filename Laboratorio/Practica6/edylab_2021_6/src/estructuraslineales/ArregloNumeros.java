package estructuraslineales;

public class ArregloNumeros extends ArregloDatos{

    public ArregloNumeros(int capacidad){
        super(capacidad);
    }

    @Override
    public int agregar(Object elemento){
        if(elemento instanceof Number){
            return super.agregar(elemento);
        }else{
            return -1;
        }
    }

    @Override
    public Object buscar(Object elemento){
        if(elemento instanceof Number){
            return super.buscar(elemento);
        }else{
            return null;
        }
    }

    @Override
    public Object eliminar(Object elemento){
        if(elemento instanceof Number){
            return super.eliminar(elemento);
        }else{
            return null;
        }
    }

    @Override
    public boolean esIgual(Object listaDatos2){
        if(listaDatos2 instanceof ArregloNumeros){
            return super.esIgual(listaDatos2);
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces){
        if(elementoNuevo instanceof Number && elementoViejo instanceof Number){
            return super.cambiar(elementoViejo,elementoNuevo,numVeces);
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiar(int indice, Object elemento){
        if(elemento instanceof Number){
            return super.cambiar(indice,elemento);
        }else{
            return false;
        }
    }

    @Override
    public boolean cambiarArregloDatos(ArregloDatos indicesBusqueda, ArregloDatos elementosNuevos){
        return false;
    }

    @Override
    public ArregloDatos buscarValores(Object elemento){
        if(elemento instanceof Number){
            return super.buscarValores(elemento);
        }else{
            return null;
        }
    }

    @Override
    public boolean agregarLista(Object listaDatos2){
        if(listaDatos2 instanceof ArregloNumeros){
            return super.agregarLista(listaDatos2);
        }else{
            return false;
        }
    }

    @Override
    public int contar(Object elemento){
        if(elemento instanceof Number){
            return super.contar(elemento);
        }else{
            return 0;
        }
    }

    @Override
    public boolean eliminarLista(Object listaDatos2){
        if(listaDatos2 instanceof ArregloNumeros){
            return super.eliminarLista(listaDatos2);
        }else{
            return false;
        }
    }

    @Override
    public void rellenar(Object elemento, int cantidad){
        if(elemento instanceof Number){
            super.rellenar(elemento,cantidad);
        }
    }

    @Override
    public void rellenar(Object elemento){
        if(elemento instanceof Number){
            super.rellenar(elemento);
        }
    }

    @Override
    public boolean esSublista(Object listaDatos2){
        if(listaDatos2 instanceof ArregloNumeros){
            return super.esSublista(listaDatos2);
        }else{
            return false;
        }
    }

    @Override
    public boolean insertar(int indice, Object elemento){
        if(elemento instanceof Number){
            return super.insertar(indice,elemento);
        }else{
            return false;
        }
    }

    @Override
    public boolean copiarLista(ArregloDatos listaDatos2){
        if(listaDatos2 instanceof ArregloNumeros){
            return super.copiarLista(listaDatos2);
        }else{
            return false;
        }
    }

    /**
     * Multiplica el escalar por todos los datos de la lista
     * @param escalar Numero por el cual se va a multiplicar cada elemento
     * @return true si lo hace, false en caso de que el arreglo este vacio
     */
    public boolean xEscalar(Number escalar){
        if(!vacia()){
            for(int posicion=0;posicion<tope;posicion++){
                cambiar(posicion,((Double)obtener(posicion))*((Double)escalar));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Suma cada elemento del arreglo por el escalar
     * @param escalar Numero por el cual se va a sumar cada elemento
     * @return true si lo hace, false en caso de que el arreglo este vacio
     */
    public boolean sumaEscalar(Number escalar){
        if(!vacia()){
            for(int posicion=0;posicion<tope;posicion++){
                cambiar(posicion,((Double)obtener(posicion))+((Double)escalar));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Suma la posición 1 del arreglo actual con la posición 1 de arreglo2, y así sucesivamente
     * @param arreglo2 Arreglo que se va a sumar al arreglo actual
     * @return True si lo hace, false en caso que las dimensiones del arreglo2 superen al actual o el arreglo actual este vacio
     */
    public boolean sumar(ArregloNumeros arreglo2){
        if(arreglo2.tope <= tope && !vacia()){
            for(int posicion=0;posicion<arreglo2.cantidadElementos();posicion++){
                cambiar(posicion,((Double)obtener(posicion))+((Double)arreglo2.obtener(posicion)));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * multiplica la posición 1 del arreglo actual con la posición 1 de arreglo2, y así sucesivamente
     * @param arreglo2 Arreglo que se va a sumar al arreglo actual
     * @return True si lo hace, false en caso que las dimensiones del arreglo2 superen al actual o el arreglo actual este vacio
     */
    public boolean multiplicar(ArregloNumeros arreglo2){
        if(arreglo2.tope <= tope && !vacia()){
            for(int posicion=0;posicion<arreglo2.cantidadElementos();posicion++){
                cambiar(posicion,((Double)obtener(posicion))*((Double)arreglo2.obtener(posicion)));
            }
            return true;
        }else{
            return false;
        }
    }

    /**
     * Hace la operacion de potencia por cada elemento del arreglo actual
     * @param escalar Exponente para hacer la operacion
     * @return true si lo hace, false si el arreglo actual esta vacio
     */
    public boolean potencia(Number escalar){
        if(!vacia()){
            for(int posicion=0;posicion<cantidadElementos();posicion++){
                cambiar(posicion,Math.pow(((Double)obtener(posicion)),((Double)escalar)));
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * Hace la operacion de potencia de cada posicon del arreglo actual por el elemento de la posicon del arregloEscalar
     * @param arregloEscalar Arreglo que contiene las potencias en orden de posicion
     * @return true si lo hace, false en caso que el arreglo actual este vacio o sea menor el numero de elementos
     */
    public boolean potencia(ArregloNumeros arregloEscalar){
        if(!vacia() && tope >= arregloEscalar.tope){
            for(int posicion=0;posicion<tope;posicion++){
                cambiar(posicion,Math.pow(((Double)obtener(posicion)),((Double)arregloEscalar.obtener(posicion))));
            }
            return true;
        }else {
            return false;
        }
    }

    /**
     * suma la multiplicacion de cada elemento de la lista actual por el arreglo2
     * @param arreglo2 arreglo que se va a multiplicar por el arreglo actual
     * @return Regresa el resultado de la operacion, 0 en caso de error
     */
    public Double productoPunto(ArregloNumeros arreglo2){
        if(arreglo2.tope == tope){
            if(!vacia()){
                Double total = 0.0;
                ArregloNumeros arreglo = new ArregloNumeros(CAPACIDAD);
                for(int posicion=0;posicion<cantidadElementos();posicion++){
                    arreglo.agregar(obtener(posicion));
                }
                arreglo.multiplicar(arreglo2);
                for(int posicion=0;posicion<cantidadElementos();posicion++){
                    total += (Double)arreglo.obtener(posicion);
                }
                return total;
            }
        }
        return null;
    }

    /**
     * Saca la magnitud / módulo / norma L2 del vector
     * @return el resultado de la operacion, 0 si el arreglo esta vacio
     */
    public Double modulo(){
        if(!vacia()){
            double total = 0;
            for(int posicion=0;posicion<cantidadElementos();posicion++){
                total += Math.pow((Double)obtener(posicion),2);
            }
            return Math.sqrt(total);
        }
        return null;
    }

    /**
     * debe calcular la norma euclidiana de los vectores numéricos actual y arreglo2
     * @param arreglo2 vector que contiene los datos para poder realizar al operacion
     * @return El resultaod de las operaciones, 0 en caso de error
     */
    public Double normaEuclidiana(ArregloNumeros arreglo2){
        if(!vacia() && arreglo2.tope == tope){
            double total = 0;
            for(int posicion=0;posicion<cantidadElementos();posicion++){
                total += Math.pow(((Double)arreglo2.obtener(posicion))-((Double)obtener(posicion)),2);
            }
            return total;
        }
        return null;
    }

    /**
     * Debe sumar de uno por uno un conjunto de arreglos al arreglo actual
     * @param arreglos ArregloDatos que contiene los ArregloNumeros para sumar
     * @return el total de sumar todos los arreglos, null en caso contrario
     */
    public Double sumarArreglosDatos(ArregloDatos arreglos){
        if(!vacia() && !arreglos.vacia()){
            for(int posicion=0;posicion<arreglos.cantidadElementos();posicion++){
                if(arreglos.obtener(posicion) instanceof ArregloNumeros){
                    sumar((ArregloNumeros) arreglos.obtener(posicion));
                }else{
                    return null;
                }
            }
            double total = 0;
            for(int posicion=0;posicion<cantidadElementos();posicion++){
                total += (Double)obtener(posicion);
            }
            return total;
        }else{
            return null;
        }
    }

    /**
     * Suma todos los escalares al cada elemento de la posicion actual de todos los escalares de los arreglos
     * @param escalares Arreglo que contiene mas arreglos y que estos guardan escalares
     * @return el total, null en caso contrario
     */
    public Double sumarEscalares(ArregloNumeros escalares){
        if(!vacia()){
            for(int posicion=0;posicion<escalares.cantidadElementos();posicion++){
                for(int pos=0;pos<escalares.cantidadElementos();pos++){
                    sumaEscalar((Double)escalares.obtener(pos));
                }
            }
            double total = 0;
            for(int posicion=0;posicion<cantidadElementos();posicion++){
                total += (Double)obtener(posicion);
            }
            return total;
        }else{
            return null;
        }
    }

    /**
     * Debe sumar del arreglo actual las posiciones de él que indica el arreglo llamado arregloIndices
     * @param arregloIndices Arreglo que contiene los indices a buscar
     * @return el total, null en caso contrario
     */
    public Double sumarIndices(ArregloNumeros arregloIndices){
        if(!vacia()){
            double total = 0;
            for(int posicion=0;posicion<arregloIndices.cantidadElementos();posicion++){
                total += (Double)obtener((Integer)arregloIndices.obtener(posicion));
            }
            return total;
        }else{
            return null;
        }
    }

    /**
     * Determina si el conjunto de arreglos pasados como parametro son linealmente dependientes
     * @param arreglosVectores Arreglo que contiene ArregloNumeros
     * @return true si son linealmente dependientes, false en caso contrario
     */
    public boolean sonLinealmenteDep(ArregloDatos arreglosVectores){
        if(!vacia() && !arreglosVectores.vacia()){
                Double ld = 0.0;
                for(int posicion=0;posicion<arreglosVectores.cantidadElementos();posicion++){
                    if(arreglosVectores.obtener(posicion) instanceof ArregloNumeros){
                        if(tope == arreglosVectores.tope){
                            ArregloNumeros arreglo = (ArregloNumeros) arreglosVectores.obtener(posicion);
                            for(int pos=0;pos<tope;pos++){
                                ld += ((Double)arreglo.obtener(pos))*((Double)obtener(pos));
                            }
                        }
                    }else{
                        return false;
                    }
                }
                if(ld == 0){
                    return true;
                }else{
                    return false;
                }

        }
        return false;
    }

    /**
     * Determina si el conjunto de arreglos pasados como parametro son linealmente independientes
     * @param arreglosVectores Arreglo que contiene ArregloNumeros
     * @return true si son linealmente dependientes, false en caso contrario
     */
    public boolean sonLinealmenteIdep(ArregloDatos arreglosVectores){
        if(!vacia() && !arreglosVectores.vacia()){
                Double li = 0.0;
                for(int posicion=0;posicion<arreglosVectores.cantidadElementos();posicion++){
                    if(arreglosVectores.obtener(posicion) instanceof ArregloNumeros){
                        if(tope == arreglosVectores.tope){
                            ArregloNumeros arreglo = (ArregloNumeros) arreglosVectores.obtener(posicion);
                            for(int pos=0;pos<tope;pos++){
                                if((Integer)obtener(pos) == 0){
                                    li += ((Double)arreglo.obtener(pos))*((Integer)obtener(pos));
                                }else{
                                    return false;
                                }
                            }
                        }
                    }else{
                        return false;
                    }
                }
                if(li == 0){
                    return true;
                }else{
                    return false;
                }
        }
        return false;
    }

    /**
     * Determina si el arreglo actual es ortogonal al arreglo pasado como argumento
     * @param arreglo2 Arreglo a evaluar junto con el actual
     * @return true si es ortogonal, false en caso contrario
     */
    public boolean esOrtogonal(ArregloNumeros arreglo2){
        if(!vacia() && !arreglo2.vacia()){
            if(tope == arreglo2.tope){
                double ort = 0;
                for(int posicion=0;posicion<cantidadElementos();posicion++){
                    ort += ((Double)obtener(posicion))*((Double) arreglo2.obtener(posicion));
                }
                if(ort == 0){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Determina si el arreglo actual es paralelo al arreglo pasado como argumento
     * @param arreglo2 arreglo con el que se evaluara si son paralelos
     * @return true si son paralelos, false en caso contrario
     */
    public boolean esParalelo(ArregloNumeros arreglo2){
        if(!vacia() && !arreglo2.vacia()){
            if(tope == arreglo2.tope){
                for(int posicion=0;posicion<cantidadElementos()-1;posicion++){
                    if(((Double)obtener(posicion)/(Double)arreglo2.obtener(posicion)) !=
                            ((Double)obtener(posicion+1)/(Double)arreglo2.obtener(posicion+1))){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
