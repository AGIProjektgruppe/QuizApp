package de.fhdw.devgroup.quizapp.end;

import java.util.Random;

import android.content.Intent;
import android.util.Log;
import de.fhdw.devgroup.quizapp.constants.Constants;
import de.fhdw.devgroup.quizapp.utilities.Shuffler;
/**
 * 
 * @author Tobias Hilger
 * @version 1.0
 */
public class ActivityApplicationLogic {
	
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityInit mActivity;
	private int mScore;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		Log.d("Logic","Logic Class created");
		
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;
		
		
		
	}

	public void submitScore() {
		
	}

}
