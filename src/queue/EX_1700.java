package queue;

public class EX_1700 {

    public static void main(String[] args) {
        countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 });
    }

    // 0 -> circular
    // 1 -> square
    public static int countStudents(int[] students, int[] sandwiches) {

        int numberOfStudentsTestedPerCicle = 0;
        int realStudentsLength = students.length;

        while (numberOfStudentsTestedPerCicle < realStudentsLength) {

            int auxCounter = 0;

            if (students[0] == sandwiches[0]) {

                if (realStudentsLength == 0)
                    break;

                while (auxCounter < realStudentsLength - 1) {
                    students[auxCounter] = students[auxCounter + 1];
                    sandwiches[auxCounter] = sandwiches[auxCounter + 1];
                    auxCounter++;
                }

                numberOfStudentsTestedPerCicle = 0;
                realStudentsLength--;
                continue;
            }

            int temp = students[0];

            while (auxCounter < realStudentsLength - 1) {
                students[auxCounter] = students[auxCounter + 1];
                auxCounter++;
            }

            students[realStudentsLength - 1] = temp;
            numberOfStudentsTestedPerCicle++;
        }

        return realStudentsLength;
    }

    public static int countStudentsFaster(int[] students, int[] sandwiches) {

        int numberOfStudentsThatWant0 = 0;
        int numberOfStudentsThatWant1 = 0;

        for (int s : students) {
            if (s == 0)
                numberOfStudentsThatWant0++;
            else
                numberOfStudentsThatWant1++;
        }

        for (int s : sandwiches) {

            if (s == 0 && numberOfStudentsThatWant0 == 0) {
                return numberOfStudentsThatWant1;
            }

            if (s == 1 && numberOfStudentsThatWant1 == 0) {
                return numberOfStudentsThatWant0;
            }

            if (s == 0)
                numberOfStudentsThatWant0--;
            else
                numberOfStudentsThatWant1--;
        }

        return 0;
    }

}
