/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;

import javax.swing.JOptionPane;

/**
 *
 * @author Filip
 */
public class MessageBox {
    public static void show(String message, String title)
    {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
