/*
 * Copyright (c) Vertex Business Services.
 * All rights reserved.
 * 
 * No parts of this source code can be reproduced without written consent from
 * Vertex Business Services.
 */
package com.farkalit.hazelcast.jdbc;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;
import java.io.IOException;

/**
 *
 * @author 72010995
 */
public class Employee implements DataSerializable
{
    private int id;

    private  String name;

    private  String role;

    public Employee() {

    }

    public Employee(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
    
     @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
        objectDataOutput.writeInt(id);
        objectDataOutput.writeUTF(name);
        objectDataOutput.writeUTF(role);
    }

    @Override
    public void readData(ObjectDataInput objectDataInput) throws IOException {
        id= objectDataInput.readInt();
        name=objectDataInput.readUTF();
        role=objectDataInput.readUTF();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!name.equals(employee.name)) return false;
        if (!role.equals(employee.role)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}
