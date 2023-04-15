package com.example.tuprak4;

import java.util.ArrayList;

public class TampilanRoomChat {

    static String[] user1 ={
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            "n ullamco laboris nisi ut aliquip ex ea commodo consequat",
            "Lorem ipsum dolor sit amet,",
            "Nemo enim ipsam voluptatem quia voluptas sit",
            "quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure"
    };
    static String[] user2 ={
            "n ullamco laboris nisi ut aliquip ex ea commodo consequat",
            "Lorem ipsum dolor sit amet,",
            "Nemo enim ipsam voluptatem quia voluptas sit",
            "quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?",
            "sifdh"
    };

    static ArrayList<ModelRoomChat> getUser() {
        ArrayList<ModelRoomChat> userlist = new ArrayList<>();
        for (int i = 0; i< user1.length; i++){
            ModelRoomChat user = new ModelRoomChat(user1[i], user2[i]);
            userlist.add(user);
        }
        return userlist;
    };
    
}
