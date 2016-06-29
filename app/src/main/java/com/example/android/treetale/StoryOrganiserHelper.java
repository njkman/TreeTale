package com.example.android.treetale;

import android.content.ContentValues
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by nj_km on 19/06/2016. This creates the database and tables that is used to store the individual stories
 */
public class StoryOrganiserHelper extends SQLiteOpenHelper {

    private static final String database_NAME = "StoryDB";
    private static final String table_STORY = "story";
    private static final String story_ID = "id";
    private static final String story_TITLE = "title";
    private static final String story_DESCRIPTION = "description";
    private static final String[] COLUMNS = { story_ID, story_TITLE, story_DESCRIPTION };

    public StoryOrganiserHelper(){
        super (context, DATABASE_NAME, null, 1);
    }


    /**
     * creates a database named story. This will have a key named id and columns name title and author.
     * @param db
     */

    public void onCreate(SQLiteDatabase db) {
        String CREATE_STORY_TABLE = "CREAT TABLE story ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "title TEXT," + "description TEXT)";
        db.execSQL(CREATE_STORY_TABLE);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS story");
        this.onCreate(db);
    }

    /**
     * creates an entry in the database with a title and description of that book
     * @param story
     */

    public void createStory(Story story) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(story_TITLE, story.getTitle());
        values.put(story_DESCRIPTION, story.getDescription());


        db.insert(table_STORY, null, values);
        db.close();
    }

    /** reads a story from the database with an id, returing and parsing the ID to a string, and retruning titles and description
     *
     * @param id
     * @return
     */

    public Story readStory (int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(table_STORY, COLUMNS, "id=?", new String[] { String.valueOf(id}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Story story = new Story();
        story.setId(Integer.parseInt(cursor.getString(0)));
        story.setTitle(cursor.getString(1));
        story.setDescription(cursor.getString(2));

        return story;
    }


    public List getAllStorys(){

        List allStory = new LinkedList();

        String query = "SELECT * FROM " + table_STORY;
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        Story story = null;

        if(cursor.moveToFirst()){
            do {
                story = new Story();
                story.setId(Integer.parseInt(cursor.getString(0)));
                story.setTitle(cursor.getString(1));
                story.setDescription(cursor.getString(2));

                story.add(story);
            }
        }



        return
    }


}
