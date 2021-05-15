package org.cordova.quasar.corona.app;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import static org.cordova.quasar.corona.app.Constants.CLASS_ROOM_ESTUDANTE;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent webviewActivityIntent = new Intent(getApplicationContext(), WebviewActivity.class);
        Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", CLASS_ROOM_ESTUDANTE);
        startActivity(activityWithUrlIntent);

        overridePendingTransition(0, 0);
    }
}