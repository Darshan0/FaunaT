package in.co.sih.faunat;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class FirActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring EditText
   // private EditText editTextEmail;
    //private EditText editTextSubject;
    //private EditText editTextMessage;

    //Send button
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fir);

        //Initializing the views
     //   editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        //editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        //editTextMessage = (EditText) findViewById(R.id.editTextMessage);

        Button buttonSend = findViewById(R.id.fucker);

        //Adding click listener
        buttonSend.setOnClickListener(this);
    }


    private void sendEmail() {
        //Getting content for email
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String email ="prometheus22345@gmail.com";
        String subject ="FIR REPORT DETAILS";
        String message ="http://faunat.ml/unkownpeople/unknown9.jpeg"+"\n"+"CLICK THE ABOVE LINK TO GET THE IMAGE OF THE INTRUDER"+"\n"+"DATE AND TIME : 31/04/2018 3:15pm"+"\n"+"LOCATION :COIMBATORE"+"\n"+"PURPOSE:INTRUTION";

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }

    @Override
    public void onClick(View v) {
        sendEmail();
    }
}
