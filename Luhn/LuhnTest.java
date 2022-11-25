package Luhn;

public class LuhnTest {
    public static void main(String[] args) {
        /* obtener numero de verificacion  de tarjeta de credito*/
Luhn l = new Luhn();
l.printCompleteAccount();
System.out.println(l.checkValidAccountNumber());
    }
}
