package Model;

import Utils.ArrayOrderedList;

/**
 * Created by usa on 7/18/2016.
 */
public class UserDB_OrderedArray<T> {
    private static ArrayOrderedList<User> users = new ArrayOrderedList<User>();
    private static User user = new User();
    private static int index;

    public static ArrayOrderedList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayOrderedList<User> users) {
       /* users.add(user);*/
        UserDB_OrderedArray.users = users;
    }

    public static ArrayOrderedList<User> getPassword() {
        return users;
    }
}
