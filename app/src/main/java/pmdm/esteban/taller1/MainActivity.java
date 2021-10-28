package pmdm.esteban.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TODO: Atributos
    private int cont;
    private TextView tvDisplay;
    private Button buttonIncrease, buttonDecrease, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUi();
    }

    //TODO: Función SetUI, obtener los elementos a utilizar

    private void setUi() {

        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonReset = findViewById(R.id.buttonReset);


        //Listeners para que se ejecuten en la funcion implementada en la activity

        buttonIncrease.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);

    }

    //TODO: Función onClick, Eventos click de los botones
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonIncrease:
                cont++;
                break;
            case R.id.buttonDecrease:
                cont--;
                break;
            case R.id.buttonReset:
                cont = 0;
                break;
        }

        tvDisplay.setText(getString(R.string.number_of_elements)+ ": "+cont);
    }
}