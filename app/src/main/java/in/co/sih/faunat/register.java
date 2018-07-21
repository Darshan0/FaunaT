package in.co.sih.faunat;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import in.co.sih.faunat.Model.User;

public class register extends AppCompatActivity {


    Button register;

    EditText phnnumber,name,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register=(Button)findViewById(R.id.newregister);
        phnnumber=(EditText)findViewById(R.id.registerphonenumber);
        name=(EditText)findViewById(R.id.registerusername);
        pass=(EditText)findViewById(R.id.registerpassword);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user =database.getReference("User");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(register.this);
                mDialog.setMessage("LOADING..");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(phnnumber.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(register.this,"USER ALREADY EXITS",Toast.LENGTH_LONG).show();
                        }
                        else {
                            mDialog.dismiss();
                            User user= new User(name.getText().toString(),pass.getText().toString());
                            table_user.child(phnnumber.getText().toString()).setValue(user);
                            Toast.makeText(register.this,"REGISTERED",Toast.LENGTH_LONG).show();
                            finish();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });


    }
}
