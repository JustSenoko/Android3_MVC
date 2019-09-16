package geekbrains.ru.lesson1mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener{
        private Presenter presenter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ((Button) findViewById(R.id.btnCounter1)).setOnClickListener(this);
            ((Button) findViewById(R.id.btnCounter2)).setOnClickListener(this);
            ((Button) findViewById(R.id.btnCounter3)).setOnClickListener(this);
            presenter = new Presenter(this);
        }

        @Override
        public void onClick(View v) {
            presenter.onClick(v.getId());
        }

    @Override
    public void setButtonText(int id, int value) {
        Button button = (Button)findViewById(id);
        if(button == null){
            //print error
            //show toast with error
            //send event to analytic
            return;
        }
        button.setText("Количество = " + value);
    }
}

