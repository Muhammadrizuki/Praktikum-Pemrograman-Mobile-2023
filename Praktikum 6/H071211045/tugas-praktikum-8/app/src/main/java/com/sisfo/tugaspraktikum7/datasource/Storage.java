package com.sisfo.tugaspraktikum7.datasource;

import com.sisfo.tugaspraktikum7.model.Post;
import com.sisfo.tugaspraktikum7.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Storage {

    public static List<User> users = new ArrayList<>();
    public static List<Post> posts = new LinkedList<>();

//    public static void addPost(Post post, int userID) {
//        users.get(userID).addPost(post);
//    }

//    public static void addPost(Post post, String username) {
//        int start = 0, end = users.size() - 1;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (users.get(mid).getUsername().equals(username)) {
//                users.get(mid).addPost(post);
//                return;
//            } else if (users.get(mid).getUsername().compareTo(username) < 0) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//
//        posts.add(post);
//    }

}
