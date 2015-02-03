package de.fhdw.devgroup.quizapp.picturequestionone;

import de.fhdw.devgroup.quizapp.constants.Constants;
import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Adrian Strzelczyk
 *
 */
public class ActivityInit extends Activity{
	
	private ActivityData mData;
	private ActivityGUI mGUI;
	private ActivityApplicationLogic mApplicationLogic;
	int[] questionOrder;
	int questionNr;
	int mScore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}

	private void initData(Bundle savedInstanceState) {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			questionOrder = extras.getIntArray("questionOrder");
			questionNr = extras.getInt("questionNr");
			mScore = extras.getInt(Constants.KEY_QUESTIONSCORE);
		}
		
		mData = new ActivityData(savedInstanceState, this, questionOrder, questionNr,mScore);
	}
	
	private void initGUI() {
		mGUI = new ActivityGUI(this);
	}

	private void initApplicationLogic() {
		mApplicationLogic = new ActivityApplicationLogic(mData, mGUI);
	}
	
	private void initEventToListenerMapping() {
		new ActivityEventToListenerMapping(mGUI, mApplicationLogic);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	

}
