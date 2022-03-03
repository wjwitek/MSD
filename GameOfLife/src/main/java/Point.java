import java.util.ArrayList;
import java.util.Random;

public class Point {
	public ArrayList<Point> neighbors;
	public Point rain_neighbour;
	private int currentState;
	private int nextState;
	private int numStates = 6;

	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState(Rules currentRules) {
		nextState = currentRules.decideRules(this);
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}

	public int numberOfNeighbours(){
		int num = 0;
		for (Point neighbour: neighbors) {
			if (neighbour.getState() > 0){
				num += 1;
			}
		}
		return num;
	}

	public void drop(int chance){
		Random random = new Random();
		if (random.nextInt(100) <= chance){
			nextState = 6;
		}
	}
}
