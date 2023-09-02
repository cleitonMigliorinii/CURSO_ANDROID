package br.edu.utfpr.trocatela

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.net.URI

class ConfirmarActivity : AppCompatActivity() {

    private  lateinit var  etCode: TextView;
    private  lateinit var  etQtd: TextView;
    private  lateinit var  etValor: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmar)

        etCode = findViewById(R.id.etCodConfirmar)
        etQtd = findViewById(R.id.etQtdeConfirmar)
        etValor = findViewById(R.id.etValorConfirmar)

        etCode.setText(intent.getStringExtra("cod"))
        etQtd.setText(intent.getStringExtra("qtd"))
        etValor.setText(intent.getStringExtra("valor"))
    }

    fun btConfirmarConfirmarOnClick(view: View) {

        val sms =  "Cod = ${etCode.text.toString()}  -  Qtde = ${etQtd.text.toString()}  - Valor = ${etValor.text.toString()}  -"

        val uri = Uri.parse("smsto:+5546991056342")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("address", "+554691056342");
        intent.putExtra("sms_body", sms);

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
                //Getting the default sms app.
                val defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this)

                // Can be null in case that there is no default, then the user would be able to choose
                // any app that support this intent.
                if (defaultSmsPackageName != null) intent.setPackage(defaultSmsPackageName)

                startActivity(intent)
            }
            else -> startActivity(intent)
        }


    }
}