import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


@SuppressWarnings("serial")
public class Frame extends JPanel{
	
	private JFrame frame;

	/**************************
	 * Launch the application.
	 **************************/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frame() {
		initialize();
	}

	private void initialize() {
		
		//Frame
		frame = new JFrame();
		//frame.setBounds(100, 100, 815, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyPressed(KeyEvent e) {
		        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
		        	System.exit(0);
		        }
		    }
		}
		);
		
		//Background Panel
		JLayeredPane backgroundPanel = new JLayeredPane();
		backgroundPanel.setBackground(Color.WHITE);
		backgroundPanel.setLocation(0, 0);
		backgroundPanel.setLayout(null);
		frame.getContentPane().add(backgroundPanel);
		
			//JLabel Image
			Image bigLogo = Toolkit.getDefaultToolkit().createImage("images/bigLogoDark.png");
			bigLogo = bigLogo.getScaledInstance(frame.getWidth()-30,frame.getHeight()-100, Image.SCALE_SMOOTH);
			JLabel bigLogoLabel = new JLabel(new ImageIcon(bigLogo));
			bigLogoLabel.setBounds(-10,-0,frame.getWidth(),frame.getHeight());
			backgroundPanel.add(bigLogoLabel);
			
			//JLabel Text
			JLabel startText = new JLabel("Touch To Start");
			startText.setFont(new Font("TimesRoman", Font.BOLD, 50));
			startText.setSize(600,50);
			startText.setLocation((frame.getWidth()/2)-195,frame.getHeight()-100);
			startText.setForeground(Color.BLACK);
			startText.setVisible(true);
			//backgroundPanel.add(startText);
			backgroundPanel.moveToFront(startText);
			
		//Header Panel
		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(1, 36, 91));
		//headerPanel.setBounds(0, 0, 800, 74);
		headerPanel.setBounds(0,0,frame.getWidth(),74);
		headerPanel.setVisible(false);
		headerPanel.setLayout(null);
		backgroundPanel.add(headerPanel);

			//JLabel
			JLabel LogoText = new JLabel();
			try {
				Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("ung.ttf")).deriveFont((float) 30);
				LogoText.setFont(customFont);
				LogoText.setText("TV Input Switching Tablet");
				LogoText.setForeground(Color.WHITE);
				LogoText.setLocation((headerPanel.getWidth()/2)-145,8);
				LogoText.setSize(headerPanel.getWidth(),60);
				LogoText.setVisible(false);
			} catch (FontFormatException | IOException e1) {
				e1.printStackTrace();
			}
			
			headerPanel.add(LogoText);

		//VolumePanel
		JPanel volumePanel = new JPanel();
		volumePanel.setBackground(new Color(1, 36, 91));
		//volumePanel.setBounds(650, 70, 150, 421);
		volumePanel.setBounds(frame.getWidth()-150,70,150,frame.getHeight()-70);
		volumePanel.setLayout(null);
		volumePanel.setVisible(false);
		backgroundPanel.add(volumePanel);
				
					//Buttons
					JGradientButton volumeUpBtn = new JGradientButton("Volume Up",Color.DARK_GRAY,Color.BLACK,15);
					Image volumeupimg = Toolkit.getDefaultToolkit().createImage("images/volup.png");
					volumeupimg = volumeupimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
					volumeUpBtn.setIcon(new ImageIcon(volumeupimg));
					volumeUpBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
					volumeUpBtn.setHorizontalTextPosition(SwingConstants.CENTER);
					volumeUpBtn.setVisible(false);
					volumeUpBtn.setEnabled(false);
					volumeUpBtn.setBounds(10,frame.getHeight()-475, 130, 100);
					
					JGradientButton volumeDownBtn = new JGradientButton("<html><p style=text-align:center>Volume Down</p></html>",Color.DARK_GRAY,Color.BLACK,15);
					Image volumedownimg = Toolkit.getDefaultToolkit().createImage("images/voldown.png");
					volumedownimg = volumedownimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
					volumeDownBtn.setIcon(new ImageIcon(volumedownimg));
					volumeDownBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
					volumeDownBtn.setHorizontalTextPosition(SwingConstants.CENTER);
					volumeDownBtn.setVisible(false);
					volumeDownBtn.setEnabled(false);
					volumeDownBtn.setBounds(10,frame.getHeight()-370, 130, 100);

					JGradientButton volumeMuteBtn = new JGradientButton("Mute",Color.DARK_GRAY,Color.BLACK,15);
					Image muteBtnImg = Toolkit.getDefaultToolkit().createImage("images/muteimg.png");
					muteBtnImg = muteBtnImg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
					volumeMuteBtn.setIcon(new ImageIcon(muteBtnImg));
					volumeMuteBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
					volumeMuteBtn.setHorizontalTextPosition(SwingConstants.CENTER);
					volumeMuteBtn.setVisible(false);
					volumeMuteBtn.setEnabled(false);
					volumeMuteBtn.setBounds(10, frame.getHeight()-220, 130, 100);
		
					
					volumePanel.add(volumeUpBtn);
					volumePanel.add(volumeDownBtn);
					volumePanel.add(volumeMuteBtn);
					
					
		//inputSwitcherPanel
		JPanel inputSwitcherPanel = new JPanel();
		//inputSwitcherPanel.setBounds(0, 70, 650, 421);
		inputSwitcherPanel.setBounds(145, 70, frame.getWidth()-150-145, frame.getHeight()-70);
		inputSwitcherPanel.setVisible(false);
		inputSwitcherPanel.setLayout(null);
		inputSwitcherPanel.setBackground(new Color(32, 79, 155));
		backgroundPanel.add(inputSwitcherPanel);

			//Buttons for Input
			JGradientButton lecternPcBtn = new JGradientButton("<html><p style=text-align:center>Lectern PC</p></html>",Color.DARK_GRAY,Color.BLACK,20);
			lecternPcBtn.setVisible(false);
			lecternPcBtn.setEnabled(false);
			int lecternPCBtnWidth = (inputSwitcherPanel.getWidth()/2)-130;
			int lecternPCBtnHeight = 100;
			lecternPcBtn.setBounds(100, (frame.getHeight()/2)-150, lecternPCBtnWidth, lecternPCBtnHeight);
			
			JGradientButton lecternLaptopBtn = new JGradientButton("Laptop",Color.DARK_GRAY,Color.BLACK,20);
			lecternLaptopBtn.setVisible(false);
			lecternLaptopBtn.setEnabled(false);
			lecternLaptopBtn.setBounds((inputSwitcherPanel.getWidth()/2)+50, (frame.getHeight()/2)-150, (inputSwitcherPanel.getWidth()/2)-150, 100);
			
			JGradientButton noRouteBtn = new JGradientButton("<html><p style=text-align:center>Blank Route</p></html>",Color.DARK_GRAY,Color.BLACK,20);
			noRouteBtn.setVisible(false);
			noRouteBtn.setEnabled(false);
			noRouteBtn.setBounds(100, (frame.getHeight()/2), (inputSwitcherPanel.getWidth())-200, 100);
			
			
			JGradientButton[] inputButtonGroup = {lecternPcBtn,lecternLaptopBtn,noRouteBtn};
			
			inputSwitcherPanel.add(lecternLaptopBtn);
			inputSwitcherPanel.add(lecternPcBtn);
			inputSwitcherPanel.add(noRouteBtn);
		
			
			
			//leftMountedPanel
			JPanel leftMountedPanel = new JPanel();
			leftMountedPanel.setBackground(new Color(1, 36, 91));
			leftMountedPanel.setBounds(0, 70, 145, frame.getHeight()-70);
			leftMountedPanel.setLayout(null);
			leftMountedPanel.setVisible(false);
			backgroundPanel.add(leftMountedPanel);
			backgroundPanel.moveToFront(leftMountedPanel);
	
					//JButton 
					JGradientButton shutdownBtn = new JGradientButton("<html><p style=text-align:center>Power Off</p></html>",Color.DARK_GRAY,Color.BLACK,15);
					Image shutdownimg = Toolkit.getDefaultToolkit().createImage("images/shutdown.png");
					shutdownimg = shutdownimg.getScaledInstance(50,50, Image.SCALE_SMOOTH);
					shutdownBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
					shutdownBtn.setHorizontalTextPosition(SwingConstants.CENTER);
					shutdownBtn.setIcon(new ImageIcon(shutdownimg));
					shutdownBtn.setForeground(Color.RED);
					shutdownBtn.setVisible(false);
					shutdownBtn.setEnabled(false);
					shutdownBtn.setBounds(5, 5, 133, 100);
			
			leftMountedPanel.add(shutdownBtn);
			
			
		//Action Listeners
		backgroundPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		bigLogoLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				volumePanel.setVisible(true);
				headerPanel.setVisible(true);
				inputSwitcherPanel.setVisible(true);
				leftMountedPanel.setVisible(true);
				switchLayoutVisibility(inputSwitcherPanel);
				switchLayoutVisibility(volumePanel);
				switchLayoutVisibility(headerPanel);
				switchLayoutVisibility(leftMountedPanel);

				bigLogoLabel.setVisible(false);
				startText.setVisible(false);
				selectInput(inputButtonGroup,noRouteBtn);
			}
		});
		
		lecternPcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              selectInput(inputButtonGroup,lecternPcBtn);
              //Code When Clicked
              LecternPcInputScript.main();
            }
        });
		lecternLaptopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              selectInput(inputButtonGroup,lecternLaptopBtn);
            //Code When Clicked
              LaptopInputScript.main();
              
            }
        });
		noRouteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              selectInput(inputButtonGroup,noRouteBtn);
            //Code When Clicked
              BlankRouteInputScript.main();
              
            }
        });
		
		volumeMuteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Code When Clicked
              if (volumeMuteBtn.isSelected()) { 
            	  volumeMuteBtn.setUnselected();
              }else{ 
            	  volumeMuteBtn.setRed();
              }
              VolumeMuteScript.main();
              
            }
        });
		
		
		Timer volumeDownGraphicsTimer = new Timer(40, new ActionListener() { 
			int timerDowncount = 0;
			 public void actionPerformed(ActionEvent e) {
				 timerDowncount++;
				    if (volumeDownBtn.isSelected()) { 
				    	volumeDownBtn.setUnselected();
		              }else{ 
		            	  volumeDownBtn.setRed();
		              }
				    if (timerDowncount >= 2) { 
				    	timerDowncount = 0;
				    ((Timer)e.getSource()).stop();
				    }
			 }
		});
		
		Timer volumeUpGraphicsTimer = new Timer(40, new ActionListener() {
			int timerUpcount = 0;
			 public void actionPerformed(ActionEvent e) {
				 timerUpcount++;
				    if (volumeUpBtn.isSelected()) { 
				    	volumeUpBtn.setUnselected();
		              }else{ 
		            	  volumeUpBtn.setRed();
		              }
				    if (timerUpcount >= 2) { 
				    	timerUpcount = 0;
				    ((Timer)e.getSource()).stop();
				    }
			 }
		});
		
		
		volumeUpBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Code When Clicked
            	volumeUpGraphicsTimer.start();
            	VolumeUpScript.main();
            }
            
        });
		
		
	
		volumeDownBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Code When Clicked
            	volumeDownGraphicsTimer.start();
            	VolumeDownScript.main();
            }
        });
		
		
		shutdownBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //Code When Clicked
            	PowerOffScript.main();
            	volumePanel.setVisible(false);
				headerPanel.setVisible(false);
				inputSwitcherPanel.setVisible(false);
				leftMountedPanel.setVisible(false);
				switchLayoutVisibility(inputSwitcherPanel);
				switchLayoutVisibility(volumePanel);
				switchLayoutVisibility(headerPanel);
				switchLayoutVisibility(leftMountedPanel);

				bigLogoLabel.setVisible(true);
				startText.setVisible(true);
				
				if (volumeMuteBtn.isSelected()) { 
					volumeMuteBtn.setUnselected();
					VolumeMuteScript.main();
				}
				
				selectInput(inputButtonGroup,noRouteBtn);
				BlankRouteInputScript.main();
				PowerOffScript.main();
				
            }
        });
		
	}
	
	private void switchLayoutVisibility(JPanel panelToSwitch) { 
		for (Component comp : panelToSwitch.getComponents()) {
				if (comp.isVisible()) { 
					comp.setVisible(false);
					comp.setEnabled(false);
				} else if(!comp.isVisible()) { 
					comp.setVisible(true);
					comp.setEnabled(true);
			}
		}
	}
	
	private void selectInput(JGradientButton[] buttonGroup, JGradientButton buttonToSelect) { 
		for (JGradientButton button : buttonGroup) { 
			if (button.isSelected() == true) { 
				button.setUnselected();
			}
		}
		buttonToSelect.setSelected();
	}

	}


