package de.fhdw.devgroup.quizapp.sortingquestion;

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
		
		mGUI.getAnswerButton1().setOnClickListener(this);
		mGUI.getAnswerButton2().setOnClickListener(this);
		mGUI.getAnswerButton3().setOnClickListener(this);
		mGUI.getAnswerButton4().setOnClickListener(this);
		mGUI.getSubmit().setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onAnswerButtonClicked(v);
		
	}

}
