/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcsint.pruebas.ejeciciosjava;

import java.util.Scanner;

/**
 *
 * @author Mario
 */
public class EntradaTeclado {
    
    public EntradaTeclado(){}
    
    public int leer(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    
    public void solicita(){
        
        int  entrada = 0, res = 0, c3 = 3, c2 = 2 , consec = 7, valor = 0;
        
        while(res <= 100){

            // Se introduzca 3 veces el valor 3 
            while(c3>0){
                System.out.println("Por favor ingrese el número 3 (le faltan " 
                        + c3 + " números 3): ");
                entrada = leer();
                if(entrada == 3){
                    res += entrada;
                    c3--;
                }
            }
            
            //  Se introduzca 2 veces el valor 2 
            while(c2>0){
                System.out.println("Por favor ingrese el número 2 (le faltan " 
                        + c2 + " números 2): ");
                entrada = leer();
                if(entrada == 2){
                    res += entrada;
                    c2--;
                }
            }
            
            // Se introduzca 8 veces consecutivas el mismo valor
            System.out.println("Por favor ingrese otro número: ");
                entrada = leer();
                valor = entrada;
                res += entrada;
            
            while(consec > 0){
                System.out.println("Por favor ingrese el número " + valor 
                        + "(le faltan " + consec + " números " + valor + "): ");
                entrada = leer();
                if(valor == entrada){
                    res += entrada;
                    consec--;
                }
            }
            entrada = 0;
        }
    }
    
}
