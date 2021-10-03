package landaluce;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class cocheVentana extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelCoche, panelBotones;
	private JLabel lCoche;
	
	
	
	double ace;
	double rot;
	
	
	
	
	public cocheVentana() {
		super(" EL MEJOR JEUGO BY LANDALUCE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setSize( 700, 600 );
		setLocation( 500, 100 );
		
		
		
		//LABEL
		
		JLabel lCoche  = new JLabel();
		lCoche.setIcon( new ImageIcon(new ImageIcon( cocheVentana.class.getResource("coche.png") ).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)) );
		lCoche.setBounds( 0, 0, 800, 800 );
		lCoche.setSize(100,100);
		
		

	
		
		//PANEL DEl coche 
				
		panelCoche = new JPanel();
		panelCoche.setLayout(null);
		panelCoche.setBackground(Color.WHITE);
		panelCoche.add(lCoche, BorderLayout.CENTER);
		
		

		
		
		//BUTTON
		
		
		JPanel panelBotones = new JPanel();
		lCoche.add(panelBotones, BorderLayout.SOUTH);
		JButton forw=new JButton("ACELERAR");
		JButton backw=new JButton("FRENAR");
		JButton right=new JButton("GIRAR DERECHA"); 
		JButton left=new JButton("GIRAR IZQUIERDA");
		
		forw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		//Para que los botones funcionen 
		
		panelBotones.add(forw);
		panelBotones.add(backw);
		panelBotones.add(right);
		panelBotones.add(left);
				
		
		
		
		Container cp = getContentPane();
		cp.add(panelCoche, BorderLayout.CENTER);
		cp.add(panelBotones, BorderLayout.SOUTH);
	
		
		
		//Lo que hace caundo se abre, cierrra la ventana
		
		
		addWindowListener( new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println( "OPENED" );
			}
			@Override
			public void windowIconified(WindowEvent e) {
			}
			@Override
			public void windowDeiconified(WindowEvent e) {
			}
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println( "DEACTIVATED" );
			}
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println( "CLOSING" );
				dispose();
			}
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println( "CLOSED" );
			}
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println( "ACTIVATED" );
			}
		});
		
		setVisible( true );
        coche c =new coche(this);
        Thread t = new Thread() {
                public void run() {
                    while(true){
                    	double f=forw.getModel().isPressed()?1:0;
                    	double b=backw.getModel().isPressed()?1:0;
                    	double r=right.getModel().isPressed()?1:0;
                    	double l=left.getModel().isPressed()?1:0;
                    	c.update((f-b)*100,(r-l)*0.5);
                        lCoche.setLocation((int) c.getPosX(),(int) c.getPosY());
                        try {
                            Thread.sleep(1000/60);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        };
        t.setDaemon(true);
        t.start();
		
	}

	
	

	public static void main(String[] args) {
		
		cocheVentana coche1 = new cocheVentana();
		coche1.setVisible(true);
	
		
		
		
		
		
	
	}

	public JPanel getPanelCoche() {
		return panelCoche;
	}

	public void setPanelCoche(JPanel panelCoche) {
		this.panelCoche = panelCoche;
	}






	public JLabel getlCoche() {
		return lCoche;
	}






	public void setlCoche(JLabel lCoche) {
		this.lCoche = lCoche;
	}






	public JPanel getPanelBotones() {
		return panelBotones;
	}






	public void setPanelBotones(JPanel panelBotones) {
		this.panelBotones = panelBotones;
	}







	

}