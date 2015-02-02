package de.fhdw.devgroup.quizapp.estimatequestion;


import de.fhdw.devgroup.quizapp.constants.Constants;
import android.os.Bundle;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */

public class Data_TS_V01 {
	
	private Init_TS_V01 mActivity;
	private GUI_TS_V01 mGUI;
	private String questionText;
	private String btn01Text;
	private double tolerance = 0.05;
	private double Answer;
	
	// Laden
	public Data_TS_V01 (Bundle savedInstanceState, Init_TS_V01 act, GUI_TS_V01 gui) {
		mActivity = act;
		mGUI = gui;
		if ( savedInstanceState == null ) {
			setQuestionText("Wieviel Millionäre gibt es in Deutschland?");
			setAnswer(386000);
			setBtn01Text("Submit");
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save
	public void saveDataInBundle(Bundle b) {
		b.putDouble(Constants.KEY_USERESTMATE_ESTIMATEQUESTION, Double.parseDouble(mGUI.getEtAnswer().getText().toString()));
	}
	
	// restore
	public void restoreDataFromBundle(Bundle b) {
		mGUI.getEtAnswer().setText(String.valueOf(b.getDouble(Constants.KEY_USERESTMATE_ESTIMATEQUESTION)));
	}
	
	// change data
	
	// Fragetext zurückgeben
	public String getQuestionText() {
		return questionText;
	}
	
	// Fragetext setzen
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getBtn01Text() {
		return btn01Text;
	}

	public void setBtn01Text(String btn01Text) {
		this.btn01Text = btn01Text;
	}
	
	// Antwort zurückgeben
	public double getAnswer() {
		return Answer;
	}
	
	// Antwort + 10% zurückgeben
	public double getAnswerMax() {
		return Answer*(1+tolerance);
	}
	
	// Antwort - 10% zurückgeben
	public double getAnswerMin() {
		return Answer*(1-tolerance);
	}
	
	// Antwort setzen
	public void setAnswer(double answer) {
		Answer = answer;
	}
	
	public Init_TS_V01 getActivity() {
		return mActivity;
	}

}
