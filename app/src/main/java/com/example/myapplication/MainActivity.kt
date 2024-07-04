package com.example.myapplication


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBtn.setOnClickListener{
            calculateBMI()
        }

    }
   private fun calculateBMI(){
       val weight= binding.weigthEdit.text.toString().toFloatOrNull()
       val height= binding.heightEdit.text.toString().toFloatOrNull()

       if (weight != null && height != null){
           val bmi= weight/ (height/100).pow(2)
           val bmiResult = String.format("%.2f",bmi)

           val bmiCategory = when{
               bmi < 18.5 -> "Sottopeso"
               bmi < 25 -> "Normopeso"
               bmi < 30 -> "Sovrappeso"
               else -> "Obesità"
           }
           binding.resultText.text = "BMI: $bmiResult\nCategoria: $bmiCategory"
       } else {
           binding.resultText.text = "Invalid input"
       }

   }
}
