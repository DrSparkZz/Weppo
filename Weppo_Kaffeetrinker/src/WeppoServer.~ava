
package com.weppo.chat;

import java.io.*;
import java.net.*;
import java.util.*;

public class WeppoServer
{
  ArrayList clientAusgabeStroeme;
  
  public class ClientHandler implements Runnable
  {
    BufferedReader reader;
    Socket sock;
    
    public ClientHandler(Socket clientSocket)
    {
      try 
      { 
        sock = clientSocket;
        InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
        reader = new BufferedReader(isReader);    
        
      } catch(Exception ex) {ex.printStackTrace();}      
    } 
    
    public void run()
    {
      String nachricht;
      try
      {
        while ((nachricht = reader.readLine()) != null) 
        { 
          System.out.println("Gelesen: " + nachricht);
          esAllenWeitersagen(nachricht);
        }       
      } catch(Exception ex) {ex.printStackTrace();}
    }
  }
  
  
  public static void main(String[] args) 
  {        
    new WeppoServer().los();
  } 
  
  public void los ()
  {
    clientAusgabeStroeme = new ArrayList();
    
    try
    {
      ServerSocket serverSock = new ServerSocket(5001);
      
      while (true) 
      { 
        Socket clientSocket = serverSock.accept();
        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
        clientAusgabeStroeme.add(writer);
        Thread t = new Thread(new ClientHandler(clientSocket));
        t.start();
        System.out.println(LoginDialog.txtNickname.getText() + "Habe eine Verbindung!");
      }  
    } catch(Exception ex) {ex.printStackTrace();}
  }
  
  //if (LoginDialog.txtNickname.getText() == Weppo.nickname) {
  //   Fehler.main(null); 
  //} // end of if
  
  public void esAllenWeitersagen(String nachricht)
  {
    Iterator it = clientAusgabeStroeme.iterator();
    while (it.hasNext()) 
    { 
      try
      {
        PrintWriter writer = (PrintWriter) it.next();
        writer.println(nachricht);
        writer.flush();
      } catch (Exception ex) {ex.printStackTrace();}
    } 
  }
}