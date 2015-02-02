package de.fhdw.devgroup.quizapp.singleanswer;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;
import de.fhdw.devgroup.quizapp.R;

/**
 * 
 * @author Sven Brückmann
 * @version 1.0
 */

public class GUI_SB_V01 {
	
	private TextView tvQuestion;
	private Button btn01Answer;
	private Button btn02Answer;
	private Button btn03Answer;
	private Button btn04Answer;
	
	public GUI_SB_V01(Init_SB_V01 act) {
		act.setContentView(R.layout.layout_qot_rg_v01);
		
		tvQuestion = (TextView) act.findViewById(R.id.textView01);
		btn01Answer = (Button) act.findViewById(R.id.btn1);
		btn02Answer = (Button) act.findViewById(R.id.btn2);
		btn03Answer = (Button) act.findViewById(R.id.btn3);
		btn04Answer = (Button) act.findViewById(R.id.btn4);
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
	
	public void setColorBtnTrue(Button button){
		button.setBackgroundColor(Color.GREEN);
	}
	
	public void setColorBtnFalse(Button button){
		button.setBackgroundColor(Color.RED);
	}
	
}
