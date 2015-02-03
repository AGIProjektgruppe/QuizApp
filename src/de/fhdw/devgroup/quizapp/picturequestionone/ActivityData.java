package de.fhdw.devgroup.quizapp.picturequestionone;

import java.util.Random;

import android.os.Bundle;

/**
 * 
 * @author Adrian Strzelczyk
 *
 */
public class ActivityData {
	
	private static final String CURRENTRANDOMNUMBER = "K1";
	
	private ActivityInit mActivity;
	private int mQuestionId;
	private int[] mQuestionOrder;
	private int mQuestionNr;
	private int mQuestionScore;

	public ActivityData (Bundle savedInstanceState, ActivityInit act, int[] questionOrder, int questionNr, int questionScore) {
		mActivity = act;
		mQuestionOrder =questionOrder;
		mQuestionNr = questionNr;
		setQuestionScore(questionScore);
		
		if ( savedInstanceState == null ) {  // no data to restore
			Random rand = new Random();
			//randomnumber between 1-5 to get one of those questions
			//next((max-min)+1)+1
			mQuestionId = questionOrder[questionNr];
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(CURRENTRANDOMNUMBER, mQuestionId);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mQuestionId = b.getInt(CURRENTRANDOMNUMBER);
	}

	// getter
	public int getquestionId() {
		return mQuestionId;
	}
	
	public ActivityInit getActivity() {
		return mActivity;
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
}
