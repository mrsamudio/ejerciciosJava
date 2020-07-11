/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcsint.pruebas.ejeciciosjava;

/**
 * 
 * @author Mario
 */
public class main {
    
    public static void main(String[] args) {
        
        EntradaTeclado entrada = new EntradaTeclado();
        
        //Ejercicio Fibonacci
        System.out.println("Ejercicio Fibonacci");
        System.out.println("Por favor ingrese el término para fibonacci: ");
        int term = entrada.leer();
        System.out.println("El termino " + term + " de la serie de Fibonacci recursiva es: " + fibonaciRec(term));
        System.out.println("El termino " + term + " de la serie de Fibonacci iterativa es: " + fibonacciIter(term) + "\n");
        System.out.println("**************************************************");
        
        //Ejercicio entrada de teclado
        System.out.println("Ejercicio entrada");
        entrada.solicita();
        
        //Ejercicio AccesoAleaorio
        AccesoAleatorio a = new AccesoAleatorio();
        a.actualizarArchivoPrecios("precio.csv");

        EntradaSalidaDatos b = new EntradaSalidaDatos();
        
        
    }
    
    /**
     * Fibonacci de forma iterativa
     * @param iesimo
     * @return 
     */
    private static int fibonacciIter(int iesimo){
        int fib = 0, fibAnt = 1;
        
        for (int i = 0; i < iesimo; i++) {
            
            fib  += fibAnt;
            fibAnt = fib - fibAnt;

            //System.out.println(fib);
        }
            return fib;
    }
    
    /**
     *  Fibonacci de forma recursiva
     * @param iesimo
     * @return 
     */
    private static int fibonaciRec(int iesimo){
        if (iesimo < 2)
            return iesimo;
        else
            return ( fibonaciRec(iesimo - 1) + fibonaciRec( iesimo -2 ) );
    }
    
    
}


