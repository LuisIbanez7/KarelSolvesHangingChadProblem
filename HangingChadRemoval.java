import stanford.karel.*;

public class HangingChadRemoval extends SuperKarel{
	int xPosition = 1;
	public void run() {
		moveToStartingPoint();
		checkBallotAndClearHangingChads();
	}
	private void checkBallotAndClearHangingChads() {
		while(frontIsClear()) {
			move();
			xPosition++;
			if(xPosition % 2 == 0) {
				if(checkIfHangingChad()) {
					clearHangingChads();
				}
			}
		}		
	}
	private void moveToStartingPoint() {
		moveToX1Y3();
	}
	private void clearHangingChads() {
		pickAllBeepers();
		checkTop(false);
		pickAllBeepers();
		checkBottom(false);
		pickAllBeepers();
		backToMiddle();
		
	}
	private void pickAllBeepers() {
		while(beepersPresent()) {
			pickBeeper();
		}		
	}
	private boolean checkIfHangingChad() {
		boolean isHangingChad = false;
		isHangingChad = checkMiddle(isHangingChad);
		isHangingChad = checkTop(isHangingChad);
		isHangingChad = checkBottom(isHangingChad);
		
		backToMiddle();
		return isHangingChad;
		
	}
	private void backToMiddle() {
		turnAround();
		move();
		turnRight();		
	}
	private boolean checkBottom(boolean isHangingChad) {
		turnAround();
		move();
		move();
		if(!beepersPresent()) {
			isHangingChad = true;
		}		
		return isHangingChad;
	}
	private boolean checkTop(boolean isHangingChad) {
		turnLeft();
		move();
		if(!beepersPresent()) {
			isHangingChad = true;
		}
		return isHangingChad;
	}
	private boolean checkMiddle(boolean isHangingChad) {
		if(!beepersPresent()) {
			isHangingChad = true;
		}		
		return isHangingChad;
	}
	private void moveToX1Y3() {
		turnLeft();
		move();
		move();
		turnRight();
	}
}
