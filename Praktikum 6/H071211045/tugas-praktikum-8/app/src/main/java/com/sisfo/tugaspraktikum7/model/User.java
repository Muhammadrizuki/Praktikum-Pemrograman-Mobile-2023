package com.sisfo.tugaspraktikum7.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class User implements Parcelable {
    @SerializedName("username")
    private String username;
    @SerializedName("name")
    private String fullName;
    @SerializedName("profile_pic")
    private String profilePicture;
    private List<Post> posts;

//    public User(String fullName, String username, String profilePicture) {
//        this.fullName = fullName;
//        this.username = username;
//        this.profilePicture = profilePicture;
//    }

    protected User(Parcel in) {
        fullName = in.readString();
        username = in.readString();
        profilePicture = in.readString();
        posts = in.createTypedArrayList(Post.CREATOR);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(fullName);
        parcel.writeString(username);
        parcel.writeString(profilePicture);
        parcel.writeTypedList(posts);
    }


}
