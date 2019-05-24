package reversi;

import java.util.LinkedList;

public class records {
	private class record{
		String winner;
		String score;
		int level;
		public record(String w,String s, int l) {
		this.level = l;
		this.score = s;
		this.winner = w;
	}
	}
	LinkedList<record> r; 
	int gameNumber;
	int humanWin;
	int computerWin;
	int draw;
	public records() {
		r= new LinkedList();
		gameNumber = r.size();
	}
	public void win() {
		for(int i = 0; i< r.size(); i++) {
			if (r.get(i).winner == "computer") {
				computerWin++;
			}
			else if (r.get(i).winner == "human"){
				humanWin++;
			}
			else {
				draw++;
			}
		}
	}
	public void insert(record record) {
		r.addFirst(record);
	}
	public LinkedList<record> recentGames(){
		LinkedList<record> recent = new LinkedList<record>();
		for(int i = 0; i<5; i++) {
			recent.add(r.get(i));
		}
		return recent;
	}
	
}

