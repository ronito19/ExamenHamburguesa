package com.example.examenhamburguesa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_HAMBURGUESA = "es.ronito19.MainActivity.hamburguesa";
    private static final String EXTRA_COMPLEMENTO = "es.ronito19.MainActivity.complemento";
    private EditText edt_hamburguesa = null;
    private EditText edt_complemento = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_hamburguesa = (EditText) findViewById(R.id.edt_hamburguesa);
        edt_complemento = (EditText) findViewById(R.id.edt_complemento);
    }

    public void siguiente(View view)
    {
       //recuperar el nombre de la hamburguesa y el complementop y validar que son correctos
       String hamburguesa = String.valueOf(edt_hamburguesa.getText());
       String complemento = String.valueOf(edt_complemento.getText());
       boolean errores = false;

       if(hamburguesa.isEmpty())
       {
           edt_hamburguesa.setError(" Debes introducir el nombre de una hamburguesa ");
           errores = true;
       }
       if(complemento.isEmpty())
       {
           edt_complemento.setError(" Debes introducir un complemento ");
           errores = true;
       }
       //-----------------------------------------------------------------------------------

        if(errores)
        {
            return;
        }
        //------------------------------------------------------------------------------------

        boolean hamburguesaOK = validarHamburguesa(hamburguesa);
        boolean complementoOK = validarComplemento(complemento);

        if(hamburguesaOK && complementoOK)
        {
            // aqui creo el Intent y mando a la pantalla 2
            Intent intent = new Intent(this, Ventana2.class);
            intent.putExtra(EXTRA_HAMBURGUESA, hamburguesa);
            intent.putExtra(EXTRA_COMPLEMENTO, complemento);
            startActivity(intent);
        }
        else
        {
            if(!hamburguesaOK)
            {
                edt_hamburguesa.setError(" Hamburguesa no valida, solamente tenemos 'mac pollo' y 'XXL' ");
            }
            if(!complementoOK)
            {
                edt_complemento.setError(" Complemento no valido, solamente tenemos 'patatas' y 'coca cola' ");
            }
        }
    }




    private boolean validarComplemento(String complemento)
    {
        if(complemento.equalsIgnoreCase("patatas") || complemento.equalsIgnoreCase("coca cola"))
        {
            return true;
        }
        return false;
    }






    private boolean validarHamburguesa(String hamburguesa)
    {
        if(hamburguesa.equalsIgnoreCase("Mac pollo") || hamburguesa.equalsIgnoreCase("XXL"))
        {
            return true;
        }
        return false;
    }
}