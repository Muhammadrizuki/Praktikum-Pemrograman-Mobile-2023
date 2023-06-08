package com.sisfo.tugaspraktikum7.datasource;

import com.sisfo.tugaspraktikum7.model.User;

import java.util.List;

public class Account {
    public static int userID = 1;
    public static User user = Storage.users.get(userID);
}
