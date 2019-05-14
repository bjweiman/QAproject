package SerializableLearn;

import java.io.Serializable;

/**
 * @program: QAproject
 * @description: 测试对象序列化和反序列化
 * @author: bjweiman
 * @create: 2019-05-07 16:53
 **/
class Person implements Serializable{
    /**
     * 序列化标识
     */
    private static final long serialVersionUID = 4603642343377807741L;
    private int age;
    private String name;
    private String sex;
    private String sex1;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", sex1='" + sex1 + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
