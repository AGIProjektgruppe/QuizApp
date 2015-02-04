package de.fhdw.devgroup.quizapp.singleanswer;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Sven Brückmann
 * @version 1.0
 */

public class Init_SB_V01 extends Activity{
	
	private Data_SB_V01 mData;
	private GUI_SB_V01 mGUI;
	private ApplicationLogic_SB_V01 mApplicationLogic;
	private int[] questionOrder;
	private int questionNr;
	private int mScore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.layout_qot_rg_v01);
		initData(savedInstanceState);
		initGUI();
		initApplicationLogic();
		initEventToListenerMapping();
	}
	
	//Data initialisieren
	private void initData(Bundle savedInstanceState) {
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			questionOrder = extras.getIntArray(Constants.KEY_QUESTIONORDER);
			questionNr = extras.getInt(Constants.KEY_QUESTIONNUMBER);
			mScore = extras.getInt(Constants.KEY_QUESTIONSCORE);
		}
		
		mData = new ActivityData(savedInstanceState, this, questionOrder, questionNr,mScore);
	}
	
	//GUI initialisieren 
	private void initGUI() {
		mGUI = new GUI_SB_V01(this);
	}
	
	//ApplicationLogic initialisieren
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic_SB_V01(mData, mGUI);
	}
	
	//EventToListenerMapping initialisieren
	private void initEventToListenerMapping() {
		new EventToListenerMapping_SB_V01(mGUI, mApplicationLogic);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
}