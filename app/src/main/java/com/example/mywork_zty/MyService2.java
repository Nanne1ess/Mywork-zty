package com.example.mywork_zty;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    private MediaPlayer mediaPlayer;
    private int[] musics={
            R.raw.music1,R.raw.music1,R.raw.music1
    };

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent){
        return new Mybinder();
    }

    protected class Mybinder extends Binder {
        public void play(){
            Log.d("service","service is play....");
            mediaPlayer=MediaPlayer.create(getApplicationContext(),musics[1]);           //三种创建对象方法，new，get，create
            mediaPlayer.start();
        }
        public void stop(){
            mediaPlayer.stop();
        }
    }

    @Override
    public void onDestroy() {
        Log.d("service","service is ondestroy....");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public void onCreate() {
        Log.d("service","service is oncreat....");
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","service is onstartcommand....");
        return super.onStartCommand(intent, flags, startId);
    }


}