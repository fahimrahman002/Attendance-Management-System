# Attendance-Management-System Build from sources

## 1. Clone the repo

git clone https://github.com/fahimrahman002/Attendance-Management-System.git

## 2. Start localhost server using xampp and goto admin panel

## 3. Import database

- create table named 'attendance_management_system'

- Import attendance_management_system.sql file.

* [Note: 'attendance_management_system.sql' file can be found in 'Database backup'folder]

- Import database by following [The Tutorial](https://youtu.be/jW5lrS6EUPM)

## 4. Open the project in netbeans ide

## 5. Database setup

- ### Open src\attendancemanagementsystem\Database\JConnection.java file

- ### Database Name settings:

1.  Set it as "attendance_management_system" in JConnection method

```sh
public class JConnection {

    public static Connection connectdb() {
        String url = "jdbc:mysql://localhost/";
        String dbName = "attendance_management_system"; //Here put your database name
        ...
    }
}
```

- ### Database username and password settings:

2.  - set yours username or keep it as root for username settings in JConnection method. Furthermore set your database password or leave it as it is.

```sh
public class JConnection {

    public static Connection connectdb() {
        String url = "jdbc:mysql://localhost/";
        String dbName = "attendance_management_system";
        String username = "root"; //Here put your username of your database
        String pass = ""; //Here put your password of your database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url + dbName, username, pass);
            System.out.println("Connected");
            return connection;
        } catch (ClassNotFoundException | SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Connection failed");
            return null;
        }

    }
}
```

## 6. Run the project
