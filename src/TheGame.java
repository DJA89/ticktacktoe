
public class TheGame {

	private String[][] tablero = {{"","",""},{"","",""},{"","",""}};
	private boolean gameEnded = false;
	private int turno = 0;
	
	public TheGame(){
	
	}
	
	public String setSymbol(int x, int y){
		if (tablero[x-1][y-1] != "" || gameEnded) {
			return tablero[x-1][y-1]+"AlreadySet";
		}
		else if (turno%2 == 0){
			return addSymbol(x,y,"X");
		
		}
		else {
			return addSymbol(x,y,"O");
		}
	}
	
	private String addSymbol(int x, int y, String s){
		tablero[x-1][y-1] = s;
		turno += 1;
		if (turno > 4 && checkForResult() != ""){
			return checkForResult();
		}
		else {
			return s;
		}
	}
	
	public String getSymbol(int i, int j){
		return tablero[i-1][j-1];
	}
	
	
	private String checkForResult(){
		
		boolean winner = false;
		String ret = "";
		int i = 0;

		do {
			if (tablero[i][0] != "" && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2] ) {
				winner = true;
				ret = tablero[i][0]+"Winner";
			}
			++i;
		} while (!winner && i < 3);
		i = 0;
		while (!winner && i < 3) {
			if (tablero[0][i] != "" && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i] ) {
				winner = true;
				ret = tablero[0][i]+"Winner";
			}
			++i;
		}
		
		if (!winner && tablero [0][0] != "" && tablero [0][0] == tablero [1][1] && tablero [0][0] == tablero [2][2]){
			winner = true;
			ret = tablero[0][0]+"Winner";
		}
		
		if (!winner && tablero [0][2] != "" && tablero [0][2] == tablero [1][1] && tablero [0][2] == tablero [2][0]){
			winner = true;
			ret = tablero[0][2]+"Winner";
		}
			
		if (!winner){
			boolean tie = true;
			i = 0;
			int j;
			while (i<tablero.length && tie){
				j = 0;
				while (j<tablero.length && tie){
					tie = (tablero[i][j] != "");
					++j;
				}
				++i;
			}
			if (tie){
				ret = "Tie";
			}
		}

		
		gameEnded = (ret != "");
		
		return ret;
	}

	public String getNextSymbol(){
		if(turno%2 == 0){
			return "X";
		}
		else {
			return "O";
		}
	}
	
	public String toString(){
		String s = new String();
		for (int i = 0; i < tablero.length; ++i){
			s += tablero[0][i] + " | " + tablero [1][i] + " | " + tablero [2][i];
			s += System.lineSeparator();
		}
		return s;
	}
	
	private void setX(int i, int j){
		tablero[i-1][j-1] ="X";
		turno+=1;
		
	}
	
	private void setO(int i, int j){
		tablero[i-1][j-1] = "O";
		turno += 1;
	}
	
	private void deleteAll(){
		for (int i = 0; i<3; ++i){
			for(int j = 0; j<3; ++j){
				tablero[i][j] = "";
			}
		}
		turno = 0;
	}
	
	public void copy(TheGame g){
		this.deleteAll();
		String s;
		for (int i = 1; i<4; ++i){
			for(int j = 1; j<4; ++j){
				s = g.getSymbol(i, j);
				if (s.equals("X")){
					this.setX(i, j);
				}
				else if (s.equals("O")){
					this.setO(i,j);
				}
			}
		}
	}
	
}
