package com.example.mywork_zty;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WechatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WechatFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private RecycleAdapterDome adapterDome;
    private Activity context;
    private List<String> list;

    public WechatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WechatFragment newInstance(String param1, String param2) {
        WechatFragment fragment = new WechatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        context = this.getActivity();
        recyclerView = view.findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        String[] label={"品牌：华为","品牌：苹果","品牌：小米"};
        String[] price={"价格：6888","价格：5999","价格：3999"};
        String[] config={"容量：128G","容量：256G","容量：512G"};
        int[] png={R.drawable.huawei,R.drawable.apple,R.drawable.xiaomi};
        List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
        for(int i=0;i< label.length;i++) {
            Map<String, Object> listitem = new HashMap<String, Object>();
            listitem.put("imageView",png[i]);
            listitem.put("name", label[i]);
            listitem.put("price", price[i]);
            listitem.put("configure", config[i]);
            data.add(listitem);
        }
        adapterDome = new RecycleAdapterDome(data, context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapterDome);
        return view;
    }

    // Inflate the layout for this fragment

    }
