package com.example.mywork_zty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private MyService2.Mybinder mybinder;

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("life","activity2 is onPostResume....");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("life","activity2 is onDestroy....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("life","activity2 is onStop....");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("life","activity2 is onStart....");

    }

    @Override
    public void finish() {
        super.finish();
        Log.d("life","activity2 is finish....");
    }

    @Override
    public void finishActivity(int requestCode) {
        super.finishActivity(requestCode);
        Log.d("life","activity2 is finishactivity....");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==31){
            String state=data.getStringExtra("state");
            Log.d("life",state);
        }
        if(resultCode==32){
            String state=data.getStringExtra("state");
            Log.d("life",state);
        }

    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("life","activity2 is onRestart....");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("life","activity2 is onCreate....");
        Button button2=findViewById(R.id.button2);
        Button button1=findViewById(R.id.button1);
        Button button3=findViewById(R.id.button3);
        Button button4=findViewById(R.id.button4);
        Button button5=findViewById(R.id.button5);
        Button button6=findViewById(R.id.button6);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main2=new Intent(MainActivity2.this,MainActivity3.class);
                main2.putExtra("name","zty");
                main2.putExtra("age","20");
                Toast.makeText(getApplicationContext(),"????????????",Toast.LENGTH_LONG).show();
                startActivityForResult(main2,1);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main3=new Intent(MainActivity2.this,MyService1.class);
                startService(main3);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main4=new Intent(MainActivity2.this,MyService1.class);
                stopService(main4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceConnection connection=new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyService2.Mybinder mybinder= (MyService2.Mybinder) service;
                        mybinder.play();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        mybinder = null;
                    }
                };
                Intent main5=new Intent(MainActivity2.this,MyService2.class);
                bindService(main5,connection, Context.BIND_AUTO_CREATE);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceConnection connection=new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        MyService2.Mybinder mybinder= (MyService2.Mybinder) service;
                        mybinder.stop();
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        mybinder = null;
                    }
                };
                Intent main6=new Intent(MainActivity2.this,MyService2.class);
                bindService(main6,connection, Context.BIND_AUTO_CREATE);
            }
        });




    }


}