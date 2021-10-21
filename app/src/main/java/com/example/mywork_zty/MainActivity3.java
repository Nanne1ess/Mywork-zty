package com.example.mywork_zty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("life","activity3 is onPostResume....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","activity3 is onDestroy....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","activity3 is onStop....");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","activity3 is onStart....");

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("life","activity3 is onRestart....");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("life","activity3 is onCreate....");

        Intent intent1=new Intent();
        intent1.putExtra("state","我今天想跑步");
        setResult(31,intent1);

        Intent intent2=new Intent();
        intent2.putExtra("state","我今天想睡觉");
        setResult(32,intent2);
    }
}