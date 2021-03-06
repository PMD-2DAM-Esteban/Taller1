package pmdm.esteban.taller1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //TODO: Atributos
    private int cont;
    private TextView tvDisplay;
    private Button buttonIncrease, buttonDecrease, buttonReset, buttonIncrease2, buttonDecrease2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUi();
        //TODO: Si hay instancia guardada obtiene el texto y lo añade de nuevo
        if (savedInstanceState!=null) {

            String textoContador= savedInstanceState.getString("contador");
            CharSequence cs= textoContador;
            tvDisplay.setText(cs);

        }
    }

    //TODO: Función SetUI, obtener los elementos a utilizar

    private void setUi() {

        tvDisplay = findViewById(R.id.tvDisplay);
        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonDecrease = findViewById(R.id.buttonDecrease);
        buttonReset = findViewById(R.id.buttonReset);
        buttonIncrease2= findViewById(R.id.buttonIncrease2);
        buttonDecrease2=findViewById(R.id.buttonDecrease2);


        //Listeners para que se ejecuten en la funcion implementada en la activity

        buttonIncrease.setOnClickListener(this);
        buttonDecrease.setOnClickListener(this);
        buttonReset.setOnClickListener(this);
        buttonIncrease2.setOnClickListener(this);
        buttonDecrease2.setOnClickListener(this);

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
            case R.id.buttonIncrease2:
                cont=cont+2;
                break;
            case R.id.buttonDecrease2:
                cont=cont-2;
                break;
        }

        tvDisplay.setText(getString(R.string.number_of_elements)+ ": "+cont);
    }
    //TODO: Fucion onSaveInstance
    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String texto= (String) tvDisplay.getText();
        savedInstanceState.putString("contador", texto);

    }
}