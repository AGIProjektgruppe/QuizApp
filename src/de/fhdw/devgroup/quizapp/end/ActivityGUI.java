package de.fhdw.devgroup.quizapp.end;

import android.widget.Button;
import de.fhdw.devgroup.quizapp.R;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityGUI {

	private Button mStart;
	private Button mHighscore;
	
	public ActivityGUI(ActivityInit activityInit) {
		
		mStart = (Button) activityInit.findViewById(R.id.start);
		mHighscore = (Button) activityInit.findViewById(R.id.highscore);

	}

	public Button getStart() {
		return mStart;
	}

	public void setStart(Button mStart) {
		this.mStart = mStart;
	}

	public Button getHighscore() {
		return mHighscore;
	}

	public void setHighscore(Button mHighscore) {
		this.mHighscore = mHighscore;
	}


}
