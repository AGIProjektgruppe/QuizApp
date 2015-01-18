package de.fhdw.devgroup.quizapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import de.fhdw.devgroup.quizapp.R;
import de.fhdw.devgroup.quizapp.constants.Constants;


public class ActivityMain extends Activity implements OnClickListener{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        Button mStart;
        mStart = (Button)findViewById(R.id.start);
        mStart.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
        intent.setClass(this, Constants.ACTIVITYMULTICLASS);
        startActivity(intent);
	}

    
   
}
