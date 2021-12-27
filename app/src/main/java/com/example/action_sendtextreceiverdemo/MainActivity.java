package com.example.action_sendtextreceiverdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.text);
        ImageView iv = findViewById(R.id.image);
        Intent intent = getIntent();
        if(intent.getAction().equals(Intent.ACTION_MAIN))
//직접실행
            tv.setText("StandAlone");
        else if(intent.getAction().equals(Intent.ACTION_SEND)) {
//다른액티비티가호출
            String type = intent.getType();
            if (type != null && type.equals("text/plain")) {
//문자열처리
                String str = intent.getStringExtra(Intent.EXTRA_TEXT);
                tv.setText(str);
            } else if (type != null && type.startsWith("image/")) {
//그림처리
                Uri uri = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (uri != null) {
                    tv.setText(uri.getPath());
                    iv.setImageURI(uri);
                }
            }
        }



    }
}