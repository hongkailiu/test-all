package com.hongkailiu.test.android.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class TestData implements Parcelable {

	private int a;
	private String s;

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(a);
		dest.writeString(s);

	}

	// 实例化静态内部对象CREATOR实现接口Parcelable.Creator
	public static final Parcelable.Creator<TestData> CREATOR = new Creator<TestData>() {

		// 将Parcel对象反序列化
		@Override
		public TestData createFromParcel(Parcel source) {
			TestData td = new TestData();
			// 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
			td.a = source.readInt();
			td.s = source.readString();
			return td;
		}

		@Override
		public TestData[] newArray(int size) {
			return new TestData[size];
		}
	};

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

}
