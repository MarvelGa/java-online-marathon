package com.softserve.edu.entity;

import java.util.Objects;

public class Entity {
    private int id ; // must be unique
    private String name;
    private static int counter =1;

    public Entity(String name){
        this.name = name;
        id = counter++;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return name.equals(entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
