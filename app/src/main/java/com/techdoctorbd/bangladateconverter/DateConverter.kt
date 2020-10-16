package com.techdoctorbd.bangladateconverter

object DateConverter {

    private const val MONTH_LENGTH_JANUARY = 31
    private const val MONTH_LENGTH_FEBRUARY = 28
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

    private val monthNames = arrayOf(
            "বৈশাখ",
            "জ্যৈষ্ঠ",
            "আষাঢ়",
            "শ্রাবণ",
            "ভাদ্র",
            "আশ্বিন",
            "কার্তিক",
            "অগ্রহায়ণ",
            "পৌষ",
            "মাঘ",
            "ফাল্গুন",
            "চৈত্র"
    )

    private val dayNames = arrayOf("শনিবার", "রবিবার", "সোমবার", "মঙ্গলবার", "বুধবার", "বৃহস্পতিবার", "শুক্রবার")

    fun getDateInBangla(date: Int, month: Int, year: Int, dayName: String): String? {
        var monthName: String? = null
        var yearInt: Int? = null
        var count = 0

        for (position in 1900..2100) {
            if (position == year) {
                yearInt = 1307 + count
                break
            }
            count++
        }

        if (month == 1 && date < 15) {
            monthName = "${(MONTH_LENGTH_DECEMBER - 15) + date} ${monthNames[8]} $yearInt"
        } else if (month == 1 && date >= 15) {
            monthName = "${(date - 14)} ${monthNames[9]} $yearInt"
        } else if (month == 2 && date < 14) {
            monthName = "${(MONTH_LENGTH_JANUARY - 14) + date} ${monthNames[9]} $yearInt"
        } else if (month == 2 && date >= 14) {
            monthName = "${(date - 13)} ${monthNames[10]} $yearInt"
        } else if (month == 3 && date < 15) {
            monthName = "${(MONTH_LENGTH_FEBRUARY - 13) + date} ${monthNames[10]} $yearInt"
        } else if (month == 3 && date >= 15) {
            monthName = "${(date - 14)} ${monthNames[11]} $yearInt"
        } else if (month == 4 && date < 14) {
            monthName = "${(MONTH_LENGTH_MARCH - 14) + date} ${monthNames[11]} $yearInt"
        } else if (month == 4 && date >= 14) {
            monthName = "${(date - 13)} ${monthNames[0]} $yearInt"
        } else if (month == 5 && date < 15) {
            monthName = "${(MONTH_LENGTH_APRIL - 13) + date} ${monthNames[0]} $yearInt"
        } else if (month == 5 && date >= 15) {
            monthName = "${(date - 14)} ${monthNames[1]} $yearInt"
        } else if (month == 6 && date < 15) {
            monthName = "${(MONTH_LENGTH_MAY - 14) + date} ${monthNames[1]} $yearInt"
        } else if (month == 6 && date >= 15) {
            monthName = "${(date - 14)} ${monthNames[2]} $yearInt"
        } else if (month == 7 && date < 16) {
            monthName = "${(MONTH_LENGTH_JUNE - 14) + date} ${monthNames[2]} $yearInt"
        } else if (month == 7 && date >= 16) {
            monthName = "${(date - 15)} ${monthNames[3]} $yearInt"
        } else if (month == 8 && date < 16) {
            monthName = "${(MONTH_LENGTH_JULY - 15) + date} ${monthNames[3]} $yearInt"
        } else if (month == 8 && date >= 16) {
            monthName = "${(date - 15)} ${monthNames[4]} $yearInt"
        } else if (month == 9 && date < 16) {
            monthName = "${(MONTH_LENGTH_AUGUST - 15) + date} ${monthNames[4]} $yearInt"
        } else if (month == 9 && date >= 16) {
            monthName = "${(date - 15)} ${monthNames[5]} $yearInt"
        } else if (month == 10 && date < 17) {
            monthName = "${(MONTH_LENGTH_SEPTEMBER - 15) + date} ${monthNames[5]} $yearInt"
        } else if (month == 10 && date >= 17) {
            monthName = "${(date - 16)} ${monthNames[6]} $yearInt"
        } else if (month == 11 && date < 16) {
            monthName = "${(MONTH_LENGTH_OCTOBER - 16) + date} ${monthNames[6]} $yearInt"
        } else if (month == 11 && date >= 16) {
            monthName = "${(date - 15)} ${monthNames[7]} $yearInt"
        } else if (month == 12 && date < 16) {
            monthName = "${(MONTH_LENGTH_NOVEMBER - 15) + date} ${monthNames[7]} $yearInt"
        } else if (month == 12 && date >= 16) {
            monthName = "${(date - 15)} ${monthNames[8]} $yearInt"
        }
        return "${convertStringToBangla(monthName!!)} , ${getDayNamesInBangla(dayName)}"
    }

    private fun convertStringToBangla(string: String): String? {
        val banglaNumbers = arrayOf('০', '১', '২', '৩', '৪', '৫', '৬', '৭', '৮', '৯')
        val englishNumbers = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        var resultString = ""
        var replaceableChar: Char

        for (position in string.indices) {
            val char = string[position]
            replaceableChar = if (char in englishNumbers) {
                val index = englishNumbers.indexOf(char)
                banglaNumbers[index]
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