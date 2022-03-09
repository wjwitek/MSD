public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer []types = {0, 1, 2};
	int type;
	int sinInput;

	public Point() {
		clear();
		type = 0;
		sinInput = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		nVel = eVel = wVel = sVel = pressure = 0;
	}

	public void updateVelocity() {
		if (type == 0){
			nVel -= nNeighbor.pressure - pressure;
			eVel -= eNeighbor.pressure - pressure;
			wVel -= wNeighbor.pressure - pressure;
			sVel -= sNeighbor.pressure - pressure;
		}
	}

	public void updatePressure() {
		// assumption x^2 = 1/2
		if (type == 0){
			pressure -= 0.5 * (nVel + eVel + sVel + wVel);
		}
		if (type == 2){
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
			sinInput += 30;
		}
	}

	public float getPressure() {
		return pressure;
	}
}