import javax.swing.SwingUtilities;


public class TTTBooter {

	public static void main (String args[]){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();


				
			}
			
			
		});
	}
	
}
