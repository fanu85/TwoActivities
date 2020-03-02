package com.fansoftsystems.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String RECEIVED_MESSAGE = "com.fansoftsystems.twoactivities.RECEIVED_MESSAGE";
    private String mMessage;
    private TextView txtMessage;
    private EditText editReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        mMessage = intent.getStringExtra(RECEIVED_MESSAGE);
        txtMessage = findViewById(R.id.text_message);
        txtMessage.setText(mMessage);
        editReply = findViewById(R.id.editText_second);

    }

    public void returnReply(View view) {
        String reply = editReply.getText().toString();
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(reply)) {
            intent.putExtra(MainActivity.REPLY_MESSAGE,reply);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            setResult(RESULT_CANCELED);
        }

    }
}
