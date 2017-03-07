package com.example.danelly.eva1_3_idioma;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
public class Principal extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton rbEsp, rbIng;
    TextView txtNom, txtApe;
    SharedPreferences shPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rbEsp = (RadioButton) findViewById(R.id.rbEsp);
        rbIng = (RadioButton) findViewById(R.id.rbIng);
        txtNom = (EditText) findViewById(R.id.txtN);
        txtApe = (EditText) findViewById(R.id.txtApe);
        shPref = getSharedPreferences("Datos", Activity.MODE_PRIVATE);
        boolean rbEspan = shPref.getBoolean("b1", false);
        boolean rbIngle = shPref.getBoolean("b2", true);
    }

    public void onRadioButtonClicked(View view) { // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();// Check which radio button was clicked
        SharedPreferences.Editor edtDatos = shPref.edit();
        switch(view.getId()) {
            case R.id.rbEsp: {
                txtApe.setText(R.string.Apellido);
                txtNom.setText(R.string.Nombre);
                break;
            }
                    case R.id.rbIng:{
                        txtNom.setText(R.string.Name);
                        txtApe.setText(R.string.Last_Name);
                        break;

                    }
                }
        }
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor edtDatos = shPref.edit();
        edtDatos.putBoolean("b1", rbEsp.isChecked());
        edtDatos.putBoolean("b2", rbIng.isChecked());
        edtDatos.commit();
    }
}
