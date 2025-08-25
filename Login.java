
import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    boolean loginstatus = false;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Users> userlist;
    private String loggedInEmail;

    public Login() {
        userlist = new ArrayList<>();
    }

    public void initializedemousers() {
        userlist.add(new Users("Ali", "1", "123", 0));
    }

    public void adduser() {
        System.out.println("Enter your kind name");
        String name = scanner.next();
        System.out.println("Enter your kind Userid");
        String email = scanner.next();
        System.out.println("enter your password");
        String password = scanner.next();
        for (int i = 0; i < userlist.size(); i++) {
            if (userlist.get(i).getemail().equals(email)) {
                System.out.println("Userid already exists,try again");
                adduser();
                return;
            }
        }
        userlist.add(new Users(name, email, password, 0));
        System.out.println("User Successfully added");
    }

    public void loginmethod() {
        System.out.println("WELCOME TO LOGIN MENU");
        System.out.println("1.login");
        System.out.println("2. Register");
        System.out.println("3. exit");
        System.out.println("choose your option");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("enter your Userid,Enter your password");
                System.out.println("USERID :");
                String email = scanner.next();
                System.out.println("PASSWORD:");
                String password = scanner.next();

                boolean found = false;
                for (int i = 0; i < userlist.size(); i++) {
                    if (userlist.get(i).getemail().equals(email) &&
                            userlist.get(i).getpassword().equals(password)) {
                        System.out.println("Login Successful,Welcome " + userlist.get(i).getname());
                        loginstatus = true;
                        found = true;
                        loggedInEmail = email; // Store logged in user's email
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Login Unsuccessful");
                    System.out.println("1.try again");
                    System.out.println("2. Register");
                    System.out.println("3. exit");
                    System.out.println("enter your choice");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            loginmethod();
                            break;
                        case 2:
                            adduser();
                            loginmethod();
                            break;
                        case 3:
                            System.out.println("exitting");
                            return;
                    }
                }
                break;

            case 2:
                adduser();
                System.out.println("Successfully Registered");
                loginmethod();
                break;

            case 3:
                System.out.println("exitting");
                return;
        }
    }

    public Users getLoggedInUser() {
        for (Users user : userlist) {
            if (user.getemail().equals(loggedInEmail)) {
                return user;
            }
        }
        return null;
    }
}

