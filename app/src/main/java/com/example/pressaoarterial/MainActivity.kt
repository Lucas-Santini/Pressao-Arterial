package com.example.pressaoarterial
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCheckPressure = findViewById<Button>(R.id.btnCheckPressure)
        val etSystolic = findViewById<EditText>(R.id.etSystolic)
        val etDiastolic = findViewById<EditText>(R.id.etDiastolic)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCheckPressure.setOnClickListener {
            val systolic = etSystolic.text.toString().toInt()
            val diastolic = etDiastolic.text.toString().toInt()

            val classification = classifyPressure(systolic, diastolic)

            if (classification == "Normal") {
                tvResult.text = "TUDO NORMAL. PARABÉNS!"
            } else {
                tvResult.text = "VALORES INADEQUADOS. PROCURE AUXÍLIO MÉDICO."
            }
        }
    }

    private fun classifyPressure(systolic: Int, diastolic: Int): String {
        return when {
            systolic < 120 && diastolic < 80 -> "Ótima"
            systolic < 130 && diastolic < 85 -> "Normal"
            systolic in 130..139 && diastolic in 85..89 -> "Limítrofe"
            systolic in 140..159 && diastolic in 90..99 -> "Hipertenção estágio 1"
            systolic in 160..179 && diastolic in 100..109 -> "Hipertenção estágio 2"
            else -> "Hipertenção estágio 3"
        }
    }
}
