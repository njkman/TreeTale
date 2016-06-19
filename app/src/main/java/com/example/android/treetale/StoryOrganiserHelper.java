package com.example.android.treetale;

import android.content.ContentValues
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nj_km on 19/06/2016.
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

    public void onCreate(SQLiteDatabase db) {
        String CREATE_STORY_TABLE = "CREAT TABLE story ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "title TEXT," + "author TEXT)";
        db.execSQL(CREATE_STORY_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS story");
        this.onCreate(db);
    }

    public void createStory(Story story) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(story_TITLE, story.getTitle());
        values.put(story_DESCRIPTION, story.getDescription());


        db.insert(table_STORY, null, values);
        db.close();
    }

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


}
