package me.mi.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Client {
	public static void main(String[] args) throws ClassNotFoundException,
	    IllegalAccessException, InstantiationException,
	    NoSuchMethodException,
	    InvocationTargetException,
	    NoSuchFieldException {
		{
		    Class clazz1 = Class.forName("me.mi.reflect.Person");
		}
		{
		    Class clazz2 = Person.class;
		}
		{
		    Person p = new Person();
		    Class clazz3 = p.getClass();
		}
		//通过无参数的构造器来创建对象
		{
		    //1. 获取字节码
		    Class clazz1 = Class.forName("me.mi.reflect.Person");
		    //2. 通过字节码创建对象
		    Person p = (Person) clazz1.newInstance();
		    p.name = "zhangsan";
		    p.age = 10;
		    p.show();
		}
		//通过有参数的构造器来创建对象
		{
		    //1.获取字节码
		    Class clazz1 = Class.forName("me.mi.reflect.Person");
		    //2.获取构造器
		    Constructor c = clazz1.getConstructor(String.class, Integer.class);
		    //3.通过构造器来创建对象
		    Person p = (Person) c.newInstance("luban", 7);
		    p.show();
		
		    //获取公共的字段
		    {
		        Field f = clazz1.getField("name");
		        f.set(p, "libai");
		        p.show();
		    }
		    //获取私有字段
		    {
		        Field f = clazz1.getDeclaredField("gender");
		        //去除私有权限
		        f.setAccessible(true);
		        f.set(p, "male");
		        p.show();
		    }
		    //获取公共方法,并执行
		    {
		        Method m = clazz1.getMethod("show");
		        m.invoke(p);
		    }
		    //获取私有方法,并执行
		    {
		        Method m = clazz1.getDeclaredMethod("eat", String.class);
		        m.setAccessible(true);
		        m.invoke(p, "rice");
		    }
		
		}
		//绕过编译器检测 在列表中加入任何类型数据
		{
		    ArrayList<Integer> list = new ArrayList<>();
		    list.add(1);
		    //list.add("what");
		    Class<?> clazz = Class.forName("java.util.ArrayList");
		    Method m = clazz.getMethod("add", Object.class);
		    m.invoke(list, "what");
		    System.out.println(list);
		}
	}
}

