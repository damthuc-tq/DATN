package com.example.iwash.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;

import com.example.iwash.R;

import java.util.ArrayList;

public class MoreFunctionFragment extends Fragment {
    String[] strings1 = {"Thiết lập ngôn ngữ", "Chính sách và bảo mật","Chia sẻ", "Đánh giá", "Hỗ trợ"};
    ListView listView;
    RadioButton btrVietnamese, btrEngland;

    public MoreFunctionFragment() {

    }
    public static MoreFunctionFragment newInstance() {
        MoreFunctionFragment fragment = new MoreFunctionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_function, container, false);
        listView = view.findViewById(R.id.lv_more);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, strings1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_select_languge_layout,null);
                        builder.setView(view1);
                        builder.create();
                        Dialog dialog = builder.create();
                        btrVietnamese = view1.findViewById(R.id.rdbtnVietnamese);
                        btrEngland = view1.findViewById(R.id.rdbtnEngland);
                        if (btrVietnamese.isChecked()){
                            dialog.dismiss();
                        }
                        if (btrEngland.isChecked()){
                            dialog.dismiss();
                        }
                        builder.show();
                        break;
                    case 2:
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareBody = "https://play.google.com/store/apps/details?id=dd.video.photomaker&hl=en&gl=US";
                        String shareSub = "https://play.google.com/store/apps/details?id=dd.video.photomaker&hl=en&gl=US";
                        intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(intent, "Share"));
                        break;
                    case 3:
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + getContext().getPackageName())));
                        } catch (android.content.ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
                        }
                        break;
                }
            }
        });
        return view;
    }
}