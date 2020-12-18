package com.yu.dersproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView= (TextView) findViewById(R.id.textView);
        Bundle gelenVeri=getIntent().getExtras();
        CharSequence gelenVeriCharSequence=gelenVeri.getCharSequence("anahtar");
        textView.setText(gelenVeriCharSequence);

    }
}