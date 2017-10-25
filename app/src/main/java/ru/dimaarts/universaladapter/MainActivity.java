package ru.dimaarts.universaladapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ru.dimaarts.universaladapter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(this);
    }

    public void onSimpleClick(View view) {
        Intent intent = new Intent(this, SimpleListExampleActivity.class);
        startActivity(intent);
    }

    public void onExpandableClick(View view) {
        Intent intent = new Intent(this, ExpandableListExampleActivity.class);
        startActivity(intent);
    }
}
