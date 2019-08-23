package org.fenxisoft.clazz;

/**
 *实现接口快捷键ALT +INSERT
 */
public abstract  class Person implements Animal{
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
