package com.reimia.fanshe;

public abstract class AbsReflectProcessor implements ReflectProcessor {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
