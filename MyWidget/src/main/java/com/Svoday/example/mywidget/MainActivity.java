package com.Svoday.example.mywidget;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends Activity {
    //声明控件对象
    private EditText EditText1;
    private EditText EditText2;
    private TextView TextView1;
    private Button Button1;
    private Button button_dialog;

    private RadioGroup radiogroup1;
    private RadioButton radio1;
    private RadioButton radio2;

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private ProgressBar progressbarH;
    private ProgressBar progressBarN;
    private Button progress_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //通过id确定控件对向
        EditText1 = (EditText)findViewById(R.id.EditText1);
        EditText2 = (EditText)findViewById(R.id.EditText2);
        TextView1 = (TextView)findViewById(R.id.TextView1);
        Button1 = (Button)findViewById(R.id.Button1);
        button_dialog = (Button)findViewById(R.id.button_dialog);

        radiogroup1 = (RadioGroup)findViewById(R.id.radiogroup1);
        radio1 = (RadioButton)findViewById(R.id.radioButton);
        radio2 = (RadioButton)findViewById(R.id.radioButton2);

        checkBox1 = (CheckBox)findViewById(R.id.checkbox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkbox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkbox3);

        progressbarH = (ProgressBar)findViewById(R.id.progressBarH);
        progressBarN = (ProgressBar)findViewById(R.id.progressBarN);
        progress_button = (Button)findViewById(R.id.progress_button);


//        TextView1.setText(R.string.multiply);
//        Button1.setText(R.string.Button1);
//        /*listview部分*/
//
//        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
//        HashMap<String,String> map1 = new HashMap<String, String>();
//        HashMap<String,String> map2 = new HashMap<String, String>();
//        HashMap<String,String> map3 = new HashMap<String, String>();
//        map1.put("list_first","aaa");
//        map1.put("list_second","111");
//        map2.put("list_first","bbb");
//        map2.put("list_second","222");
//        map3.put("list_first","ccc");
//        map3.put("list_second","333");
//        list.add(map1);
//        list.add(map2);
//        list.add(map3);
//        SimpleAdapter listAdapter = new SimpleAdapter(this,
//                list,R.layout.list_widget,new String[]{"list_first","list_second"},
//                new int[]{R.id.list_first,R.id.list_second});
//        setListAdapter(listAdapter);

        //设置对象监听器
        Button1.setOnClickListener(new CalculateListener());
        button_dialog.setOnClickListener(new DialogListener());
        radiogroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Intent intent_radio_dialog = new Intent();
                if(i == radio1.getId()){
                    //按下第一个radio后
//                    intent_radio_dialog.putExtra("mainacitivy_text","I'm the radio1");
//                    intent_radio_dialog.setClass(MainActivity.this,Dialog_Activity.class);
//                    MainActivity.this.startActivity(intent_radio_dialog);
                    Toast.makeText(MainActivity.this,"I'm the radio1",Toast.LENGTH_SHORT).show();
                }else if(i == radio2.getId()){
                    //按下第二个radio后
                    intent_radio_dialog.putExtra("mainacitivy_text","I'm the radio2");
                    intent_radio_dialog.setClass(MainActivity.this,Dialog_Activity.class);
                    MainActivity.this.startActivity(intent_radio_dialog);
                }

            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"CheckBox1 was Checked",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"CheckBox1 wasn't Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this,"CheckBox2 was Checked",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"CheckBox2 wasn't Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Intent checkbox3_intent = new Intent();
                    checkbox3_intent.setClass(MainActivity.this,List_Activity.class);
                    MainActivity.this.startActivity(checkbox3_intent);
                    Toast.makeText(MainActivity.this,"CheckBox3 was Checked",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"CheckBox3 wasn't Checked",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //进度条
        progress_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Thread progress = new Thread(updateThread);
                progress.start();
                System.out.println("progress_button pushed   Thread NO." + Thread.currentThread().getId());
                progressbarH.setVisibility(View.VISIBLE);
                //handler.post(updateThread);
            }
        });

    }

    class CalculateListener implements View.OnClickListener{//“计算”按钮侦听器

        @Override
        public void onClick(View view) {

            String str1 = EditText1.getText().toString();
            String str2 = EditText2.getText().toString();

            Intent intent = new Intent();
            intent.putExtra("first",str1);
            intent.putExtra("second",str2);

            intent.setClass(MainActivity.this,SecendActivity.class);
            MainActivity.this.startActivity(intent);

        }
    }

    class DialogListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent_dialog = new Intent();
            intent_dialog.putExtra("mainacitivy_text","You push the button!");
            intent_dialog.setClass(MainActivity.this, Dialog_Activity.class);
            MainActivity.this.startActivity(intent_dialog);
        }
    }

    //handler
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            progressbarH.setProgress(msg.arg1);
            //handler.post(updateThread);
            Thread progress = new Thread(updateThread);
            progress.start();
        }

    };
    //线程类。该类使用匿名内部类的方法进行声明
    Runnable updateThread = new Runnable() {
        int i = 0;
        @Override
        public void run() {
            if(i > 100){
                handler.removeCallbacks(updateThread);
                i = 0;
            }else{
            System.out.println("updateThread Begin    Thread NO." + Thread.currentThread().getId());
//            handler.postDelayed(updateThread, 3000);
            i = i + 10;
            //创建一个消息对象，由android提供
            Message msg = handler.obtainMessage();
            msg.arg1 = i;//arg1和arg2是用来传递消息
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            handler.sendMessage(msg);
            }
        }
    };


    @Override
    //这是菜单，当用户点击menu时调用
        public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    //当用户点击菜单选项时调用，并把选项参数menu传到这里
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_exit)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
