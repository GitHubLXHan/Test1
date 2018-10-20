package com.example.hany.test1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_first);setTitle("FirstActivity"); // 调用基类setTitle()方法，设置本活动标题
        setTitle("FirstActivity"); // 调用基类setTitle()方法，设置本活动标题


        // 弹出吐司提示
        Button makeToastBtn = (Button) findViewById(R.id.make_toast);
        makeToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "弹出吐司提示", Toast.LENGTH_SHORT).show();
            }
        });

        // 显示跳转到SecondActivity
        Button explicitToSecondBtn = findViewById(R.id.btn_first_explicit_to_second);
        explicitToSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        // 隐式跳转到secondActivity
        Button implicitToSecondBtn = findViewById(R.id.btn_first_implicit_to_second);
        implicitToSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.hany.test1.ACTION_SECOND");
                startActivity(intent);
            }
        });

        // 隐式跳转到
        Button implicitCallPhoneBtn = findViewById(R.id.btn_first_implicit_to_callPhone);
        implicitCallPhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });

        // 隐式跳转到浏览器
        Button implicitToBrowser = findViewById(R.id.btn_first_implicit_to_browser);
        implicitToBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });


        // 输入框
        final EditText inputDataEit = findViewById(R.id.edt_first_input_data_to_second);
        inputDataEit.setInputType(EditorInfo.TYPE_CLASS_TEXT); // 设置默认打开输入文本的键盘
        // inputDataEit.setInputType(EditorInfo.TYPE_TEXT_VARIATION_URI); 设置默认打开输入字母的键盘
        // 设置打开活动时不聚焦该EditText，因此不会打开输入法
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // 传输
        Button transmitToSecondBtn = findViewById(R.id.btn_first_explicit_transmit_second);
        transmitToSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                String data = inputDataEit.getText().toString();
                intent.putExtra("data", data);
                startActivityForResult(intent, 1);
            }
        });

        // 跳转到拓展页面
        Button toExpandBtn = findViewById(R.id.btn_first_to_expand);
        toExpandBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, ExpandActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 显示secondActivity返回的数据
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String d = data.getStringExtra("returnData");
                    TextView displayBackDataTxt = findViewById(R.id.txt_first_display_back_data);
                    displayBackDataTxt.setText(d);
                }
                break;
        }
    }
}
