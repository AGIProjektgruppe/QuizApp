package de.fhdw.devgroup.quizapp.estimatequestion;

import de.fhdw.devgroup.quizapp.constants.Constants;
import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */

public class Init_TS_V01 extends Activity{
	
	private Data_TS_V01 mData;
	private GUI_TS_V01 mGUI;
	private ApplicationLogic_TS_V01 mApplicationLogic;
	private int[] questionOrder;
	private int questionNr;
	private int mScore;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.layout_qot_rg_v01);
		initGUI();
		initData(savedInstanceState);
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
		mData = new Data_TS_V01(savedInstanceState, this, mGUI, questionOrder, questionNr, mScore);
	}
	
	//GUI initialisieren
	private void initGUI() {
		mGUI = new GUI_TS_V01(this);
	}
	
	
	//ApplicationLogic initialisieren
	private void initApplicationLogic() {
		mApplicationLogic = new ApplicationLogic_TS_V01(mData, mGUI);
	}
	
	//EventToListenerMapping initialisieren
	private void initEventToListenerMapping() {
		new EventToListenerMapping_TS_V01(mGUI, mApplicationLogic);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		mData.saveDataInBundle(outState);
		super.onSaveInstanceState(outState);
	}
	

}