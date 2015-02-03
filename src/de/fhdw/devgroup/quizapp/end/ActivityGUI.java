package de.fhdw.devgroup.quizapp.end;

import android.widget.Button;
import android.widget.EditText;
import de.fhdw.devgroup.quizapp.R;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityGUI {


	private EditText mUsername;
	private Button mSubmitName;
	
	public ActivityGUI(ActivityInit activityInit) {
		
		mUsername = (EditText) activityInit.findViewById(R.id.username);
		setSubmitName((Button) activityInit.findViewById(R.id.submitname));		

	}

	public EditText getUsername() {
		return mUsername;
	}

	public void setUsername(EditText mUsername) {
		this.mUsername = mUsername;
	}

	public Button getSubmitName() {
		return mSubmitName;
	}

	public void setSubmitName(Button mSubmitName) {
		this.mSubmitName = mSubmitName;
	}


}
