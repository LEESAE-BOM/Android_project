package knu.mobileapp.midterm2

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var graphicLayout : LinearLayout
    lateinit var graphicView: MyGraphicView

    lateinit var but1: Button
    lateinit var but2: Button
    companion object {
        const val CIRCLE = 1
        const val RECTANGLE = 2
        var curShape = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        graphicLayout = findViewById<LinearLayout>(R.id.graphicLayout)
        graphicView= MyGraphicView(this)
        graphicLayout.addView(graphicView)
        but1= findViewById<Button>(R.id.button1)
        but2= findViewById<Button>(R.id.button2)
        but1.setOnClickListener{
            curShape=1
        }
        but2.setOnClickListener{
            curShape=2
        }

    }

    class MyGraphicView(context: Context) : View(context) {

        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)

            var x= this.width/2f
            var y= this.height/2f

            var ax= this.width/1f
            var ay= this.height/1f

            var paint = Paint()
            paint.isAntiAlias = true
            paint.color = Color.RED
            paint.strokeWidth = 5f

            canvas.drawCircle(x, x, x, paint)

            when (curShape) {
                CIRCLE ->{
                    canvas.drawCircle(x,x, x, paint)
                }
                RECTANGLE -> {
                    this.invalidate()
                    val path = Path()
                    path.moveTo(0f,ay)
                    path.lineTo(0f+ax,ay+ax)
                    path.lineTo(0f+ax/2,0f)
                    path.lineTo(0f,ay)
                    canvas.drawPath(path, paint)
                }
            }
        }
    }
}