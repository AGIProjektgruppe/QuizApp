package de.fhdw.devgroup.quizapp.timedquestion;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class Init_RG_V01 extends Activity{
	
	private Data_RG_V01 mData;
	private GUI_RG_V01 mGUI;
	private ApplicationLogic_RG_V01 mApplicationLogic;
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
		mGUI = new GUI_RG_V01(this);
	}
	
	//ApplicationLogic initialisieren
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic_RG_V01(mData, mGUI);
	}
	
	//EventToListenerMapping initialisieren
	private void initEventToListenerMapping() {
		new EventToListenerMapping_RG_V01(mGUI, mApplicationLogic);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	
}