package com.example.calaenderdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    Toolbar toolbar;
    public Spinner spinner;
    TextView month_name;
    String Ismonth ="April";
    String item,Date;
    ArrayList<Integer> dates = new ArrayList<>(100);

    FloatingActionButton floatingActionButton;
    MyRecyclerViewAdapter adapters;
    ImageView imageView;
    private DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ham);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        spinner = findViewById(R.id.spinner);
        floatingActionButton=findViewById(R.id.submit);
        month_name=findViewById(R.id.month_name);
        ButtonCLick();


        List<String> months= new ArrayList<>();
        months.add(0,"September");
        months.add("January");
        months.add("February ");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("Aug");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        ArrayAdapter<String> adapter;
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,months);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (parent.getItemAtPosition(position).equals("ChooseCategory")){
                }else{
                    item =parent.getItemAtPosition(position).toString();
                    Ismonth =item;

                    month_name.setText(item);
                    Log.i("Month",month_name.toString());
                    Log.d("MonthValue", Ismonth);


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayList<Integer> dates = new ArrayList<>(100);
        for (int i=1;i<=31;i++) {
            dates.add(i);
          }
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapters = new MyRecyclerViewAdapter(this, dates, Ismonth);
        adapters.setClickListener((MyRecyclerViewAdapter.ItemClickListener) this);
        recyclerView.setAdapter(adapters);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private void ButtonCLick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item= month_name.getText().toString();
                Intent intent= new Intent(MainActivity.this ,FabActivity.class);
                intent.putExtra("Months",item);
                startActivity(intent);
            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_LONG).show();
            return true;
        } else if(id == R.id.setting) {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG).show();
            return true;
        } else if(id == R.id.about) {
            Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapters.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
/*
        Date=adapters.getItem(position);
        Log.d("Value",item);
        Log.d("Date",adapters.getItem(position));*/
    }

}
