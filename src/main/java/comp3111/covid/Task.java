package comp3111.covid;

import javafx.beans.property.*;

public class Task {
	private ReadOnlyStringWrapper name = new ReadOnlyStringWrapper();
    private BooleanProperty selected = new SimpleBooleanProperty(false);

    public Task(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }
    public ReadOnlyStringProperty nameProperty() {
        return name.getReadOnlyProperty();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }
    public boolean isSelected() {
        return selected.get();
    }
    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }
}
