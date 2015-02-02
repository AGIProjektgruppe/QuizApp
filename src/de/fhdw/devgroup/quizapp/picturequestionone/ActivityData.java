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
	private int mCurrentRandomNumber;

	public ActivityData (Bundle savedInstanceState, ActivityInit act) {
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
}
