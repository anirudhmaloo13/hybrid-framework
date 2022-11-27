package com.brillio.test;


	
	class Father{
		public int fatherAge;
		
		public Father(int fAge)
		{
			this.fatherAge=fAge;
			System.out.println("Father");
		}
		
		public void fatherStyle()
		{
			System.out.println("Father Style");
		}
	}

	class Son extends Father{
		
		public int sonAge;
		
		public Son(int fAge, int sAge)
		{
			super(fAge);   // super keyword used to call parent constructor
			this.sonAge=sAge;
			System.out.println("son");
		}
		
		public void sonStyle()
		{
			System.out.println("Son Style");
		}
		
	}
	
	public class Constructor {
	public static void main(String[] args) {

		Son s = new Son(68, 30);
        s.fatherStyle();
        s.sonStyle();

	}

}
