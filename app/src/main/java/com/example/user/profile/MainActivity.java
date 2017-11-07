package com.example.user.profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String UPDATE_NAME="com.example.user.Profile.userName";
    public static final String UPDATE_EMAIL="com.example.user.Profile.email";
    public static final int REQUEST_PROFILE_UPDATE = 1;
    private TextView textViewName,textViewEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName=(TextView)findViewById(R.id.userName);
        textViewEmail=(TextView)findViewById(R.id.email);
    }


    public void UpdateProfile(View view){
        Intent intent=new Intent(this,Update.class);
        startActivityForResult(intent,REQUEST_PROFILE_UPDATE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Request Code is a unique code to identify an intent
        //Result Code is a result of an intent call
        //data is the actual data returned in an intent
        if(resultCode== REQUEST_PROFILE_UPDATE){
            String name, email;
            name=data.getStringExtra(UPDATE_NAME);
            email=data.getStringExtra(UPDATE_EMAIL);
            textViewName.setText(getString(R.string.userName)+" "+name);
            textViewEmail.setText(getString(R.string.email)+" "+email);
        }
    }
    public  void visitTaruc(View view){
        String uri="http://www.tarc.edu.my";
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }
    public void showMain(View view){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        startActivity(intent);
    }
    public void showDial(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +"0123456789"));
        startActivity(intent);
    }
    public void showSend(View view){
        Intent intent= new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:"+"seekt@tarc.edu.my"));
        startActivity(intent);
    }
}
