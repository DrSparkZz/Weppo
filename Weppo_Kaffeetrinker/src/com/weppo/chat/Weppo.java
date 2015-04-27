package com.weppo.chat;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Weppo {
  
  JTextArea eingang;
  JTextField ausgang;
  BufferedReader reader;
  PrintWriter writer;
  Socket sock;
  public String nickname;
  
  public static void main(String[] args) {
    Weppo client = new Weppo();
    client.los();
  }
  
  public void los() {
    JFrame frame = new JFrame("Weppo");
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    /*
    frame.addWindowListener(new java.awt.event.WindowAdapter() {
      @Override
      public void windowClosing(java.awt.event.WindowEvent windowEvent) {
        
        eingang.append(nickname + " hat die Verbindung getrennt."); 
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        if (JOptionPane.showConfirmDialog(frame,
        "Möchtest du dich wirklich abmelden?", "Abmelden",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
          System.exit(0);      
        }     
      }  
    });
    */  
    
    JPanel hauptPanel = new JPanel();
    
    JLabel jLabel1 = new JLabel();
    jLabel1.setBounds(120, 320, 44, 16);
    jLabel1.setText("Get from Server");
    jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    jLabel1.setVisible(true);
    
    JLabel jLabel2 = new JLabel();
    jLabel2.setBounds(120, 320, 44, 16);
    jLabel2.setText("Send to Server");
    jLabel2.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    jLabel2.setVisible(true);
    
    eingang = new JTextArea(13, 25);
    eingang.setLineWrap(true);
    eingang.setWrapStyleWord(true);
    eingang.setEditable(false);
    
    JScrollPane fScroller = new JScrollPane(eingang);
    fScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    fScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    
    ausgang = new JTextField(26);
    JButton senden = new JButton("Senden");
    senden.addActionListener(new SendenButtonListener());
    
    hauptPanel.add(jLabel1);
    hauptPanel.add(fScroller);
    hauptPanel.add(jLabel2);
    hauptPanel.add(ausgang);
    hauptPanel.add(senden);
    
    frame.getRootPane().setDefaultButton(senden);
    
    frame.getContentPane().add(BorderLayout.CENTER, hauptPanel);
    frame.setSize(350, 360);
    frame.setVisible(true);
    
    LoginDialog login;
    login = new LoginDialog(frame, true);
    login.setParentApp(this);
    
    login.setVisible(true);
    
  } 
  
  
  
  
  public void netzwerkEinrichten(String ip, Integer port) {
    try {
      sock = new Socket(ip, port);
      InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
      reader = new BufferedReader(streamReader);
      writer = new PrintWriter(sock.getOutputStream());
      
      messageAppender("Netzwerkverbindung steht!");
      
      Thread readerThread = new Thread(new EingehendReader());
      readerThread.start();  
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }    
  
  
  private class SendenButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
      try {   
        writer.println(nickname + ": " + ausgang.getText());
        writer.flush();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      ausgang.setText("");
      ausgang.requestFocus();
      
      // end of if-else
      
      
      //Den Text aus dem Textfeld holen und ihn mit dem writer
      //(einem PrintWriter) an den Server senden
    }
  } //innere Klasse SendenButtonListener schlie?en
  
  public void messageAppender(String message){
    eingang.append(message + "\n");
  }
  
  public class EingehendReader implements Runnable {
    public void run() {
      String nachricht;
      try {
        
        while ((nachricht = reader.readLine()) != null) {
          messageAppender(nachricht);
        }
        
      } catch (Exception ex) {
        ex.printStackTrace();
      }// au?ere Klasse schlie?en
    }
  }
}
    