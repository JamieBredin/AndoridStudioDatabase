package com.example.gameprojecthighscoredatabase;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        List<HighscoreClass> highscore = db.getAllHighscore();


        //db.emptyContacts();     // empty table if required
        db.emptyHighscore();
        // Inserting Contacts
        Log.i("Insert: ", "Inserting ..");
        db.addHighscore(new HighscoreClass("Joe", 4));
        db.addHighscore(new HighscoreClass("Mary", 3));
        db.addHighscore(new HighscoreClass("Jack", 8));
        db.addHighscore(new HighscoreClass("Andrew", 5));
        db.addHighscore(new HighscoreClass("Harold", 2));
        db.addHighscore(new HighscoreClass("John", 9));

        // Reading all contacts
        Log.i("Reading: ", "Reading all contacts..");

        for (HighscoreClass cn : highscore) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Highscore: " +
                    cn.getHighscore();
                            Log.i("Name: ", log);

        }

        Log.i("divider", "====================");

        HighscoreClass singleUser = db.getHighscoreClass(5);
        Log.i("contact 5 is ", singleUser.getName());

        Log.i("divider", "====================");

        // Calling SQL statement
        int userCount = db.getHighscoreCount();
        Log.i("User count: ", String.valueOf(userCount));


    }

    public void topFiveFilter()
    {
        DatabaseHandler db = new DatabaseHandler(this);
        List<HighscoreClass> highscoreList = db.top5Highscore();
        Log.i("Name: ", "list successful");
        for (HighscoreClass cn2 : highscoreList) {


            String log = "Id: " + cn2.getID() + " ,Name: " + cn2.getName() + " ,Highscore: " +
                    cn2.getHighscore();

            Log.i("Name: ", log);
        }
    }

    public void addHighScore(View view) {
        String name;
        EditText e1,e2;
        String highscore;
        e1 = (EditText) findViewById(R.id.nameTv);
        e2 = (EditText) findViewById(R.id.highscoreTv);

        name = String.valueOf(e1.getText());
        highscore = String.valueOf(e2.getText());
        DatabaseHandler db = new DatabaseHandler(this);
        db.addHighscore(new HighscoreClass(name, Integer.parseInt(highscore)));
        int userCount = db.getHighscoreCount();
        Log.i("User count: ", String.valueOf(userCount));

        List<HighscoreClass> highscoreList = db.getAllHighscore();


        for (HighscoreClass cn2 : highscoreList) {


            String log = "Id: " + cn2.getID() + " ,Name: " + cn2.getName() + " ,Highscore: " +
                    cn2.getHighscore();
            //if(cn2.getHighscore() >= )
            Log.i("Name: ", log);
        }
            topFiveFilter();
        }


        //Making EditView Clear
        public void noClickHighscore(View view)//will have to click edit view twice to clear text
        {
            EditText e2;
            e2 = (EditText) findViewById(R.id.highscoreTv);
            e2.getText().clear();
        }

    public void noClickName(View view)//will have to click edit view twice to clear text
    {
        EditText e1;
        e1 = (EditText) findViewById(R.id.nameTv);
        e1.getText().clear();
    }
    }
