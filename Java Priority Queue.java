import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<Student>(
            11,
            new Comparator<Student>() {

                @Override
                public int compare(Student a, Student b) {
                    int result = Double.compare(b.getCGPA(), a.getCGPA());

                    if (result != 0) {
                        return result;
                    }
                    result = a.getName().compareTo(b.getName());

                    if (result != 0) {
                        return result;
                    }
                    return Integer.compare(a.getID(), b.getID());
                }
            }
        );

        for (String event : events) {

            if (event.startsWith("ENTER")) {

                String[] parts = event.split("\\s+");

                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                queue.add(new Student(id, name, cgpa));

            } else if (event.equals("SERVED")) {

                if (!queue.isEmpty()) {
                    queue.poll();
                }
            }
        }

        List<Student> students = new ArrayList<Student>();

        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
