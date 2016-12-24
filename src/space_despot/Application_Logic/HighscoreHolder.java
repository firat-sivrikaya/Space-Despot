package space_despot.Application_Logic;

public class HighscoreHolder {
	private String nickname;
	private int score;
	public HighscoreHolder(String nickname, int score) {
		super();
		this.nickname = nickname;
		this.score = score;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
