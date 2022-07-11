package ru.skillbranch.divintensive.utils

object Utils {
    fun parseFullName(fullName: String): Pair<String?, String?> {
        val parts: List<String> = fullName.split(" ")
        val firstName = parts.getOrElse(0, {""})
        val lastName = parts.getOrElse(1, {""})
        return Pair(firstName, lastName)
    }
}
