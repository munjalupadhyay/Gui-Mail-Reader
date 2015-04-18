import java.awt.*; 
import javax.swing.*;

class MyFrame extends JFrame
{
  JPanel panel;
  JLabel label1,label2;
  int i=0;

  // constructor
  MyFrame( String title )
  {
    super( title );                      // invoke the JFrame constructor
    setSize( 400, 500 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    
    setLayout( new FlowLayout() );       // set the layout manager
    label1 = new JLabel("Hello Swing!");  // construct a JLabel
    add( label1 );                        // add the label to the JFrame
    label2 = new JLabel("Hello Swingggg!");  // construct a JLabel
    add( label2 ); 






  }

} 

public class t3
{
  public static void main ( String[] args )
  {
    MyFrame frame = new MyFrame("Hello"); // construct a MyFrame object
    frame.setVisible( true );             // ask it to become visible
  }
}
