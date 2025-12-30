import java.util.*;
import java.time.Year;


public class Main {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        List<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java OOP", 2024, 90, "HD"));
        items.add(new VideoLecture("Design Patterns", 2022, 120, "4K"));
        items.add(new PodcastEpisode("Tech Talk", 2023, 45, "Alice"));
        items.add(new PodcastEpisode("Dev Chat", 2021, 60, "Bob"));

        for (ContentItem item : items) {
            System.out.println(item + " | licenseCost=" +
                    item.getLicenseCost(currentYear));
            if (item instanceof Downloadable d) {
                d.download();
                System.out.println("max/day=" + d.getMaxDownloadsPerDay());
            }
        }
    }
}