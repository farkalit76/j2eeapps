/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farkalit.util.collection;

/**
 *
 * @author fusman
 */
public class Person 
{
    private int age;
    private String name;
    private String address;
   

    public Person(int age, String name, String address )
    {
        this.age=age;
        this.name=name;
        this.address=address;
    }
    public int getAge()
    {
        return age;
    }  
    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    @Override
    public boolean equals(Object that) { // use same values as in hashCode
      return (that instanceof Person) 
          && ((Person) that).age ==this.age
          && ((Person) that).name.equals(this.name)
          && ((Person) that).address.equals(this.address);
    }
    
    @Override
    public int hashCode() { // use same values as in equals
      int result = 17;
      result = 31 * result + age;
      result = 31 * result + name.hashCode();
      result = 31 * result + address.hashCode();
      return result;
    }

    @Override
    public String toString() {
      return String.format("%d %s (%s)", age, name, address);
    }
}
