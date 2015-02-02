package de.fhdw.devgroup.quizapp.timedquestion;

import android.graphics.Color;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Robert Glashagen
 * @version 1.0
 */

public class GUI_RG_V01 {
	
	private TextView tvQuestion;
	private Button btn01Answer;
	private Button btn02Answer;
	private Button btn03Answer;
	private Button btn04Answer;
	private ProgressBar pbTimer;
	
	public GUI_RG_V01(Init_RG_V01 act) {
		act.setContentView(R.layout.layout_qot_rg_v01);
		
		tvQuestion = (TextView) act.findViewById(R.id.textView01);
		btn01Answer = (Button) act.findViewById(R.id.btn1);
		btn02Answer = (Button) act.findViewById(R.id.btn2);
		btn03Answer = (Button) act.findViewById(R.id.btn3);
		btn04Answer = (Button) act.findViewById(R.id.btn4);
		pbTimer = (ProgressBar) act.findViewById(R.id.progressBar01);
	}
	
	//getter and setter to access Views
	
	public TextView getTvQuestion() {
		return tvQuestion;
	}

	public void setTvQuestionText(String text) {
		this.tvQuestion.setText(text); 
	}

	public Button getBt1Answer() {
		return btn01Answer;
	}

	public Button getBt2Answer() {
		return btn02Answer;
	}


	public Button getBt3Answer() {
		return btn03Answer;
	}

	public Button getBt4Answer() {
		return btn04Answer;
	}
	
	public void setBtn01AnswerText(String text) {
		btn01Answer.setText(text);
	}
	
	public void setBtn02AnswerText(String text) {
		btn02Answer.setText(text);
	}
	
	public void setBtn03AnswerText(String text) {
		btn03Answer.setText(text);
	}
	
	public void setBtn04AnswerText(String text) {
		btn04Answer.setText(text);
	}
	
	public ProgressBar getPbTimer() {
		return pbTimer;
	}

	public void setPbTimer(ProgressBar pbTimer) {
		this.pbTimer = pbTimer;
	}
	
	public void setColorBtnTrue(Button button){
		button.setBackgroundColor(Color.GREEN);
	}
	
	public void setColorBtnFalse(Button button){
		button.setBackgroundColor(Color.RED);
	}
	
}
