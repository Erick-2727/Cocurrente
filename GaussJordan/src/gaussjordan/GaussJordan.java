/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussjordan;

/**
 *
 * @author Erick
 */
public class GaussJordan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

    }

    public static void ordenar(double[][] a) {
        int fil, col;
        fil = a.length;
        col = a[0].length;
        double mult;

        for (int i = 0; i < fil; i++) {
            for (int j = i+1; j < col; j++) {
                if (a[j][i]!=0) {
                    sumarFilas(a,i,j,col);
                }
             
            }
        }

    }

    public static void sumarFilas(double[][] a, int f1, int f2, int col) {
        double mult = a[f2][f1] / a[f1][f1];
        System.out.println("Sumo la fila "+f2+"con la fila "+f1+"*"+mult);
        for (int i = f1; i < col; i++) {
            a[f2][i] = a[f2][i] - a[f1][i] * mult;
        }

    }
}
