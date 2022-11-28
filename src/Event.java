public abstract class Event {
    public String title;
    public int age;
    public int releaseYear;

    public Event(String title, int age, int releaseYear){
        this.title = title;
        this.age = age;
        this.releaseYear = releaseYear;
    }

    public String toString() {
       String text = title + " " + age + " " + releaseYear;
        return text;
    }
}
