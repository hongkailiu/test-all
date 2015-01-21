package com.hongkailiu.test.app.aaa;

public class D {
	
	private int  b;
	
	public void y(){
		InnerD iD= new InnerD();
		iD.a = 3;
		
	}

	public class InnerD {
		private int  a;
		
		public int x(){
			D d = new D();
			d.b = 3;
			return 0;
		}
	}
}
