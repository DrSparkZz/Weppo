
package com.weppo.chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 20.04.2015
  * @author 
  */

public class Fehler extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JButton jButton1 = new JButton();
  // Ende Attribute
  
  public Fehler(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 253; 
    int frameHeight = 129;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    jLabel1.setBounds(8, 24, 225, 25);
    jLabel1.setText("Bitte benutze einen anderen Nickname!");
    cp.add(jLabel1);
    jLabel2.setBounds(8, 8, 208, 20);
    jLabel2.setText("Dein Nickname ist bereits vergeben!");
    cp.add(jLabel2);
    jButton1.setBounds(72, 56, 75, 25);
    jButton1.setText("Ok");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Fehler
  
  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    this.dispose();
  } // end of jButton1_ActionPerformed
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new Fehler("Fehler");
  } // end of main
  
} // end of class Fehler
