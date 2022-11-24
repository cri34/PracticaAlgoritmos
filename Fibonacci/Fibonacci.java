package Fibonacci;

public class Fibonacci {
        int maxSequenceNumber = 17;
        int[] numeros = new int[maxSequenceNumber];

        public int[] calcFibonacci() {
            numeros[0] = 1;
            numeros[1] = 1;
            for (int index = 0; index < numeros.length - 2; index++) {
                numeros[index + 2] = numeros[index] + numeros[index + 1];
            }
            return numeros;
        }
        public void mostrarFibonacci ( int[] array){
            for (int index = 0; index < array.length; index++) {
                System.out.println(" " + array[index]);
            }
        }
}
