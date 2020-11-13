package com.techdoctorbd.bangladateconverter

object DateConverter {

    //English Month's length
    private const val MONTH_LENGTH_JANUARY = 31
    private var MONTH_LENGTH_FEBRUARY = 28
    private const val MONTH_LENGTH_MARCH = 31
    private const val MONTH_LENGTH_APRIL = 30
    private const val MONTH_LENGTH_MAY = 31
    private const val MONTH_LENGTH_JUNE = 30
    private const val MONTH_LENGTH_JULY = 31
    private const val MONTH_LENGTH_AUGUST = 31
    private const val MONTH_LENGTH_SEPTEMBER = 30
    private const val MONTH_LENGTH_OCTOBER = 31
    private const val MONTH_LENGTH_NOVEMBER = 30
    private const val MONTH_LENGTH_DECEMBER = 31

    //Bangla month's start date in english month's
    private const val MAGH_START_IN_JANUARY = 15
    private const val FALGUN_START_IN_FEBRUARY = 14
    private const val CHOITRO_START_IN_MARCH = 15
    private const val BOISHAKH_START_IN_APRIL = 14
    private const val JOSTHO_START_IN_MAY = 15
    private const val ASHAR_START_IN_JUNE = 15
    private const val SRABON_START_IN_JULY = 16
    private const val VADRO_START_IN_AUGUST = 16
    private const val ASSHIN_START_IN_SEPTEMBER = 16
    private var KARTIK_START_IN_OCTOBER = 16
    private const val AGROHAYON_START_IN_NOVEMBER = 16
    private const val POUSH_START_IN_DECEMBER = 16

    private val monthNames = arrayOf("বৈশাখ", "জ্যৈষ্ঠ", "আষাঢ়", "শ্রাবণ", "ভাদ্র", "আশ্বিন", "কার্তিক", "অগ্রহায়ণ", "পৌষ", "মাঘ", "ফাল্গুন", "চৈত্র")

    private val dayNames = arrayOf("শনিবার", "রবিবার", "সোমবার", "মঙ্গলবার", "বুধবার", "বৃহস্পতিবার", "শুক্রবার")

    private val banglaDigits = arrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
    private val englishDigits = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')

    fun getDateInBangla(date: Int, month: Int, year: Int, dayName: String): String? {
        var banglaDate: String? = null
        var yearInt: Int? = null
        val banglaDateInt: Int?
        var count = 0

        //For Bangla year calculation
        for (position in 1900..2100) {
            if (position == year) {
                yearInt = 1307 + count
                break
            }
            count++
        }

        //To find leap year
        for (position in 1900..2100 step 4) {
            if (position == year) {
                MONTH_LENGTH_FEBRUARY = 29
                break
            } else {
                MONTH_LENGTH_FEBRUARY = 28
            }
        }


        /*The length of Ashwin month is 30 days every year but in 2020 the length of Ashwin month is 31 days that's why I use this condition to check that*/
        KARTIK_START_IN_OCTOBER = if (year == 2020) 17 else 16

        if (month == 1 && date < MAGH_START_IN_JANUARY) {

            banglaDateInt = (MONTH_LENGTH_DECEMBER - (POUSH_START_IN_DECEMBER - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[8]} ${yearInt!! - 1}"

        } else if (month == 1 && date >= MAGH_START_IN_JANUARY) {

            banglaDateInt = date - (MAGH_START_IN_JANUARY - 1)
            banglaDate = "$banglaDateInt ${monthNames[9]} ${yearInt!! - 1}"

        } else if (month == 2 && date < FALGUN_START_IN_FEBRUARY) {

            banglaDateInt = (MONTH_LENGTH_JANUARY - (MAGH_START_IN_JANUARY - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[9]} ${yearInt!! - 1}"

        } else if (month == 2 && date >= FALGUN_START_IN_FEBRUARY) {

            banglaDateInt = date - (FALGUN_START_IN_FEBRUARY - 1)
            banglaDate = "$banglaDateInt ${monthNames[10]} ${yearInt!! - 1}"

        } else if (month == 3 && date < CHOITRO_START_IN_MARCH) {

            banglaDateInt = (MONTH_LENGTH_FEBRUARY - (FALGUN_START_IN_FEBRUARY - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[10]} ${yearInt!! - 1}"

        } else if (month == 3 && date >= CHOITRO_START_IN_MARCH) {

            banglaDateInt = date - (CHOITRO_START_IN_MARCH - 1)
            banglaDate = "$banglaDateInt ${monthNames[11]} ${yearInt!! - 1}"

        } else if (month == 4 && date < BOISHAKH_START_IN_APRIL) {

            banglaDateInt = (MONTH_LENGTH_MARCH - (CHOITRO_START_IN_MARCH - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[11]} ${yearInt!! - 1}"

        } else if (month == 4 && date >= BOISHAKH_START_IN_APRIL) {

            banglaDateInt = date - (BOISHAKH_START_IN_APRIL - 1)
            banglaDate = "$banglaDateInt ${monthNames[0]} $yearInt"

        } else if (month == 5 && date < JOSTHO_START_IN_MAY) {

            banglaDateInt = (MONTH_LENGTH_APRIL - (BOISHAKH_START_IN_APRIL - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[0]} $yearInt"

        } else if (month == 5 && date >= JOSTHO_START_IN_MAY) {

            banglaDateInt = date - (JOSTHO_START_IN_MAY - 1)
            banglaDate = "$banglaDateInt ${monthNames[1]} $yearInt"

        } else if (month == 6 && date < ASHAR_START_IN_JUNE) {

            banglaDateInt = (MONTH_LENGTH_MAY - (JOSTHO_START_IN_MAY - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[1]} $yearInt"

        } else if (month == 6 && date >= ASHAR_START_IN_JUNE) {

            banglaDateInt = date - (ASHAR_START_IN_JUNE - 1)
            banglaDate = "$banglaDateInt ${monthNames[2]} $yearInt"

        } else if (month == 7 && date < SRABON_START_IN_JULY) {

            banglaDateInt = (MONTH_LENGTH_JUNE - (ASHAR_START_IN_JUNE - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[2]} $yearInt"

        } else if (month == 7 && date >= SRABON_START_IN_JULY) {

            banglaDateInt = date - (SRABON_START_IN_JULY - 1)
            banglaDate = "$banglaDateInt ${monthNames[3]} $yearInt"

        } else if (month == 8 && date < VADRO_START_IN_AUGUST) {

            banglaDateInt = (MONTH_LENGTH_JULY - (SRABON_START_IN_JULY - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[3]} $yearInt"

        } else if (month == 8 && date >= VADRO_START_IN_AUGUST) {

            banglaDateInt = date - (VADRO_START_IN_AUGUST - 1)
            banglaDate = "$banglaDateInt ${monthNames[4]} $yearInt"

        } else if (month == 9 && date < ASSHIN_START_IN_SEPTEMBER) {

            banglaDateInt = (MONTH_LENGTH_AUGUST - (VADRO_START_IN_AUGUST - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[4]} $yearInt"

        } else if (month == 9 && date >= ASSHIN_START_IN_SEPTEMBER) {

            banglaDateInt = date - (ASSHIN_START_IN_SEPTEMBER - 1)
            banglaDate = "$banglaDateInt ${monthNames[5]} $yearInt"

        } else if (month == 10 && date < KARTIK_START_IN_OCTOBER) {

            banglaDateInt = (MONTH_LENGTH_SEPTEMBER - (ASSHIN_START_IN_SEPTEMBER - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[5]} $yearInt"

        } else if (month == 10 && date >= KARTIK_START_IN_OCTOBER) {

            banglaDateInt = date - (KARTIK_START_IN_OCTOBER - 1)
            banglaDate = "$banglaDateInt ${monthNames[6]} $yearInt"

        } else if (month == 11 && date < AGROHAYON_START_IN_NOVEMBER) {

            banglaDateInt = (MONTH_LENGTH_OCTOBER - (KARTIK_START_IN_OCTOBER - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[6]} $yearInt"

        } else if (month == 11 && date >= AGROHAYON_START_IN_NOVEMBER) {

            banglaDateInt = date - (AGROHAYON_START_IN_NOVEMBER - 1)
            banglaDate = "$banglaDateInt ${monthNames[7]} $yearInt"

        } else if (month == 12 && date < POUSH_START_IN_DECEMBER) {

            banglaDateInt = (MONTH_LENGTH_NOVEMBER - (AGROHAYON_START_IN_NOVEMBER - 1)) + date
            banglaDate = "$banglaDateInt ${monthNames[7]} $yearInt"

        } else if (month == 12 && date >= POUSH_START_IN_DECEMBER) {

            banglaDateInt = date - (POUSH_START_IN_DECEMBER - 1)
            banglaDate = "$banglaDateInt ${monthNames[8]} $yearInt"

        }
        return "${convertStringToBangla(banglaDate!!)} , ${getDayNamesInBangla(dayName)}"
    }

    private fun convertStringToBangla(string: String): String? {
        var resultString = ""
        var replaceableChar: Char

        for (position in string.indices) {
            val char = string[position]
            replaceableChar = if (char in englishDigits) {
                val index = englishDigits.indexOf(char)
                banglaDigits[index]
            } else {
                char
            }

            resultString += replaceableChar
        }

        return resultString
    }

    private fun getDayNamesInBangla(dayName: String): String? {
        return when (dayName) {
            "saturday" -> dayNames[0]
            "sunday" -> dayNames[1]
            "monday" -> dayNames[2]
            "tuesday" -> dayNames[3]
            "wednesday" -> dayNames[4]
            "thursday" -> dayNames[5]
            "friday" -> dayNames[6]
            else -> ""
        }
    }
}