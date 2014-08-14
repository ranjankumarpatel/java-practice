package com.singleton;

public class SingleTon {
	
	private static SingleTon singleTon = new SingleTon();
	
	private SingleTon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static SingleTon getSingleTon(){
		if(singleTon != null){
			return singleTon;
		}else{
			singleTon = new SingleTon();
			return singleTon;
		}
	}
	public static SingleTon getSingleTon(boolean flag){
		if(singleTon != null){
			return singleTon;
		}else{
			singleTon = new SingleTon();
			return singleTon;
		}
	}
	
	public static void main(String[] args){
		SingleTon singleTon1 = getSingleTon();
		System.out.println(singleTon1);
		SingleTon singleTon3 = singleTon1;
		System.out.println(singleTon3);
		singleTon3 = null;
		SingleTon singleTon2 = getSingleTon();
		System.out.println(singleTon2);
	}

}
