package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login)  throws UserNotFoundException {
        for (User u : users) {
            if (u.getUsername().equals(login)) {
                  return u;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 4) {
            throw new UserInvalidException("Invalid element.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Ivan Ivanov", false)
        };
        String login = "Ivan Ivanov";
        try {
             findUser(users, login);
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
