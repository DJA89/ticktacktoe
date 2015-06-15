import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Toolbar extends JPanel implements ActionListener{

	
	private JButton[] b = new JButton[3];
	
	private IntListener listener;
	


	


	
	public Toolbar(){
		
		for (int i = 0; i<b.length; ++i){
			b[i] = new JButton(" ");
			b[i].addActionListener(this);
			add(b[i]);
			b[i].setPreferredSize(new Dimension(100,100));
			
		}
	
		
	}
	
	public void setIntListener(IntListener listener){
		this.listener = listener;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if (clicked == b[0]) {
			if (listener != null){
				listener.intEmitted(1);
			}
		}
		else if (clicked == b[1]){
			if (listener != null){
				listener.intEmitted(2);
			}
			
		}
		else if (clicked == b[2]){
			if (listener != null) {
				listener.intEmitted(3);
			}
		}
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
	}
	
	public void setText(int i, String s){
		b[i-1].setText(s);
	}
	
	

}
