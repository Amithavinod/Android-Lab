package com.example.gridviewpopup;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    int[] images={
            R.drawable.apple,
            R.drawable.banana,
            R.drawable.orange,
    };
    String[] names ={
            "Apple",
            "Banana",
            "Orange",
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridView);
        gridView.setAdapter(new BaseAdapter() {
           @Override
           public int getCount() {
               return images.length;
           }

           @Override
           public Object getItem(int position) {
               return images[position];
           }

           @Override
           public long getItemId(int position) {
               return position;
           }

           @Override
           public View getView(int position, View convertView, ViewGroup parent) {
               ImageView imageview =new ImageView(MainActivity.this);
               imageview.setImageResource(images[position]);
               imageview.setLayoutParams(
                       new GridView.LayoutParams(300,300)
               );
               imageview.setScaleType(
                       ImageView.ScaleType.CENTER_CROP
               );
               return imageview;
           }
       });
       gridView.setOnItemClickListener(
               new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent,
                                        View view,
                                        int position,
                                         long id){
                   new AlertDialog.Builder(MainActivity.this)
                           .setTitle("selected image")
                           .setMessage("you selected " +names[position])
                           .setPositiveButton("ok",null)
                           .show();
        }
    });
    }
}
