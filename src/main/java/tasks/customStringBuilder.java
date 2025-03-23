package tasks;

//Originator
public class customStringBuilder {

    private String text;

    public customStringBuilder() {
        this.text = "";
    }

    public customStringBuilder(String text) {
        this.text = text;
    }

    public void append(String s) {
        this.text += s;
    }

    public String getText() {
        return this.text;
    }

    public StringBuilderMemento save() {
        return new StringBuilderMemento(this.text);
    }

    public void restore(StringBuilderMemento memento) {
        this.text = memento.getState();
    }

     // Memento
    static class StringBuilderMemento {
        private final String state;

        public StringBuilderMemento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}

//Caretaker
class StringBuilderCaretaker {
    private customStringBuilder.StringBuilderMemento memento;

    public void saveState(customStringBuilder stringBuilder) {
        this.memento = stringBuilder.save();
    }

    public void undo(customStringBuilder stringBuilder) {
        if (this.memento != null) {
            stringBuilder.restore(this.memento);
        } else {
            System.out.println("No memento to restore.");
        }
    }
}