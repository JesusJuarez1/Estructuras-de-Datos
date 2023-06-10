package modelo;

public enum TipoVehiculo {
    PLATA_CERR("Trailer con plataforma cerrada",1),
    TREN("Tren",2),
    PLATA_ABI("Camion con plataforma abierta",3),
    PLATA_LONA("Camione con plataforma con lona",4),
    CAM_FRIG("Camione frigorifico",5),
    CAM_CIS("Camione cisterna",6),
    CAM_CERR_COM("Camion cerrado compacto",7),
    MADRINA("Camion parachoque",8),
    CAM_JAU("Camion jaula",9),
    AUTOMOVIL("Automovil",10),
    MINIVAN("Minivan",11),
    MOTO("Motocicleta",12),
    AVION("Avion",13),
    AVIONETA("Avioneta",14);

    private String nombre;
    private int indice;
    private TipoVehiculo(String nombre,int indice){
        this.nombre = nombre;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
