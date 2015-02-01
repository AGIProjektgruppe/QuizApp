package de.fhdw.devgroup.quizapp.picturequestionone;

import android.view.View;
import android.view.View.OnClickListener;

public class ActivityEventToListenerMapping  implements OnClickListener{
	
	private ActivityApplicationLogic mApplicationLogic;
	private ActivityGUI mGUI;
	
	public ActivityEventToListenerMapping (ActivityGUI gui, ActivityApplicationLogic appLogic) {
		this.mGUI = gui;
		this.mApplicationLogic = appLogic;
		
		mGUI.getmConfirm().setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		mApplicationLogic.onConfirmButtonClicked();		
	}


}
