package de.fhdw.devgroup.quizapp.sortingquestion;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityGUI {

	private TextView mQuestionText;
	
	private Button mAnswerButton1;
	private Button mAnswerButton2;
	private Button mAnswerButton3;
	private Button mAnswerButton4;
	private Button mSubmit;
	
	private TextView mPosition1;
	private TextView mPosition2;
	private TextView mPosition3;
	private TextView mPosition4;
	
	
	
	public ActivityGUI(ActivityInit activityInit) {
		Log.d("GUI","Succesfully Created GUI");
		setQuestionText((TextView) activityInit.findViewById(R.id.questionText));
		
		mAnswerButton1 = (Button) activityInit.findViewById(R.id.answer1);
		mAnswerButton2 = (Button) activityInit.findViewById(R.id.answer2);
		mAnswerButton3 = (Button) activityInit.findViewById(R.id.answer3);
		mAnswerButton4 = (Button) activityInit.findViewById(R.id.answer4);
		setSubmit((Button) activityInit.findViewById(R.id.submit));
		
		mPosition1 = (TextView) activityInit.findViewById(R.id.position1);
		mPosition2 = (TextView) activityInit.findViewById(R.id.position2);
		mPosition3 = (TextView) activityInit.findViewById(R.id.position3);
		mPosition4 = (TextView) activityInit.findViewById(R.id.position4);
	}

	public Button getAnswerButton1() {
		return mAnswerButton1;	}

	public Button getAnswerButton2() {
		return mAnswerButton2;	}

	public Button getAnswerButton3() {
		return mAnswerButton3;	}

	public Button getAnswerButton4() {
		return mAnswerButton4;	}

	public TextView getPosition1() {
		return mPosition1;	}

	public TextView getPosition2() {
		return mPosition2;	}

	public TextView getPosition3() {
		return mPosition3;	}

	public TextView getPosition4() {
		return mPosition4;	}

	public Button getSubmit() {
		return mSubmit;	}

	public TextView getQuestionText() {
		return mQuestionText;	}

	public void setQuestionText(TextView mQuestionText) {
		this.mQuestionText = mQuestionText;	}

	public void setSubmit(Button mSubmit) {
		this.mSubmit = mSubmit;	}

	public void setAnswerButton1(Button mAnswerButton1) {
		this.mAnswerButton1 = mAnswerButton1;	}

	public void setAnswerButton2(Button mAnswerButton2) {
		this.mAnswerButton2 = mAnswerButton2;	}

	public void setAnswerButton3(Button mAnswerButton3) {
		this.mAnswerButton3 = mAnswerButton3;	}

	public void setAnswerButton4(Button mAnswerButton4) {
		this.mAnswerButton4 = mAnswerButton4;	}

	public void setPosition1(TextView mPosition1) {
		this.mPosition1 = mPosition1;	}

	public void setPosition2(TextView mPosition2) {
		this.mPosition2 = mPosition2;	}

	public void setPosition3(TextView mPosition3) {
		this.mPosition3 = mPosition3;	}

	public void setPosition4(TextView mPosition4) {
		this.mPosition4 = mPosition4;	}
}
