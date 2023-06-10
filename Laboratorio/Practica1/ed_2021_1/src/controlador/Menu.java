package controlador;

public enum Menu {
    ALTA_VEHI(1,"Dar de alta vehiculos"),
    CONS_VEHI(2,"Consultar vehiculos por tipo "),
    REG_TRA(3,"Registrar transporte de origen a destino con chofer"),
    ALTA_CHOF(4,"Dar de alta choferes"),
    ALTA_ORIG(5,"Dar de alta origen"),
    ALTA_DES(6,"Dar de alta destino"),
    CONS_ORIG(7,"Consultar origen"),
    CONS_DES(8,"Consultar destino"),
    ALTA_MAT(9,"Dar de alta materiales"),
    CONS_MAT(10,"Consultar materiales"),
    CONS_PEND(11,"Consultar el listado completo de materiales pendientes de entregar"),
    SALIR(12,"Salir");

    private int indice;
    private String nombre;
    private Menu(int indice,String nombre){
        this.indice = indice;
        this.nombre = nombre;
    }

    public int getIndice() {
        return indice;
    }

    public String getNombre() {
        return nombre;
    }
}
