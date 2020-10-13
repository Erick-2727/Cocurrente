/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Erick
 */
public class Cocinero implements Runnable {
    private Restaurant restaurant;
    private String nombre;
    
    public Cocinero(Restaurant resto,String nomb){
    restaurant=resto;
    nombre=nomb;}
    public void run(){
    this.restaurant.trabajarCocinero();
    }
}
