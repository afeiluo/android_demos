package com.example.textswitcherdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView mTv;
	private TextSwitcher mTs;
	private int mNum;

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (mNum++ < 100) {
				mTv.setText(String.valueOf(mNum));
				mTs.setText(String.valueOf(mNum));
				sendEmptyMessageDelayed(0, 500);
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTv = (TextView) findViewById(R.id.tv);

		mTs = (TextSwitcher) findViewById(R.id.ts);

		mTs.setFactory(new TextSwitcher.ViewFactory() {
			@Override
			public View makeView() {
				final TextView tv = (TextView) LayoutInflater.from(
						getApplicationContext()).inflate(R.layout.text, null);
				return tv;
			}
		});

		mTs.setInAnimation(AnimationUtils.loadAnimation(
				getApplicationContext(), android.R.anim.fade_in));
		mTs.setOutAnimation(AnimationUtils.loadAnimation(
				getApplicationContext(), android.R.anim.fade_out));

	}

	public void onClick(View view) {
		mHandler.sendEmptyMessage(0);
	}

}
