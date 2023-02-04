/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgfinal.project;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author bhavj
 */
public class MyFrame extends JFrame{

         int r1;
         int x1;
         int y1;
         MyPanel panel;

   MyFrame() throws InterruptedException{
         panel= new MyPanel(); 
         //circle data
         panel.cr=AnimationPlayer.r1;
         panel.cor=AnimationPlayer.red1;
         panel.cob=AnimationPlayer.blue1;
         panel.cog=AnimationPlayer.green1;
         panel.x=AnimationPlayer.x1;
         panel.y=AnimationPlayer.y1;
         panel.w=AnimationPlayer.w1;
         panel.l=AnimationPlayer.l1;
         panel.borderr=AnimationPlayer.borderThickness1;
         //rect data
         panel.l=AnimationPlayer.l1;
         panel.w=AnimationPlayer.w1;
         panel.rcob=AnimationPlayer.blue1r;
         panel.rcog=AnimationPlayer.green1r;
         panel.rcor=AnimationPlayer.red1r;
         panel.xr=AnimationPlayer.x1r;
         panel.yr=AnimationPlayer.y1r;
         panel.rborderr=AnimationPlayer.borderThickness1r;
         panel.effects=AnimationPlayer.effects;
         panel.readlist();
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.add(panel);
         this.pack();
         this.setLocationRelativeTo(null);
         this.setVisible(true);   
   
     }

}
