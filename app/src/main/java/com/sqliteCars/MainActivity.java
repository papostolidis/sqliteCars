package com.sqliteCars;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataSource data;
    ListView list;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new DataSource(MainActivity.this);

        list = findViewById(R.id.list);

        Button btn = findViewById(R.id.btn_activity);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewCarActivity.class);
                startActivity(intent);
            }
        });



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtVw_brand = view.findViewById(R.id.txtVw_brand);
                String brand = txtVw_brand.getText().toString();
                Log.d("myLog", brand);
            }
        });

        data.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        data.open();
        ArrayList<Car> cars =  data.getCarsFromDB();

        CarAdapter myAdapter = new CarAdapter(MainActivity.this, cars);

        list.setAdapter(myAdapter);
    }
}
