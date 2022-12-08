# AndoridStudioDatabase
THis is very similar to the second database lab with added extras of inserting int's into the database and then filtering through the code with a sql statment

This Method uses the "selectFilterQuery" which will get all the information from the table and then orders the data from the highest score to the lowest and then
then will get the top 5 of the highscores and sending them to a list to be displayed
In DatabaseHandler.java
 public List<HighscoreClass> top5Highscore()
    {
        List<HighscoreClass> topFiveHighscoreList = new ArrayList<HighscoreClass>();
        // Select All Query

        String selectFilterQuery = "SELECT id, name, highscore FROM " + TABLE_HIGHSCORE + " ORDER BY CAST(highscore as INTEGER) DESC LIMIT 5";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectFilterQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                HighscoreClass highscore = new HighscoreClass();
                highscore.setID(Integer.parseInt(cursor.getString(0)));
                highscore.setName(cursor.getString(1));
                highscore.setHighscore(Integer.parseInt(cursor.getString(2)));
                // Adding contact to list
                topFiveHighscoreList.add(highscore);
            } while (cursor.moveToNext());
        }

        return topFiveHighscoreList;
    }


This Method calls the Database method which has the filtered list and then loops through it displaying the filtered data
In MainActivity.Java
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
