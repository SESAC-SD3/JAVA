package d.inheritance.practice02;

class Movie {
    String title;
    double rating;

    public Movie(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Rating: " + rating);
    }
}

class Action extends Movie {
    String specialEffects;

    public Action(String title, double rating, String specialEffects) {
        super(title, rating);
        this.specialEffects = specialEffects;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Special Effects: " + specialEffects);
    }
}
class Comedy extends Movie {
    String humorStyle;

    public Comedy(String title, double rating, String humorStyle) {
        super(title, rating);
        this.humorStyle = humorStyle;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Humor Style: " + humorStyle);
    }
}

class Drama extends Movie {
    String theme;

    public Drama(String title, double rating, String theme) {
        super(title, rating);
        this.theme = theme;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Theme: " + theme);
    }
}


public class Practice02 {
    public static void main(String[] args) {
        Movie[] movies = {
                new Action("어벤져스", 4.5, "최고급 CG"),
                new Comedy("극한직업", 4.7, "상황 코미디"),
                new Drama("기생충", 4.9, "계급 갈등")
        };

        for (Movie movie : movies) {
            movie.displayInfo();
        }
    }
}
