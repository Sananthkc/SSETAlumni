package com.pro.ssetalumni;

public class uploadjobs {

    private String mDescription;
    private String mImageUrl;
    private String mName;
    public Uploadjobs() {
        //empty constructor needed
    }
    public UploadImage(String name,String description, String imageUrl) {
        if (description.trim().equals("")) { //if no description
            description = "....";
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
}
}
