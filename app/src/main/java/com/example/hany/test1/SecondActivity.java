package com.example.hany.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_second);
        setTitle("SecondActivity"); // 调用基类setTitle()方法，设置本活动标题

        // 显示firstActivity传输过来的数据
        Intent intent = getIntent();
        String d = intent.getStringExtra("data");
        TextView displayDataFromFirstTxt = findViewById(R.id.txt_second_display_first_data);
        if (!TextUtils.isEmpty(d)) {
            displayDataFromFirstTxt.setText(d);
        }

        // 输入数据返回到first
        final EditText inputDataEit = findViewById(R.id.edt_second_input_data_back_first);
        inputDataEit.setInputType(EditorInfo.TYPE_CLASS_TEXT); // 设置默认打开输入文本的键盘
        // inputDataEit.setInputType(EditorInfo.TYPE_TEXT_VARIATION_URI); 设置默认打开输入字母的键盘
        // 设置打开活动时不聚焦该EditText，因此不会打开输入法
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // 返回数据按钮
        Button sendDataReturnFirstBtn = findViewById(R.id.btn_second_back_transmit_first);
        sendDataReturnFirstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d = inputDataEit.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("returnData", d);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
