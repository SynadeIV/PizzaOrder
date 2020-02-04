package com.example.pizzaorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Pizza pizza;
    TextView textRecap;
    TextView textCrusty;
    TextView textOrder;
    Spinner spinner1;
    Switch switch1;

    public static final String EXTRA_MESSAGE = "com.example.pizzaorder.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.pizzaname, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        pizza = new Pizza();
        textRecap = findViewById(R.id.textRecap);
        textCrusty = findViewById(R.id.textCrusty);
    }

    public void sendOrder(View view) {

        Intent intent = new Intent(this, RecapOrder.class);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        Switch switch1 = (Switch) findViewById(R.id.switch1);
        String crusty2 = switch1.getText().toString();
        String choice = spinner1.getSelectedItem().toString();
        String message = choice + " " + pizza.getCheese() + " " + pizza.getBacon() + " " + /*crusty2*/ pizza.getCrusty() + " " + "test";
        //String message = pizza.toString() <----choix possible mais toString a changer.---->

        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
        //String pizza = spinner1.getSelectedItem().toString();
        //intent.putExtra(EXTRA_MESSAGE, pizza);
        /*TextView textOrder = (TextView) findViewById(R.id.textOrder);*/



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void boxChecked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.checkBox:
                if(checked)
                    pizza.setCheese(" Add Cheese ");
                else
                    pizza.setCheese("");
                break;
            case R.id.checkBox2:
                 if(checked)
                     pizza.setBacon(" Add Bacon ");
                 else
                     pizza.setBacon("");
                 break;
             }
             textRecap.setText("   " + pizza.getBacon() + pizza.getCheese());
        }


   public void onSwitch(View view){
       Switch switch1 = (Switch) view;
       if(switch1.isChecked())
           textCrusty.setText("Add Crusty cheese !");
       else
           textCrusty.setText("");

    }

}


