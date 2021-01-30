package com.example.eighthours

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.widget.Button
import java.util.*

class MainActivity : AppCompatActivity() {

    fun set_alarm(x_hours: Int, y_minutes: Int){
        val c = Calendar.getInstance()
        var hour = (c.get(Calendar.HOUR_OF_DAY) + x_hours) % 24
        var minute = c.get(Calendar.MINUTE)
        if (minute + y_minutes > 60){
            hour = (hour+1) % 24
        }
        minute = (minute+y_minutes) % 60

        val openNewAlarm = Intent(AlarmClock.ACTION_SET_ALARM)
        openNewAlarm.putExtra(AlarmClock.EXTRA_HOUR, hour)
        openNewAlarm.putExtra(AlarmClock.EXTRA_MINUTES, minute)
        startActivity(openNewAlarm)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val seven_point_five_hours_button = findViewById<Button>(R.id.seven_point_five_hours_button)
        val eight_hours_of_sleep_button = findViewById<Button>(R.id.eight_hours_button)
        val eight_point_five_hours_button = findViewById<Button>(R.id.eight_point_five_hours_button)
        val nine_hours_button = findViewById<Button>(R.id.nine_hours_button)

        seven_point_five_hours_button.setOnClickListener { view ->
        set_alarm(7, 30)
    }

    eight_hours_of_sleep_button.setOnClickListener { view ->
        set_alarm(8, 0)
    }

    eight_point_five_hours_button.setOnClickListener { view ->
        set_alarm(8, 30)
    }

    nine_hours_button.setOnClickListener { view ->
        set_alarm(9, 0)
    }

    }
}
