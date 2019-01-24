import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P4_Articles_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> books = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(", ");

            Article article = new Article(line[0], line[1], line[2]);

            books.add(article);
        }
        String input = scanner.nextLine();

        switch (input){
            case "title":
                books.stream().sorted(Comparator.comparing(Article::getTitle))
                        .forEach(x -> System.out.println(x.toString()));
                break;
            case "content":
                books.stream().sorted(Comparator.comparing(Article::getContent))
                        .forEach(x -> System.out.println(x.toString()));
                break;
            case "author":
                books.stream().sorted(Comparator.comparing(Article::getAuthor))
                        .forEach(x -> System.out.println(x.toString()));
                break;
        }

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
