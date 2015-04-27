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
public class ZuWenig extends JFrame {
  // Anfang Attribute
  private JLabel jLabel1 = new JLabel();
  private JButton jButton1 = new JButton();
  // Ende Attribute

  public ZuWenig(String title) {
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 263;
    int frameHeight = 91;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten

    jLabel1.setBounds(16, 8, 231, 16);
    jLabel1.setText("Hast du vergessen etwas einzugeben?");
    jLabel1.setFont(new Font("MS Sans Serif", Font.PLAIN, 13));
    cp.add(jLabel1);
    jButton1.setBounds(80, 32, 89, 25);
    jButton1.setText("Zurück");
    jButton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        jButton1_ActionPerformed(evt);
      }
    });
    cp.add(jButton1);
    // Ende Komponenten

    setResizable(false);
    setVisible(true);
  }

  // Anfang Methoden
  public void jButton1_ActionPerformed(ActionEvent evt) {
    this.dispose();
  }

  // Ende Methoden

  public static void main(String[] args) {
    new ZuWenig("ZuWenig");
  }
}
