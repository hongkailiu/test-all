package com.hongkailiu.test.android.db.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hongkailiu.test.android.db.entity.TVSeries;
import com.hongkailiu.test.android.db.sqlitehelper.MySQLiteOpenHelper;
import com.hongkailiu.test.android.param.DBParams;


/**
 * 数据库tvseries表的数据访问对象
 * 
 * @author Hongkai Liu
 * 
 */
public class TVSeriesDAO {

	private MySQLiteOpenHelper dbHelper;
	private static TVSeriesDAO mInstance;

	public synchronized static TVSeriesDAO getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new TVSeriesDAO(context);
		}

		return mInstance;
	}

	private TVSeriesDAO(Context context) {
		super();
		dbHelper = MySQLiteOpenHelper.getInstance(context);
	}

	public long insert(TVSeries tvSeries) {

		ContentValues values = new ContentValues();
		values.put(DBParams.ID_FIELD, tvSeries.getId());
		values.put(DBParams.NAME_FIELD, tvSeries.getName());
		values.put(DBParams.SEASON_ON_AIR_FIELD, tvSeries.getSeasonOnAir());
		values.put(DBParams.EPISODE_ON_AIR_FIELD, tvSeries.getEpisodeOnAir());
		values.put(DBParams.SEASON_WATCHED_FIELD, tvSeries.getSeasonWatched());
		values.put(DBParams.EPICODE_WATCHED_FIELD, tvSeries.getEpisodeWatched());
		values.put(DBParams.IMAGE_MD5_FIELD, tvSeries.getImageMd5());
		values.put(DBParams.IMAGE_URL_FIELD, tvSeries.getImageUrl());
		values.put(DBParams.IMAGE_FILENAME_FIELD, tvSeries.getImageFilename());
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		long result = db.insert(DBParams.TV_SERIES_TABLE_NAME, null, values);
		db.close();
		return result;
	}
	
	public TVSeries findById(long id) {
		String[] columns = new String[] { DBParams.ID_FIELD,DBParams.NAME_FIELD,
				DBParams.SEASON_ON_AIR_FIELD, DBParams.EPISODE_ON_AIR_FIELD,
				DBParams.SEASON_WATCHED_FIELD, DBParams.EPICODE_WATCHED_FIELD, DBParams.IMAGE_MD5_FIELD, DBParams.IMAGE_URL_FIELD, DBParams.IMAGE_FILENAME_FIELD};

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String selection = DBParams.ID_FIELD + " = ?";
		String[] selectionArgs = new String[] {
		   Long.toString(id)
		};
		
		Cursor cursor = db.query(DBParams.TV_SERIES_TABLE_NAME, columns, selection,
				selectionArgs, null, null, null);
		TVSeries tvSeries = null;
		if (cursor != null) {
			if (cursor.moveToFirst()) {
				tvSeries = new TVSeries();
				tvSeries.setId(cursor.getLong(0));
				tvSeries.setName(cursor.getString(1));
				tvSeries.setSeasonOnAir(cursor.getInt(2));
				tvSeries.setEpisodeOnAir(cursor.getInt(3));
				tvSeries.setSeasonWatched(cursor.getInt(4));
				tvSeries.setEpisodeWatched(cursor.getInt(5));
				tvSeries.setImageMd5(cursor.getString(6));
				tvSeries.setImageUrl(cursor.getString(7));
				tvSeries.setImageFilename(cursor.getString(8));
			}
			cursor.close();
			
		}
		db.close();
		return tvSeries;
	}
	
	public int updateById(TVSeries tvSeries) {
		
		ContentValues values = new ContentValues();
		values.put(DBParams.ID_FIELD, tvSeries.getId());
		values.put(DBParams.NAME_FIELD, tvSeries.getName());
		values.put(DBParams.SEASON_ON_AIR_FIELD, tvSeries.getSeasonOnAir());
		values.put(DBParams.EPISODE_ON_AIR_FIELD, tvSeries.getEpisodeOnAir());
		values.put(DBParams.SEASON_WATCHED_FIELD, tvSeries.getSeasonWatched());
		values.put(DBParams.EPICODE_WATCHED_FIELD, tvSeries.getEpisodeWatched());
		values.put(DBParams.IMAGE_MD5_FIELD, tvSeries.getImageMd5());
		values.put(DBParams.IMAGE_URL_FIELD, tvSeries.getImageUrl());
		values.put(DBParams.IMAGE_FILENAME_FIELD, tvSeries.getImageFilename());

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		String selection = DBParams.ID_FIELD + " = ?";
		String[] selectionArgs = new String[] {
		   Long.toString(tvSeries.getId())
		};
		
		int result = db.update(DBParams.TV_SERIES_TABLE_NAME, values, selection,
				selectionArgs);
		db.close();
		return result;
	}
	
	public boolean save(TVSeries tvSeries) {

		if (findById(tvSeries.getId())!=null) {
			return updateById(tvSeries)!=0;
		} else {
			return insert(tvSeries)!=-1;
		}
		
	}

	public List<TVSeries> getAllTVSeries() {
		String[] columns = new String[] { DBParams.ID_FIELD,DBParams.NAME_FIELD,
				DBParams.SEASON_ON_AIR_FIELD, DBParams.EPISODE_ON_AIR_FIELD,
				DBParams.SEASON_WATCHED_FIELD, DBParams.EPICODE_WATCHED_FIELD, DBParams.IMAGE_MD5_FIELD, DBParams.IMAGE_URL_FIELD, DBParams.IMAGE_FILENAME_FIELD};

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = db.query(DBParams.TV_SERIES_TABLE_NAME, columns, null,
				null, null, null, null);
		List<TVSeries> list = null;
		if (cursor!=null) {
			list = new ArrayList<TVSeries>();
			cursor.moveToFirst();
			while (!cursor.isAfterLast()) {
				TVSeries tvSeries = new TVSeries();
				tvSeries.setId(cursor.getLong(0));
				tvSeries.setName(cursor.getString(1));
				tvSeries.setSeasonOnAir(cursor.getInt(2));
				tvSeries.setEpisodeOnAir(cursor.getInt(3));
				tvSeries.setSeasonWatched(cursor.getInt(4));
				tvSeries.setEpisodeWatched(cursor.getInt(5));
				tvSeries.setImageMd5(cursor.getString(6));
				tvSeries.setImageUrl(cursor.getString(7));
				tvSeries.setImageFilename(cursor.getString(8));
				list.add(tvSeries);
				cursor.moveToNext();
			}
			cursor.close();
		}
		db.close();
		return list;
	}

}
