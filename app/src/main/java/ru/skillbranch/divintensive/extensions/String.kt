package ru.skillbranch.divintensive.extensions

fun String.truncate(value: Int = 16): String {
    if (this.length <= value) return this
    val strTrup = this.substring(0, value)
    return  if (strTrup.substring(value-1, value) == " ") strTrup.dropLast(1)+"..." else strTrup + "..."
}