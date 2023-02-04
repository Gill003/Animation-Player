/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author bhavj
 */
public class MyPanel extends JPanel implements ActionListener {

    java.util.List<String> circle1 = new ArrayList<>();
    java.util.List<String> rect1 = new ArrayList<>();
    java.util.List<String> line1 = new ArrayList<>();
    java.util.List<String> effects = new ArrayList<>();
    Timer timer;
    final int PANEL_WIDTH = 400;
    final int PANEL_HEIGHT = 300;
    int l;
    int w;
    int x, x2;
    int y, y2;
    int xr, x2r;
    int yr, y2r;
    int xl, x2l;
    int yl, y2l;
    int cr;
    int cor, cob, cog;
    int bcor, bcob, bcog;
    int rcor, rcob, rcog;
    int rbcor, rbcob, rbcog;
    int lcor, lcob, lcog;
    int lbcor, lbcob, lbcog;
    int borderr;
    int rborderr;
    int lborderr;
    double ti = 0;
    boolean showc = false;
    boolean showr = false;
    boolean showl = false;
    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        timer = new Timer(500, this);
        timer.start();
    }
    public void readlist() {
        System.out.println(effects.size());
        for (int i = 0; i < effects.size(); i++) {
            System.out.println(effects.get(i));
        }
    }
    public void paint(Graphics g) {
        super.paint(g);//backround 
        Graphics2D g2Dc = (Graphics2D) g;
        Graphics2D g2Dr = (Graphics2D) g;
        Graphics2D g2Dl = (Graphics2D) g;
        
            if (showc == true) {
            g2Dc.setStroke(new BasicStroke(8)); //changes width
            g2Dc.setPaint(new Color(bcor, bcog, bcob)); //colour 
            g2Dc.drawOval(x - cr, y - cr, cr, cr); //creates circle, subtract raduis so that x and y are center coordinates
            g2Dc.setPaint(new Color(cor, cog, cob));
            g2Dc.fillOval(x - cr, y - cr, cr, cr);
        }
        if (showc == false) {
            g2Dc.setPaint(new Color(0, 0, 255, 0)); //hide 
            g2Dc.drawOval(x - cr, y - cr, cr, cr); //creates circle, subtract raduis so that x and y are center coordinates
            g2Dc.setPaint(new Color(0, 0, 255, 0));
            g2Dc.fillOval(x - cr, y - cr, cr, cr);
        }      
           if (showr == true) {
            g2Dr.setPaint(new Color(rbcor, rbcog, rbcob)); //colour
            g2Dr.setStroke(new BasicStroke(rborderr)); //changes width
            g2Dr.drawRect(xr, yr, w, l);
            g2Dr.setPaint(new Color(rcor, rcog, rcog)); //colour
            g2Dr.fillRect(xr, yr, w, l);
        }
        if (showr == false) {
            g2Dr.setPaint(new Color(0, 0, 255, 0)); //hide 
            g2Dr.setStroke(new BasicStroke(rborderr)); //changes width
            g2Dr.drawRect(xr, yr, w, l);
            g2Dr.setPaint(new Color(0, 0, 255, 0));
            g2Dr.fillRect(xr, yr, w, l);
        }  
        if (showl) {
            g2Dl.setPaint(new Color(lcor, lcob, lcog)); //colour
            g2Dl.setStroke(new BasicStroke(lborderr)); //changes width
            g2Dl.drawLine(xl, yl, x2l, y2l);
        }
       if (showl == false) {
            g2Dl.setPaint(new Color(0, 0, 255, 0)); //hide 
            g2Dl.setStroke(new BasicStroke(lborderr)); //changes width
            g2Dl.drawLine(xl, yl, x2l, y2l);
        }
    }
    public void actionPerformed(ActionEvent e) {
        ti = ti + 0.5;
        System.out.println(ti);
        for (int i = 0; i < effects.size(); i++) {
            String[] toarray = effects.get(i).split(",");
            String time = toarray[2];
            String shape = toarray[0];
            String effectt = toarray[1];
            double time2 = Double.parseDouble(time) / 10;
            if (ti == time2) {               
                switch (effectt) {
                    case "Show":
                        switch (shape) {
                            case "Circle":                              
                                showc = true;
                                repaint();
                                break;
                            case "Rect":
                               
                                showr = true;
                                repaint();
                                break;
                            case "Line":
                                showl = true;
                                repaint();
                                break;
                        }
                        break;
                    case "Hide":
                        switch (shape) {
                            case "Circle":                                
                                showc = false;
                                repaint();
                                break;
                            case "Rect":                              
                                showr = false;
                                repaint();
                                break;
                            case "Line":
                                showl = false;
                                repaint();
                                break;
                        }
                        break;                     
                      case "Jump":
                          switch (shape) {
                            case "Circle":                              
                                x=Integer.parseInt(toarray[3]);
                                y=Integer.parseInt(toarray[4]);
                                repaint();
                                break;
                            case "Rect":                               
                                xr=Integer.parseInt(toarray[3]);
                                yr=Integer.parseInt(toarray[4]);
                                repaint();
                                break;
                            case "Line":
                                xl=Integer.parseInt(toarray[3]);
                                yl=Integer.parseInt(toarray[4]);
                                
                                repaint();
                                break;
                        }
                        break;
                        case "Changecolor":
                          switch (shape) {
                            case "Circle":
                              cor=Integer.parseInt(toarray[3]);
                               cog=Integer.parseInt(toarray[4]);
                               cob=Integer.parseInt(toarray[5]);
                                repaint();
                                break;
                            case "Rect":
                               rcor=Integer.parseInt(toarray[3]);
                               rcog=Integer.parseInt(toarray[4]);
                               rcob=Integer.parseInt(toarray[5]);
                                repaint();
                                break;
                            case "Line": 
                               lcor=Integer.parseInt(toarray[3]);
                               lcog=Integer.parseInt(toarray[4]);
                               lcob=Integer.parseInt(toarray[5]);
                                repaint();
                                break;
                        }
                        break;                                              
                }

            }

        }

    }

}
