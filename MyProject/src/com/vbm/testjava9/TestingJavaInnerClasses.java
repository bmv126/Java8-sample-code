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
		int x;

		public StaticInnerClass() {
			// TODO Auto-generated constructor stub
			x = 20;
		}

		static void displayClassName() {
			System.out.println("inside static inner class ");
		}

		void displayX() {
			System.out.println("x = " + x);
		}
	}

	void localInnerClass() {
		int x = 10;
		class LocalInnerClass {
			int y;

			public LocalInnerClass() {
				y = 20;
			}

			void displayClassName() {
				System.out.println("inside local inner class " + x + " " + y);
			}
		}

		new LocalInnerClass().displayClassName();
	}

	public static void main(String[] args) {
		TestingJavaInnerClasses.InnerClass innObj = new TestingJavaInnerClasses().new InnerClass();
		innObj.displayClassName();
		StaticInnerClass sts = new StaticInnerClass();
		sts.displayX();
		TestingJavaInnerClasses.StaticInnerClass.displayClassName();
		new TestingJavaInnerClasses().localInnerClass();
	}
}
