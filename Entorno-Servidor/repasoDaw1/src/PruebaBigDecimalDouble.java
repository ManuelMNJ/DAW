
import java.math.BigDecimal;

public class PruebaBigDecimalDouble {

    public static void main(String[] args) {

        double valor = 0.1d;
        System.out.println(Double.toString(valor));

        //No utilizar double con el constructor
        BigDecimal bdD = new BigDecimal(0.1);
        System.out.println(bdD);
        // Salida: 0.1000000000000000055511151231257827021181583404541015625
        BigDecimal bdStr = new BigDecimal("0.1");
        System.out.println(bdStr);
        // Salida: 0.1

        // valueOf double es más seguro que el constructor de double
        BigDecimal bd = BigDecimal.valueOf(0.1d);
        System.out.println(bd);
        // Salida: 0.1
        // pero no es 100% seguro

        BigDecimal x = BigDecimal.valueOf(1.01234567890123456789);
        System.out.println(x);
        // Salida:1.0123456789012346
        BigDecimal y = new BigDecimal("1.01234567890123456789");
        BigDecimal average = y.setScale( 2, BigDecimal.ROUND_DOWN);
        System.out.println(y);
        System.out.println(average);

        // Salida: 1.01234567890123456789

        //CONCLUSIÓN:
        //NÚMEROS DECIMALES CONSTRUIDOS EN BigDecimal DESDE STRING SIEMPRE
    }
}