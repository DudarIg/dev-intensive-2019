package ru.skillbranch.divintensive.models

import ru.skillbranch.divintensive.utils.Utils
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String? = null,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
    ) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String): this(id, "Jooin", "Doo $id")
    init {
        println("Инициализация...\n $firstName $lastName \n" +
                "${getIntro()}")

    }

    private fun getIntro(): String = """
        try try try
        
        Ура! Ура! Ура!!!        
    """.trimIndent()

    fun printMe(): Unit = println("""
                        id: $id  
                        firstName: $firstName  
                        lastName: $lastName  
                        avatar: $avatar  
                        rating: $rating  
                        respect: $respect  
                        lastVisit: $lastVisit  
                        isOnline: $isOnline                  
                 """.trimIndent())

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            fullName?.let  {
                val (firstName, lastName) = Utils.parseFullName(fullName)
                return  User(id="$lastId", firstName = firstName , lastName = lastName )
            }
            return User(id="$lastId", firstName = "" , lastName = "" )
        }
    }


}