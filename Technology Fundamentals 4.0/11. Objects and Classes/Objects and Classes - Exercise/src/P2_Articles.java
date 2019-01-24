import java.util.Scanner;

public class P2_Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");
        Article article = new Article(line[0], line[1], line[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] cmd = scanner.nextLine().split(": ");

            switch (cmd[0]) {
                case "Edit":
                    article.Edit(cmd[1]);
                    break;
                case "ChangeAuthor":
                    article.ChangeAuthor(cmd[1]);
                    break;
                case "Rename":
                    article.Rename(cmd[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String Edit(String content) {
            return this.content = content;
        }

        public String ChangeAuthor(String author) {
            return this.author = author;

        }

        public String Rename(String title) {
            return this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

}

