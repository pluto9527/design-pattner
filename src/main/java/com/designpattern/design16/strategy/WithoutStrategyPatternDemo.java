package com.designpattern.design16.strategy;

public class WithoutStrategyPatternDemo {
	
	public static void main(String[] args) {
		// 有一个参数，是discountStyle
		// 如果这个参数1，那么选择一种优惠计价的方式
		// 如果这个参数2，那么选择一种优惠计价的方式
		// 如果这个参数3，那么选择一种优惠计价的方式
		
		int discountStyle = 1;
		
		if(discountStyle == 1) {
			System.out.println("执行优惠计价方式1的复杂业务逻辑"); 
		} else if(discountStyle == 2) {
			System.out.println("执行优惠计价方式2的复杂业务逻辑");
		} else if(discountStyle == 3) { 
			System.out.println("执行优惠计价方式3的复杂业务逻辑");  
		} else {
			System.out.println("执行默认的优惠计价方式的复杂业务逻辑");  
		}
		
		// 实际上在我们的业务代码，if else，看起来绝对不是这么短的，也不是这么简单
		// 在实际的业务代码中，常见的结构是上面这样的，但是每个if和if else之间的代码行数，可能多达几十行，甚至几百行
		// if和else if的判断条件，很模糊，经常就是用一堆变量的比较来判断，是走哪个分支
		
		// 类似上面这样的代码，会让我们在代码写好以后，1年之后，回过头来看这个代码，哇塞，看到了一坨屎一样
		// 看都看不懂了：代码太多了，if else if之后的条件判断，我们都看不懂，不知道在判断，if else if里面的代码，量太大了
		// 定位个bug，疯了，或者是对这段代码的业务逻辑做一些改动，疯了
		// 基本上，你得花个一两天的时间，把这段代码重新读一遍，然后看懂，才能下手写代码

	}
	
}
