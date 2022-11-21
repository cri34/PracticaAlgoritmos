package Berkeley;

public class Berkeley {
    private Reloj relojes[];
    private int indMaster;
    private static int indReloj = 0;
    private final int cantidadRelojes;

    public Berkeley(int cantidadRelojes) {
        this.cantidadRelojes = cantidadRelojes;
        relojes = new Reloj[cantidadRelojes];
    }

    public void setIndMaster(int indMaster) {
        this.indMaster = indMaster;
    }

    public void addReloj(int tiempo, int retardoTransmision) {
        if (indReloj >= cantidadRelojes) {
            System.out.println("Relojes maximos en funcionamiento");
            return;
        }
        relojes[indReloj++] = new Reloj(tiempo, retardoTransmision);
    }

    public void enviarInstrucionCambioTiempoASlaver() {
        int intervaloTiempo;
        int tiempoMaster = relojes[indMaster].getTiempo();
        int tiempoSlaver;
        int mediaRetraso = 0;
        //calcular media de tiempo de retraso de respuestas de slavers
        for (int index = 0; index < relojes.length; index++) {
            mediaRetraso += relojes[index].getRetardoTransmision();
        }
        mediaRetraso /= relojes.length;
        //envio de intervalo de tiempo a cada slaver contando retraso de trasmision
        for (int ind = 0; ind < relojes.length; ind++) {
            if (ind == indMaster) {
                continue;
            }
            tiempoSlaver = relojes[ind].getTiempo();
            intervaloTiempo = (tiempoMaster - tiempoSlaver) + mediaRetraso;
            relojes[ind].setTiempo(intervaloTiempo);
        }


    }

    public void printTimeRelojes() {
        for (int index = 0; index < relojes.length; index++) {
            System.out.println(" reloj : " + index + " hora : " + relojes[index].getTiempo());
        }
        System.out.println();
    }

}
