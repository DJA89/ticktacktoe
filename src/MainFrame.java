import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame{
	
	
	
		private Toolbar nT = new Toolbar();
		private Toolbar cT = new Toolbar();
		private Toolbar sT = new Toolbar();
		
		private TheGame TTT = new TheGame();
		
		private String result;
		
		private int turno = 0;
		
		public MainFrame(){
			super("Ta-Te-Ti!");
			
			setLayout(new BorderLayout());
			
			setSize(350, 370);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			
			add(nT, BorderLayout.NORTH);
			add(cT, BorderLayout.CENTER);
			add(sT, BorderLayout.SOUTH);
			
			
			
			nT.setIntListener(new IntListener() {

				@Override
				public void intEmitted(int i) {

					result = TTT.setSymbol(i, 1);

					if (result.equals("X") || result.equals("O")){

						nT.setText(i, result);
							
					}
					else if (result.equals("XWinner") || result.equals("OWinner") || result.equals("Tie")){

						nT.setText(i, result.substring(0,1));
						toggleEndOfGame(result);
					}

				}
				
			});
			
			cT.setIntListener(new IntListener() {

				@Override
				public void intEmitted(int i) {
					//Acá se comunica con programa Ta Te Ti principal.
					
					result = TTT.setSymbol(i, 2);

					if (result.equals("X") || result.equals("O")){

						cT.setText(i, result);
					}
					else if (result.equals("XWinner") || result.equals("OWinner") || result.equals("Tie")){

						cT.setText(i, result.substring(0,1));
						toggleEndOfGame(result);
					}

				}
				
			});
			
			sT.setIntListener(new IntListener() {

				@Override
				public void intEmitted(int i) {
					//Acá se comunica con programa Ta Te Ti principal.

					result = TTT.setSymbol(i, 3);

					if (result.equals("X") || result.equals("O")){

							sT.setText(i, result);
					}
					else if (result.equals("XWinner") || result.equals("OWinner") || result.equals("Tie")){

						sT.setText(i, result.substring(0,1));
						toggleEndOfGame(result);
					}

				}
				
			});
			
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		}
		

	
		/*private void setToSymbol(int i, int j, Toolbar t){
			boolean pasoTurno;
			if (turno%2 == 0) {
				pasoTurno = TTT.setToX(i,j);//Acá se comunica con programa Ta Te Ti principal.
				if (pasoTurno) {
					turno+=1;
					t.setText(i,"X");
					if (turno>4) {
						String s = TTT.checkForResult();
						if (s !=""){
							toggleEndOfGame(s);
						}
					}
				}
			
			}
			else {
				pasoTurno = TTT.setToO(i,j);//Acá se comunica con programa Ta Te Ti principal.
				if (pasoTurno) {
					turno+=1;
					t.setText(i,"O");
					if (turno>4) {
						String s = TTT.checkForResult();
						if (s !=""){
							toggleEndOfGame(s);
						}
					}
				}
			
			}
			

		}*/
		
		private void toggleEndOfGame(String s){
			JFrame fin = new JFrame("Fin del juego");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			fin.setSize(1000, 1000);
			fin.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			fin.setVisible(true);
			
			JTextArea text = new JTextArea();
			 text.setAlignmentX(CENTER_ALIGNMENT);
			 text.setAlignmentY(CENTER_ALIGNMENT);
			if (s != "Tie"){
				text.append("¡¡El ganador es " + s.substring(0,1) + "!!" + System.lineSeparator() + "¡¡¡Felicitaciones!!!");
			}
			else {
				text.append("Ha sido un empate!");
			}
			fin.setLayout(new BorderLayout());
			
			fin.setSize(350, 370);
			fin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			fin.add(text, BorderLayout.CENTER);
			
			text.setEditable(false);

			
			
			
		}
	
	
	
}
