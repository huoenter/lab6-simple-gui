import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Scanner;

public class SampleGUI extends JFrame implements ActionListener
{
	JButton textButton, imageButton;
	JLabel textLabel, imageLabel;


    public SampleGUI()
    {
        setLayout(new BorderLayout());
        
        textLabel = new JLabel("North");
        add("North",textLabel);
                
        imageButton = new JButton(createImage());
        add("West",imageButton);
                
        imageLabel = new JLabel(createImage());
        add("South",imageLabel);
                
        textButton = new JButton("A Button");
        textButton.addActionListener(this);
        add("East",textButton);
                
        JPanel centerPanel = new JPanel(new GridLayout(2,3));
        JButton[][] buttonArray = new JButton[2][3];
        for (int r=0;r<2;r++)
        {
            for (int c=0;c<3;c++)
            {
                buttonArray[r][c] = new JButton(" ("+r+":"+c+") ");
                buttonArray[r][c].setActionCommand(r + " " + c);
                buttonArray[r][c].addActionListener(this);
                centerPanel.add(buttonArray[r][c]);
            }
        }
        add("Center",centerPanel);
        


        pack();
        setVisible(true);
        
    }
    
    public ImageIcon createImage()
    {
        BufferedImage exampleImage = new 
            BufferedImage(50,50,BufferedImage.TYPE_3BYTE_BGR);
        Graphics drawer = exampleImage.getGraphics();
        
        drawer.setColor(new Color(200,200,200));
        drawer.fillRect(0, 0, 50, 50);
        
        drawer.setColor(new Color(0,255,0));
        drawer.fillOval(20, 20, 10, 10);
        
        return new ImageIcon(exampleImage);
    }

    
    public static void main(String[] args)
    {
    	SampleGUI gui = new SampleGUI(); 
    }

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == textButton)
	    {
	        textButton.setText("Pushed");
	        //SampleGUI.this.pack(); 
	    }  else {                       // somehow assume it's a button in the grid
          String msg = event.getActionCommand();
          Scanner sc = new Scanner(msg);
          int row = sc.nextInt();
          int col = sc.nextInt();
          System.out.println("row: " + row + " col: " + col);
      } 

		
	}
}