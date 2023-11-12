package com.example.contador;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ApuntarMisRecords extends AppCompatActivity {//implements View.OnClickListener, AdapterView.OnItemClickListener{

    private Button mbAñadir;
    private ListView mListV;
    private EditText mEditT;
    private TextView vT;
    private List<String> mLista = new ArrayList<>();
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewtest);


        mbAñadir = findViewById(R.id.btnAgregar);
        //mbAñadir.setOnClickListener(this);
        mListV = findViewById(R.id.ranking);
        //mListV.setOnClickListener(this);
        mEditT = findViewById(R.id.etLista);
    }


    public void onClick(View view) {

        if (view.getId() == R.id.btnAgregar) {
            String text = mEditT.getText().toString().trim();
            mLista.add(text);
            mEditT.getText().clear();
            mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mLista);
            mListV.setAdapter(mAdapter);
        }
    }
    public void Volver (View v){
        finish();
    }

//    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//        Toast.makeText(this, "Item Clicked " +position, Toast.LENGTH_SHORT).show();
//
//    }
}
