package com.portfolio.spring.util;

public class DEFINE {

	public enum Statistics_State{
		
		DAY_VIEW("일간 방문자", 0), DAY_LOGIN("일간 로그인", 1);
		
		private String name;
		private int value;
		
		private Statistics_State(String name, int value) {
			this.name = name;
			this.value = value;
		}
		
		public int getStateNum() {
			return this.value;
		}
		
		public String getStateName() {
			return this.name;
		}
		
	}
	

	/*public static int Statistics_Num(int state) {

		Statistics_State[] values = Statistics_State.values();
		
		int num = values[state - 1].value;

		return num;
		
	}
	
	public static String Statistics_Name(int state) {

		Statistics_State[] values = Statistics_State.values();
		
		String str = values[state - 1].name();

		return str;
		
	}*/

}


