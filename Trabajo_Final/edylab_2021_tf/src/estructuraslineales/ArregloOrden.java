package estructuraslineales;

import herramientas.comunes.Herramientas;
import herramientas.comunes.TipoOrden;

public class ArregloOrden extends ArregloDatos{
    protected TipoOrden orden;

    public ArregloOrden(int tope, TipoOrden orden){
        super(tope);
        this.orden = orden;
    }
    public TipoOrden orden(){
        return orden;
    }

    @Override
    public int agregar(Object elemento){
        if(lleno() == false){
            if(vacia() == false) {
                Integer posicionEncontado = (Integer)buscar(elemento);
                if(posicionEncontado != null){
                    if(posicionEncontado<0){
                        posicionEncontado *= (-1);
                        posicionEncontado -= 1;
                        tope++;
                        if(orden == TipoOrden.ASCENDENTE) {
                            for (int movs = tope; movs >= posicionEncontado+1; movs--) {
                                lote[movs] = lote[movs - 1];
                            }
                        }else if(orden == TipoOrden.DESCENDENTE){
                            for (int movs = (CAPACIDAD-tope-1); movs <= posicionEncontado-1; movs++) {
                                lote[movs] = lote[movs + 1];
                            }
                        }
                        lote[posicionEncontado] = elemento;
                        return posicionEncontado;
                    }else{
                        return -1;
                    }
                }else{
                    return -1;
                }
            }else{
                if(orden == TipoOrden.ASCENDENTE) {
                    lote[0]=elemento;
                    tope++;
                    return 0;
                }else if(orden == TipoOrden.DESCENDENTE){
                    lote[CAPACIDAD-1] = elemento;
                    tope++;
                    return CAPACIDAD-1;
                }
                return -1;
            }
        }else{
            return -1;
        }
    }

    @Override
    public Object buscar(Object elemento){
        if(!vacia()){
            int posicion = 0;
            if(orden == TipoOrden.ASCENDENTE){
                while(posicion <= tope && 0 < Herramientas.compararObjetos(elemento,lote[posicion])){
                    posicion += 1;
                }
            }else if(orden == TipoOrden.DESCENDENTE){
                posicion = CAPACIDAD-1;
                while(posicion >= (CAPACIDAD-tope) && 0 < Herramientas.compararObjetos(elemento,lote[posicion])){
                    posicion -= 1;
                }
            }
            if(posicion > tope || 0 > Herramientas.compararObjetos(elemento,lote[posicion])){
                return (posicion+1)*(-1);
            }else{
                return posicion+1;
            }
        }else{
            return null;
        }
    }

    @Override
    public Object eliminar(Object elemento){
        Integer posicion = (Integer)buscar(elemento);
        if(posicion != null){
            if(posicion > 0){
                posicion -= 1;
                Object elementoBorrado = lote[posicion];
                tope--;
                if(orden == TipoOrden.ASCENDENTE){
                    for(int movs=posicion;movs<=tope;movs++){
                        lote[movs] = lote[movs+1];
                    }
                }else if(orden == TipoOrden.DESCENDENTE){
                    for(int movs=(CAPACIDAD-tope-1);movs>=posicion;movs--){
                        lote[movs] = lote[movs-1];
                    }
                }
                return elementoBorrado;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public boolean cambiar(Object elementoViejo, Object elementoNuevo, int numVeces){
        Integer posicion = (Integer)buscar(elementoViejo);
        if(posicion != null){
            if(posicion > 0){
                if(eliminar(elementoViejo) != null) {
                    if (agregar(elementoNuevo) > -1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean cambiar(int indice, Object elemento){
        if(indice < tope && indice > -1){
            Object elemElim = obtener(indice);
            if(eliminar(elemElim) != null){
                if(agregar(elemento)>-1){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean agregarLista(Object listaDatos2){
        if(listaDatos2 instanceof ArregloDatos) {
            if (((ArregloDatos) listaDatos2).tope <= (CAPACIDAD - tope)) {
                for(int posicion=0;posicion<((ArregloDatos) listaDatos2).tope;posicion++){
                    agregar(((ArregloDatos) listaDatos2).obtener(posicion));
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void invertir(){
        ArregloOrden tmp = null;
        if(orden == TipoOrden.ASCENDENTE){
            tmp = new ArregloOrden(CAPACIDAD,TipoOrden.DESCENDENTE);
            for (int posicion=0,pos=tope;posicion<=tope;posicion++,pos--){
                tmp.lote[pos] = obtener(posicion);
            }
        }else if(orden == TipoOrden.DESCENDENTE){
            tmp = new ArregloOrden(CAPACIDAD,TipoOrden.ASCENDENTE);
            for (int posicion=CAPACIDAD-1;posicion>(CAPACIDAD-tope-1);posicion++){
                tmp.agregar(obtener(posicion));
            }
        }
        lote = tmp.lote;
        orden = tmp.orden;
    }

    @Override
    public void rellenar(Object elemento){
        if(elemento instanceof Integer){
            int relleno = (Integer)elemento;
            if(relleno != 0){
                if(relleno < 0){
                    if(((relleno)*(-1)) <= (CAPACIDAD-tope)){
                        if(orden == TipoOrden.ASCENDENTE){
                            for (int posicion=-1;posicion>=relleno;posicion--){
                                agregar(posicion);
                            }
                        }else if(orden == TipoOrden.DESCENDENTE){
                            for (int posicion=relleno;posicion<0;posicion++){
                                agregar(posicion);
                            }
                        }
                    }
                }else if(relleno > 0){
                    if(relleno <= (CAPACIDAD-tope)){
                        if(orden == TipoOrden.ASCENDENTE){
                            for (int posicion=1;posicion<=relleno;posicion++){
                                agregar(posicion);
                            }
                        }else if(orden == TipoOrden.DESCENDENTE){
                            for (int posicion=relleno;posicion>0;posicion--){
                                agregar(posicion);
                            }
                        }
                    }
                }
            }
        }else{
            if(elemento instanceof String){
                String relleno = (String) elemento;
                if(relleno.length() > 1){
                    agregar(elemento);
                }else{
                    String abc="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
                    if((abc.indexOf(relleno)+1) < (CAPACIDAD-tope)) {
                        for (int posicion=0; posicion<abc.indexOf(relleno)+1; posicion++) {
                            agregar(abc.charAt(posicion));
                        }
                    }
                }
            }else{
                agregar(elemento);
            }
        }
    }

    /**
     * Desordena los elementos del arreglo y los introduce en un arreglo normal
     * @return El arreglo desordenado
     */
    public ArregloDatos arregloDesordenado(){
        ArregloDatos arr = new ArregloDatos(CAPACIDAD);
        ArregloDatos arr2 = (ArregloDatos) clonar();
        if(!vacia()){
            if(orden == TipoOrden.ASCENDENTE){
                int posicion = 0;
                while(posicion <= tope){
                    arr.agregar(arr2.eliminar(0));
                    posicion++;
                    if(posicion < tope){
                        arr.agregar(arr2.eliminar());
                        posicion++;
                    }
                }
            }else if(orden == TipoOrden.DESCENDENTE){
                int posicion = tope;
                while(posicion >= (CAPACIDAD-tope)){
                    arr.agregar(arr2.eliminar(CAPACIDAD-posicion));
                    posicion++;
                    if(posicion <= tope){
                        arr.agregar(arr2.eliminar(posicion));
                        posicion++;
                    }
                }
            }

        }
        return arr;
    }

    @Override
    public boolean esSublista(Object listaDatos2){
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
    public boolean cambiarLista(ArregloDatos listaDatos2,ArregloDatos listaDatos2Nuevos){
        if(listaDatos2.tope == listaDatos2Nuevos.tope){
            for(int pos=0;pos< listaDatos2.tope+1;pos++){
                if(buscar(listaDatos2.obtener(pos)) != null){
                    cambiar((Integer)buscar(listaDatos2.obtener(pos)),listaDatos2Nuevos.obtener(pos));
                }
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean retenerLista(ArregloDatos listaDatos2) {
        for(int pos=0;pos<tope+1;pos++){
            if(listaDatos2.buscar(obtener(pos)) == null){
                eliminar(obtener(pos));
            }
        }
        return true;
    }

    @Override
    public boolean insertar(int indice, Object elemento){
        if(indice <= tope && indice > -1){
            Object elemElim = obtener(indice);
            if(eliminar(elemElim) != null){
                if(agregar(elemento)>-1){
                    return true;
                }
            }else{
                agregar(elemento);
            }
        }
        return false;
    }

    @Override
    public boolean copiarLista(ArregloDatos listaDatos2){
        if(listaDatos2.tope < CAPACIDAD){
            vaciar();
            if(orden == TipoOrden.ASCENDENTE){
                for(int pos=0;pos< listaDatos2.tope+1;pos++){
                    agregar(listaDatos2.obtener(pos));
                }
            }else if(orden == TipoOrden.DESCENDENTE){
                for(int pos= listaDatos2.CAPACIDAD;pos>(listaDatos2.CAPACIDAD-listaDatos2.tope-1);pos++){
                    agregar(listaDatos2.obtener(pos));
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
