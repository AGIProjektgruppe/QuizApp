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
		mData = new Data_SB_V01(savedInstanceState, this);
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