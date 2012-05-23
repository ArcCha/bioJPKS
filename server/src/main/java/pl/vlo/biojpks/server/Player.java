package pl.vlo.biojpks.server;

public class Player
{
    private String nick;
    private int score;
    
	public Player(String nick, int score) {
		super();
		this.nick = nick;
		this.score = score;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
