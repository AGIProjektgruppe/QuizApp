package de.fhdw.devgroup.quizapp.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper { 
	
	

	private static final String TAG = DatabaseManager.class.getSimpleName();
	
	//Name and Version of the Database
	private static final String DATABASE_NAME = "quizquestions.db";
	private static final int DATABASE_VERSION = 1;
	
	//Name and Attributes of Table "sortingquestion"
	private static final String _ID = "_id";
	private static final String TABLE_NAME_SORTINGQUESTION = "sortingquestion";
	private static final String QUESTIONTEXT = "questiontext";
	private static final String ANSWERS = "answers";
	
	//Create and Delete Table "qortingquestion"
	private static final String TABLE_SORTINGQUESTION_CREATE =
			"CREATE TABLE " + TABLE_NAME_SORTINGQUESTION+ "(" + _ID
			+ " STRING PRIMARY KEY, "
			+ QUESTIONTEXT + " STRING, "
			+ ANSWERS + " INTEGER);";
	
	private static final String TABLE_SORTINGQUESTION_DROP =
			"DROP TABLE IF EXISTS " + TABLE_NAME_SORTINGQUESTION;
	
	
	public DatabaseManager(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	
	@Override
	public void onCreate( SQLiteDatabase db){
		db.execSQL(TABLE_SORTINGQUESTION_CREATE);
		Log.d("DB onCreate()","Successfully created DB");
		
	}
	
	@Override
	public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion){
		Log.w(TAG, "Upgrade DB fom version " + oldVersion + " to " + newVersion
				+ "; all data will be deleted");
		db.execSQL(TABLE_SORTINGQUESTION_DROP);
		onCreate(db);
		
	}
	
	public void insertSortingquestion(String id, String questiontext, String answers){
	long rowId = -1;
			try{
				//Open Database
				SQLiteDatabase db = getWritableDatabase();
				
				ContentValues values = new ContentValues();
				values.put( _ID, id);
				values.put(QUESTIONTEXT, questiontext);
				values.put(ANSWERS, answers);
				
				rowId = db.insert(TABLE_NAME_SORTINGQUESTION, null, values);
			}catch (SQLiteException e) {
				Log.e(TAG, "insert()", e);
			}finally{
				Log.d(TAG, "insert(): rowId =" + rowId);				
			}
		
		
	}
	
	public String[] retrieveSortingquestion(String id){
		String sortingquestion[] = new String[2];
		SQLiteDatabase db = getReadableDatabase();
		Cursor c;
		
		
		c = db.rawQuery("SELECT * FROM " + TABLE_NAME_SORTINGQUESTION + " WHERE _ID = '" + id + "'", null);
		if (c != null)
            c.moveToFirst();
	            
	        	sortingquestion[0] =c.getString((c.getColumnIndex(QUESTIONTEXT)));
	        	sortingquestion[1] =c.getString(c.getColumnIndex(ANSWERS));
	 
	            // adding to tags list
	            
	       
	    
		return sortingquestion;
	}
	
	
}
