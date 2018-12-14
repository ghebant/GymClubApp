package app.gymclubapp.recyclerViewComponents;

public class RecyclerViewItem {

    private String text;
    private String image;
    private int imageDrawableTMP;

    public RecyclerViewItem(String str, String img, int tmp) {
        text = str;
        image = img;
        imageDrawableTMP = tmp;
    }

    public int getImageDrawableTMP() {
        return imageDrawableTMP;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}
