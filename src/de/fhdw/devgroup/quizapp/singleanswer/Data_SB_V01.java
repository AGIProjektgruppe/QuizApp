package de.fhdw.devgroup.quizapp.singleanswer;

import android.os.Bundle;

/**
 * 
 * @author Sven Brückmann
 * @version 1.0
 */

public class Data_SB_V01 {
	
	private static final String CURRENTQUESTIONNUMBER = "K1";
	
	private Init_SB_V01 mActivity;
	private int mQuestionId;
	private int[] mQuestionOrder;
	private int mQuestionNr;
	private int mQuestionScore;
	
	// Laden
	public Data_SB_V01 (Bundle savedInstanceState, Init_SB_V01 act, int[] questionOrder, int questionNr, int questionScore) {
		mActivity = act;
		mQuestionOrder =questionOrder;
		mQuestionNr = questionNr;
		setQuestionScore(questionScore);
		
		if ( savedInstanceState == null ) {
			mQuestionId = questionOrder[questionNr];
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save 
	public void saveDataInBundle(Bundle b) {
		b.putInt(CURRENTQUESTIONNUMBER, mQuestionId);
	}
	
	//restore
	public void restoreDataFromBundle(Bundle b) {
		mQuestionId = b.getInt(CURRENTQUESTIONNUMBER);
	}
	
	//getter und setter
	public int getquestionId() {
		return mQuestionId;
	}

	public int[] getQuestionOrder() {
		return mQuestionOrder;
	}

	public void setQuestionOrder(int[] questionOrder) {
		this.mQuestionOrder = questionOrder;
	}

	public int getQuestionNr() {
		return mQuestionNr;
	}

	public void setQuestionNr(int mQuestionNr) {
		this.mQuestionNr = mQuestionNr;
	}

	public int getQuestionScore() {
		return mQuestionScore;
	}

	public void setQuestionScore(int mQuestionScore) {
		this.mQuestionScore = mQuestionScore;
	}
	
	public Init_SB_V01 getActivity() {
		return mActivity;
	}

}
