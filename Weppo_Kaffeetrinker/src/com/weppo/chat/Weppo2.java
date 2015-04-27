import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.04.2015
  * @author 
  */

public class Weppo2 extends Frame {
  // Anfang Attribute
  // Ende Attribute
  
  public Weppo2(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 496; 
    int frameHeight = 351;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Weppo2
  
  // Anfang Methoden
  // Ende Methoden
  
  public static void main(String[] args) {
    new Weppo2("Weppo2");
  } // end of main
  
} // end of class Weppo2
