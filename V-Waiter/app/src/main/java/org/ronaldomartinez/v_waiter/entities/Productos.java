package org.ronaldomartinez.v_waiter.entities;

/**
 * Created by Ronaldo on 17/07/2016.
 */
public class Productos {
    String name;
    int photoId;

    public Productos(String name, int photoId) {
        this.name = name;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
