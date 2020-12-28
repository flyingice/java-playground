public class Apple {
    double unitPrice;
    Color color = Color.PINK;
    Category category = new Category();

    enum Color {
        RED, GREEN, PINK
    }

    class Category {
        String name = "";
    }
}
