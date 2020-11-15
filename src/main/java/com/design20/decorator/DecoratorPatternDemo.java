package com.design20.decorator;

/**
 * 装饰器模式：对目标类的功能进行增强，可以层层嵌套增强
 * 		java的io、spring的aop等
 */
public class DecoratorPatternDemo {
	
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		Component decorator = new Decorator(component);
		decorator.execute();
	}
	
	public interface Component {
		
		void execute();
		
	}
	
	public static class ConcreteComponent implements Component {
		
		public void execute() {
			System.out.println("执行基础功能");
		}
		
	}
	
	public static class Decorator implements Component {

		private Component component;
		
		public Decorator(Component component) {
			this.component = component;
		}
		
		public void execute() {
			System.out.println("在执行基础功能之前，执行部分功能增强"); 
			component.execute();
			System.out.println("在执行基础功能之后，执行部分功能增强");  
		}
		
	}
	
}
