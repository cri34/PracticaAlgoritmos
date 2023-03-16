package codigoUniversalProducto;

public class CodigoUniversalDeProducto {
    public static void main(String[] args) {
        String codigo = "03600029145";
        String codigo1 = "042100005264";
        System.out.println(calcularDigitoDeControl(codigo));
    }
    public static int calcularDigitoDeControl(String codigo){
        final int multiplicador = 3;
        final int dividendo = 10;
        int dC ;
        int dControl = sumarContenido(codigo,true);
        dControl *= multiplicador;
        dControl += sumarContenido(codigo,false);
        dC = dControl % dividendo;
        if (dC == 0)
            return dC;
        return 10 - dC;
    }
    private static int sumarContenido(String codigo,boolean par){
        int suma = 0;
        int dividendo = (par)?2:3;
        for (int i = 0; i < codigo.length(); i++){
            if (i % dividendo == 0) {

                suma += Character.getNumericValue(codigo.charAt(i));
            }
        }
       return suma;
    }


}
