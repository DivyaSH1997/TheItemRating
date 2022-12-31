package com.example.itemrating;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    ImageView imageDisplay;
    Button btnBack;
    int imageid;
    TextView itemname;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        imageDisplay=findViewById(R.id.imageDisplay);
        itemname=findViewById(R.id.txtItemName);
        btnBack=findViewById(R.id.btnBack);


        Intent forward = getIntent();
        Bundle bundle = forward.getExtras();
        imageid= bundle.getInt("id");
        imageDisplay.setImageResource(imageid);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Like:makeToast("Liked");
                 break;
            case R.id.Dislike:makeToast("Disliked");
                 break;
            case R.id.Okay:makeToast("Okay");
                 break;
            case R.id.None:makeToast("None of the Above");
                 break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void makeToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

    }
}
