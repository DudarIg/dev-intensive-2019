package ru.skillbranch.divintensive.utils

object Utils {
    val map = mapOf ( "а" to "a","б" to "b","в" to "v","г" to "g","д" to "d","е" to "e","ё" to "e",
        "ж" to "zh","з" to "z","и" to "i","й" to "i","к" to "k","л" to "l","м" to "m","н" to "n",
        "о" to "o","п" to "p","р" to "r","с" to "s","т" to "t","у" to "u","ф" to "f","х" to "h",
        "ц" to "c","ч" to "ch","ш" to "sh","щ" to "sh'","ъ" to "","ы" to "i","ь" to "","э" to "e",
        "ю" to "yu","я" to "ya")

    fun transliteration(payload: String, divider: String = " "): String {
        var latName = ""
        val masLat = mutableListOf<String>()
        val listPayload = payload.toList()
        for (i in listPayload) {
            latName += map.getOrElse(i.toString().lowercase()) {divider}
        }
        val listString = latName.split(divider)

        for (i in listString) {
            masLat.add(i.substring(0, 1).uppercase() + i.substring(1))
        }
        latName = masLat.joinToString(separator = divider)

        return latName
    }

    fun parseFullName(fullName: String): Pair<String?, String?> {
        val parts: List<String> = fullName.split(" ")
        val firstName = parts.getOrElse(0, {""})
        val lastName = parts.getOrElse(1, {""})
        return Pair(firstName, lastName)
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        var initials: String? = null
        firstName?.let {
            initials = if (it.length>0)  firstName.first().uppercase() else ""
        }
        lastName?.let {
            if (initials != null)
                initials += if (it.length>0)  lastName.first().uppercase() else ""
            else
                initials = if (it.length>0)  lastName.first().uppercase() else ""
        }
        if (initials?.length == 0)
            initials = null
        return initials
    }
}
