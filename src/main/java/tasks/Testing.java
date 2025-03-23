package tasks;

public class Testing {
    public static void main(String[] args) {
        CustomStringBuilder stringBuilder = new CustomStringBuilder();
        StringBuilderCaretaker caretaker = new StringBuilderCaretaker();

        stringBuilder.append("Hello , how are you ..");
        caretaker.saveState(stringBuilder);

        stringBuilder.append("I am fine , how about you ?");
        System.out.println("Current state: " + stringBuilder.getText());

        caretaker.undo(stringBuilder);
        System.out.println("Restored state: " + stringBuilder.getText());

    }
}

