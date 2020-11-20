package com.designpattern.design06.abstract_factory;

/**
 * 抽象工厂模式：一个一个的产品组合（属于不同产品簇）
 *
 * 	场景：
 * （1）就是我们现在要生产的不是一个一个产品，而一个一个的产品组合
 * （2）比如说我们有产品ABC，现在第一种产品组合是A+B，第二种产品组合是B+C，第三种产品组合是A+Cs
 * （3）就是要对工厂模式进行进一步的增强
 */
public class AbstractFactoryPatternDemo {
	
	public static void main(String[] args) {
		// 产品A1+产品B1 -> 产品A1+产品B3
		ProductA firstProductA = Factory1.get().createProductA();
		ProductB firstProductB = Factory1.get().createProductB();
		firstProductA.execute();
		firstProductB.execute();
		
		// 产品A2+产品B2
		ProductA secondProductA = Factory2.get().createProductA();
		ProductB secondProductB = Factory2.get().createProductB();
		secondProductA.execute();
		secondProductB.execute();
		
		// 产品A3+产品B3
		ProductA thirdProductA = Factory3.get().createProductA();
		ProductB thirdProductB = Factory3.get().createProductB();
		thirdProductA.execute();
		thirdProductB.execute();
		
		// 哪怕你有100个地方定义了产品组合，要调整组合的逻辑，只要修改一个工厂就可以了
	}
	
	public interface ProductA {
		
		void execute();
		
	}
	
	public static class ProductA1 implements ProductA {

		public void execute() {
			System.out.println("产品A1的功能逻辑");
 		}
 		
	}
	
	public static class ProductA2 implements ProductA {

		public void execute() {
			System.out.println("产品A2的功能逻辑");
 		}
 		
	}
	
	public static class ProductA3 implements ProductA {

		public void execute() {
			System.out.println("产品A3的功能逻辑");
 		}
 		
	}
	
	public interface ProductB {
		
		void execute();
		
	}
	
	public static class ProductB1 implements ProductB {

		public void execute() {
			System.out.println("产品B1的功能逻辑");
 		}
 		
	}
	
	public static class ProductB2 implements ProductB {

		public void execute() {
			System.out.println("产品B2的功能逻辑");
 		}
 		
	}
	
	public static class ProductB3 implements ProductB {

		public void execute() {
			System.out.println("产品B3的功能逻辑");
 		}
 		
	}
	
	public interface Factory {
		
		ProductA createProductA();
		ProductB createProductB();
		
	}
	
	public static class Factory1 implements Factory {
		
		private static final Factory1 instance = new Factory1();
		
		private Factory1() {
			
		}
		
		public static Factory get() {
			return instance;
		}

		public ProductA createProductA() {
			return new ProductA1();
		}

		public ProductB createProductB() {
			return new ProductB3(); 
		}
		
	}
	
	public static class Factory2 implements Factory {
		
		private static final Factory2 instance = new Factory2();
		
		private Factory2() {
			
		}
		
		public static Factory get() {
			return instance;
		}

		public ProductA createProductA() {
			return new ProductA2();
		}

		public ProductB createProductB() {
			return new ProductB2(); 
		}
		
	}
	
	public static class Factory3 implements Factory {
		
		private static final Factory3 instance = new Factory3();
		
		private Factory3() {
			
		}
		
		public static Factory get() {
			return instance;
		}

		public ProductA createProductA() {
			return new ProductA3();
		}

		public ProductB createProductB() {
			return new ProductB3(); 
		}
		
	}
	
}
