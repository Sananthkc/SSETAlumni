package com.pro.ssetalumni;
// class to intitalize datas

public class UploadImage {
    private String mDescription;
    private String mImageUrl;
    public UploadImage() {
        //empty constructor needed
    }
    public UploadImage(String description, String imageUrl) {
        if (description.trim().equals("")) { //if no description
            description = "SCMS";
        }
        mDescription = description;
        mImageUrl = imageUrl;
    }
    public String getName() {
        return mDescription;
    }
    public void setName(String description) {
        mDescription = description;
    }
    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}

