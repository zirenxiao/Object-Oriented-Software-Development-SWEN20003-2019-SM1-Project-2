import java.util.ArrayList;

import org.newdawn.slick.Input;

/** A train handler can handler the training tasks.
 * It will add each training task into a queue and
 * train it sequentially.
 */
public class TrainHandler {
	
	private ArrayList<Sprite> trainQueue;
	
	private int trainTimer;
	
	private int trainTime;
	
	public static final int NOT_TRAINING = -1;

	/** Construct the handler with a certain training
	 * time
	 * @param trainTime
	 */
	public TrainHandler(int trainTime) {
		trainQueue = new ArrayList<Sprite>();
		trainTimer = 0;
		this.trainTime = trainTime;
	}
	
	/** Handle a training request
	 * @param input
	 * @param key
	 * @param generate
	 * @param cost
	 * @param costType
	 */
	public void handle(Input input, int key, Sprite generate, 
						int cost, ResourcesType costType) {
		if (input.isKeyPressed(key)) {
			boolean costSuccess = false;
			if (costType == ResourcesType.METAL) {
				costSuccess = World.getInstance().costMetal(cost);
			}else if (costType == ResourcesType.UNOBTAINIUM) {
				costSuccess = World.getInstance().costUnobtainium(cost);
			}
			if (costSuccess) {
				trainQueue.add(generate);
			}
		}
	}
	
	/** Action of time pass each delta
	 * @param delta
	 */
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
	
	/** Get remaining training time
	 * @return
	 */
	public int getTrainRemainTime() {
		if (trainQueue.isEmpty()) {
			return NOT_TRAINING;
		}else {
			return (trainTime - trainTimer) / 1000;
		}
	}
	
	/** Get total training number
	 * @return
	 */
	public int getTrainNumber() {
		return trainQueue.size();
	}

}
