package de.fhdw.devgroup.quizapp.multiquestion;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Sebastian Feder
 *
 */
public class ActivityGUI {

	
	private Button mAnswerButton1;
	private Button mAnswerButton2;
	private Button mAnswerButton3;
	private Button mAnswerButton4;
	private Button mSubmit;

	//saving initialColor to allow color switching for multiple selected answers
	private int initialColor;
	
	
	public ActivityGUI(ActivityInit activityInit) {

		//TODO would be better to use the original background color of the button, but I dont find the correct function call
		initialColor = Color.LTGRAY;
		
		mAnswerButton1 = (Button) activityInit.findViewById(R.id.answer1);
		//TODO replace with answers from DB entry
		mAnswerButton1.setText("Answer 1");
		mAnswerButton1.setBackgroundColor(initialColor);
		
		mAnswerButton2 = (Button) activityInit.findViewById(R.id.answer2);
		//TODO replace with answers from DB entry
		mAnswerButton2.setText("Answer 2");
		mAnswerButton2.setBackgroundColor(initialColor);
		
		mAnswerButton3 = (Button) activityInit.findViewById(R.id.answer3);
		//TODO replace with answers from DB entry
		mAnswerButton3.setText("Answer 3");
		mAnswerButton3.setBackgroundColor(initialColor);
		
		mAnswerButton4 = (Button) activityInit.findViewById(R.id.answer4);
		//TODO replace with answers from DB entry
		mAnswerButton4.setText("Answer 4");
		mAnswerButton4.setBackgroundColor(initialColor);
		
		setSubmit((Button) activityInit.findViewById(R.id.submit));
	}


    /**
     * 
     * @return the initial color of answer buttons
     */
	public int getInitialColor() {
		return initialColor;
	}

	public Button getAnswerButton1() {
		return mAnswerButton1;
	}

	public Button getAnswerButton2() {
		return mAnswerButton2;
	}

	public Button getAnswerButton3() {
		return mAnswerButton3;
	}

	public Button getAnswerButton4() {
		return mAnswerButton4;
	}

	public Button getSubmit() {
		return mSubmit;
	}

	public void setSubmit(Button mSubmit) {
		this.mSubmit = mSubmit;
	}

	public void setAnswerButton1(Button mAnswerButton1) {
		this.mAnswerButton1 = mAnswerButton1;
	}

	public void setAnswerButton2(Button mAnswerButton2) {
		this.mAnswerButton2 = mAnswerButton2;
	}

	public void setAnswerButton3(Button mAnswerButton3) {
		this.mAnswerButton3 = mAnswerButton3;
	}

	public void setAnswerButton4(Button mAnswerButton4) {
		this.mAnswerButton4 = mAnswerButton4;
	}

}
