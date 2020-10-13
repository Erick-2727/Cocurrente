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
public class PollosHermanos {
public static void main(String[] args){
        
        Restaurant barberia = new Restaurant();
        Mozo mozo = new Mozo(barberia,"Edgar");
        Cocinero cocinero =new Cocinero(barberia,"manuel");
        Empleado[] empleados = new Empleado[6];
        
        Thread hiloMozo = new Thread(mozo,"Mozo");
        Thread hiloCocinero = new Thread(cocinero,"Cocinero");
        inicioClientes(empleados, barberia);
        
        Thread h1 = new Thread(empleados[0],"Hector");
        Thread h2 = new Thread(empleados[1],"Jack");
        Thread h3 = new Thread(empleados[2],"William");
        Thread h4 = new Thread(empleados[3],"Edgar");
        Thread h5 = new Thread(empleados[4],"Butcher");
        Thread h6 = new Thread(empleados[5],"Sirius");
        Thread[] threads={h1,h2,h3,h4,h5,h6};
        hiloMozo.start();
        hiloCocinero.start();
        for(int i = 0; i < 6; i++){
            threads[i].start();
        }

//        BarberiaVisual bv = new BarberiaVisual(clientes, barbero, barberia);
//        bv.iniciarMain();
    }
    
    
    private static void inicioClientes(Empleado[] empleados, Restaurant resto){
        
        String[] nombres = {"\u001B[40;31mHector", "\u001B[40;32mJack", "\u001B[40;33mWilliam",
                            "\u001B[40;34mEdgar", "\u001B[40;35mButcher", "\u001B[40;36mSirius"};
        
        for(int i = 0; i < 6; i++){
            empleados[i] = new Empleado(resto, nombres[i]);
        }
    }
}
