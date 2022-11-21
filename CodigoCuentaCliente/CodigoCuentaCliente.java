package CodigoCuentaCliente;

public class CodigoCuentaCliente {
    /*2020(codEntidad)-0000(codOficina)-11(codControl)-2233445564(CodCuenta)*/
    private String codEntidad;
    private String codOficina;
    private String codControl="";
    private String codCuenta;

    public CodigoCuentaCliente(String codEntidad, String codOficina, String codCuenta) {
        this.codEntidad = codEntidad;
        this.codOficina = codOficina;
        this.codCuenta = codCuenta;
        calcularCodControl();
    }

    private int[] encontrarFactores() {
        final int maxFactor = 10,
                base = 2;
        final int divisor = 11;
        int[] factoresPorPos = new int[maxFactor];
        for (int index = 0; index < factoresPorPos.length; index++) {
            factoresPorPos[index] = (int) (Math.pow(base, index) % divisor);
        }

        return factoresPorPos;
    }

    private int calularDigitCodControl(String infoCalcDigitControl) {
        final int maxLenghtDigits = 10, divisor = 11;
        int multiplicarDigitPerCorresponentPosFactor, sumaTotal = 0, restoSuma, numControl;
        int[] factoresPorPos = encontrarFactores();

        for (int index = 0; index < maxLenghtDigits; index++) {
            multiplicarDigitPerCorresponentPosFactor = Character.getNumericValue(infoCalcDigitControl.charAt(index)) * factoresPorPos[index];
            sumaTotal += multiplicarDigitPerCorresponentPosFactor;
        }
        restoSuma = sumaTotal % divisor;
        return numControl = divisor - restoSuma;

    }

    public void calcularCodControl() {
        String infoCalcularPrimerDigit = "00" + codEntidad + codOficina;
        String infoCalcularSegonDigit = codCuenta;
        codControl += calularDigitCodControl(infoCalcularPrimerDigit);
        codControl += calularDigitCodControl(infoCalcularSegonDigit);
    }
    public void mostrarCodigoCuentaCliente(){
        System.out.println(codEntidad+" "+codOficina+" "+codControl+" "+codCuenta);
    }

}
