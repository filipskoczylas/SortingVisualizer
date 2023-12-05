/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.FilipSkoczylas.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;

/**
 * Application main graphical window. Paints visual representation of sorting steps. 
 * @author Filip Skoczylas
 * @version f1
 * @since p1
 */
public class MainPanel extends JPanel{
    private final int LEFT_RIGHT_OFFSET = 10;
    private final int TOP_BOTTOM_OFFET = 10;
    private final int SCREEN_HEIGHT = 500;
    private final int SCREEN_WIDTH = 600;
    private int elementLength;
    private int pixelsPerValue;
    private int numberOfElements;
    //has to be public to be used in paintComponent
    private int maxElementSize;
    private ArrayList<Integer> printedArray;
    public MainPanel(int numberOfElements, int maxSize){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.white);
        //this.setBorder(BorderFactory.createLineBorder(Color.red));
        this.numberOfElements = numberOfElements;
        maxElementSize = maxSize;
        elementLength = (600 - 2 * LEFT_RIGHT_OFFSET)  / numberOfElements;
        pixelsPerValue = (500 - 2 * TOP_BOTTOM_OFFET) / maxSize;
        printedArray = new ArrayList<Integer>(Collections.nCopies(numberOfElements, 0));
    }
    public void setArray(ArrayList<Integer> list){
        printedArray = list;
        this.repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int i = 0; i < numberOfElements; i++) {
            g.setColor(Color.blue);
            int rectangleX = i * elementLength + LEFT_RIGHT_OFFSET;
            int rectangleY = TOP_BOTTOM_OFFET + (maxElementSize - printedArray.get(i)) * pixelsPerValue;
            int rectangleheight = SCREEN_HEIGHT - 2 * TOP_BOTTOM_OFFET - (maxElementSize - printedArray.get(i)) * pixelsPerValue;
            g.fillRect(rectangleX, rectangleY , elementLength, rectangleheight);
            g.setColor(Color.black);
            g.drawRect(rectangleX, rectangleY , elementLength, rectangleheight);
        }
    }
    
}
