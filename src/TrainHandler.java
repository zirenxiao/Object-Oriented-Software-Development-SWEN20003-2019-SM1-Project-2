import java.util.ArrayList;

import org.newdawn.slick.Input;

public class TrainHandler {
	
	private ArrayList<Sprite> trainQueue;
	
	private int trainTimer;
	
	private int trainTime;
	
	public static final int NOT_TRAINING = -1;

	public TrainHandler(int trainTime) {
		// TODO Auto-generated constructor stub
		trainQueue = new ArrayList<Sprite>();
		trainTimer = 0;
		this.trainTime = trainTime;
	}
	
	public void handle(Input input, int key, Sprite generate, int cost, ResourcesType costType) {
		if (input.isKeyPressed(key)) {
			boolean costSuccess = false;
			if (costType == ResourcesType.METAL) {
				costSuccess = World.getInstance().costCurrentCarryMetal(cost);
			}else if (costType == ResourcesType.UNOBTAINIUM) {
				costSuccess = World.getInstance().costCurrentCarryUnobtainium(cost);
			}
			if (costSuccess) {
				trainQueue.add(generate);
//				World.getInstance().getMap().addUnit(generate);
			}
		}
	}
	
	public void timePass(int delta) {
		if (trainQueue.isEmpty()) {
			return;
		}
		trainTimer++;
		if (trainTime <= trainTimer) {
			trainTimer = 0;
			World.getInstance().getMap().addUnit(trainQueue.get(0));
			trainQueue.remove(0);
		}
	}
	
	public int getTrainRemainTime() {
		if (trainQueue.isEmpty()) {
			return NOT_TRAINING;
		}else {
			return (trainTime - trainTimer) / 1000;
		}
	}
	
	public int getTrainNumber() {
		return trainQueue.size();
	}

}
