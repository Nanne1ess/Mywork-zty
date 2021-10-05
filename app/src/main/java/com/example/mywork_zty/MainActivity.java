package com.example.mywork_zty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Fragment wechatfragment=new WechatFragment();
    private Fragment wechatFragment1=new WechatFragment1();
    private Fragment wechatFragment2=new WechatFragment2();
    private Fragment wechatFragment3=new WechatFragment3();
    private FragmentManager fragmentManager;
    private LinearLayout linerlayout,linerlayout1,linerlayout2,linearlayout3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linerlayout=findViewById(R.id.LinearLayout);
        linerlayout1=findViewById(R.id.LinearLayout1);
        linerlayout2=findViewById(R.id.LinearLayout2);
        linearlayout3=findViewById(R.id.LinearLayout3);
        linerlayout.setOnClickListener(this);
        linerlayout1.setOnClickListener(this);
        linerlayout2.setOnClickListener(this);
        linearlayout3.setOnClickListener(this);
        newFragment();

    }

    private void newFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content,wechatfragment);
        fragmentTransaction.add(R.id.id_content,wechatFragment1);
        fragmentTransaction.add(R.id.id_content,wechatFragment2);
        fragmentTransaction.add(R.id.id_content,wechatFragment3);
        fragmentTransaction.commit();
        hideFragment(fragmentTransaction);
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        fragmentTransaction.hide(wechatfragment);
        fragmentTransaction.hide(wechatFragment1);
        fragmentTransaction.hide(wechatFragment2);
        fragmentTransaction.hide(wechatFragment3);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.LinearLayout:
                showfragment(0);
                break;
            case R.id.LinearLayout1:
                showfragment(1);
                break;
            case R.id.LinearLayout2:
                showfragment(2);
                break;
            case R.id.LinearLayout3:
                showfragment(3);
                break;
            default:
                break;
        }
    }
    private void showfragment(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                transaction.show(wechatfragment);
                break;
            case 1:
                transaction.show(wechatFragment1);
                break;
            case 2:
                transaction.show(wechatFragment2);
                break;
            case 3:
                transaction.show(wechatFragment3);
                break;
            default:
                break;
        }
        transaction.commit();
    }
}