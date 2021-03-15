package com.example.iwash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.iwash.activity.CarWashSeviceActivity;
import com.example.iwash.activity.MaintenanceSeviceActivity;
import com.example.iwash.activity.MotorcycleWashSeviceActivity;
import com.example.iwash.activity.OilSeviceActivity;
import com.example.iwash.fragment.AccountFragment;
import com.example.iwash.fragment.HomeFragment;
import com.example.iwash.fragment.MoreFunctionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fragmentManager = getSupportFragmentManager();
        HomeFragment homeFragment = HomeFragment.newInstance();
        AccountFragment accountFragment = AccountFragment.newInstance();
        MoreFunctionFragment moreFunctionFragment = MoreFunctionFragment.newInstance();
        setCurrentFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        setCurrentFragment(homeFragment);
                        return true;
                    case R.id.account:
                        setCurrentFragment(accountFragment);
                        return true;
                    case R.id.more:
                        setCurrentFragment(moreFunctionFragment);
                        return true;
                }

                return false;
            }

        });

    }

    private void setCurrentFragment(Fragment fragment) {
        fragmentManager.beginTransaction().replace(R.id.flFragment, fragment).commit();
    }

    public void ditail(View view) {
        startActivity(new Intent(this, UserDitailActivity.class));
    }

    public void notification(View view) {
        startActivity(new Intent(this, NotificationActivity.class));
    }

    public void historyUsed(View view) {
        startActivity(new Intent(this, HistoryUsedActivity.class));
    }

    public void feedback(View view) {
        startActivity(new Intent(this, FeedbackActivity.class));
    }

    public void logout(View view) {

    }

    public void CarWash(View view) {
        startActivity(new Intent(getApplicationContext(), CarWashSeviceActivity.class));
    }

    public void MotorcycleWash(View view) {
        startActivity(new Intent(getApplicationContext(), MotorcycleWashSeviceActivity.class));
    }

    public void OilService(View view) {
        startActivity(new Intent(getApplicationContext(), OilSeviceActivity.class));
    }

    public void Maintenance(View view) {
        startActivity(new Intent(getApplicationContext(), MaintenanceSeviceActivity.class));
    }
}