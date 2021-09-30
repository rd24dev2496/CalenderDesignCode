package com.example.calaenderdesign;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FabActivity extends AppCompatActivity {

    Intent intent;
    EditText usernameEditText;
    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab);
        TextView  tv_month_name=findViewById(R.id.tv_month_name);
         submit_btn =findViewById(R.id.submit_btn);
         usernameEditText =findViewById(R.id.et_task);

        String monthname= getIntent().getStringExtra("Months");
        tv_month_name.setText(monthname);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FabActivity.this ,MainActivity.class);
                startActivity(intent);
                Toast.makeText(FabActivity.this,"Submitted", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
