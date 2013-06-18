package com.Svoday.example.mywidget;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by suoday on 13-6-13.
 */
public class Dialog_Activity extends Activity {
    private Button back_button;
    private TextView dialog_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Intent intent = getIntent();
        String information = intent.getStringExtra("mainacitivy_text");

        dialog_textview = (TextView)findViewById(R.id.dialog_textview);

        dialog_textview.setText(information);

        back_button = (Button)findViewById(R.id.dialog_back);
        back_button.setOnClickListener(new BackButtonListener());
    }


    class BackButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            finish();
        }
    }
}

