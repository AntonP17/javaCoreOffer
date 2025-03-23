package tasks;

public class Testing {
    public static void main(String[] args) {
        CustomStringBuilder stringBuilder = new CustomStringBuilder();

        stringBuilder.append("Hello");
        stringBuilder.append(" ");
        stringBuilder.append("World");
        stringBuilder.append("!");
        stringBuilder.append("How are you?");

        System.out.println("current state: " + stringBuilder.getText());

        stringBuilder.undo();
        System.out.println("current state after undo 1: " + stringBuilder.getText());
        stringBuilder.undo();
        System.out.println("current state after undo 2: " + stringBuilder.getText());
        stringBuilder.undo();
        System.out.println("current state after undo 3: " + stringBuilder.getText());

        stringBuilder.redo();
        System.out.println("current state after redo 1: " + stringBuilder.getText());
        stringBuilder.redo();
        System.out.println("current state after redo 2: " + stringBuilder.getText());
        stringBuilder.redo();
        System.out.println("current state after redo 3: " + stringBuilder.getText());

    }
}

