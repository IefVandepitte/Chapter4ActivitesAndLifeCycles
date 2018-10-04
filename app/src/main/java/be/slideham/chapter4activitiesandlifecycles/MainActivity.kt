package be.slideham.chapter4activitiesandlifecycles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity to show lifecycle methods
 * easy to track with a filter on the logcat
 * I/MainActivity level info
 */

class MainActivity : AppCompatActivity() {

    private val TAG= MainActivity::class.java.simpleName
    private val COUNTER = "counter"
    var counter = 0


    private fun incrementAndShowCounter(){
        counter++
        lifeCycleCounterTextView.text = counter.toString()
    }

    private fun logAndDisplay (functionName : String){
        Log.i(TAG, functionName + " called.")
        incrementAndShowCounter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logAndDisplay("onCreate")
        powerUpButtons()

    }

    private fun powerUpButtons() {
        toAct2Button.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
        stopButton1.setOnClickListener{
            finish()
        }
    }


    override fun onStart() {
        super.onStart()

        logAndDisplay("onStart")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        logAndDisplay("onRestoreInstanceState")
        if (savedInstanceState != null) counter = savedInstanceState.get(COUNTER) as Int
        lifeCycleCounterTextView.text = counter.toString()

    }

    override fun onResume() {
        super.onResume()

        logAndDisplay("onResume")

    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        logAndDisplay("onSaveInstanceState")
        if (outState != null) {
            outState.putInt(COUNTER, counter)
        }
    }



    override fun onPause() {
        super.onPause()

        logAndDisplay("onPause")
    }

    override fun onStop() {
        super.onStop()

        logAndDisplay("onStop")

    }

    override fun onRestart() {
        super.onRestart()

        logAndDisplay("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        logAndDisplay("onDestroy")
    }






}
