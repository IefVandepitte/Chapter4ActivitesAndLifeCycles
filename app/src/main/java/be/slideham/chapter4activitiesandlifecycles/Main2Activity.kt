package be.slideham.chapter4activitiesandlifecycles

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private val TAG = Main2Activity::class.java.simpleName
    private val COUNTER = "counter"
    var counter = 0

    private fun bindListenerToButton() {
        toAct1Button.setOnClickListener{

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        StopActivity2.setOnClickListener{
            finish()
        }
    }

    private fun incrementAndShowCounter(){
        counter++
        textView2.text = counter.toString()
    }

    private fun logAndDisplay (functionName : String){
        Log.i(TAG, functionName + " called.")
        incrementAndShowCounter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        logAndDisplay("onCreate")
        bindListenerToButton()

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
