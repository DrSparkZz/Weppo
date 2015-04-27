import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 24.03.2015
  * @author
  */
public class asd extends JFrame {
  // Anfang Attribute
  // Ende Attribute

  public asd(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300;
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  // Ende Methoden

  public static void main(String[] args) {
    new asd("asd");
  }
}
