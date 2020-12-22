package com.example.nhom7.product;

public class ListAccount {
    int image;
    String course;

    public ListAccount(){

    }
    public ListAccount(int image, String course){
        super();
        this.image = image;
        this.course = course;
    }
    public int getImage(){
        return image;
    }
    public String getCourse(){
        return course;
    }
    public void setImage(int image){
        this.image = image;
    }
    public void setCourse(String course){
        this.course = course;
    }
}