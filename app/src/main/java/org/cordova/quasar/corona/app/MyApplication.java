package org.cordova.quasar.corona.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.datami.smi.SdState;
import com.datami.smi.SdStateChangeListener;
import com.datami.smi.SmiResult;
import com.datami.smi.SmiVpnSdk;
import com.datami.smi.internal.MessagingType;

import org.jetbrains.annotations.NotNull;

public class MyApplication extends Application implements SdStateChangeListener {
    private static final String TAG = MainActivity.class.getName();
    public static SdState sdState;

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        String mySdkKey = "SUBSTITUIR_POR_CHAVE_DATAMI"; //Use the SDK API access key given by Datami.
        SmiVpnSdk.initSponsoredData(mySdkKey, this, R.drawable.ic_launcher_background, MessagingType.NONE);
    }

    @Override
    public void onChange(@NotNull SmiResult currentSmiResult) {
        sdState = currentSmiResult.getSdState();
        Log.d(TAG, "sponsored data state : " + sdState);
        typeOfAccess(sdState, currentSmiResult);
    }

    private void typeOfAccess(SdState currentState, SmiResult currentSmiResult) {
        CharSequence text = "";
        if (currentState == SdState.SD_AVAILABLE) {
            text = "Seu acesso a esse site é gratuito.";
        } else if (currentState == SdState.SD_NOT_AVAILABLE) {
            text = "Seu acesso a esse site poderá acarretar cobranças em seu plano de dados.";
            Log.d(TAG, " - reason: " + currentSmiResult.getSdReason());
        } else if (currentState == SdState.WIFI) {
            // device is in wifi
            text = "Acesso via wifi.";
            Log.d(TAG, "wifi - reason: " + currentSmiResult.getSdReason());
        }
    }
}


