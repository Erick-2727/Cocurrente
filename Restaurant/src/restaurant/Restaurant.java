/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Erick
 */
public class Restaurant {

    private Semaphore semMozo = new Semaphore(0, true);
    private Semaphore semAtencionCocinero = new Semaphore(1, true);
    private Semaphore semCocinero = new Semaphore(0, true);
    private Semaphore semAtencionMozo = new Semaphore(1, true);
    private Semaphore mutexSillas = new Semaphore(1, true);
    private int espacio = 2;

    public Restaurant() {
    }

    //LO QUE HACE EL EMPLEADO
    public boolean entrar(String name) {
        System.out.println(name + " intenta ingresar");
        boolean pudoEntrar = verificarEspacio(name);
        if (!pudoEntrar) {
            System.out.println(name+" No pudo entrar por que no habia espacio " );}
        
        return pudoEntrar;
    }

    public boolean verificarEspacio(String name) {
        boolean ocupoAsiento = false;
        try {
            mutexSillas.acquire();
            if (espacio > 0) {
                espacio--;
                System.out.println(name + " pudo ingresar y quiere hacer un pedido");
                ocupoAsiento = true;
            }
            mutexSillas.release();
        } catch (InterruptedException ex) {
            System.out.println("Silla rota");
        }
        return ocupoAsiento;
    }

    public void pedirComida() {
        try {
            semAtencionCocinero.acquire();
            semCocinero.release();
        } catch (InterruptedException ex) {
            System.out.println("Error en pedir comida");
        }

    }

    public void pedirBebida() {
        try {
            semAtencionMozo.acquire();
            semMozo.release();
        } catch (InterruptedException ex) {
            System.out.println("Error en pedir bebida");
        }

    }

    public void salir(String name) {
        try {
            mutexSillas.acquire();
            espacio++;
            Thread.sleep(4000);
            System.out.println(name + " ya comio y se retira");
            mutexSillas.release();
        } catch (InterruptedException ex) {
            System.out.println("Silla rota");
        }
    }

    public void trabajarCocinero() {
        try {
            semCocinero.acquire();
            System.out.println("Que queres que te cocine");
            Thread.sleep(2000);
            System.out.println("Su comida ");
            semAtencionCocinero.release();
        } catch (InterruptedException ex) {
            System.out.println("Error en trabajo cocinero");
        }

    }

    public void trabajarMozo() {
        try {
            semMozo.acquire();
            System.out.println("Que quiere que le sirva señor");
            Thread.sleep(2000);
            System.out.println("Su bebida caballero");
            semAtencionMozo.release();
        } catch (InterruptedException ex) {
            System.out.println("Error en trabajo Mozo");
        }

    }

}
