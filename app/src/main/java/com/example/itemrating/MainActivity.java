package com.example.itemrating;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView foodlist;
    Resources resources;
    String fooditems[];
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        listAdapter();
        initListeners();
    }

        public void initViews() {
            foodlist = findViewById(R.id.foodlist);
        }
        public void listAdapter()
        {
            resources=getResources();
            fooditems=resources.getStringArray(R.array.fooditems);
            adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,fooditems);
            foodlist.setAdapter(adapter);

        }
        public void initListeners()
        {
            foodlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    switch (position)
                    {
                        case 0: intent.putExtra("id", R.drawable.chocolate);
                            makeToast("Chocolates");
                            break;
                        case 1: intent.putExtra("id", R.drawable.cake);
                            makeToast("Cake");
                            break;
                        case 2: intent.putExtra("id", R.drawable.icecream);
                            makeToast("Icecream");
                            break;
                        case 3: intent.putExtra("id", R.drawable.cookies);
                            makeToast("Cookies");
                            break;
                    }
                    startActivityForResult(intent, 1);
                }
            });

        }

    public void makeToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();

    }
}
