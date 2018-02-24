package com.example.logonrm.testcomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNome;
    private EditText txtNumero;
    private RatingBar rtbEstrelas;
    private Switch swtDesliza;
    private CheckBox ckbSeleciona;
    private SeekBar skbVolume;
    private Spinner spnCombo;
    private RadioGroup rdgRadio;
    private Button btnBotao;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto = (TextView) findViewById(R.id.textView3);
        skbVolume = (SeekBar) findViewById(R.id.seekBar);
        skbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lblTexto.setText("" + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Valor Inicial: " + skbVolume.getProgress(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Valor Final: " + skbVolume.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });

        setRadioGroup();
        setCheckBox();
        setSwitch();

    }

    private String isCheckedToString(boolean isChecked) {
        return isChecked == true ? "SIM" : (isChecked == false ? "NÃO" : "SIM");
    }

    private void setRadioGroup() {
        rdgRadio = (RadioGroup) findViewById(R.id.radioGroup);

        rdgRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(MainActivity.this, "[RADIO] Texto: " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setCheckBox() {
        ckbSeleciona = (CheckBox) findViewById(R.id.checkBox);

        ckbSeleciona.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "[CHECKBOX] Marcado?: " + isCheckedToString(isChecked), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setSwitch() {

        swtDesliza = (Switch) findViewById(R.id.switch1);
        swtDesliza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "[SWITCH] Marcado?: " + isCheckedToString(isChecked), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
