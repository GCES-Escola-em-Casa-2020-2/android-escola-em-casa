package org.cordova.quasar.corona.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static org.cordova.quasar.corona.app.Constants.*;
import static org.cordova.quasar.corona.app.Constants.ESCOLA_EM_CASA;
import static org.cordova.quasar.corona.app.Constants.WIKIPEDIA_PT;
import static org.cordova.quasar.corona.app.UrlsEnum.*;

public class AboutActivity extends AppCompatActivity {
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int AboutActivityLayout = R.layout.activity_about;
        setContentView(AboutActivityLayout);

        setupNavigationView(R.id.about);
    }

    public void myOnClick(View view) {
        String link = view.getResources().getResourceEntryName(view.getId());

        switch (link) {
            case "escola_em_casa_btn":
                startActivity(new Intent(getApplicationContext(), WebviewActivity.class)
                        .putExtra("url", ESCOLA_EM_CASA));
                overridePendingTransition(0, 0);
                break;
            case "como_acessar_btn":
                startActivity(new Intent(getApplicationContext(), WebviewActivity.class)
                        .putExtra("url", COMO_ACESSAR));
                overridePendingTransition(0, 0);
                break;
            case "secretaria_site_btn":
                startActivity(new Intent(getApplicationContext(), WebviewActivity.class)
                        .putExtra("url", SECRETARIA_SITE.getUrl()));
                overridePendingTransition(0, 0);
                break;
        }

    }

    private void setupNavigationView(int viewId) {
        int navigationId = R.id.navigation;
        BottomNavigationView navigationView = findViewById(navigationId);

        navigationView.setSelectedItemId(viewId);

        navigationView.setOnNavigationItemSelectedListener(
                item -> {
                    final int wikipediaId = R.id.wikipedia;
                    final int questionsId = R.id.questions;
                    final int classroomId = R.id.classroom;
                    final int aboutId = R.id.about;

                    int selectedItemId = item.getItemId();

                    Context applicationContext = getApplicationContext();

                    Intent webviewActivityIntent = new Intent(applicationContext, WebviewActivity.class);

                    overridePendingTransition(0, 0);
                    switch (selectedItemId) {
                        case classroomId: {
                            Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", CLASS_ROOM_ESTUDANTE);
                            startActivity(activityWithUrlIntent);
                            return true;
                        }
                        case wikipediaId: {
                            Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", WIKIPEDIA_PT);
                            startActivity(activityWithUrlIntent);
                            return true;
                        }
                        case questionsId: {
                            Intent questionsActivityIntent = new Intent(applicationContext, QuestionsActivity.class);
                            startActivity(questionsActivityIntent);
                            return true;
                        }
                        case aboutId: {
                            Intent aboutActivityIntent = new Intent(applicationContext, AboutActivity.class);
                            startActivity(aboutActivityIntent);
                            return true;
                        }
                    }
                    navigationView.getMenu().getItem(selectedItemId).setChecked(true);
                    return false;
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        BottomNavigationView navigationView = findViewById(R.id.navigation);
        navigationView.getMenu().getItem(3).setChecked(true);
    }
}