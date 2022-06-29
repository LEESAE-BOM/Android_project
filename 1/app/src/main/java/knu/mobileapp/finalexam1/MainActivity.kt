package knu.mobileapp.finalexam1

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnNewActivity = findViewById<Button>(R.id.btnNewActivity)

        btnNewActivity.setOnClickListener {
            var edtNum1 = findViewById<EditText>(R.id.edtNum1)
            var edtNum2 = findViewById<EditText>(R.id.edtNum2)

            var intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("Num1", Integer.parseInt(edtNum1.text.toString()))
            intent.putExtra("Num2", Integer.parseInt(edtNum2.text.toString()))
            startActivityForResult(intent, 0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            var hap = data!!.getIntExtra("Hap", 0)
            Toast.makeText(applicationContext, "Goodbye!", Toast.LENGTH_SHORT).show()
        }
    }
}