/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Ameli
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SleepChart extends JPanel
{

    private JFrame frame;
    private int[] yCoords;

    public SleepChart(int[] args)
    {
        yCoords = args;
    //    createAndShowGui();
    }
 //   private int[] yCoords;
//        private int startX = 100;
//        private int startY = 100;
//        private int endX = 400;
//        private int endY = 400;
//        private int unitX = (endX - startX) / 10;
//        private int unitY = (endY - startY) / 10;
//        private int prevX = startX;
//        private int prevY = endY;

//        public GraphDrawer(int[] yCoords)
//        {
//            this.yCoords = yCoords;
//        }

        @Override
        protected void paintComponent(Graphics g)
        {
         int startX = 100;
         int startY = 100;
         int endX = 400;
         int endY = 400;
         int unitX = (endX - startX) / 10;
         int unitY = (endY - startY) / 10;
         int prevX = startX;
         int prevY = endY;
        
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.LIGHT_GRAY);
            for (int i = startX; i <= endX; i += unitX)
            {
                g2d.drawLine(i, startY, i, endY);
            }

            for (int i = startY; i <= endY; i += unitY)
            {
                g2d.drawLine(startX, i, endX, i);
            }

            g2d.setColor(Color.BLACK);
            g2d.drawLine(startX, startY, startX, endY);
            g2d.drawLine(startX, endY, endX, endY);

            g2d.setColor(Color.RED);
            for (int y : yCoords)
            {
                g2d.drawLine(prevX, prevY, prevX += unitX, prevY = endY - (y * unitY));
            }
        }

//        @Override
//        public Dimension getPreferredSize()
//        {
//            return new Dimension(endX + 100, endY + 100);
//        }
//
//    private void createAndShowGui()
//    {
//     //   frame = new JFrame(getClass().getSimpleName());
//
//        GraphDrawer drawer = new GraphDrawer(yCoords);
//
////        frame.add(drawer);
////        frame.pack();
////        frame.setVisible(true);
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    @SuppressWarnings("serial")
//    class GraphDrawer extends JPanel
//    {
//
//        private int[] yCoords;
//        private int startX = 100;
//        private int startY = 100;
//        private int endX = 400;
//        private int endY = 400;
//        private int unitX = (endX - startX) / 10;
//        private int unitY = (endY - startY) / 10;
//        private int prevX = startX;
//        private int prevY = endY;
//
//        public GraphDrawer(int[] yCoords)
//        {
//            this.yCoords = yCoords;
//        }
//
//        @Override
//        protected void paintComponent(Graphics g)
//        {
//            super.paintComponent(g);
//            Graphics2D g2d = (Graphics2D) g;
//
//            g2d.setColor(Color.LIGHT_GRAY);
//            for (int i = startX; i <= endX; i += unitX)
//            {
//                g2d.drawLine(i, startY, i, endY);
//            }
//
//            for (int i = startY; i <= endY; i += unitY)
//            {
//                g2d.drawLine(startX, i, endX, i);
//            }
//
//            g2d.setColor(Color.BLACK);
//            g2d.drawLine(startX, startY, startX, endY);
//            g2d.drawLine(startX, endY, endX, endY);
//
//            g2d.setColor(Color.RED);
//            for (int y : yCoords)
//            {
//                g2d.drawLine(prevX, prevY, prevX += unitX, prevY = endY - (y * unitY));
//            }
//        }
//
//        @Override
//        public Dimension getPreferredSize()
//        {
//            return new Dimension(endX + 100, endY + 100);
//        }
//    }
}
