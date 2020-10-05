package com.nstabile.formulariocontacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContactoActivity extends AppCompatActivity {

    private TextView tv_fullname, tv_birthdate, tv_phonenumber, tv_emailadress, tv_description;
    private Button btn_editcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detalle de Contacto");

        tv_fullname = findViewById(R.id.tv_fullname);
        tv_birthdate = findViewById(R.id.tv_birthdate);
        tv_phonenumber = findViewById(R.id.tv_phonenumber);
        tv_emailadress = findViewById(R.id.tv_emailadress);
        tv_description = findViewById(R.id.tv_description);

        btn_editcontact = findViewById(R.id.btn_editcontact);

        Bundle bundle = getIntent().getExtras();
        String fullName = bundle.getString("fullName");
        String birthDate = bundle.getString("birthDate");
        String phoneNumber = bundle.getString("phoneNumber");
        String emailAdress = bundle.getString("emailAdress");
        String description = bundle.getString("description");

        tv_fullname.setText(fullName);
        tv_birthdate.setText("Fecha nacimiento: " + birthDate);
        tv_phonenumber.setText("Tel.: " + phoneNumber);
        tv_emailadress.setText("E-mail: " + emailAdress);
        tv_description.setText("Descripción: " + description);

        btn_editcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
