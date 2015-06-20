package in.motorindiaonline.motorindia.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import in.motorindiaonline.motorindia.R;
import in.motorindiaonline.motorindia.Utilities.CommonData;
import in.motorindiaonline.motorindia.Utilities.MotorIndiaPreferences;


public class SplashScreen extends ActionBarActivity {

    public static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Hide the ActionBar
        getSupportActionBar().hide();

        // UNCOMMENT The following to customize ActionBar
        //getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getSupportActionBar().setCustomView(R.layout.actionbar_layout);
        //getSupportActionBar().setIcon(R.drawable.icon_tentative);

        SharedPreferences prefs = getSharedPreferences(MotorIndiaPreferences.GENERAL_DATA, MODE_PRIVATE);
        final Boolean GCMRegistered = prefs.getBoolean(MotorIndiaPreferences.GCM_REGISTRATION_STATUS, false);

        // wait for SPLASH_SCREEN_DELAY milliseconds then launch the intent depending on registration status
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(GCMRegistered){
                    Log.i(TAG, "GCM is registered, going to HOME activity");
                    Intent myIntent = new Intent(SplashScreen.this, ArticleList.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    SplashScreen.this.startActivity(myIntent);
                }
                else{
                    Log.i(TAG, "GCM is not registered, going to take this guy to get registered");
                    Intent myIntent = new Intent(SplashScreen.this, GCMData.class);
                    myIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    SplashScreen.this.startActivity(myIntent);
                }
            }
        }, CommonData.SPLASH_SCREEN_DELAY);
    }
}
