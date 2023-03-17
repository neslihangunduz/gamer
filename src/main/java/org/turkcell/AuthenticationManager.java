package org.turkcell;

import java.util.ArrayList;

public class AuthenticationManager {
    private final ArrayList<User> users = new ArrayList<User>();
    private int userCount = 0;

    public void register(User user){
        users.add(user);
        userCount++;
        System.out.println("User(" + user.getId()+ ") kayıt oldu.");
    }

    public void deleteUser(User user){
        // users.remove(user);
        for(int i=0, len=users.size(); i<len; i++){
            if(users.get(i).getId() == user.getId()){
                users.remove(i);
                userCount--;
                System.out.println("User("+user.getId()+") silindi.");
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "AuthenticationManager{" +
                "users=" + users +
                '}';
    }
    public int getUserCount() {
        return userCount;
    }
}
