package de.fhdw.devgroup.quizapp.singleanswer;

import android.view.View;
import android.view.View.OnClickListener;

/**
 * 
 * @author Sven Brückmann
 * @version 1.0
 */

public class EventToListenerMapping_SB_V01 implements OnClickListener{
	
	private ApplicationLogic_SB_V01 mApplicationLogic;
	private GUI_SB_V01 mGUI;
	
	// EventToListenerMapping starten
	public EventToListenerMapping_SB_V01 (GUI_SB_V01 gui, ApplicationLogic_SB_V01 appLogic) {
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
