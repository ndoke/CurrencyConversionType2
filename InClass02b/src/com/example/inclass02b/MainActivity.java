package com.example.inclass02b;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText ed;
	public TextView tx;
	public String readText;
	public RadioButton rd1, rd2, rd3, rd4, rd5;
	public double num = 0.0d;

	public static boolean isNumber(String string) {
		if (string == null || string.isEmpty()) {
			return false;
		}
		int i = 0;
		if (string.charAt(0) == '-') {
			return false;
		}
		int count = 0;
		for (; i < string.length(); i++) {
			if (!Character.isDigit(string.charAt(i)) && !(string.charAt(i) == '.')) {
				return false;
			}
			if (string.charAt(i) == '.')
				count++;
		}

		if (count > 1)
			return false;
		else
			return true;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.button1).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rd1 = (RadioButton) findViewById(R.id.rad01);
				rd2 = (RadioButton) findViewById(R.id.rad02);
				rd3 = (RadioButton) findViewById(R.id.rad03);
				rd4 = (RadioButton) findViewById(R.id.rad04);
				rd5 = (RadioButton) findViewById(R.id.rad05);
				ed = (EditText) findViewById(R.id.editText1);
				tx = (TextView) findViewById(R.id.textView1);
				double mul = 0.0d;
				String cur = "";

				if (rd1.isChecked()) {
					mul = 0.849282;
					cur = "EUR";
				} else if (rd2.isChecked()) {
					mul = 1.19;
					cur = "CAD";
				} else if (rd3.isChecked()) {
					mul = 0.65;
					cur = "GBP";
				} else if (rd4.isChecked()) {
					mul = 117.62;
					cur = "JPY";
				} else if (rd5.isChecked()) {
					ed.setText("");
					tx.setText("");
				}

				if (isNumber(ed.getText().toString()) && !rd5.isChecked()) {
					String inp = new DecimalFormat("#.##").format(Double.parseDouble(ed.getText().toString()));
					double result = Double.parseDouble(inp) * mul;
					String res = new DecimalFormat("#.##").format(result);
					tx.setText(inp + " USD = " + res + " " + cur);
				} else if (!isNumber(ed.getText().toString()) && !rd5.isChecked()) {
					Toast.makeText(getBaseContext(), "Wrong input", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

}
