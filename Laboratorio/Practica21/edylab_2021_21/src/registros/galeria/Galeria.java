package registros.galeria;

import entradasalida.EntradaTerminal;
import entradasalida.SalidaTerminal;
import estructuraslineales.ArregloDatos;
import estructurasnolineales.Tabla3D;
import herramientas.comunes.Herramientas;

public class Galeria {
    protected Tabla3D tabla3D;
    protected ArregloDatos pintores;

    public Galeria(int numP){
        tabla3D = new Tabla3D(10,52,7);
        tabla3D.rellenar(new Actividad(new Pintor("",0,"","","",""),""));
        pintores = new ArregloDatos(numP);
    }

    /**
     * Agrega una actividad a la tabla
     * @param actividad La actividad que se hace
     * @param anio numero de año en el que se hace la actividad
     * @param semana numero de semana en el que se hace la actividad
     * @param dia Numero de dia de la semana en que se hace la actividad
     * @return true si agrega correctamente, false en caso contrario
     */
    public boolean agregarActividad(Actividad actividad,int anio,int semana,int dia){
        return tabla3D.asignarCelda(anio,semana,dia,actividad);
    }

    /**
     * Crea y regresa la actividad escogida
     * @param p Pintor que hace la actividad
     * @return La actividad escogida con sus datos
     */
    public Actividad crearActividad(Pintor p){
        Integer op = 0;
        while(op < 1 || op > 4){
            SalidaTerminal.consola("Ingresa el numero de la actividad a crear: \n" +
                    "1.- Pintar\n" +
                    "2.- Exponer\n" +
                    "3.- Firmar autografos\n" +
                    "4.- Viajar\n");
            op = EntradaTerminal.consolaInteger();
            if(op == null){
                op = 0;
            }
        }
        if(op == 1){
            SalidaTerminal.consola("Ingresa el nombre del evento: ");
            return new Pintar(p,EntradaTerminal.consolaCadena());
        }else if(op == 2){
            SalidaTerminal.consola("Ingresa el nombre del evento: ");
            String nombre = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingresa el lugar del evento: ");
            String lugar = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingresa la fecha del evento: ");
            String fecha = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingresa el aforo del evento: ");
            int aforo = EntradaTerminal.consolaInteger();
            return new Exponer(p,nombre,lugar,fecha,aforo);
        }else if(op == 3){
            SalidaTerminal.consola("Ingresa el lugar de la firma de autografos: ");
            String lugar = EntradaTerminal.consolaCadena();
            SalidaTerminal.consola("Ingresa la fecha de la firma de autografos: ");
            String fecha = EntradaTerminal.consolaCadena();
            return new Firma_Autografo(p,lugar,fecha);
        }else if(op == 4){
            SalidaTerminal.consola("Ingresa el lugar al que esta viajando: ");
            String lugar = EntradaTerminal.consolaCadena();
            return new Viajar(p,lugar);
        }else{
            return null;
        }
    }

    /**
     * Pide los datos de un pintor y lo crea
     * @return Regresa el pintor creado
     */
    public Pintor crearPintor(){
        SalidaTerminal.consola("Ingresa el nombre del pintor: ");
        String nombre = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("Ingresa la edad del pintor: ");
        int edad = EntradaTerminal.consolaInteger();
        SalidaTerminal.consola("Ingresa la fecha de nacimiento: ");
        String fecha = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("Ingresa el domicilio del pintor: ");
        String domicilio = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("Ingresa el rfc del pintor: ");
        String rfc = EntradaTerminal.consolaCadena();
        SalidaTerminal.consola("Ingresa el nivel de estudios del pintor: ");
        String estudios = EntradaTerminal.consolaCadena();
        int pos = pintores.agregar(new Pintor(nombre,edad,fecha,domicilio,rfc,estudios));
        if(pos != -1){
            return (Pintor)pintores.obtener(pos);
        }else{
            return null;
        }
    }

    /**
     * Agrega un pintor al arreglo
     * @param p Pintor a agregar
     * @return true si lo hizo, false en caso contrario
     */
    public boolean agregarPintor(Pintor p){
        int pos = pintores.agregar(p);
        if(pos != -1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Evalua cual fue la actividad mas popular en el año indicado
     * @param anio año en el que se evaluar las actividades
     * @return Regresa una cadena con el nombre de la actividad mas popular
     */
    public String actividadMasPopular(int anio){
        anio = anio-1;
        int popular = 0;
        String pop = "";
        for(int pos=0;pos<4;pos++){
            int veces = 0;
            for(int semana=0;semana<tabla3D.getColumnas();semana++){
                for(int dia=0;dia<tabla3D.getProfundidad();dia++){
                    if(pos == 0){
                        if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase
                                ("Pintar")){
                            veces++;
                        }
                    }else if(pos == 1){
                        if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase
                                ("Exponer")){
                            veces++;
                        }
                    }else if(pos == 2){
                        if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase
                                ("Firma de Autografos")){
                            veces++;
                        }
                    }else if(pos == 3){
                        if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase
                                ("Viajar")){
                            veces++;
                        }
                    }
                }
            }
            if(popular < veces){
                popular = veces;
                if(pos == 0){
                    pop = "Pintar";
                }else if(pos == 1){
                    pop = "Exponer";
                }else if(pos == 2){
                    pop = "Firma de Autografos";
                }else if(pos == 3){
                    pop = "Viajar";
                }
            }
        }
        return pop;
    }

    /**
     * Obtiene el pintor que hace mas autografos
     * @return El pintor con mas actividades de autografos, null si no hay pintor que hizo autografos
     */
    public Pintor masAutografos(){
        Pintor p = null;
        int maximo = 0;
        for(int pin=0;pin<pintores.cantidadElementos();pin++){
            int num = 0;
            for(int anio=0;anio<tabla3D.getFilas();anio++){
                for(int semana=0;semana<tabla3D.getColumnas();semana++){
                    for(int dia=0;dia<tabla3D.getProfundidad();dia++){
                        if(Herramientas.compararObjetos(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).pintor,
                                (Pintor)pintores.obtener(pin)) == 0 && ((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).
                                nombre.equalsIgnoreCase("Firma de Autografos")){
                            num++;
                        }
                    }
                }
            }
            if(num > maximo){
                maximo = num;
                p = (Pintor)pintores.obtener(pin);
            }
        }
        if(p != null){
            return p;
        }else{
            return null;
        }
    }

    /**
     * Imprime los pintores que desarrollaron la actividad indicada
     * @param actividad Actividad que tienen que hacer el pintor para imprimir nombre y edad
     */
    public void pintorDesarrollo(String actividad){
        for(int anio=0;anio<tabla3D.getFilas();anio++) {
            for (int semana = 0; semana < tabla3D.getColumnas(); semana++) {
                for (int dia = 0; dia < tabla3D.getProfundidad(); dia++) {
                    if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase(actividad)){
                        Pintor p = ((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).pintor;
                        SalidaTerminal.consola(p.nombre+", "+p.edad+"\n");
                    }
                }
            }
        }
    }

    /**
     * Indica en que año y en que evento un pintor expuso o pinto
     * @param p Pintor el cual se va evaluar
     */
    public void pintoOExpuso(Pintor p){
        for(int anio=0;anio<tabla3D.getFilas();anio++) {
            for (int semana = 0; semana < tabla3D.getColumnas(); semana++) {
                for (int dia = 0; dia < tabla3D.getProfundidad(); dia++) {
                    Actividad ac = (Actividad)tabla3D.obtenerCelda(anio,semana,dia);
                    if(Herramientas.compararObjetos(ac.pintor,p) == 0){
                        if(ac.nombre.equalsIgnoreCase("Pintar")){
                            Pintar pin = (Pintar)ac;
                            SalidaTerminal.consola("Año: "+(anio+1)+", Evento: "+pin.nombre_evento+"\n");
                        }else if(ac.nombre.equalsIgnoreCase("Exponer")){
                            Exponer ex = (Exponer)ac;
                            SalidaTerminal.consola("Año: "+(anio+1)+", Evento: "+ex.nombre_evento+"\n");
                        }
                    }
                }
            }
        }
    }

    /**
     * Obtiene el año en el que la actividad indicada se hizo menos veces
     * @param actividad Actividad a evaluar
     * @return El año en el que se hizo menos veces la actividad indicada, -1 si no se hizo esa actividad nunca
     */
    public int anioMenosActividad(String actividad){
        int ani = -1;
        int menos = 0;
        for(int anio=0;anio<tabla3D.getFilas();anio++) {
            int act = 0;
            for (int semana = 0; semana < tabla3D.getColumnas(); semana++) {
                for (int dia = 0; dia < tabla3D.getProfundidad(); dia++) {
                    if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase(actividad)){
                        act++;
                    }
                }
            }
            if(ani == -1){
                menos = act;
                ani = anio+1;
            }else if(act < menos){
                menos = act;
                ani = anio+1;
            }
        }
        return ani;
    }

    /**
     * Imprime los nombres y domicilios de los pintores que hicieron la actividad indicada todos los años
     * @param actividad Actividad que tuvieron que hacer los pintores todos los años
     */
    public void todosAniosHicieron(String actividad){
        for(int pos=0;pos<pintores.cantidadElementos();pos++){
            int veri = 0;
            for(int anio=0;anio<tabla3D.getFilas();anio++) {
                for (int semana = 0; semana < tabla3D.getColumnas(); semana++) {
                    for (int dia = 0; dia < tabla3D.getProfundidad(); dia++) {
                        if(Herramientas.compararObjetos(((Pintor)pintores.obtener(pos)),
                            (Pintor)((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).pintor) == 0){
                            if(((Actividad)tabla3D.obtenerCelda(anio,semana,dia)).nombre.equalsIgnoreCase(actividad)){
                                veri++;
                                semana = tabla3D.getColumnas();
                                dia = tabla3D.getProfundidad();
                            }
                        }
                    }
                }
            }
            if(veri == 10){
                Pintor p = (Pintor)pintores.obtener(pos);
                SalidaTerminal.consola(p.nombre+", "+p.domicilio+"\n");
            }
        }
    }

    /**
     * Obtiene la actividad Exponer en la que hubo un aforo mayor al resto
     * @return Exponer que tuvo mas aforo que el resto, null en caso contrario
     */
    public Exponer masAforo(){
        Exponer ex = null;
        for (int anio = 0; anio < tabla3D.getFilas(); anio++) {
            for (int semana = 0; semana < tabla3D.getColumnas(); semana++) {
                for (int dia = 0; dia < tabla3D.getProfundidad(); dia++) {
                    Actividad ac = (Actividad)tabla3D.obtenerCelda(anio,semana,dia);
                    if(ac.nombre.equalsIgnoreCase("Exponer")){
                        Exponer e = (Exponer) ac;
                        if(ex == null){
                            ex = e;
                        }else if(ex.aforo < e.aforo){
                            ex = e;
                        }
                    }
                }
            }
        }
        return ex;
    }
}
