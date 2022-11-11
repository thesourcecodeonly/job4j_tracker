package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login)  throws UserNotFoundException {
        for (User u : users) {
            if (u.getUsername().equals(login)) {
                  return u;
            }
            if (!u.getUsername().equals(login)) {
                new UserNotFoundException("User njt found");
            }

        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid()) {
            return true;
        }
        if (!user.isValid()) {
            new UserInvalidException("Invalid element.");
        }
        return false;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ivan Ivanov", false)
        };
        String login = "Petr Arsent";
        try {
             findUser(users, login);
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
