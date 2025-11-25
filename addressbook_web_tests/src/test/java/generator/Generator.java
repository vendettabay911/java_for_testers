package generator;

public class Generator {
    public static void main(String[] args) {
        new Generator().run();
    }

    private void run() {
        var data = generate();
        save(data);
    }

    private Object generate() {
        return null;
    }

    private void save(Object data) {
    }
}
