package geekbrains.ru.lesson1mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    private Presenter presenter;
    private Map<Integer, Integer> idxMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.btnCounter1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnCounter2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btnCounter3)).setOnClickListener(this);
        initIdxMap();
        presenter = new Presenter(this);
    }

    private void initIdxMap() {
        idxMap.put(R.id.btnCounter1, 0);
        idxMap.put(R.id.btnCounter2, 1);
        idxMap.put(R.id.btnCounter3, 2);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Integer idx = idxMap.get(id);
        if (idx == null) {
            return;
        }
        presenter.onClick(idx);
    }

    @Override
    public void setButtonText(int idx, int value) {
        Integer id = getIdByIdx(idx);
        if (id == null) {
            return;
        }
        Button button = (Button) findViewById(id);
        if (button == null) {
            //print error
            //show toast with error
            //send event to analytic
            return;
        }
        button.setText("Количество = " + value);
    }

    private Integer getIdByIdx(int idx) {
        for (Map.Entry<Integer, Integer> entry : idxMap.entrySet()){
            if (entry.getValue() == idx) {
                return entry.getKey();
            }
        }

        return null;
    }
}

