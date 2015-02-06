package de.fhdw.devgroup.quizapp.estimatequestion;


import de.fhdw.devgroup.quizapp.constants.Constants;
import android.os.Bundle;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */
//Datenklasse
public class Data_TS_V01 {
	
	private Init_TS_V01 mActivity;
	private GUI_TS_V01 mGUI;
	private String questionText;
	private String btn01Text;
	// Toleranzwert kann geändert werden, falls die Fragen zu schwierig oder zu leicht eingeschätzt werden.
	private double tolerance = 0.05;
	private double Answer;
	private String mQuestionText;
	private int[] mQuestionOrder;
	private int mQuestionNr;
	private int mQuestionScore;
	
	// Laden
	public Data_TS_V01 (Bundle savedInstanceState, Init_TS_V01 act, GUI_TS_V01 gui, int[] questionOrder, int questionNr, int mScore) {
		mActivity = act;
		mGUI = gui;
		setQuestionOrder(questionOrder);
		setQuestionNr(questionNr);
		setQuestionScore(mScore);
		if ( savedInstanceState == null ) {
			mQuestionText = "estimatequestion_"  + questionOrder[questionNr] +"_text";
			int lId = this.getActivity().getResources().getIdentifier(mQuestionText, "string", this.getActivity().getPackageName());
			questionText = this.getActivity().getResources().getString(lId);
			
			
			String answer = "estimatequestion_" + questionOrder[questionNr] + "_answer";
			int id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			Answer = Double.parseDouble(this.getActivity().getResources().getString(id));
			setBtn01Text("Submit");
		}
		else {
			mQuestionText = "estimatequestion_text_"  + questionOrder[questionNr];
			int lId = this.getActivity().getResources().getIdentifier(mQuestionText, "string", this.getActivity().getPackageName());
			questionText = this.getActivity().getResources().getString(lId);
			
			String answer = "estimatequestion_" + questionOrder[questionNr] + "_answer";
			int id = this.getActivity().getResources().getIdentifier(answer, "string", this.getActivity().getPackageName());		
			Answer = Double.parseDouble(this.getActivity().getResources().getString(id));
			setBtn01Text("Submit");
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save
	public void saveDataInBundle(Bundle b) {
		if (mGUI.getEtAnswer().getText().toString() != null ) b.putDouble(Constants.KEY_USERESTMATE_ESTIMATEQUESTION, Double.parseDouble(mGUI.getEtAnswer().getText().toString()));
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
	
	// Antwort + 5% zurückgeben
	public double getAnswerMax() {
		return Answer*(1+tolerance);
	}
	
	// Antwort - 5% zurückgeben
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
	
	public int getQuestionScore() {
		return mQuestionScore;
	}

	public int getQuestionNr() {
		return mQuestionNr;
	}

	public int[] getQuestionOrder() {
		return mQuestionOrder;
	}
	
	public void setQuestionOrder(int[] mQuestionOrder) {
		this.mQuestionOrder = mQuestionOrder;
	}

	public void setQuestionNr(int mQuestionNr) {
		this.mQuestionNr = mQuestionNr;
	}

	public void setQuestionScore(int mQuestionScore) {
		this.mQuestionScore = mQuestionScore;
	}
}
