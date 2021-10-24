package com.example.mywork_zty;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService1 extends Service {
    private MediaPlayer mediaPlayer;
    private int[] musics={
      R.raw.music1,R.raw.music1,R.raw.music1
    };
    public MyService1() {
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service","service is onstartcommand....");
        mediaPlayer=MediaPlayer.create(getApplicationContext(),musics[1]);           //三种创建对象方法，new，get，create
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
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
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}