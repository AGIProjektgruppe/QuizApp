package de.fhdw.devgroup.quizapp.main;

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
	private Class<?>[] questiontype = {
			//Constants.ACTIVITYTIMEDCLASS,
			Constants.ACTIVITYESTIMATECLASS,
			//Constants.ACTIVITYMULTICLASS,
			Constants.ACTIVITYPICTURECLASSONE,
			Constants.ACTIVITYPICTURECLASSTWO,
			Constants.ACTIVITYSINGLEQUESTIONCLASS,
			Constants.ACTIVITYSORTINGCLASS,
			Constants.ACTIVITYGAPCLASS
			
			};
	private int[] questionsOrderForThisRun = {1,2,3,4,5,6,7,8,9,10};
	private int mCurrentRandomNumber;
	private int questionNr;
	private int mScore;
	
	
	public ActivityApplicationLogic(ActivityData mData, ActivityGUI mGUI, ActivityInit mActivity) {
		Log.d("Logic","Logic Class created");
		
		this.mActivity = mActivity;
		this.mData = mData;
		this.mGUI = mGUI;	
	}

	public void startButtonClicked() {
		Random rand = new Random();
		mCurrentRandomNumber = rand.nextInt((5-1)+1)+1;
		questionsOrderForThisRun = Shuffler.shuffleArray(questionsOrderForThisRun);
		questionNr = 0;
		mScore = 0;
		Intent intent; 
		intent = new Intent();
		intent.putExtra(Constants.KEY_QUESTIONORDER, questionsOrderForThisRun);
		intent.putExtra(Constants.KEY_QUESTIONNUMBER, questionNr);
		intent.putExtra(Constants.KEY_QUESTIONSCORE, mScore);
        intent.setClass(mData.getActivity(), questiontype[mCurrentRandomNumber]);
		//intent.setClass(mData.getActivity(), Constants.ACTIVITYGAPCLASS);
        mData.getActivity().startActivity(intent);
        
        
	}


	public void highscoreButtonClicked() {
		
		/* Intent intent = new Intent();
        intent.setClass(mData.getActivity(), Constants.ACTIVITYSORTINGCLASS);
        mData.getActivity().startActivity(intent);
		*/
	}

}
