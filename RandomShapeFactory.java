//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ShapeFactory extends JFrame implements ActionListener {
	
 public static void main(String[] args) {
	 new ShapeFactory();
 }
 
 public int numberOfRects;
 public int numberOfEllis;
 public int numberOfLines;
 JButton ranRects = new JButton("Random Rectangles");
 JButton ranElli = new JButton("Random Ellipses");
 JButton ranLines = new JButton("Random Lines");
 JButton close = new JButton("Exit");
 Graphics g;
 Color c;
 ArrayList shapeList = new ArrayList();

 public ShapeFactory() {
	 super("Shape Factory");
	 setLayout(new FlowLayout());
	 setSize(600,400);
	 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 
	 add(ranRects);
	 add(ranElli);
	 add(ranLines);
	 


	 JPanel nPanel = new JPanel(new GridLayout(1, 3));
	 nPanel.add(ranRects);
	 nPanel.add(ranElli);
	 nPanel.add(ranLines);
	 
	 add(nPanel);
	 
	 ranRects.addActionListener(this);
	 ranElli.addActionListener(this);
	 ranLines.addActionListener(this);
	 setVisible(true);
 }
 
 public void paint(Graphics g) {
	 
	 super.paint(g);
	
	 for(int i = 0; i < this.numberOfRects; i++)
		 paintRect(g);
	 for(int i = 0; i < this.numberOfEllis; i++)
		 paintOval(g);
	 for(int i = 0; i < this.numberOfLines; i++)
		 this.paintLine(g);
	 
 }
 
 public void paintRect(Graphics g) {
	 
	 int recX1 = (int)(Math.random() * getWidth() / 4.0);
	 int recY1 = (int)(Math.random() * getWidth() / 4.0);
	 int recX2 = (int)(Math.random() * getWidth());
	 int recY2 = (int)(Math.random() * getWidth());
	  
	 c = new Color((int) (Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
	 g.setColor(c);
	 g.fillRect(recX1 , recY1 , recX2 , recY2);
 }
 
 public void paintOval(Graphics g) {
	 int ellX1 = (int)(Math.random() * getWidth() / 4.0);
	 int ellY1 = (int)(Math.random() * getWidth() / 4.0);
	 int ellX2 = (int)(Math.random() * getWidth());
	 int ellY2 = (int)(Math.random() * getWidth());
	  
	 c = new Color((int) (Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
	 g.setColor(c);
	 g.fillOval(ellX1 , ellY1 , ellX2 , ellY2);
}
 
 public void paintLine(Graphics g) {
	 int linX1 = (int)(Math.random() * getWidth() / 4.0);
	 int linY1 = (int)(Math.random() * getWidth() / 4.0);
	 int linX2 = (int)(Math.random() * getWidth());
	 int linY2 = (int)(Math.random() * getWidth());
	  
	 c = new Color((int) (Math.random() * 255),(int)(Math.random() * 255),(int)(Math.random() * 255));
	 g.setColor(c);
	 g.drawLine(linX1 , linY1 , linX2 , linY2);
 }
 
 private class CloseListener implements ActionListener{
	    
	    public void actionPerformed(ActionEvent e) {
	        
	        System.exit(0);
	    }
	}
 
 public void actionPerformed(ActionEvent e) {
	 Object source = e.getSource();
	 if(source == ranRects) {
		 this.numberOfRects++;
	 }else if (source == ranElli) {
		 this.numberOfEllis++;
	 }else if (source == ranLines) {
		 this.numberOfLines++;
	 }
	 repaint();
 }
 
}
