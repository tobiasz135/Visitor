package com.palidon.visitor;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
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
import android.widget.ListView;

import com.palidon.visitor.Data.DataSearch;
import com.palidon.visitor.Data.data;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchFilter extends AppCompatActivity {
    //private static final String TAG = "MainActivity";

  //  private ArrayAdapter adapter;

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
                new DataSearch().AddCity(v);
/*                EditText editText = findViewById(R.id.actv);
                String wpisaneMiasto = editText.getText().toString();
                String[] androidStrings = data.miasta;
       //         if (Arrays.asList(androidStrings).contains(wpisaneMiasto)) {
         //           Snackbar.make(v, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    //startActivity(new Intent(SearchFilter.this, SearchFilter.class));
           //     }

                for (int i = 0; i < data.miasta.length; i++){
                    Log.w("Iter","" + data.miasta.length);
                    Log.w("data.miasta","" + data.miasta[i]);
                    if (data.miasta[i].equals(wpisaneMiasto)){
                        Snackbar.make(v, "Miasto: " + data.miasta[i] + ", index: " + i, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        break;
                    }
                }
                Log.w("Input","" + wpisaneMiasto);*/
                // Code here executes on main thread after user presses button
            }
        });


        /*Context cont;
        LayoutInflater layinf;
        List<data.miasta> nazwyMiast;
        ArrayList<data.miasta> miastaArray;
*/


       /* ListView list = (ListView) findViewById(R.id.searchList2);
        EditText theFilter = (EditText) findViewById(R.id.search);
        Log.d(TAG, "onCreate: Started.");

        ArrayList<String> names = new ArrayList<>();
        names.add("Mitch");
        names.add("Blake");
        names.add("Shelly");
        names.add("Jess");
        names.add("Steve");
        names.add("Mohammed");

        adapter = new ArrayAdapter(this, R.layout.addcity_layout,R.id.searchResult, names);
        list.setAdapter(adapter);

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (SearchFilter.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });*/

    }
}
