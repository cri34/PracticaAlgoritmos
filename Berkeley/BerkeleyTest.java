package Berkeley;

public class BerkeleyTest {
    public static void main(String[] args) {
        Berkeley b = new Berkeley(4);
        b.addReloj(23000000,10);
        b.addReloj(13500000,2);
        b.addReloj(23400000,4);
        b.addReloj(23400000,6);
        b.setIndMaster(0);
        b.printTimeRelojes();
        b.enviarInstrucionCambioTiempoASlaver();
        b.printTimeRelojes();
    }
}
