package com.pro.ssetalumni;
// class to intitalize datas

import com.google.firebase.database.Exclude;

public class UploadImage {
    private String mDescription;
    private String mImageUrl;
    private String mName;
   private String id;

    private String mKey;
    public UploadImage() {
        //empty constructor needed
    }
    public UploadImage(String name,String description, String imageUrl) {
        if (description.trim().equals("")) { //if no description
            description = "SCMS";
        }
        mName = name;
        mDescription = description;
        mImageUrl = imageUrl;
    }
    public  void setName(String name) {
        mName = name;
    }
    public String getName() {
        return mName;
    }
    public String getDescription() {
        return mDescription;
    }
    public void setDescription(String description) {
        mDescription = description;
    }
    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Exclude
    public String getKey() {
        return mKey;
    }
    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}

