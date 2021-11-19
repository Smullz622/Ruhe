/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author apl5638
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoodChart {
    int value[];
    int start = 0;

    Color[] colors = {Color.red, Color.green, Color.blue, Color.orange};
    public MoodChart(String[] args)
    {
        value = new int[args.length];

        for(int i = 0; i<args.length; i++) //Error at this line
        {
            value[i] = Integer.parseInt(args[i]);
        }

    }

    public void paintComponent(Graphics g)  {
         if (value == null) {
             return;
         }
        for(int i = 0; i<value.length; i++) {
            g.setColor(colors[i%colors.length]);
            g.fillArc(150, 150, 200, 200, start, value[i]);
            start = start + value[i];
        }

    }

    public static void main(String args[])
    {
        JFrame f = new JFrame("Piechart");
        MoodChart p = new MoodChart(new String[]{"90","90","90", "90"});

        f.add(p);
        p.setPreferredSize(new Dimension(400, 400));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.repaint();
    }
}