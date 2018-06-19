/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluadorexpresiones;

/**
 *
 * @author alaina
 */
public class Evaluador {
  
    public static double evaluar(String infija){
        String posfija = convertir(infija);
        System.out.println(posfija);
        return evaluarPosfija(posfija);
    }

    private static String convertir(String infija) {
        String posfija = "";
        Pila pila = new Pila(100);
        for (int i = 0; i < infija.length(); i++) {
            char letra = infija.charAt(i);
            if(esOperador(letra)) {
              if(pila.estaVacia()) {
                  pila.apilar(letra);
              } else {
                  int pe= prioridadEnExpresion(letra);
                  int pp= prioridadEnPila((char)pila.elementoTope());
                  if (pe>pp){
                      pila.apilar(letra);
                  } else {
                      posfija += pila.desapilar();
                      pila.apilar(letra);
                              
                  }
              }
            } else {
                posfija += letra;
            }
        }
        while(!pila.estaVacia()) {
            posfija+=pila.desapilar();
        }
        return posfija;
    }
    
    private static int prioridadEnExpresion(char operador) {
        if (operador == '!') return 4;
        if (operador == '*' || operador == '/') return 2;
        if (operador == '+' || operador == '-') return 1;
        if (operador == '(') return 5;
        return 0; 
    }

    private static int prioridadEnPila(char operador) {
        if (operador == '!') return 3;
        if (operador == '*' || operador == '/') return 2;
        if (operador == '+' || operador == '-') return 1;
        if (operador == '(') return 0;
        return 0; 
    }
    
    private static double evaluarPosfija(String posfija) {
        return 0;
    }

    private static boolean esOperador(char letra) {
        if(letra== '*' || letra== '/' || letra== '+' || letra== '-' || letra== '(' ||  letra== ')' || letra== '!') {
            return true;
        }
        return false; 
    }
}
