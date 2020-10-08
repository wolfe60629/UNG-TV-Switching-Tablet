import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;

    @SuppressWarnings("serial")
	public class JGradientButton extends JButton {
    	private Color startColor;
    	private Color endColor;
    	private boolean isSelected;
    	
        JGradientButton(String text,Color startColor, Color endColor, int size) {
            super(text);
            setContentAreaFilled(false);
            setFocusPainted(false); // used for demonstration
            setForeground(Color.WHITE);
            this.startColor = startColor;
            this.endColor = endColor;
            this.isSelected = false;
            try {
                GraphicsEnvironment ge = 
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ung.ttf")).deriveFont((float) size);
                
                ge.registerFont(customFont);
                
                setFont(customFont);
           } catch (IOException|FontFormatException e) {
                //Handle exception
           }
            
        }

        @Override
        protected void paintComponent(Graphics g) {
            final Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0), 
                    startColor, 
                    new Point(0, getHeight()), 
                    endColor));
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }

        public void setSelected() {
        	this.isSelected = true;
        	startColor = Color.GRAY.brighter();
        	repaint();
        }
        public void setRed() {
        	this.isSelected = true;
        	startColor = Color.RED.darker();
        	repaint();
        }
        public void setUnselected() { 
        	this.isSelected = false;
        	startColor = Color.DARK_GRAY;
        	repaint();
        }
        
        
        public boolean isSelected() { 
        	return isSelected;
        }
        
        public Color getStartColor() {
			return startColor;
		}



		public void setStartColor(Color startColor) {
			this.startColor = startColor;
		}



		public Color getEndColor() {
			return endColor;
		}



		public void setEndColor(Color endColor) {
			this.endColor = endColor;
		}



		public void  setIsSelected(boolean value) { 
        	this.isSelected = value;
        }
    }
