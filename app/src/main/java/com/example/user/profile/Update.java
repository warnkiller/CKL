package com.example.user.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Update extends AppCompatActivity {

    private EditText    editTextName,editTextEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editTextName=(EditText)findViewById(R.id.nameUpdate);
        editTextEmail=(EditText)findViewById(R.id.emailUpdate);
    }

    public void saveProfile(View view){
        Intent intent = getIntent();

        String name, email;
        name=editTextName.getText().toString();
        email=editTextEmail.getText().toString();

        intent.putExtra(MainActivity.UPDATE_NAME,name);
        intent.putExtra(MainActivity.UPDATE_EMAIL,email);

        setResult(MainActivity.REQUEST_PROFILE_UPDATE,intent);

        finish();

    }
}
