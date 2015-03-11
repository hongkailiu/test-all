package com.hongkailiu.test.app.aaa;

public class D {
	
	@SuppressWarnings("unused")
	private int  b;
	
	public void y(){
		InnerD iD= new InnerD();
		iD.a = 3;
		
	}

	public class InnerD {
		@SuppressWarnings("unused")
		private int  a;
		
		public int x(){
			D d = new D();
			d.b = 3;
			return 0;
		}
	}
}
