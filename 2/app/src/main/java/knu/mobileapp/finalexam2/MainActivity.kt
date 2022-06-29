package knu.mobileapp.finalexam2

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var btn2: Button
    lateinit var pb1: ProgressBar
    lateinit var pb2: ProgressBar
    lateinit var tv1: TextView
    lateinit var tv2: TextView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        pb1 = findViewById<ProgressBar>(R.id.bar1)
        pb2 = findViewById<ProgressBar>(R.id.bar2)
        btn = findViewById<Button>(R.id.button1)
        btn2 = findViewById<Button>(R.id.button2)

        tv1 = findViewById<TextView>(R.id.text1)
        tv2 = findViewById<TextView>(R.id.text2)

        tv1.text = ("First Runner : " + 0 + "")
        tv2.text = ("Second Runner: " + 0 + "")

        btn.setOnClickListener {
            object : Thread() {
                override fun run() {
                    for(i in 0 .. 10 ) {
                        for (i in 0..100) {
                            runOnUiThread {
                                pb1.progress = pb1.progress + 1
                                tv1.text = ("First Runner : " + pb1.progress + "")

                            }
                            SystemClock.sleep(10)
                        }
                        SystemClock.sleep(100)
                    }
                }
            }.start()

            object : Thread() {
                override fun run() {
                    for(i in 0 .. 10 ) {
                        for (i in 0..100) {
                            runOnUiThread {
                                pb2.progress = pb2.progress + 1
                                tv2.text = ("Second Runner: " + pb2.progress + "")
                            }
                            SystemClock.sleep(20)
                        }
                        SystemClock.sleep(200)
                    }
                }
            }.start()
        }

        btn2.setOnClickListener {
            pb1.progress=0
            pb2.progress=0
        }

    }
}
