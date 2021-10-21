package ru.job4j.solid.lsp.example3;

public class MovieGoer {
    int age;
    Movie movie;

    public MovieGoer(int age, Movie movie) {
        validate(age, movie);
        this.age = age;
        this.movie = movie;
    }

    public void setMovie(Movie movie) {
        validate(age, movie);
        this.movie = movie;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private void validate(int age, Movie movie) {
        if ((age < 18) && movie.getRating().equals("18+")) {
            throw new IllegalArgumentException("Запрещено к просмотру!");
        }
        /*
        other checks ...
         */
    }

}
    class Movie {
        String rating;

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getRating() {
            return rating;
        }
    }

    /*
     Инвариант нарушен в классе Child.
     У потомка отсутствует валидация возроста рейтинга кино.
     Инварианты — все условия базового класса, должны быть
     сохранены и в подклассе.
     */
    class Child extends MovieGoer {

        public Child(int age, Movie movie) {
            super(age, movie);
        }

        /*
        Забыли сделать проверку в сеттере.
         */
        @Override
        public void setMovie(Movie movie) {
            this.movie = movie;
        }
    }

