package com.palidon.visitor;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.constraint.ConstraintSet;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.palidon.visitor.Data.data;
import com.palidon.visitor.SearchFilter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                //Extra bundle is null
            } else {
                int method = extras.getInt("methodName");
                Log.i("Extras.getMethodname","" + method);
                if (method == 1) {
                    AddIMG();
                }
            }
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_map);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show();
               // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AddCityFragment()).commit();
               // navigationView.setCheckedItem(R.id.menu_none);
                startActivity(new Intent(MainActivity.this,SearchFilter.class));

            }
        });

   //     final ImageView imageView = new ImageView(this);
        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.dotsLayout);
     //   imageView.setLayoutParams(new LayoutParams(20, 20)); // value is in pixels

        // RelativeLayout. though you can use xml RelativeLayout here too by `findViewById()`
        ConstraintLayout ConstLayout = findViewById(R.id.mapLayout);
/*         if (ConstLayout != null) {
        ConstLayout.addView(imageView);
        }

        imageView.setX(50);
        imageView.setY(50);
        imageView.setImageResource(R.drawable.ic_visited);
*/
  /*      RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(200, 200);
        lp.addRule(RelativeLayout.CENTER_IN_PARENT); // A position in layout.
        ImageView imageView = new ImageView(this); // initialize ImageView
        imageView.setLayoutParams(lp);
// imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(R.drawable.ic_visited);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.dotsLayout);
        layout.addView(imageView);
*/

 /*       ConstraintLayout layout = findViewById(R.id.mapLayout);
        ConstraintSet set = new ConstraintSet();

        ImageView view = new ImageView(v);
        view.setId(View.generateViewId());
        layout.addView(view,0);
        set.clone(layout);
        set.connect(view.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, 60);
        set.applyTo(layout);
   *///final RelativeLayout rl = (RelativeLayout) findViewById(R.id.dotsLayout);
        RelativeLayout linearLayout = findViewById(R.id.dotsLayout);
        //linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        //linearLayout.setOrientation(RelativeLayout.VERTICAL);

        //Add Imageview
     //   ImageView imageView = new ImageView(this);
        //imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        //imageView.setImageResource(R.drawable.ic_visited);

     //   linearLayout.addView(imageView);
     //   setContentView(linearLayout);





    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_map:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).commit();
                break;
            case R.id.nav_achievements:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AchievementsFragment()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
       if(drawer.isDrawerOpen(GravityCompat.START)){
           drawer.closeDrawer(GravityCompat.START);
       }
       else{
           super.onBackPressed();
       }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i("onNewIntent","Odebrano wywołanie");
        if(intent.getStringExtra("methodName").equals(1)){
       //    AddIMG();
        }

    }

/*  To jest ten moment, w którym się doweidziałem, że trzeba przerobić tok myślenia.

 */


    public void AddIMG() {
       // LayoutInflater inflater = (LayoutInflater)MainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // View view = inflater.inflate(R.layout.fragment_map, null);
       // setContentView(R.layout.activity_main);
        Log.w("AddIMG()","Modyfikacja obrazu");
        //setContentView(R.layout.activity_main);
        ImageView myImage = findViewById(R.id.dot_1);
        Log.e("IsItReallyNull?","" + myImage);
        //ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) myImage.getLayoutParams();
        //marginParams.setMargins(50,0,0,0);
        myImage.setVisibility(View.INVISIBLE);
    }
}
