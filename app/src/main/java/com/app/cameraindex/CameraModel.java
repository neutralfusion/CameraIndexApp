package com.app.cameraindex;

public class CameraModel {
    String cameraName;
    String cameraYear;
    String cameraRating;
    int image;

    public CameraModel(String cameraName, String cameraYear, String cameraRating, int image) {
        this.cameraName = cameraName;
        this.cameraYear = cameraYear;
        this.cameraRating = cameraRating;
        this.image = image;
    }

    public String getCameraName() {
        return cameraName;
    }

    public String getCameraYear() {
        return cameraYear;
    }

    public String getCameraRating() {
        return cameraRating;
    }

    public int getImage() {
        return image;
    }
}
