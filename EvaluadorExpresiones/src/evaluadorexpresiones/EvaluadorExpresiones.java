
package evaluadorexpresiones;

import java.util.Scanner;


public class EvaluadorExpresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la expresion que desee evaluar; ");
        String infija = sc.next();
        System.out.println("El resultado es: "+ Evaluador.evaluar(infija));
    }
    
}
