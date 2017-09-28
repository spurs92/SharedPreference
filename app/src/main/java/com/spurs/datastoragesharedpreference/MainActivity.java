package com.spurs.datastoragesharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    EditText editAge;

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);

        text=(TextView)findViewById(R.id.text);
    }

    public void clickSave(View v){

        String name=editName.getText().toString();
        int age=Integer.parseInt(editAge.getText().toString());

        //data.xml 파일에 저장하기..
        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();

        editor.putString("Name",name);
        editor.putInt("Age",age);
        editor.commit();

    }

    public void clickLoad(View v){

        SharedPreferences pref=getSharedPreferences("data",MODE_PRIVATE);
        String name=pref.getString("Name","No Name");
        int age=pref.getInt("Age",0);

        text.setText("Name : "+name+"   Age : "+age);

    }
}
