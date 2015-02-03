package de.fhdw.devgroup.quizapp.end;

import de.fhdw.devgroup.quizapp.R;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityEventToListenerMapping implements OnClickListener {

	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;

	public ActivityEventToListenerMapping(ActivityGUI mGUI,
			ActivityApplicationLogic mApplicationLogic) {
		
		this.mGUI = mGUI;
		this.mApplicationLogic = mApplicationLogic;
		
		mGUI.getStart().setOnClickListener(this);
		mGUI.getHighscore().setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.start :
			mApplicationLogic.startButtonClicked();
			break;
			
		case R.id.highscore :
			mApplicationLogic.highscoreButtonClicked();
			break;
		
		
		}
		
	}

}
