package islp.controllers;

import java.util.HashMap;

public class SingletonObjectManager {
    private static SingletonObjectManager ourInstance = new SingletonObjectManager();

    private HashMap<Class,Object> objects = new HashMap<>();

    public static SingletonObjectManager getInstance() {
        return ourInstance;
    }

    private SingletonObjectManager() {
    }

    public HashMap<Class, Object> getObjects() {
        return objects;
    }
}
