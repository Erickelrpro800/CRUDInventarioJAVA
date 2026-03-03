/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author FAMILIA
 */
public class clsCliente {
    
    private Double numero_cliente;
    private String nombre;
    private String tipo_cliente;
    private String razon_social;
    
    public clsCliente(Double numero_cliente, String nombre, String tipo_cliente, String razon_social){
        this.numero_cliente = numero_cliente;
        this.nombre = nombre;
        this.tipo_cliente = tipo_cliente;
        this.razon_social = razon_social;
    }
    
    public clsCliente(){
        
    }
    
    public String aTexto(){
        String cliente = this.numero_cliente + "|" + this.nombre + "|" + this.tipo_cliente + "|" + this.razon_social;
        return cliente;
    }
    
    public void guardar(){
        mCliente client = new mCliente();
        client.insertar(this.aTexto());
        
        System.out.println(this.aTexto());
    }
    
    public DefaultListModel<String> llenarLista(){
        mCliente mClient = new mCliente();
        ArrayList<String> datos = mClient.consultar();
        
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        return modelLista;
    }
}
    

