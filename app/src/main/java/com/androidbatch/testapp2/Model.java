package com.androidbatch.testapp2;

class Model {
    String restaurant_name, restaurant_image, latitude, longitude;


    public Model(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public Model(String restaurant_name, String restaurant_image, String latitude, String longitude) {
        this.restaurant_name = restaurant_name;
        this.restaurant_image = restaurant_image;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getRestaurant_image() {
        return restaurant_image;
    }

    public void setRestaurant_image(String restaurant_image) {
        this.restaurant_image = restaurant_image;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
