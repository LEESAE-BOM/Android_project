package knu.mobileapp.finalexam1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.second)

        var inIntent = intent
        var hapValue = inIntent.getIntExtra("Num1", 0) +
                inIntent.getIntExtra("Num2", 0)

        var btnResult = findViewById<Button>(R.id.btnResult)
        var textResult = findViewById<TextView>(R.id.result)

        btnResult.setOnClickListener {
            textResult.text=hapValue.toString()
        }

        var btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            var outIntent = Intent(applicationContext, MainActivity::class.java)
            outIntent.putExtra("Hap", hapValue)
            setResult(Activity.RESULT_OK, outIntent)
            finish()
        }
    }
}