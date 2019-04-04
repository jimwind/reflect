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
		//ͨ���޲����Ĺ���������������
		{
		    //1. ��ȡ�ֽ���
		    Class clazz1 = Class.forName("me.mi.reflect.Person");
		    //2. ͨ���ֽ��봴������
		    Person p = (Person) clazz1.newInstance();
		    p.name = "zhangsan";
		    p.age = 10;
		    p.show();
		}
		//ͨ���в����Ĺ���������������
		{
		    //1.��ȡ�ֽ���
		    Class clazz1 = Class.forName("me.mi.reflect.Person");
		    //2.��ȡ������
		    Constructor c = clazz1.getConstructor(String.class, Integer.class);
		    //3.ͨ������������������
		    Person p = (Person) c.newInstance("luban", 7);
		    p.show();
		
		    //��ȡ�������ֶ�
		    {
		        Field f = clazz1.getField("name");
		        f.set(p, "libai");
		        p.show();
		    }
		    //��ȡ˽���ֶ�
		    {
		        Field f = clazz1.getDeclaredField("gender");
		        //ȥ��˽��Ȩ��
		        f.setAccessible(true);
		        f.set(p, "male");
		        p.show();
		    }
		    //��ȡ��������,��ִ��
		    {
		        Method m = clazz1.getMethod("show");
		        m.invoke(p);
		    }
		    //��ȡ˽�з���,��ִ��
		    {
		        Method m = clazz1.getDeclaredMethod("eat", String.class);
		        m.setAccessible(true);
		        m.invoke(p, "rice");
		    }
		
		}
		//�ƹ���������� ���б��м����κ���������
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

