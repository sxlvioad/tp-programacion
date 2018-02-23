import javax.swing.JFrame;

public class App {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 500, 500);
		frame.setContentPane(new PanelPrincipal(frame));
		frame.setVisible(true);
		

		
		
	}
	
	
}
