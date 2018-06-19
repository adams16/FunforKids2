package com.example.adams.funforkids;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton alphabets, fruits, flowers, colors, birds, numbers, animals;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphabets = (ImageButton) findViewById(R.id.alphabets);
        fruits = (ImageButton) findViewById(R.id.fruits);
        colors = (ImageButton) findViewById(R.id.colors);
        birds = (ImageButton) findViewById(R.id.birds);
        numbers = (ImageButton) findViewById(R.id.numbers);
        flowers = (ImageButton) findViewById(R.id.flowers);
        animals = (ImageButton) findViewById(R.id.animals);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, SigninActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        alphabets.setOnClickListener(this);
        fruits.setOnClickListener(this);
        colors.setOnClickListener(this);
        birds.setOnClickListener(this);
        numbers.setOnClickListener(this);
        flowers.setOnClickListener(this);
        animals.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, SigninActivity.class));

        }

        return super.onOptionsItemSelected(item);
    }

    private void imagebutton()
    {
        
    }


    @Override
    public void onClick(View v) {

    }
}

