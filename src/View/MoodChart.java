/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoodChart extends JPanel
{

    int value[];
    int start = 0;
    Graphics2D g2d;
    Graphics g;

    Color[] colors =
    {
        Color.red, Color.blue, Color.yellow
    };

    public MoodChart(int[] args)
    {
        value = args;

    }

    @Override
    public void paintComponent(Graphics g)
    {
        this.g = g;
        super.paintComponent(g);
        if (value == null)
        {
            return;
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < value.length; i++)
        {
            g2d.setColor(colors[i % colors.length]);
            g2d.fillArc(150, 150, 200, 200, start, value[i]);
            start = start + value[i];
        }

    }

    public void setValue(int[] args)
    {
        value = args; 
        repaint();
    }
    
    public void refresh(int[] args)
    {
        value = args;
        start = 0;
        
        for (int i = 0; i < value.length; i++)
        {
            g2d.setColor(colors[i % colors.length]);
            g2d.fillArc(150, 150, 200, 200, start, value[i]);
            start = start + value[i];
        }
    }

}
