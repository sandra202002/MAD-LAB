package com.example.adapterview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l;
    ImageView x;
    String[] fruits = {"apple", "orange", "banana", "grape"};
    int images[] = {R.drawable.img, R.drawable.img_1, R.drawable.img_2, R.drawable.img_3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        l = (ListView) findViewById(R.id.list);
        x = (ImageView) findViewById(R.id.im);

        // Create an ArrayAdapter for the list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, fruits);
        l.setAdapter(adapter);
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView temp = (TextView) view;

        // Display the corresponding image when an item is clicked
        x.setImageResource(images[i]);

        // Show a Toast message with the selected item name and its index
        Toast.makeText(this, temp.getText() + " " + i, Toast.LENGTH_LONG).show();
    }
}
