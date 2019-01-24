import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_SoftUni_Course_Planning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("course start")) {
                break;
            }
            String[] cmd = line.split(":");
            String command = cmd[0];
            String lessonTitle = cmd[1];

            if (command.equals("Add")) {
                if (lessons.contains(lessonTitle) == false) {
                    lessons.add(lessonTitle);
                }
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(cmd[2]);

                if (lessons.contains(lessonTitle) == false && index >= 0 && index < lessons.size()) {
                    lessons.add(index, lessonTitle);
                }
            } else if (command.equals("Remove")) {
                if (lessons.contains(lessonTitle)) {
                    lessons.remove(lessonTitle);
                    lessons.remove(lessonTitle + "-Exercise");
                }
            } else if (command.equals("Swap")) {
                String secondLessonTitle = cmd[2];

                    int indexOfFirstLesson = lessons.indexOf(lessonTitle);
                    int indexOfSecondLesson = lessons.indexOf(secondLessonTitle);

                    if (indexOfFirstLesson == -1 || indexOfSecondLesson == -1){
                        continue;
                    }
                        lessons.remove(indexOfFirstLesson);

                        lessons.add(indexOfFirstLesson, secondLessonTitle);

                        lessons.remove(indexOfSecondLesson);

                        lessons.add(indexOfSecondLesson, lessonTitle);

                    if (lessons.contains(lessonTitle + "-Exercise")) {
                        lessons.remove(lessonTitle + "-Exercise");
                        lessons.add(indexOfSecondLesson + 1, lessonTitle + "-Exercise");
                    }
                    if (lessons.contains(secondLessonTitle + "-Exercise")) {
                        lessons.remove(secondLessonTitle + "-Exercise");
                        lessons.add(indexOfFirstLesson + 1, secondLessonTitle + "-Exercise");
                    }


            } else if (command.equals("Exercise")) {
                if (lessons.contains(lessonTitle) && lessons.contains(lessonTitle + "-Exercise") == false) {
                    int index = lessons.indexOf(lessonTitle);
                    lessons.add(index + 1, lessonTitle + "-Exercise");
                } else if (lessons.contains(lessonTitle) == false) {
                    lessons.add(lessonTitle);
                    lessons.add(lessonTitle + "-Exercise");
                }
            }
        }
        for (int i = 1; i <= lessons.size(); i++) {
            System.out.println(i + "." + lessons.get(i - 1));
        }
    }
}
