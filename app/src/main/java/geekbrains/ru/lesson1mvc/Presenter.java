package geekbrains.ru.lesson1mvc;

public class Presenter
{
    Model model;
    private MainView view;

    public Presenter(MainView view){
        model = new Model();
        this.view = view;
    }

    private void updateNewElementValue(int idx){
        int newValue = model.getElementValueAtIndex(idx) + 1;
        model.setElementValueAtIndex(idx, newValue);
        view.setButtonText(idx, newValue);
    }

    public void onClick(int idx) {
        updateNewElementValue(idx);
    }
}
