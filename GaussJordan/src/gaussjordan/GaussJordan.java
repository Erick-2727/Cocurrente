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
        int fil = 4, col = 4;
        double[][] a = new double[fil][col];
        a[0][0] = 1;a[0][1] = 2; a[0][2] = 1;a[0][3] = 4;
        a[1][0] = 2;a[1][1] = 0;a[1][2] = 4;a[1][3] = 3;
        a[2][0] = 4; a[2][1] = 2;a[2][2] = 2;a[2][3] = 1;
        a[3][0] = 3; a[3][1] = 1;a[3][2] = 3;a[3][3] = 3;
        gauss(a);
    }

    public static void gauss(double[][] a) {
        int fil, col;
        fil = a.length;
        col = a[0].length;
        mostrarMatriz(a);
        for (int i = 0; i < fil; i++) {
            intercambiarFila(a, i);
            for (int j = i + 1; j < col; j++) {
                
                if (a[j][i] != 0) {
                    sumarFilas(a, i, j);
                }

            }
        }

    }

    public static void sumarFilas(double[][] a, int f1, int f2) {
        int col,x=f1,y=f2;
        col = a[0].length;
        double mult = a[f2][f1] / a[f1][f1];
        double mult2=mult*-1;
        System.out.println("Sumo la fila " +y + " con la fila " + x + "*" + mult2);
        
        for (int i = f1; i < col; i++) {
            a[f2][i] = a[f2][i] - a[f1][i] * mult;
        }
        mostrarMatriz(a);

    }

    public static void intercambiarFila(double[][] a, int f1) {
        boolean intercambio = false;
        double temp;
        int fils, cols, cont = f1 + 1;
        fils = a.length;
        cols = a[0].length;
        if (a[f1][f1] == 0) {
            while (!intercambio && cont < fils) {
                if (a[cont][f1] != 0) {
                    int x=f1+1,y=cont+1;
                    System.out.println("Intercambio la fila " + x + " con la fila "+ y);
                    for (int i = 0; i < cols; i++) {
                        temp = a[f1][i];
                        a[f1][i] = a[cont][i];
                        a[cont][i] = temp;
                    }
                    intercambio = true;
                } else {
                    cont++;
                }
            }

        }
    }

    public static void mostrarMatriz(double[][] a) {
        int fil, col;
        fil = a.length;
        col = a[0].length;
        for (int i = 0; i < fil; i++) {
            for (int j = 0; j < col; j++) {
                if (a[i][j] % 1 == 0) {
                    System.out.print((int) a[i][j] + "  ");
                } else {
                    System.out.print(a[i][j] + " ");

                }

            }
            System.out.println("");
        }

    }
}
