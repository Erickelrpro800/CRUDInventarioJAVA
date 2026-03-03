/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

/**
 *
 * @author FAMILIA
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author FAMILIA
 */
public class mCliente {
        
    public void insertar(String cadenaCliente){
            
            try {
            // Esta linea crea el archivo donde se guarda la informacion
                FileWriter archivo = new FileWriter("listado_articulos.txt",true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
                BufferedWriter buffer = new BufferedWriter(archivo);
            
            // Escribe en el archivo de texto
            buffer.write(cadenaCliente); 
            // Agrega un salto de linea al registro
            buffer.newLine(); 
            // Guarda los registros en el archivo
            buffer.close();

        } catch (IOException e) {
            //lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }
           
    }

    public ArrayList<String> consultar(){
        
        ArrayList<String> listaRegistros = new ArrayList<>();
        
        try(BufferedReader br = new BufferedReader( new FileReader("listado_articulos.txt"))){
            String linea;
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split("\\|");
                String datoVisual = "Numero de cliente: " + datos[0] + "Nombre: " + datos[1] + "Tipo de cliente: " + datos[2] + "Razon social:" + datos[3];
                listaRegistros.add(datoVisual);
            }
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }
        return listaRegistros;
    }
    
}
