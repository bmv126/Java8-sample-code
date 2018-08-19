package com.vbm.testjava9;

public class TestingJavaInnerClasses {

	void displayClassName() {
		System.out.println("inside TestingJavaInnerClass");
	}

	class InnerClass {
		void displayClassName() {
			System.out.println("inside inner class");
		}
	}

	static class StaticInnerClass {
		static void displayClassName() {
			System.out.println("inside static inner class");
		}
	}
	
	void localInnerClass() {
		int x =10;
		class LocalInnerClass{
			int y;
			public LocalInnerClass() {
				// TODO Auto-generated constructor stub
				y = 20;
			}
			void displayClassName() {
				System.out.println("inside local inner class "+x+" "+y);
			}
		}
		
		new LocalInnerClass().displayClassName();
	}
	
	public static void main(String[] args) {
		TestingJavaInnerClasses.InnerClass innObj = new TestingJavaInnerClasses().new InnerClass();
		innObj.displayClassName();
		TestingJavaInnerClasses.StaticInnerClass.displayClassName();
		new TestingJavaInnerClasses().localInnerClass();
	}
}
