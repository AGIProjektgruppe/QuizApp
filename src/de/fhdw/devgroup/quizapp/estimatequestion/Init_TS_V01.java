package de.fhdw.devgroup.quizapp.estimatequestion;

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
		mData = new Data_TS_V01(savedInstanceState, this, mGUI);
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