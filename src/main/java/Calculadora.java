import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Calculadora {

    //Declaracion de operadores a travez de una funcion
    //Se declaran inmutables
    static final IntBinaryOperator suma = (a, b) -> a + b;

    static final IntBinaryOperator resta = (a, b) -> a - b;


    //La multiplicacion se compone de la funcion operador suma definida anteriormente
    static final IntBinaryOperator multiplicacion = (a, b) -> {
        return IntStream.range(0, Math.abs(b) + 1)
                .reduce((acu, num) -> suma.applyAsInt(Math.abs(a), acu)).getAsInt();
    };

    //La division se compone de funcion operador  multiplicacion la suma
    static final IntBinaryOperator division = (a, b) -> {

        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir entre 0");
        } else {
            return IntStream.range(0, Math.abs(a))
                    .reduce((acu, num) -> multiplicacion.applyAsInt(num, b) <= a ? suma.applyAsInt(acu, 1) : acu).getAsInt();
        }
        
    };

    public static void main(String[] args) {
        //Pruebas de funcionamiento
        //TODO: validacion de division entre 0
        System.out.println("La suma es " + suma.applyAsInt(2, 3));
        System.out.println("La resta es " + resta.applyAsInt(7, 5));
        System.out.println("La multiplicacion es " + multiplicacion.applyAsInt(2, 4));
        System.out.println("La division es " + division.applyAsInt(20, 0));
    }
}


