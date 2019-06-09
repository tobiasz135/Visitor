package com.palidon.visitor.Data;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.palidon.visitor.MainActivity;
import com.palidon.visitor.R;
import com.palidon.visitor.SearchFilter;

import java.util.Arrays;

public class DataSearch extends AppCompatActivity {

    public int AddCity(View view) {
        EditText editText = findViewById(R.id.actv);
        String wpisaneMiasto = editText.getText().toString();
        String[] androidStrings = data.miasta;
        //         if (Arrays.asList(androidStrings).contains(wpisaneMiasto)) {
        //           Snackbar.make(v, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        //startActivity(new Intent(SearchFilter.this, SearchFilter.class));
        //     }

        for (int i = 0; i < data.miasta.length; i++) {
            Log.w("Iter", "" + data.miasta.length);
            Log.w("data.miasta", "" + data.miasta[i]);
            if (data.miasta[i].equals(wpisaneMiasto)) {
                Snackbar.make(view, "Miasto: " + data.miasta[i] + ", index: " + i, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
            }
        }
        Log.w("Input", "" + wpisaneMiasto);
        // Code here executes on main thread after user presses button
        return 0;
    }
}




