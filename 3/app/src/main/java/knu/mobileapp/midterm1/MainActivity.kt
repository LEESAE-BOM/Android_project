package knu.mobileapp.midterm1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var baseLayout: LinearLayout
    lateinit var button8: Button
    lateinit var text: TextView

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)

        var minflater=menuInflater
        minflater.inflate(R.menu.menu1,menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseLayout= findViewById<LinearLayout>(R.id.layout)
        button8=findViewById<Button>(R.id.but8)
        text=findViewById<TextView>(R.id.textView1)
        registerForContextMenu(button8)
    }
    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo? ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        var mInflater = this.menuInflater
        if (v === button8) {
            mInflater.inflate(R.menu.menu2, menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemRed-> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            R.id.subRotate->{
                button8.rotation = 45f
                return true
            }

        }
        return false
    }
    override fun onContextItemSelected(item: MenuItem) : Boolean {
        when(item.itemId){
            R.id.context1-> {
                Toast.makeText(applicationContext,
                    "헬로, 월드!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.context2->{
                text.setTextColor(Color.BLUE)
                return true
            }

        }
        return false
    }
}