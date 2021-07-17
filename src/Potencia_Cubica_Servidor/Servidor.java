/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Potencia_Cubica_Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Mireille Betancourt
 */
public class Servidor {
    
    public void iniciar() 
	{
        ServerSocket servidor;
        boolean fin = false;
        	try {
        		servidor = new ServerSocket(6000);
        		System.out.println("Servidor escuchando en el puerto 6000");
        
        		Socket socketManejoCliente = servidor.accept();
        		DataInputStream in= new DataInputStream(socketManejoCliente.getInputStream());
        		DataOutputStream out = new DataOutputStream(socketManejoCliente.getOutputStream());
        do 
        {
        Double mensaje =0d;
        mensaje = in.readDouble();
        System.out.println("El servidor recibio del cliente: "+ mensaje);
        
        out.writeDouble(mensaje*mensaje*mensaje);
        System.out.println("Se envio el mensaje: " + mensaje*mensaje*mensaje);
        
        	if (mensaje.equals(".")) 
        	{
        		fin= true;
        		System.out.println("Servidor apagado: ");
        	}
        }while(!fin);
        
        in.close();
        out.close();
        socketManejoCliente.close();
        servidor.close();
        
        	}catch (IOException e) {
        	e.printStackTrace();
        	}
		}
	
	public static void main(String args[]) 
	{
		Servidor servidor = new Servidor();
		servidor.iniciar();
	} 
}
