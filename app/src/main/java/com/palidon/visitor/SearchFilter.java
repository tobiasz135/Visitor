package com.palidon.visitor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.palidon.visitor.Data.DataSearch;
import com.palidon.visitor.Data.data;
import com.palidon.visitor.MainActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchFilter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcity_layout);

        AutoCompleteTextView editText = findViewById(R.id.actv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data.miasta);
        editText.setAdapter(adapter);

        final Button button = findViewById(R.id.addcitybtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               //new DataSearch().AddCity(v);
                EditText editText = findViewById(R.id.actv);
                String wpisaneMiasto = editText.getText().toString();
                int i = 0;
                for (; i < data.miasta.length; i++){
                //    Log.w("Iter","" + data.miasta.length);
                //    Log.w("data.miasta","" + data.miasta[i]);
                    if (data.miasta[i].equals(wpisaneMiasto)){
                        Snackbar.make(v, "Miasto: " + data.miasta[i] + ", index: " + i, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        break;

                    }
                }
                Log.w("Input","" + wpisaneMiasto);

                Intent intent = new Intent(SearchFilter.this, com.palidon.visitor.MainActivity.class);
                if( wpisaneMiasto.length() > 0 && data.miasta[i].equals(wpisaneMiasto)){
                    intent.putExtra("methodName",1);
                    intent.putExtra("MIASTO", i);
                }


                startActivity(intent);

                // Code here executes on main thread after user presses button

            }
        });

    }
}
