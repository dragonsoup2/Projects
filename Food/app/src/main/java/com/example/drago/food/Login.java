package com.example.drago.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity
{
    MyDb md = new MyDb(this, null, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = (Button) findViewById(R.id.li);
        Button register = (Button) findViewById(R.id.rg);
        Button forgot = (Button) findViewById(R.id.fg);

        //id = dragon
        //pw = qwerty

        login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText userName = (EditText) findViewById(R.id.un);
                EditText passWord = (EditText) findViewById(R.id.pw);
             /*   ArrayList<String> info = md.findUser(userName.getText().toString());
                if(info == null)
                {
                    Toast.makeText(Login.this, "Such user doesn't exist", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (!passWord.getText().toString().equals(info.get(3)))
                    {
                        Toast.makeText(Login.this, "Wrong password!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(Login.this, "Successfully logged in", Toast.LENGTH_LONG).show();*/
                        Intent tomenu = new Intent(Login.this, listMenu.class);
                        startActivity(tomenu);
                    //}
                //}
            }
        });

        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent toregi = new Intent(Login.this, Register.class);
                startActivity(toregi);
            }
        });
    }
}
