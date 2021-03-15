package com.example.iwash.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.transition.Scene;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.iwash.R;
import com.example.iwash.adapter.VehiclesAdapter;
import com.example.iwash.model.Vehicles;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private int state;
    private final String VALUE_KEY = "HomeData";
    ImageView imgButton;
    ImageView imgNews;
    AutoCompleteTextView loaiXe, mauXe, hangXe;
    EditText editBienSo;
    Button btnAdd, btnCancel;
    RecyclerView rcListVehicles;
    VehiclesAdapter adapter;
    ArrayList<Vehicles> arrayList = new ArrayList<>();
    Vehicles vehicles;
    ViewGroup sceneRoot;
    Scene aScene;
    Scene anotherScene;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            state = savedInstanceState.getInt(VALUE_KEY);
            // Do something with value if needed
        }
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rcListVehicles = view.findViewById(R.id.rcListVehicles);
        sceneRoot = (ViewGroup) view.findViewById(R.id.scene_root);
        setAnimation();

        imgNews = view.findViewById(R.id.imgNews);
        Glide.with(this).load("https://24hthongtin.com/img_data/images/garage-bao-duong-sua-chua-o-to-tai-tphcm.jpg").into(imgNews);

        adapter = new VehiclesAdapter(getContext(), arrayList);
        adapter.notifyDataSetChanged();
        rcListVehicles.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,true));
        rcListVehicles.setAdapter(adapter);
        imgButton = view.findViewById(R.id.img_add_vehicle);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                AlertDialog dialog = builder.create();
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_add_vehicle,null);
                loaiXe = view1.findViewById(R.id.id_LoaiXe);
                mauXe = view1.findViewById(R.id.id_MauXe);
                hangXe = view1.findViewById(R.id.id_HangXe);
                editBienSo = view1.findViewById(R.id.id_BienSo);
                btnAdd = view1.findViewById(R.id.btnAdd);
                btnCancel = view1.findViewById(R.id.btnCancel);
                setUpSpin(loaixe,loaiXe);
                setUpSpin(mauxe, mauXe);
                setUpSpin(hang,hangXe);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vehicles = new Vehicles(loaiXe.getText().toString(),mauXe.getText().toString(), hangXe.getText().toString(),editBienSo.getText().toString());
                        arrayList.add(vehicles);
                        dialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.setView(view1);
                dialog.show();
            }
        });
        return view;
    }
    String[] loaixe = {"Small","Medium","Large","X-Large"};
    String[] mauxe  = {"Red","White","Blue"};
    String[] hang = {"aaaa","ddddđ","ddddđ"};
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(VALUE_KEY, state);
        super.onSaveInstanceState(outState);
    }
    public void setUpSpin(String[] data, AutoCompleteTextView textView){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);
        textView.setAdapter(adapter);
    }

    @SuppressLint("NewApi")
    public void setAnimation(){
        aScene = Scene.getSceneForLayout(sceneRoot, R.layout.a_scene, getContext());
        anotherScene = Scene.getSceneForLayout(sceneRoot, R.layout.activity_car_wash_sevice, getContext());
    }
    
}