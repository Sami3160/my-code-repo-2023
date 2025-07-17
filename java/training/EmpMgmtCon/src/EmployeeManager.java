package dbms_operations;
import java.sql.*;
import java.util.*;

public class EmployeeManager {

    private static Map<Integer, Employee> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadFromDatabase(); 

        while (true) {
            System.out.println(
                    "\n1. Add   2. Display   3. Delete   4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> displayEmployees();
                case 3 -> deleteEmployee(sc);
                case 4 -> stop();
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static void stop() {
        System.out.println("Exiting Employee Manager. Goodbye!");
        System.exit(0);
    }

    public static void loadFromDatabase() {
        try (Connection con = DBInit.getConnection()) {
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM emp;"); // Use SELECT * FROM emp
            while (res.next()) {
                Employee e = new Employee(
                        res.getInt("id"),
                        res.getString("name"),
                        res.getString("department"), // Corrected column name to "department"
                        res.getDouble("salary") // Corrected to getDouble for salary
                );
                map.put(e.getId(), e);
            }
            System.out.println("Loaded from database: " + map.size() + " records.");
        } catch (SQLException e) { // Catch SQLException for database errors
            System.err.println("Error loading from database: " + e.getMessage());
        }
    }

    public static void addEmployee(Scanner sc) {
        System.out.println("--- Add New Employee ---");
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        // Consume the newline character left by nextInt()
        sc.nextLine(); 

        // Check if ID already exists
        if (map.containsKey(id)) {
            System.out.println("Error: Employee with ID " + id + " already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        // Consume the newline character left by nextDouble()
        sc.nextLine(); 

        Employee emp = new Employee(id, name, dept, salary);

        try (Connection con = DBInit.getConnection()) {
            String sql = "INSERT INTO emp (id, name, department, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, emp.getId());
            pst.setString(2, emp.getName());
            pst.setString(3, emp.getDepartment());
            pst.setDouble(4, emp.getSalary());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                map.put(emp.getId(), emp); // Add to map only on successful database insert
                System.out.println("Employee " + name + " added successfully!");
            } else {
                System.out.println("Failed to add employee to the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error adding employee: " + e.getMessage());
        }
    }

    public static void displayEmployees() {
        System.out.println("--- Employee List ---");
        if (map.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        // Sort employees by ID for consistent display
        map.values().stream()
           .sorted(Comparator.comparingInt(Employee::getId))
           .forEach(System.out::println);
    }

    public static void deleteEmployee(Scanner sc) {
        System.out.println("--- Delete Employee ---");
        System.out.print("Enter ID of employee to delete: ");
        int idToDelete = sc.nextInt();
        // Consume the newline character
        sc.nextLine(); 

        if (!map.containsKey(idToDelete)) {
            System.out.println("Error: Employee with ID " + idToDelete + " not found.");
            return;
        }

        try (Connection con = DBInit.getConnection()) {
            String sql = "DELETE FROM emp WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idToDelete);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                Employee removedEmp = map.remove(idToDelete); // Remove from map only on successful database delete
                System.out.println("Employee " + removedEmp.getName() + " (ID: " + idToDelete + ") deleted successfully!");
            } else {
                System.out.println("Failed to delete employee from the database.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting employee: " + e.getMessage());
        }
    }
}
