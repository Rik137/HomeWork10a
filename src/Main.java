class Main {
    public static void main(String[] args)throws NullPointerException  {

        for (Event event: getMovies()) {
            validEvent(event);
        }
        for (Event event: getTheatres()) {
            validEvent(event);
        }
        System.out.println("Все события корректны");
    }
    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Начало", 16, 2000),
                new Movie(null, 0, 90)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Донкий Хот", 100, 0)
        };
    }
    public static void validEvent(Event event) throws NullPointerException{
        if(event.title == null || event.age == 0 || event.releaseYear == 0) {
            throw new NullPointerException("Некорректные события оброти внимания -> " + event.toString());
        }
    }
}