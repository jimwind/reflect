package me.mi.reflect;

public class Person {
	public String name;
    public Integer age;
    private String gender;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println(name + " " + age +" "+gender);
    }

    private void eat(String food){
        System.out.println(name +" eat "+food);
    }
}
