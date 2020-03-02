package com.fansoftsystems.twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String REPLY_MESSAGE = "com.fansoftsystems.twoactivities.REPLY_MESSAGE";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final int REPLY_CODE = 1;
    private EditText txtMessage;
    private TextView txtRepliedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMessage = findViewById(R.id.editText_main);
        txtRepliedMessage = findViewById(R.id.replied_message);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button clicked");
        String message = txtMessage.getText().toString();
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(SecondActivity.RECEIVED_MESSAGE,message);
        startActivityForResult(intent,REPLY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==REPLY_CODE && resultCode == RESULT_OK){
            String reply = data.getStringExtra(REPLY_MESSAGE);
            txtRepliedMessage.setText(reply);
        }
    }
}
