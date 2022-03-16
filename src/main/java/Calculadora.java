import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

    public class Calculadora {

        //Declaracion de operadores a travez de una funcion
        static final IntBinaryOperator suma = (a, b) -> a + b;

        static final IntBinaryOperator resta = (a, b) -> a - b;

        static final IntBinaryOperator multiplicacion = (a, b)-> {
            return IntStream.range(0, Math.abs(b) + 1)
                    .reduce((acu, num) -> suma.applyAsInt(Math.abs(a), acu)).getAsInt();};
        static final IntBinaryOperator division = (a,b) -> {
            return IntStream.range(0,Math.abs(a) )
                    .reduce((acu, num) -> multiplicacion.applyAsInt(num, b) <= a ? suma.applyAsInt(acu, 1) : acu).getAsInt();};


        public static void main(String[] args) {
            System.out.println("La suma es "+suma.applyAsInt(2,3));
            System.out.println("La resta es "+resta.applyAsInt(7,5));
            System.out.println("La multiplicacion es "+multiplicacion.applyAsInt(2,4));
            System.out.println("La resta es "+division.applyAsInt(20,10));
        }
    }


