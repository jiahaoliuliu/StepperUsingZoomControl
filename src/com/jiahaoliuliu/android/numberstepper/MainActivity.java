package com.jiahaoliuliu.android.numberstepper;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ZoomButton;

public class MainActivity extends Activity {

	private TextView textView1;
	private ZoomButton zoomInButton;
	private ZoomButton zoomOutButton;
	private ZoomControls zoomControls1;
	
	private TextView textView2;
	private android.widget.ZoomControls zoomControls2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// First approach
		// Customize the zoomControl class
		// Take the source code and created the methods to set and
		// Get the buttons
		textView1 = (TextView)findViewById(R.id.textView1);

		zoomInButton = (ZoomButton)findViewById(R.id.zoomIn);
		zoomOutButton = (ZoomButton)findViewById(R.id.zoomOut);
		
		zoomControls1 = new ZoomControls(this);
		zoomControls1.setZoomInButton(zoomInButton);
		zoomControls1.setZoomOutButton(zoomOutButton);
		
		zoomControls1.setOnZoomInClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int actualValue = Integer.valueOf(textView1.getText().toString());
				actualValue ++;
				textView1.setText(String.valueOf(actualValue));
			}
		});

		zoomControls1.setOnZoomOutClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int actualValue = Integer.valueOf(textView1.getText().toString());
				if (actualValue > 0) {
					actualValue--;
					textView1.setText(String.valueOf(actualValue));
				}
			}
		});
		
		// Second approach
		// Use the option foreground in the Framelayout
		textView2 = (TextView)findViewById(R.id.textView2);
		zoomControls2 = (android.widget.ZoomControls) findViewById(R.id.zoomControl2);
		zoomControls2.setOnZoomInClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int actualValue = Integer.valueOf(textView2.getText().toString());
				actualValue ++;
				textView2.setText(String.valueOf(actualValue));
			}
		});

		zoomControls2.setOnZoomOutClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int actualValue = Integer.valueOf(textView2.getText().toString());
				if (actualValue > 0) {
					actualValue--;
					textView2.setText(String.valueOf(actualValue));
				}
			}
		});
	}
}
