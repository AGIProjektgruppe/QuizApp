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
		
		mGUI.getSubmitName().setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.submitScore();
	}

}
