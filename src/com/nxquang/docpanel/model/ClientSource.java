package com.nxquang.docpanel.model;

import android.content.ContentValues;
import android.content.Context;

import com.nxquang.docpanel.database.ClientHelper;
import com.nxquang.docpanel.security.MCrypto;

import net.sqlcipher.Cursor;
import net.sqlcipher.SQLException;
import net.sqlcipher.database.SQLiteDatabase;

public class ClientSource {

	private SQLiteDatabase database;
	private ClientHelper dbHelper;
	private String[] allColumns = {ClientHelper.COLUMN_ID, ClientHelper.COLUMN_VALUE};
	private static ClientSource cs = null;
	
	private ClientSource(Context context){
		SQLiteDatabase.loadLibs(context);
		dbHelper = new ClientHelper(context);
	}
	
	public static ClientSource getInstance(Context context){
		if(cs == null){
			cs = new ClientSource(context);
		}
		return cs;
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase(MCrypto.getInstance().getSecretKey());
	}
	
	public void close(){
		dbHelper.close();
	}
	
	public int insertToken(String value){
		ContentValues values = new ContentValues();
		values.put(ClientHelper.COLUMN_VALUE, value);
		values.put(ClientHelper.COLUMN_ID, Client.getInstance().getId());
		long insertId = database.insert(ClientHelper.TABLE_CLIENT, null, values);
		return (int)insertId;
	}
	
	public String getToken(){
		Cursor cur = database.query(ClientHelper.TABLE_CLIENT, allColumns, null, null, null, null, null);
		cur.moveToFirst();
		return cur.getString(cur.getColumnIndex(ClientHelper.COLUMN_VALUE));
	}
	
	public void deleteToken(){
		database.delete(ClientHelper.TABLE_CLIENT, null, null);
	}
}
