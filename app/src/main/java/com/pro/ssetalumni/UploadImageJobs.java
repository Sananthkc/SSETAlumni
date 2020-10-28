package com.pro.ssetalumni;
// class to intitalize datas

public class UploadImageJobs {
    private String mDescription;
    private String mImageUrl;
    private String mName;
    public UploadImageJobs() {
        //empty constructor needed
    }
    public UploadImageJobs(String description, String imageUrl) {
        if (description.trim().equals("")) { //if no description
            description = "SCMS jobs";
        }

        mDescription = description;
        mImageUrl = imageUrl;
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

