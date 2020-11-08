package com.design13.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 */
public class ObserverPatternDemo {
	
	public static void main(String[] args) {
		Subject subject = new Subject(0); 

		//给目标对象注册观察者，目标对象改变会反过来通知观察者
		Observer observer = new ConcreteObserver();
		subject.addObserver(observer); 
		
		subject.setState(1);
		subject.setState(2);  
	}
	
	public static class Subject extends Observable {
		
		private Integer state;
		
		public Subject(Integer state) {
			this.state = state;
		}
		
		public Integer getState() {
			return state;
		}
		public void setState(Integer state) {
			// 在这里状态就改变了
			this.state = state;
			// 通知关联的一些观察者，说我的状态变化了
			this.setChanged();
//			this.notifyObservers(state);   // 推模式
			this.notifyObservers();	//拉模式（观察者自己获取目标对象变化的数据）
		}
		
	}
	
	public static class ConcreteObserver implements Observer {

		public void update(Observable o, Object arg) {
//			Integer state = (Integer) arg;
			Subject subject = (Subject) o;
			Integer state = subject.getState();
			System.out.println("目标对象的状态变化成：" + state);  
		}
		
	}
	
}
