package org.cordova.quasar.corona.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String classroomUrl = "https://classroom.google.com/a/estudante.se.df.gov.br";

        Intent webviewActivityIntent = new Intent(getApplicationContext(), WebviewActivity.class);
        Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", classroomUrl);
        startActivity(activityWithUrlIntent);

        overridePendingTransition(0, 0);
    }
}