package ru.gb.androidstart.opencalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private MaterialButton openCalcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openCalcButton = findViewById(R.id.open_calc_button);
        openCalcButton.setOnClickListener(v -> openCalc());
    }

    public void openCalc() {
        Uri uri = Uri.parse("expression://intent");
        Intent openCalcIntent = new Intent(Intent.ACTION_VIEW, uri);
        ActivityInfo activityInfo = openCalcIntent.resolveActivityInfo(getPackageManager(), 0);
        if (activityInfo != null) {
            startActivity(openCalcIntent);
        }
    }
}