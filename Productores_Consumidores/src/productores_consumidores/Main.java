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
public class Main {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args){
        
        int cant = 10;
        
        Buffer buffer = new Buffer();
        Consumidor[] consumidores = new Consumidor[cant];
        Productor[] productores = new Productor[cant];
        Selector s = new Selector(buffer);
        
        for(int i = 0; i < cant; i++){
            consumidores[i] = new Consumidor(buffer,"Consumidor "+i);
            productores[i] = new Productor(buffer,"Productor "+i);
        }
        
        for(int i = 0; i < cant; i++){
            consumidores[i].start();
            productores[i].start();
        }
        
        s.start();
    }
}

