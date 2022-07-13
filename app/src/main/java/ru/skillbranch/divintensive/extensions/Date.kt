package ru.skillbranch.divintensive.extensions


import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.humanizeDiff(): String {
    val visitDate = this.time
    val tekDate =Date().time
    val times = ((tekDate - visitDate) / 1000L).toInt()
    val mm : Int
    val fraza = when(times) {
        in 0..1 -> "только что"
        in 2..45 -> "несколько секунд назад"
        in 46..75 -> "минуту назад"
        in 75..45 * 60 -> {  mm = (times/60).toInt()
                                if (mm==2 || mm==3 || mm == 4) "$mm минуты назад" else "$mm минут назад" }
        in 45*60..75*60 -> "час назад"
        in 75*60..22*3600 -> {  mm = (times/3600).toInt()
                                if (mm==2 || mm==3 || mm == 4) "$mm часа назад" else "$mm часов назад" }
        in 22*3600..26*3600 -> "день назад"
        in 26*3600..360*86400 -> {  mm = (times/86400).toInt()
            if (mm==2 || mm==3 || mm == 4) "$mm дня назад" else "$mm дней назад" }
        else -> "более года назад"
    }
    return fraza
}


fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimesUnits = TimesUnits.SECOND): Date {
    var time = this.time
    time += when(units) {
        TimesUnits.SECOND -> value * SECOND
        TimesUnits.MINUTE -> value * MINUTE
        TimesUnits.HOUR -> value * HOUR
        TimesUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

enum class TimesUnits {
    SECOND, MINUTE, HOUR, DAY
}

fun String.truncate(value: Int = 16): String {
    if (this.length <= value) return this
    val strTrup = this.substring(0, value)
    return  if (strTrup.substring(value-1, value) == " ") strTrup.dropLast(1)+"..." else strTrup + "..."
}