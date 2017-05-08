package tech.inception.validations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name_et , email_et , mobile_et , password_et ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_et = (EditText) findViewById(R.id.name_et);
        email_et =(EditText) findViewById(R.id.email_et);
        mobile_et = (EditText) findViewById(R.id.mobile_et);
        password_et = (EditText) findViewById(R.id.password_et);

    }

    public void check_data(View view) {

        String name = name_et.getText().toString();
        String email = email_et.getText().toString();
        String mobile = mobile_et.getText().toString();
        String password = password_et.getText().toString();


        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";

        if(name.length() < 4 || !name.matches("[a-zA-Z ]+"))
        {

            Toast.makeText(MainActivity.this, "name must be 4 character long and not contain any digits", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.contains("_"))
        {
            Toast.makeText(MainActivity.this , "please enter valid email type" , Toast.LENGTH_SHORT).show();
            return;
        }
        if(mobile.length() < 10)
        {
            Toast.makeText(MainActivity.this , "mobile must be 10 digit" , Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.matches(pattern) || password.length() < 8)
        {
            Toast.makeText(MainActivity.this, "password must contain atleast one alphabet , digit , special character and length must be 8 character", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(MainActivity.this , "all good" , Toast.LENGTH_SHORT).show();



    }
}
