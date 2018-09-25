package stream;

import java.io.*;

/**
 * @Description: 序列化与反序列化
 * @Author: daihong
 * @Date: Created in  2018/9/25
 */
public class TestObjSerializeAndDeserialize {

    public static void main(String[] args) throws Exception {
        //serializePerson();

        deserializePerson();
    }
    public static void serializePerson() throws Exception {
        Person person = new Person();
        person.setAge(10);
        person.setName("小王");
        person.setSex("男");
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("person.txt")));
        oo.writeObject(person);
        System.out.println("成功");
        oo.close();
    }
    public static void deserializePerson() throws Exception{
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(new File("person.txt")));
        Person person = (Person) oi.readObject();
        System.out.println(person);
        oi.close();
    }
}
