import java.time.Year;

public abstract class ContentItem {
    protected int id;
    protected static int idGen = 1;
    protected String title;
    protected int year;
    protected int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id = idGen++;
        setTitle(title);
        setYear(year);
        setDurationMinutes(durationMinutes);
    }

    public int getAge(int currentYear) { return currentYear - year; }
    public abstract double getLicenseCost(int currentYear);

    public void setTitle(String title) {
        if (title == null || title.isBlank()) throw new IllegalArgumentException();
        this.title = title;
    }
    public void setYear(int year) {
        int now = Year.now().getValue();
        if (year < 1990 || year > now) throw new IllegalArgumentException();
        this.year = year;
    }
    public void setDurationMinutes(int d) {
        if (d <= 0) throw new IllegalArgumentException();
        this.durationMinutes = d;
    }

    @Override
    public String toString() {
        return "id=" + id + ", title=" + title + ", year=" + year +
                ", duration=" + durationMinutes;
    }
}
