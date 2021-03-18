package compulsory;

import java.time.LocalTime;

public class Movie extends Item {
    int duration;
    int year;
    String genre;

    //constructor

    public Movie() {
        super();
    }

    public Movie(String id, String name, String path, int duration, int year, String genre) throws InvalidItemData {
        this.setId(id);
        this.setName(name);
        this.setLocation(path);
        this.setDuration(duration);
        this.setYear(year);
        this.setGenre(genre);
    }

    //setters and getters

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) throws InvalidItemData {
        if (duration < 0) throw new InvalidItemData(" negative number for duration.");
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws InvalidItemData {
        if (year > 2020 || year < 0) throw new InvalidItemData("wrong year.");
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) throws InvalidItemData {
        if (genre == null) throw new InvalidItemData(" no genre added.");
        this.genre = genre;
    }

    @Override
    public String toString() {
        return  "duration=" + duration +
                ", year=" + year +
                ", genre='" + genre + '\'';
    }
}
