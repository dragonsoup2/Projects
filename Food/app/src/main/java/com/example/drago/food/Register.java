package com.example.drago.food;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Register extends AppCompatActivity
{
    MyDb md = new MyDb(this, null, null, 1);

    EditText userName;
    EditText passWord;
    EditText reType;
    EditText firstName;
    EditText lastName;
    EditText email;
    EditText phone;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.ui);
        passWord = (EditText) findViewById(R.id.pw);
        reType = (EditText) findViewById(R.id.rt);
        firstName = (EditText) findViewById(R.id.fn);
        lastName = (EditText) findViewById(R.id.ln);
        email = (EditText) findViewById(R.id.em);
        phone = (EditText) findViewById(R.id.pn);
        Button register = (Button) findViewById(R.id.rg);

        register.setOnClickListener(new View.OnClickListener()
        {
            boolean valid = true;

            @Override
            public void onClick(View v)
            {
                if(userName.getText().toString().equals(""))
                {
                    userName.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                if(passWord.getText().toString().equals(""))
                {
                    passWord.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                if(reType.getText().toString().equals(""))
                {
                    reType.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                if(firstName.getText().toString().equals(""))
                {
                    firstName.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                if(lastName.getText().toString().equals(""))
                {
                    lastName.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                /*if(email.getText().toString().equals(""))
                {
                    email.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }
                if(phone.getText().toString().equals(""))
                {
                    phone.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }*/
                if (!passWord.getText().toString().equals(reType.getText().toString()))
                {
                    passWord.setHintTextColor(Color.parseColor("#FF0000"));
                    reType.setHintTextColor(Color.parseColor("#FF0000"));
                    valid = false;
                }

                if(valid)
                {
                    ArrayList<String> info = new ArrayList<String>();

                    info.add(userName.getText().toString());
                    info.add(passWord.getText().toString());
                    info.add(lastName.getText().toString());
                    info.add(firstName.getText().toString());
                    //info.add(phone.getText().toString());
                    //info.add(email.getText().toString());

                    if(md.addUser(info).equals("d"))
                    {
                        //Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_LONG).show();
                        Cursor check = md.findUser("d");
                        if(check == null) {
                            Toast.makeText(Register.this, "it is null and username is " + userName.getText().toString(), Toast.LENGTH_LONG).show();
                        }
                        else {
                            check.moveToFirst();
                            int id = check.getColumnIndex("userName");
                            Toast.makeText(Register.this, "username would be " + check.getString(id), Toast.LENGTH_LONG).show();
                        }
                        //Intent backLog = new Intent(Register.this, Login.class);
                        //startActivity(backLog);
                    }
                    else
                    {
                        Toast.makeText(Register.this, "There is a problem with registration", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(Register.this, "Invalid information. Please check again", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
