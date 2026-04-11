package com.tutego.ch_05.jdbcTemplate;

// JavaBean: reusable Java class with a no-arg constructor and getter/setter properties following standard naming conventions.
public class ProfilePhoto {
    private long id;
    private String imageName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "ProfilePhoto{" +
                "id=" + id +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}
