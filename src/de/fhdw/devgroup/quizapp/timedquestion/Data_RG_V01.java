package de.fhdw.devgroup.quizapp.timedquestion;

import android.os.Bundle;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class Data_RG_V01 {
	
	private Init_RG_V01 mActivity;
	private String questionText;
	private String btn01Text;
	private String btn02Text;
	private String btn03Text;
	private String btn04Text;
	private int Answer;
	
	// Laden
	public Data_RG_V01 (Bundle savedInstanceState, Init_RG_V01 act) {
		mActivity = act;
		if ( savedInstanceState == null ) {
			setAnswer(3);
			setBtn01Text("Antwort 1");
			setBtn02Text("Antwort 2");
			setBtn03Text("Antwort 3");
			setBtn04Text("Antwort 4");
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save 
	public void saveDataInBundle(Bundle b) {
		// ?
	}
	
	// restore
	public void restoreDataFromBundle(Bundle b) {
		// ?
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
	
	// ButtonText01 zurückgeben
	public String getBtn01Text() {
		return btn01Text;
	}
	
	// ButtonText01 setzen
	public void setBtn01Text(String btn01Text) {
		this.btn01Text = btn01Text;
	}
	
	public String getBtn02Text() {
		return btn02Text;
	}

	public void setBtn02Text(String btn02Text) {
		this.btn02Text = btn02Text;
	}

	public String getBtn03Text() {
		return btn03Text;
	}

	public void setBtn03Text(String btn03Text) {
		this.btn03Text = btn03Text;
	}

	public String getBtn04Text() {
		return btn04Text;
	}

	public void setBtn04Text(String btn04Text) {
		this.btn04Text = btn04Text;
	}
	
	// Antwort zürckgeben
	public int getAnswer() {
		return Answer;
	}
	
	// Antwort setzen
	public void setAnswer(int answer) {
		Answer = answer;
	}
	
	public Init_RG_V01 getActivity() {
		return mActivity;
	}

}
