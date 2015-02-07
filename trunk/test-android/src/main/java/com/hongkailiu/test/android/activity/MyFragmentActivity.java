package com.hongkailiu.test.android.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hongkailiu.test.android.R;
import com.hongkailiu.test.android.fragment.LM_Fragment;
import com.hongkailiu.test.android.fragment.PM_Fragment;

public class MyFragmentActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 下载这句真是可有可无啊
		//setContentView(R.layout.activity_my_fragment);
		Configuration config = getResources().getConfiguration();

	      //FragmentManager fragmentManager = getFragmentManager();
	      FragmentManager fragmentManager = getSupportFragmentManager();
	      FragmentTransaction fragmentTransaction = 
	      fragmentManager.beginTransaction();

	      /**
	      * Check the device orientation and act accordingly
	      */
	      if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
	         /**
	         * Landscape mode of the device
	         */
	         LM_Fragment ls_fragment = new LM_Fragment();
	         fragmentTransaction.replace(android.R.id.content, ls_fragment);
	      }else{
	         /**
	         * Portrait mode of the device
	         */
	         PM_Fragment pm_fragment = new PM_Fragment();
	         fragmentTransaction.replace(android.R.id.content, pm_fragment);
	      }
	      fragmentTransaction.commit();
	}
}
