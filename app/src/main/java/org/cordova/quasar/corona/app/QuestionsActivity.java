package org.cordova.quasar.corona.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class QuestionsActivity extends AppCompatActivity {
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int QuestionsActivityLayout = R.layout.activity_questions;
        setContentView(QuestionsActivityLayout);

        setupNavigationView(R.id.questions);
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
                            String classroomUrl = "https://classroom.google.com/a/estudante.se.df.gov.br";
                            Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", classroomUrl);
                            startActivity(activityWithUrlIntent);
                            return true;
                        }
                        case wikipediaId: {
                            String wikipediaUrl = "https://pt.wikipedia.org/";
                            Intent activityWithUrlIntent = webviewActivityIntent.putExtra("url", wikipediaUrl);
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
        navigationView.getMenu().getItem(2).setChecked(true);
    }
}