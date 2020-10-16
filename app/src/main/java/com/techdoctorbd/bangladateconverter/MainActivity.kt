package com.techdoctorbd.bangladateconverter

import android.app.DatePickerDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var mYear: Int? = 0
    private var mMonth: Int? = 0
    private var mDay: Int? = 0
    private var currentDate: Int? = 0
    private var currentMonth: Int? = 0
    private var currentYear: Int? = 0
    private var dateSetListenerCurrent: DatePickerDialog.OnDateSetListener? = null
    private var dayOfWeek = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val calendarForCurrent = Calendar.getInstance()
        val simpleDateFormat = SimpleDateFormat("dd - MMMM - yyyy , EEEE", Locale.getDefault())
        val dateFormatForDay = SimpleDateFormat("EEEE", Locale.getDefault())

        val date = calendarForCurrent[Calendar.DAY_OF_MONTH]
        Log.d("Date: ", "$date")
        val month = calendarForCurrent[Calendar.MONTH]
        Log.d("Month: ", "$month")
        val year = calendarForCurrent[Calendar.YEAR]
        Log.d("Year: ", "$year")
        dayOfWeek = dateFormatForDay.format(calendarForCurrent.time).toString().toLowerCase(Locale.getDefault())
        Log.d("Day of Week: ", dayOfWeek)


        tv_date_english.text = simpleDateFormat.format(calendarForCurrent.time)

        val resultText = DateConverter.getDateInBangla(date, month + 1, year, dayOfWeek)
        tv_date_bangla.text = resultText
        /*Toast.makeText(
            this,
            "Bangla : ${DateConverter.convertStringToBangla(resultText!!)}",
            Toast.LENGTH_SHORT
        ).show()*/

        tv_date_english.setOnClickListener {
            val c = Calendar.getInstance()
            if (currentDate == 0) {
                mYear = c[Calendar.YEAR]
                mMonth = c[Calendar.MONTH]
                mDay = c[Calendar.DAY_OF_MONTH]
            } else {
                mDay = currentDate
                mMonth = currentMonth
                mYear = currentYear
            }
            val datePickerDialog = DatePickerDialog(
                    this@MainActivity,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    dateSetListenerCurrent, mYear!!, mMonth!!, mDay!!
            )

            datePickerDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            datePickerDialog.show()
        }

        dateSetListenerCurrent = DatePickerDialog.OnDateSetListener { _, i, i1, i2 ->
            calendarForCurrent.set(i, i1, i2)
            currentDate = calendarForCurrent.get(Calendar.DAY_OF_MONTH)
            currentMonth = calendarForCurrent.get(Calendar.MONTH)
            currentYear = calendarForCurrent.get(Calendar.YEAR)
            dayOfWeek = dateFormatForDay.format(calendarForCurrent.time).toString().toLowerCase(Locale.getDefault())
            Log.d("Day of Week: ", dayOfWeek)
            tv_date_english.text = simpleDateFormat.format(calendarForCurrent.time)
            tv_date_bangla.text =
                    DateConverter.getDateInBangla(currentDate!!, currentMonth!! + 1, currentYear!!, dayOfWeek)

        }

    }
}