package com.hongkailiu.test.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hongkailiu.test.android.activity.TVSeriesActivity;
import com.hongkailiu.test.android.param.Param;

public class MainActivity extends Activity {
	
	private GridView myGridView;
	private GridAppAdapter myGridAppAdapter;

	//
	private final static int COUNT = 30;
	private String[] textArray = new String[COUNT];

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(Param.LOG_TAG, "HelloAndroidActivity.onCreate");
        setContentView(R.layout.activity_main);
        setGridView();
    }
    
    private void setGridView() {
		initText();
		myGridAppAdapter = new GridAppAdapter();
		myGridView = (GridView) findViewById(R.id.gridView1);
		myGridView.setAdapter(myGridAppAdapter);

		OnItemClickListener myOnItemClickListener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// arg2 is position
				handleClick(arg2);

			}
		};
		myGridView.setOnItemClickListener(myOnItemClickListener);

	}
    
    private void initText() {
		textArray[0] = "tvSeries";
	}
    
    private void handleClick(int position) {
		Log.d(Param.LOG_TAG, "position: " + position);

		switch (position) {
		case 0:
			startActivity(TVSeriesActivity.class);
			break;
		default:

			break;
		}

	}
    
    private void startActivity(Class<?> cla) {
		Intent intent = new Intent();
		intent.setClass(this, cla);
		// 无返回值的调用,启动一个明确的activity
		startActivity(intent);
		// startActivityForResult(intent, REQUEST_CODE);

	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(com.hongkailiu.test.android.R.menu.main, menu);
	return true;
    }
    
    private class GridAppAdapter extends BaseAdapter {

		LayoutInflater inflater;

		public GridAppAdapter() {
			inflater = LayoutInflater.from(MainActivity.this);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			Holder holder;

			if (convertView == null) {

				holder = new Holder();
				convertView = inflater.inflate(R.layout.imagetext, null);
				holder.image = (ImageView) convertView
						.findViewById(R.id.imageViewIT1);
				holder.text = (TextView) convertView
						.findViewById(R.id.textViewIT1);
				convertView.setTag(holder);
			} else {

				holder = (Holder) convertView.getTag();
			}

			holder.image.setImageResource(R.drawable.icon);
			String tempStr = textArray[position];
			if (tempStr == null) {
				holder.text.setText("abc: " + position);
			} else {
				holder.text.setText(tempStr);
			}

			// LayoutParams lp = holder.icon.getLayoutParams();
			// lp.width = iconWidth;
			// lp.height = iconHeight;

			// 分布更新
			// myGridAppAdapter.notifyDataSetChanged();
			return convertView;

		}

		@Override
		public final int getCount() {
			return COUNT;
		}

		@Override
		public final Object getItem(int position) {
			return position;
		}

		@Override
		public final long getItemId(int position) {
			return position;
		}
	}

	private class Holder {
		ImageView image;
		TextView text;
	}

}

