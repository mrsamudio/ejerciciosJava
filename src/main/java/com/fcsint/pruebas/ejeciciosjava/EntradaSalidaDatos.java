/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcsint.pruebas.ejeciciosjava;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mario
 */
public class EntradaSalidaDatos {
    
    public EntradaSalidaDatos(){
        
        digitarMes(7, 'Z');
    }
    
    /**
     * El método escribirá en un archivo un calendario para ese mes
     * @param mes
     * @param dia 
     */
    public void digitarMes(int mes, char dia){
        
        List<Character> dias = new ArrayList<Character>();
        dias.add('L'); //lunes
        dias.add('M'); //martes
        dias.add('Z'); //miercoles
        dias.add('J'); //jueves
        dias.add('V'); //viernes
        dias.add('S'); //sabado
        dias.add('D'); //domingo
        
        char[] losDias = new char[dia];
        
//        //SortedMap<Character, String> diass = new TreeMap<>();
//        Map<Character, String> diass = new HashMap<>();
//        diass.put('L', "lunes"); 
//        diass.put('M', "martes");
//        diass.put('Z', "miércoles");
//        diass.put('J', "jueves");
//        diass.put('V', "viernes");
//        diass.put('S', "sábado");
//        diass.put('D', "domingo");
        
        Calendar cal = Calendar.getInstance();
        
        //El nombre del mes
        cal.set(Calendar.MONTH, mes-1);
        String elMes = cal.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault());
        
        // El primer día del mes
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault()));
        String elDia = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault());
        
        //System.out.println(cal.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.getDefault()));
        //System.out.println(cal.getDisplayName(Calendar.HOUR_OF_DAY, Calendar.LONG_FORMAT, Locale.getDefault()));
        
        //Iteración sobre los días
        for (Character entry : dias) {
            System.out.println(entry);
        }
        

        try {
          
            //archivo de escritura        
            Writer writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(
                                    mes + "_" + elMes + ".txt"), "UTF-8"));
            
            writer.write(elMes + "\n");
            
            //Iteración sobre los días
            for (Character entry : dias) {

                //System.out.println(entry);
                writer.write(entry + "\t");
            }
            
            writer.write("\n");
            
            // Variables de control paa iteración
            int sem = cal.getMaximum(Calendar.WEEK_OF_MONTH);
            int max = cal.getMaximum(Calendar.DAY_OF_WEEK);
            int control =1;
            
            // Iteración de los días del mes
            for (int i = 1; i < sem; i++) {
                for (int j = 1; j <= max; j++) {
                    
                    if(cal.getMaximum(Calendar.DAY_OF_MONTH) >= control){
                        writer.write( control + "\t");
                        control++;
                    }
                        
                }
                
                writer.write("\n");
                if(cal.getMaximum(Calendar.DAY_OF_MONTH) > control)
                    control++;
            }
            
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(
                    EntradaSalidaDatos.class
                            .getName()).log(Level.SEVERE, null, ex);
        }       
    }   
}
