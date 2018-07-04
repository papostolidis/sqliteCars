package com.sqliteCars;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {

    Context context;
    ArrayList<Car> cars;

    public CarAdapter(Context context, ArrayList<Car> cars){
        this.context = context;
        this.cars = cars;
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cars.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView txtVw_name = convertView.findViewById(R.id.txtVw_brand);
        TextView txtVw_email = convertView.findViewById(R.id.txtVw_model);
        TextView txtVw_phone = convertView.findViewById(R.id.txtVw_color);

        Car car_pos = cars.get(position);

        Log.d("carAdapter", car_pos.getColor());

        txtVw_name.setText(car_pos.getBrand());
        txtVw_email.setText(car_pos.getModel());
        txtVw_phone.setText(car_pos.getColor());

        return convertView;
    }
}
