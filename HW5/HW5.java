import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class HW5 {
	public static void printPlayersById(Player[] array) {
		Arrays.sort(array, new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return p1.id - p2.id;
			}
		});
		for (Player player : array) {
                  if(player.id ==-1) {
                    continue;
                  }
		   System.out.println(player);
		}
	}
	
	/* num_players = number of players
	 * portion = portion of points passed from the player with the most points to the one with the least
	 * min_points = minimum of the initital points range
	 * max_points = max of the initial points range
	 * rounds = number of rounds to play 
	 */
public static void playGame(int num_players, double portion, int min_points, int max_points, int rounds, int seed) {
	Random rand = new Random(seed);
  //creating max and min heap
  ArrayPriorityQueue maxHeap = new ArrayPriorityQueue(num_players,false);
  ArrayPriorityQueue minHeap =  new ArrayPriorityQueue(num_players,true);
  //initialzing loop
  for(int i = 0; i < num_players; i++) {

    int randomInt = rand.nextInt(max_points - min_points) + min_points;
    Player player = new Player(i, randomInt);

    player.setMaxIndex(i+1);
    player.setMinIndex(i+1);

    minHeap.add(player);
    maxHeap.add(player);
    }
  //round loop
  for(int i = 0; i < rounds; i++) {
		
    Player minPlayer = minHeap.poll();
    Player maxPlayer = maxHeap.poll();

    int points_transferred = (int) (maxPlayer.points * portion);

    minPlayer.points += points_transferred;
    maxPlayer.points -= points_transferred;

    minHeap.removeAtIndex(maxPlayer.minIndex);
    maxHeap.removeAtIndex(minPlayer.maxIndex);

    minHeap.add(maxPlayer);
    minHeap.add(minPlayer);

    maxHeap.add(maxPlayer);
    maxHeap.add(minPlayer);
     
  }
  printPlayersById(maxHeap.getHeap());
}
	public static void main(String[] args) {
    playGame(5, 0.3, 0, 100, 4, 15);
	}
}