package de.fhdw.devgroup.quizapp.timedquestion;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class EventToListenerMapping_RG_V01 implements OnClickListener{
	
	private ApplicationLogic_RG_V01 mApplicationLogic;
	private GUI_RG_V01 mGUI;
	
	// EventToListenerMapping starten
	public EventToListenerMapping_RG_V01 (GUI_RG_V01 gui, ApplicationLogic_RG_V01 appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		// Buttons ein Event zuweisen
		mGUI.getBt1Answer().setOnClickListener(this);
		mGUI.getBt2Answer().setOnClickListener(this);
		mGUI.getBt3Answer().setOnClickListener(this);
		mGUI.getBt4Answer().setOnClickListener(this);

	}
	
	// Wenn Event gestartet wird tue ...
	@Override
	public void onClick(View v) {
		
		mApplicationLogic.onButtonClicked(v);
	
	}
	
}
