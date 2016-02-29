package com.group26.sax;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by crosario on 2/22/2016.
 */
public class Person {

    String name, department;
    int age, id;

    public static Person createPerson(JSONObject json) throws JSONException{
        Person person = new Person();
        person.setName(json.getString("name"));
        person.setId(json.getInt("id"));
        person.setDepartment(json.getString("department"));
        person.setAge(json.getInt("age"));
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
