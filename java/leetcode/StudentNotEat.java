public class StudentNotEat {
    public static int countStudents(int[] students, int[] sandwiches) {
        int count = 0, j;
        for (int i = 0; i < sandwiches.length; i++) {
            // i = i;
            int rep=sandwiches.length-i;
            while (students[i] != sandwiches[i] && rep!=0) {
                int temp = students[i];
                for (int k = i; k < students.length - 1; k++) {
                    students[k] = students[k + 1];
                }
                rep--;
                students[students.length - 1] = temp;
                // System.out.print(students[i]+",");

            }
            if(rep==0)break;
            if (students[i] == sandwiches[i]) {
                count++;
                students[i] = -1;
                sandwiches[i] = -1;
            }
        }

        return students.length - count;
    }

    public static void main(String[] args) {
        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
} 