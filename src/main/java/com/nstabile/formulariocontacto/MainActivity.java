package com.nstabile.formulariocontacto;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button btn_picker_birthdate, btn_next;
    private EditText et_fullname, et_phonenumber, et_emailadress, et_description;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    private int year, month, day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_fullname = findViewById(R.id.et_fullname);
        et_phonenumber = findViewById(R.id.et_phonenumber);
        et_emailadress = findViewById(R.id.et_emailadress);
        et_description = findViewById(R.id.et_description);
        btn_picker_birthdate = findViewById(R.id.btn_picker_birthdate);
        btn_next = findViewById(R.id.btn_next);

        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        btn_picker_birthdate.setText(day+"/"+(month + 1)+"/"+year);

        btn_picker_birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, R.style.PickerTheme, onDateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1;
                day = i2;
                btn_picker_birthdate.setText(day+"/"+(month + 1)+"/"+year);
            }
        };

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DetalleContactoActivity.class);
                i.putExtra("fullName", et_fullname.getText().toString());
                i.putExtra("birthDate", day+"/"+(month + 1)+"/"+year);
                i.putExtra("phoneNumber", et_phonenumber.getText().toString());
                i.putExtra("emailAdress", et_emailadress.getText().toString());
                i.putExtra("description", et_description.getText().toString());

                startActivity(i);
            }
        });

    }
}
