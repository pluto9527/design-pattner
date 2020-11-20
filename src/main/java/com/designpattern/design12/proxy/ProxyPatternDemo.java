package com.designpattern.design12.proxy;

/**
 * 代理模式：本地接口代理远程接口的调用
 * 		和被代理的对象实现相同的接口，并在内部持有被代理的对象
 */
public class ProxyPatternDemo {
	
	public static void main(String[] args) {
		Subject subject = new ConcreteSubject();
		Subject proxy = new Proxy(subject);
		proxy.request();
	}
	
	public interface Subject {
		
		void request();
		
	}
	
	public static class ConcreteSubject implements Subject {
		
		public void request() {
			System.out.println("执行请求");
		}
		
	}
	
	public static class Proxy implements Subject {
		
		private Subject subject;
		
		public Proxy(Subject subject) {
			this.subject = subject;
		}

		public void request() {
			System.out.println("执行额外的条件判断，拷贝是否要调用subject的request()方法"); 
			boolean invoke = true;
			if(invoke) {
				subject.request();
			}
		}
		
	}
	
}
