package com.qinweiping.dynamicstring;

import com.example.androiddynamicstringlistactivity.R;
import com.qinweiping.dynamicstring.common.ViewHolder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author qwp
 * 
 */

@SuppressLint("NewApi")
public class DynamicStringListActivity extends Activity {

	private String[] questionList,responseList;
	private LayoutInflater mLayoutInflater;
	private LinearLayout rootLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dynamicstringlist);
		init();
	}
	
	private void init(){
		initActionBar();
		rootLayout = (LinearLayout)findViewById(R.id.help_rootlayout);
		
		questionList = this.getResources().getStringArray(R.array.question_list);
		responseList = this.getResources().getStringArray(R.array.answer_list);
		
		mLayoutInflater = LayoutInflater.from(this);
		
		initList();
	}
	
	private void initList(){
		for(int i = 0 ; i < questionList.length;i++){
			rootLayout.addView(createItem(questionList[i],responseList[i],"Q"+(i+1)));
		}
	}
	
	private void initActionBar(){
		
	}
	
	/**
	 * 得到页面布局中的每一个ViewItem  
	 * @param question
	 * @param response
	 * @param questionIcon
	 * @return
	 */
	private View createItem(String question,String response,String questionIcon){
		View view = mLayoutInflater.inflate(R.layout.listitem, null);
		TextView QuestionIconText = ViewHolder.get(view,R.id.question_icon);
		TextView QuestionText = ViewHolder.get(view,R.id.quesion);
		TextView answerText = ViewHolder.get(view,R.id.answer);
		QuestionIconText.setText(questionIcon);
		QuestionText.setText(question);
		answerText.setText(response);
		return view;
	}
	
}
