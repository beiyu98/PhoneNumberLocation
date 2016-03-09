package com.project.android.bruce.phonenumberlocation;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText inputNumberEt;
    private TextView phone,prefix,supplier,province,city,suit;
    private HttpConnection httpConnection;
    private ParserJsonData parserJsonData;
    private NumberData numberData;
    private String inputNumber;
    private static final int SUCCESS = 100;

    private Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){
                case SUCCESS:
                    numberData = (NumberData) msg.obj;
                    phone.setText("输入的电话号码："+numberData.getPhoneNumber());
                    prefix.setText("手机号码前7位："+numberData.getPrefix());
                    supplier.setText("提供服务的运营商："+numberData.getNumberSupplier());
                    province.setText("归属地所在省份："+numberData.getNumberProvince());
                    city.setText("归属地所在城市："+numberData.getNumberCity());
                    suit.setText("号码的所属号段："+numberData.getNumberSuit());
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.search_btn).setOnClickListener(this);
        inputNumberEt = (EditText) findViewById(R.id.input_et);
        phone = (TextView) findViewById(R.id.text_number);
        prefix = (TextView) findViewById(R.id.text_prefix);
        supplier = (TextView) findViewById(R.id.text_supplier);
        province = (TextView) findViewById(R.id.text_province);
        city = (TextView) findViewById(R.id.text_city);
        suit = (TextView) findViewById(R.id.text_suit);
    }

    @Override
    public void onClick(View v) {
        inputNumber = inputNumberEt.getText().toString().trim();
        if (inputNumber.length()!=11){
            Toast.makeText(MainActivity.this,"您输入的电话号码有误！！！",Toast.LENGTH_SHORT).show();
        }else {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    httpConnection = new HttpConnection();
                    String data = httpConnection.requestData(inputNumber);

                    parserJsonData = new ParserJsonData();
                    numberData = parserJsonData.parserTool(data);

                    Message message = Message.obtain();
                    message.what = SUCCESS;
                    message.obj=numberData;
                    myHandler.sendMessage(message);
                }
            }.start();
        }
    }
}
