package com.example.lab3;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.lab3.ui.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;

import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();;
                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja,REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void kliknij(View view)
    {
        Toast.makeText(this, "Kliknięto przycisk login", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


    public void randomImage(View view)
    {
        Button button = (Button)view;

        Drawable drawable;

        switch((new Random()).nextInt(5))
        {
            case 0:
                drawable = getResources().getDrawable(R.drawable.image1,getTheme());
                break;
            case 1:
                drawable = getResources().getDrawable(R.drawable.image2,getTheme());
                break;
            case 2:
                drawable = getResources().getDrawable(R.drawable.image3,getTheme());
                break;
            case 3:
                drawable = getResources().getDrawable(android.R.drawable.ic_menu_zoom,getTheme());
                break;
            case 4:
                drawable = getResources().getDrawable(android.R.drawable.checkbox_on_background,getTheme());
                break;
            default:
                drawable = getResources().getDrawable(R.drawable.image4,getTheme());
                break;
        }

        button.setBackground(drawable);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        Bundle extras=data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = (ConstraintLayout)findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch(id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"action_settings", Toast.LENGTH_SHORT).show();
                break;


            case R.id.action_settings1:
                Toast.makeText(getApplicationContext(),"action_settings1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.action_settings2:
                Toast.makeText(getApplicationContext(),"action_settings2", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
