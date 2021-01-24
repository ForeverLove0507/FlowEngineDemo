package com.example.demo.context;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Context {
    private final Map<Class<?>, Object> CONTEXT = new ConcurrentHashMap<>();

    public <T> T get(Class<T> clazz) {
        return (T) CONTEXT.get(clazz);
    }

    public void put(Object obj) {
        if (null == obj) {
            return;
        }
        CONTEXT.put(obj.getClass(), obj);
    }

}
