/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productores_consumidores;

/**
 *
 * @author Erick
 */
public class Consumidor extends Thread {
    
    private Buffer buffer ;
    private String name;
    public Consumidor(Buffer buffer,String name){
        this.buffer = buffer;
        this.name=name;
    }
    
    public void run(){
        
        for (int i = 0; i < 50; i++) {
            
            buffer.consumirElemento(name);
        }
        System.out.println(name+": ya comi demasiado me voy a mi casa");
    }
}
