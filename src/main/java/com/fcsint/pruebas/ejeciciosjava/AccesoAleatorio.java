/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fcsint.pruebas.ejeciciosjava;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario
 */
public class AccesoAleatorio {

    public AccesoAleatorio(){}
    
    public void actualizarArchivoPrecios(String nombreArch){
               
        try {
           
            CSVReader csvReader = new CSVReader(new FileReader(new File(nombreArch)));
            List<String[]> datoss = csvReader.readAll();
            
            CSVWriter writer = new CSVWriter(new FileWriter("nuevosPrecios.csv"));
            
            // Iteración que actaliza los precios de la lista del archivo
            for (String[] columna : datoss) {
                if(Double.parseDouble(columna[1]) > 100){
                    // Disminuye un 20%
                    columna[1] = String.valueOf(
                            Double.parseDouble(columna[1]) - (Double.parseDouble(columna[1])*0.2)
                    );
                    writer.writeNext(columna);

                }else if(Double.parseDouble(columna[1]) < 100){
                    // Incrementa un 25% 
                    columna[1] = String.valueOf(
                            Double.parseDouble(columna[1]) + (Double.parseDouble(columna[1])*0.25)
                    );
                    writer.writeNext(columna);
                }

                System.out.println("Coulmn = " + columna[0] + " , Column = " + columna[1]);
            }
            
            csvReader.close();
            writer.close();
            
        } catch (FileNotFoundException e) {
             Logger.getLogger(
                    AccesoAleatorio.class.getName()).log(Level.SEVERE, null, e);
        } catch(IOException | CsvException e){
            Logger.getLogger(
                    AccesoAleatorio.class.getName()).log(Level.SEVERE, null, e);
        }
            
    }
        
    
}
