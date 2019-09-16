package geekbrains.ru.lesson1mvc;

public class Presenter
{
    Model model;
    private MainView view;

    public Presenter(MainView view){
        model = new Model();
        this.view = view;
    }

    private void updateNewElementValue(int idx, int id){
        int newValue = model.getElementValueAtIndex(idx) + 1;
        model.setElementValueAtIndex(idx, newValue);
        view.setButtonText(id, newValue);
    }

    public void onClick(int id) {
        switch (id){
            case R.id.btnCounter1:
                updateNewElementValue(0, id);
                break;
            case R.id.btnCounter2:
                updateNewElementValue(1, id);
                break;
            case R.id.btnCounter3:
                updateNewElementValue(2, id);
                break;
        }
    }
}
