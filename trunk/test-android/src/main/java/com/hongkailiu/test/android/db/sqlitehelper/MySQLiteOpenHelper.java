package com.hongkailiu.test.android.db.sqlitehelper;

import com.hongkailiu.test.android.param.DBParams;
import com.hongkailiu.test.android.param.Param;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	private final static int DATABASE_VERSION = 1;
	private final static String DATABASE_NAME = "mytest.db";
	private static MySQLiteOpenHelper mInstance;

	@Override
	public void onCreate(SQLiteDatabase db) {
		createTables(db);

	}

	private void createTables(SQLiteDatabase db) {
		// String sql = "CREATE TABLE [t_tv_series] ("
		// + "[_id] AUTOINC,"
		// + "[name] VARCHAR(20) NOT NULL ON CONFLICT FAIL,"
		// + "CONSTRAINT [sqlite_autoindex_t_tv_series_1] PRIMARY KEY ([_id]))";

		String sql = "CREATE TABLE [" + DBParams.TV_SERIES_TABLE_NAME + "] ( ["
				+ DBParams.ID_FIELD + "] LONG PRIMARY KEY,["
				+ DBParams.NAME_FIELD + "] TEXT,[" + DBParams.SEASON_ON_AIR_FIELD
				+ "] INTEGER, [" + DBParams.EPISODE_ON_AIR_FIELD + "] INTEGER, ["
				+ DBParams.SEASON_WATCHED_FIELD + "] INTEGER, ["
				+ DBParams.EPICODE_WATCHED_FIELD + "] INTEGER, ["
				+ DBParams.IMAGE_MD5_FIELD + "] TEXT,["
				+ DBParams.IMAGE_URL_FIELD + "] TEXT,["
				+ DBParams.IMAGE_FILENAME_FIELD + "] TEXT"
				+ ");";
		Log.d(Param.LOG_TAG, sql);
		db.execSQL(sql);

	}

	private MySQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	/**
	 * Return a singleton helper for the database.
	 */
	public synchronized static MySQLiteOpenHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new MySQLiteOpenHelper(context);
		}

		return mInstance;
	}
}
