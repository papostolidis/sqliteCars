package com.sqliteCars;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DataSource {

    private SQLiteDatabase database;
    private SQLliteHelper dbHelper;
    private String[] tableColumns = {SQLliteHelper.COLUMN_BRAND, SQLliteHelper.COLUMN_MODEL, SQLliteHelper.COLUMN_COLOR};

    DataSource(Context context){
        dbHelper = new SQLliteHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertCar(String brand, String model, String color){
        String sql = "INSERT INTO cars (brand, model, color) VALUES ('"+brand+"', '"+model+"', '"+color+"')";
        Log.d("mysqls", sql);
        database.execSQL(sql);

    }


    public ArrayList<Car> getCarsFromDB(){

        ArrayList<Car> cars = new ArrayList<>();

        Cursor cursor = database.query("cars", tableColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            cars.add(cursorToCar(cursor));
            cursor.moveToNext();
        }
        return cars;
    }

    private Car cursorToCar(Cursor cursor) {
        Car car = new Car();
        car.setBrand(cursor.getString(0));
        car.setModel(cursor.getString(1));
        car.setColor(cursor.getString(2));
        return car;
    }
}
