package com.sqliteCars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewCarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_car);

        final DataSource data = new DataSource(NewCarActivity.this);

        final EditText edTxt_brand = findViewById(R.id.edTxt_brand);
        final EditText edTxt_model = findViewById(R.id.edTxt_model);
        final EditText edTxt_color = findViewById(R.id.edTxt_color);

        Button btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String brand = edTxt_brand.getText().toString();
                String model = edTxt_model.getText().toString();
                String color = edTxt_color.getText().toString();

                data.open();
                data.insertCar(brand, model, color);
                data.close();
            }
        });
    }
}
