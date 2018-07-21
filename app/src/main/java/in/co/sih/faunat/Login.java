package in.co.sih.faunat;

import android.app.ProgressDialog;
import android.content.Intent;
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
import in.co.sih.faunat.Common.Common;
import in.co.sih.faunat.Model.User;

public class Login extends AppCompatActivity {

    EditText phone,password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        phone=(EditText)findViewById(R.id.phonenumber);
        password=(EditText)findViewById(R.id.password);
        Login=(Button)findViewById(R.id.login);

        //init firebase

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Login.this);
                mDialog.setMessage("LOADING..");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(phone.getText().toString()).exists())
                        {

                            mDialog.dismiss();


                            User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
                            user.setPhone(phone.getText().toString());
                            if(user.getPassword().equals(password.getText().toString()))
                            {
                            Toast.makeText(Login.this, "LOGIN SUCCESSFULL", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(Login.this,Home.class);
                                //Common.currentUser=user;
                                startActivity(intent);
                                finish();

                            }
                            else
                            {
                            Toast.makeText(Login.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText(Login.this, "USER DOES NOT EXIST", Toast.LENGTH_SHORT).show();
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
