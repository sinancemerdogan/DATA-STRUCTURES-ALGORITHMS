public class Player {
	public int points;
	public int id;
  public int minIndex;
  public int maxIndex;
	
	public Player(int id, int points) {
		this.id = id;
		this.points = points;
	}
	
	public String toString() {
		return "Player " + this.id + " with " + this.points + " points"; 
	}
  public void setMinIndex(int i) {
    this.minIndex = i;
  }
  public void setMaxIndex(int i) {
    this.maxIndex = i;
  }
}
