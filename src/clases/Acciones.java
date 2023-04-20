/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author jacqueline
 */
public class Acciones implements ActionListener{

    private int x;
    private int y;
    private int minas;
    private int filas;
    private int columnas;
    int matrizLogica[][];
    JButton matrizBotones[][];
    
    public Acciones(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Acciones(int matrizLogica[][] , JButton matrizBotones[][], int x, int y) {
        this.x = x;
        this.y = y;
        this.matrizLogica = matrizLogica; 
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        if (matrizLogica[x][y] == -1) {
            JOptionPane.showMessageDialog(null, "¡Has perdido!");
            //reiniciarJuego();
        } else {
            mostrarCasilla(x, y);
            if (casillasRestantes() == minas) {
                JOptionPane.showMessageDialog(null, "¡Has ganado!");
                //reiniciarJuego();
            }
        }
    }
    
    private void mostrarCasilla(int x, int y) {
        if (matrizBotones[x][y].isEnabled()) {
            matrizBotones[x][y].setEnabled(false);
            matrizBotones[x][y].setText("" + matrizLogica[x][y]);
            if (matrizLogica[x][y] == 0) {
                if (x > 0 && y > 0) mostrarCasilla(x-1, y-1);
                if (x > 0) mostrarCasilla(x-1, y);
                if (x > 0 && y < columnas-1) mostrarCasilla(x-1, y+1);
                if (y > 0) mostrarCasilla(x, y-1);
                if (y < columnas-1) mostrarCasilla(x, y+1);
                if (x < filas-1 && y > 0) mostrarCasilla(x+1, y-1);
                if (x < filas-1) mostrarCasilla(x+1, y);
                if (x < filas-1 && y < columnas-1) mostrarCasilla(x+1, y+1);
            }
        }
    }
    
    private int casillasRestantes() {
        int casillasRestantes = filas * columnas - minas;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!matrizBotones[i][j].isEnabled()) {
                    casillasRestantes--;
                }
            }
        }
        return casillasRestantes;
    }
}
