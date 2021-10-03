package landaluce;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JLabel;

public class JLabelCoche extends JLabel{
	private static final long serialVersionUID =1L;
	
	Image real;
	public JLabelCoche(Image real) {
		super();
		this.real = real;
	}
	public void setSize(int x, int y) {
		super.setIcon( (Icon) (real.getScaledInstance(x, y, Image.SCALE_SMOOTH)));
	}
	
	

	
}
