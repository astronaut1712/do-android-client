package com.nxquang.docpanel.database;

import java.io.File;

import com.nxquang.docpanel.security.MCrypto;

import android.content.Context;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class ClientHelper extends SQLiteOpenHelper {

	public static final String TABLE_CLIENT = "client";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_VALUE = "value";

	public static final String DATABASE_NAME = "doclient.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_CLIENT + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_VALUE
			+ " text not null);";
	private static final String DATEBASE_DROP = "DROP TABLE IF EXISTS " + TABLE_CLIENT;

	public ClientHelper(Context context){
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		File dbFile = context.getDatabasePath(DATABASE_NAME);
		SQLiteDatabase.openOrCreateDatabase(dbFile, MCrypto.getInstance().getSecretKey(), null);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL(DATEBASE_DROP);
		db.execSQL(DATABASE_CREATE);
	}

}
