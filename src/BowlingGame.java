import java.util.Arrays;
import java.util.List;


public class BowlingGame {
	
	private List<Integer> rolls;
	public BowlingGame(Integer[] rolls) {
		this.rolls = Arrays.asList(rolls);
	}

	public int score() {
		int result = 0;
		for (int frameNo = 1; frameNo <= 10; frameNo++) {
			for (Integer roll : subScoreRolls(frameNo)) {
				result += roll;
			}
		}
		return result;
	}
	
	public List<Integer> subScoreRolls(int frameNo) {
		int firstIndex = (frameNo-1) * 2;
		if (isStrike(firstIndex)) {
			if (frameNo == 10) {
				return _subScoreRolls(firstIndex, 3);
			} else if (frameNo == 9) {
				return _subScoreRolls(firstIndex, 4);
			} else if (isStrike(firstIndex+2)) {
				return _subScoreRolls(firstIndex, 5);
			} else {
				return _subScoreRolls(firstIndex, 4);
			}
		}
		if (isSpare(firstIndex)) {
			return _subScoreRolls(firstIndex, 3);
		}
		return _subScoreRolls(firstIndex, 2);
	}

	private boolean isStrike(int firstIndex) {
		return rolls.get(firstIndex) == 10;
	}

	private List<Integer> _subScoreRolls(int firstIndex, int range) {
		return this.rolls.subList(firstIndex, firstIndex + range);
	}

	boolean isSpare(int firstIndex) {
		if (!isStrike(firstIndex) && rolls.get(firstIndex) + rolls.get(firstIndex+1) == 10) {
			return true;
		}
		return false;
	}
}
