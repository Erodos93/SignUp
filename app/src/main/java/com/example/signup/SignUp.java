package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.parse.ParseException;

import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    private EditText name, punch_speed, punch_power, kick_power, kick_speed;
    private Button Enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        punch_speed = (EditText) findViewById(R.id.punchSpeed);
        punch_power = (EditText) findViewById(R.id.punch_power);
        kick_power= (EditText) findViewById(R.id.kickPower);
        kick_speed = (EditText) findViewById(R.id.kickSpeed);
        name = (EditText) findViewById(R.id.name);
        Enter = (Button) findViewById(R.id.Enter);
        Enter.setOnClickListener(SignUp.this);

    }


    @Override
    public void onClick(View v) {
        ParseObject kickboxer = new ParseObject("KickBoxer");
        kickboxer.put("Name",name.getText().toString() );
        kickboxer.put("punch_speed", Integer.parseInt(punch_speed.getText().toString()));
        kickboxer.put("punch_power", Integer.parseInt(punch_power.getText().toString()));
        kickboxer.put("power_kick", Integer.parseInt(kick_power.getText().toString()));
        kickboxer.put("kick_speed", Integer.parseInt(kick_speed.getText().toString()));

        try {
            kickboxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(SignUp.this, "Sucessfull", Toast.LENGTH_SHORT,FancyToast.SUCCESS,true).show();
                    }else{
                        FancyToast.makeText(SignUp.this, "False "+ e.getMessage(), Toast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                    }

                }
            });
        }catch (Exception x){
            FancyToast.makeText(SignUp.this, "False "+ x.getMessage(), Toast.LENGTH_SHORT,FancyToast.ERROR,false).show();

        }

    }
}
