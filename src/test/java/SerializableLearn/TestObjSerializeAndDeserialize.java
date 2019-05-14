package SerializableLearn;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;

import java.io.*;

/**
 * @program: QAproject
 * @description: 测试对象的序列化和反序列
 * @author: bjweiman
 * @create: 2019-05-07 16:54
 **/
public class TestObjSerializeAndDeserialize {
    public static void main(String[] args) {
//        SerializePerson();
        try {
            Person person = DeserializePerson();
            System.out.println(person);
            String json = JSON.toJSONString(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 序列化对象
     */
    private static void SerializePerson(){
        Person person = new Person();

        person.setAge(1);
        person.setName("willa");
        person.setSex("male");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("E:/Person.txt")));
            objectOutputStream.writeObject(person);
            System.out.println("person对象序列化成功");
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化
     * @return
     * @throws Exception
     */
    private static Person DeserializePerson() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("E:/Person.txt")));
        Person person = (Person) objectInputStream.readObject();
        System.out.println("person对象反序列化成功");
        return person;
    }


}
