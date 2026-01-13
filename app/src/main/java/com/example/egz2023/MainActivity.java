package com.example.egz2023;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> rzeczyDoZrobienia;
    private ArrayAdapter<String> arraryAdapter;
    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);

        rzeczyDoZrobienia = new ArrayList<>();
        rzeczyDoZrobienia.add("Wyjście do kina");
        rzeczyDoZrobienia.add("Nauczyc sie robienia list w mobile");
        rzeczyDoZrobienia.add("Pomyslec cieplo o projekcie");

        arraryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
        rzeczyDoZrobienia);

        listView.setAdapter(arraryAdapter);
        // dostateczny dziala list view
        // dopuszczajacy list view xml

        // dobra, dodanie elementu do listy
        // bardzo dobry klikanie element listy i cos sie dzieje z nim np zniknac przekreslic

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String rzeczyDozrobienia = editText.getText().toString();
                        rzeczyDoZrobienia.add(rzeczyDozrobienia);
                        arraryAdapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        view.setBackgroundColor(Color.GRAY);
                        TextView textView = (TextView) view;
                        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                    }
                }
        );
    }
}