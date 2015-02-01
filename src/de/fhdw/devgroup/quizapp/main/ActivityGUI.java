package de.fhdw.devgroup.quizapp.main;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

public class ActivityGUI {

	private Button mStart;
	private Button mHighscore;
	
	public ActivityGUI(ActivityInit activityInit) {
		
		Button mStart = (Button) activityInit.findViewById(R.id.start);
		Button mHighscore = (Button) activityInit.findViewById(R.id.highscore);

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
