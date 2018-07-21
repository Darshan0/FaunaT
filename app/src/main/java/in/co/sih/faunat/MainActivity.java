package in.co.sih.faunat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.onesignal.OneSignal;

public class MainActivity extends AppCompatActivity {

    Button btnsignin,btnsignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // OneSignal Initialization
        //OneSignal.startInit(this)
          //      .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            //    .unsubscribeWhenNotificationsAreDisabled(true)
              //  .init();


        btnsignin=(Button)findViewById(R.id.signin);
        btnsignup=(Button)findViewById(R.id.signup);


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,Login.class));
            }
        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,register.class));
            }
        });



    }
}
