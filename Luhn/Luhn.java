package Luhn;

public class Luhn {
    private String numCuenta = "7992739871";
    private String numCuentaConNumVerificacion;

    public Luhn(String numCuenta) {
        this.numCuenta = numCuenta;
        calcLuhn();
    }

    public Luhn() {
        calcLuhn();
    }

    private int sumNumbers(String numerosCuenta) {
        final int firstPosition = 0;
        int totalSum = 0, index, digitNum;
        boolean isIndexPar;
        for (index = numerosCuenta.length() - 1; index >= firstPosition; index--) {
            digitNum = Character.getNumericValue(numerosCuenta.charAt(index));
            isIndexPar = (index + 1) % 2 == 0;
            if (isIndexPar) {
                digitNum = digitNum * 2;
                digitNum = (digitNum % 10) + (digitNum / 10);
            }
            totalSum += digitNum;
        }
        return totalSum;
    }

    private void calcLuhn() {
        int totalSum = sumNumbers(numCuenta);
        int checkDigit = (totalSum * 9) % 10;
        numCuentaConNumVerificacion = numCuenta + checkDigit;
    }


    public boolean checkValidAccountNumber() {
        int totalSum = sumNumbers(numCuentaConNumVerificacion);
        return totalSum % 10 == 0;
    }

    public void printCompleteAccount() {
        System.out.println(numCuentaConNumVerificacion);
    }
}