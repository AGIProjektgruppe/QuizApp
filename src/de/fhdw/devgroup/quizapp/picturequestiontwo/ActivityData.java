package de.fhdw.devgroup.quizapp.picturequestiontwo;

import java.util.Random;

import android.os.Bundle;
import de.fhdw.devgroup.quizapp.picturequestiontwo.ActivityInit;

/**
 * 
 * @author Adrian Strzelczyk
 *
 */
public class ActivityData {
	
	private static final String CURRENTRANDOMNUMBER = "K1";
	
	private ActivityInit mActivity;
	private int mCurrentRandomNumber;
	private int[] mQuestionOrder;
	private int mQuestionNr;
	private int mQuestionScore;


	public ActivityData (Bundle savedInstanceState, ActivityInit act, int[] questionOrder, int questionNr, int mScore) {
		mActivity = act;
		if ( savedInstanceState == null ) {  // no data to restore
			Random rand = new Random();
			//randomnumber between 1-5 to get one of those questions
			//next((max-min)+1)+1
			mCurrentRandomNumber = rand.nextInt((5-1)+1)+1;
		}
		else {
			restoreDataFromBundle(savedInstanceState);
		}
	}
	
	// save and restore
	
	public void saveDataInBundle(Bundle b) {
		b.putInt(CURRENTRANDOMNUMBER, mCurrentRandomNumber);
	}
	
	public void restoreDataFromBundle(Bundle b) {
		mCurrentRandomNumber = b.getInt(CURRENTRANDOMNUMBER);
	}

	// getter
	public int getCurrentRandomNumber() {
		return mCurrentRandomNumber;
	}
	
	public ActivityInit getActivity() {
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
