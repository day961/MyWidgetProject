package com.Svoday.example.mywidget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by suoday on 13-6-13.
 */
public class SecendActivity extends Activity {

    private TextView ResultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        ResultView = (TextView)findViewById(R.id.ResultView);
        Intent intent = getIntent();
        String str1 = intent.getStringExtra("first");
        String str2 = intent.getStringExtra("second");
        int one = Integer.parseInt(str1);
        int two = Integer.parseInt(str2);
        int result = one * two;
        ResultView.setText(result + "");
    }
}
