package de.fhdw.devgroup.quizapp.estimatequestion;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @author Thomas Schmiedel
 * @version 1.0
 */

public class EventToListenerMapping_TS_V01 implements OnClickListener{
	
	private ApplicationLogic_TS_V01 mApplicationLogic;
	private GUI_TS_V01 mGUI;
	
	// EventToListenerMapping starten
	public EventToListenerMapping_TS_V01 (GUI_TS_V01 gui, ApplicationLogic_TS_V01 appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		// Button ein Event zuweisen
		mGUI.getBtnsubmit().setOnClickListener(this);

	}
	
	// Wenn Event gestartet wird tue ...
	@Override
	public void onClick(View v) {
		
		mApplicationLogic.onButtonClicked(v);
	
	}
	
}
