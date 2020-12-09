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
public class Productor extends Thread{
    
    private Buffer buffer;
    private String name;
    
    public Productor(Buffer buffer,String name){
        this.buffer = buffer;
        this.name=name;
        
        
    }
    
    public void run(){
        
        while(true){
            buffer.ponerElemento(name);
        }
    }
}
