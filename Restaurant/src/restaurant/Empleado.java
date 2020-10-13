/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick
 */
public class Empleado implements Runnable {

    private Restaurant restaurant;
    private String nombre;

    public Empleado(Restaurant resto, String nomb) {
        restaurant = resto;
        nombre = nomb;

    }

    public void run() {
        Random bool = new Random();
        int x = bool.nextInt(3) + 1;
        boolean comio=false;
        while(!comio){
        if (restaurant.entrar(nombre)) {
            switch (x) {
                case 1:
                    System.out.println(nombre + " Quiere una bebida");
                    restaurant.pedirBebida();
                    break;
                case 2:
                    System.out.println(nombre + " Quiere una comida");
                    restaurant.pedirComida();
                    break;
                case 3:
                    System.out.println(nombre + " Quiere una bebida y comida");
                    restaurant.pedirBebida();
                    restaurant.pedirComida();
                    break;
            }
            comio=true;
            this.restaurant.salir(nombre);
        }else{
            try {
                System.out.println(nombre+ " Se va y vuelve en un rato");
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        }

    }

}
