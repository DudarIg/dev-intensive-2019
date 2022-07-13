package ru.skillbranch.divintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.divintensive.extensions.TimesUnits
import ru.skillbranch.divintensive.extensions.add
import ru.skillbranch.divintensive.extensions.humanizeDiff
import ru.skillbranch.divintensive.models.User
import ru.skillbranch.divintensive.utils.Utils
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2", "Сергей", "Иванов")
        val user3 = User("3", "Александр", "Синица",
                                                        lastVisit = Date(), isOnline = true)

        user.printMe()
        user2.printMe()
        user3.printMe()
        println("$user $user2 $user3")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser( "Александр Пушкин")
        println(user)
        val user1 = User("21","Алексей", "Сидоров", lastVisit = Date())
        val user2 = user1.copy(lastName = "Сергей", firstName = "Лазарев", lastVisit = Date().add(10, TimesUnits.MINUTE))
        val user3 = user1.copy(lastName = "Толстой", firstName = "Лев", lastVisit = Date().add(-2, TimesUnits.HOUR))
        user1.printMe()
        user2.printMe()
        user3.printMe()

        println("${Utils.toInitials(user1.firstName, user1.lastName)}")
        println("${Utils.toInitials(user2.firstName, user2.lastName)}")
        println("${Utils.toInitials(user3.firstName, user3.lastName)}")
    }

    @Test
    fun test_initials() {
        println("${Utils.toInitials("fdsdfs", "bvcvbc")}")
        println("${Utils.toInitials("", "bvcvbc")}")
        println("${Utils.toInitials("fdsdfs", "")}")
        println("${Utils.toInitials("fdsdfs", null)}")
        println("${Utils.toInitials(null,"fdsdfs")}")
        println("${Utils.toInitials("","")}")
        println("${Utils.toInitials(null,null)}")

//        val user = User.makeUser( "Александр Пушкин")
//        println(user)
//        val user1 = User("21","Алексей", "Сидоров", lastVisit = Date())
//        val user2 = user1.copy(lastName = "Сергей", firstName = "Лазарев", lastVisit = Date().add(10, TimesUnits.MINUTE))
//        val user3 = user1.copy(lastName = "Толстой", firstName = "Лев", lastVisit = Date().add(-2, TimesUnits.HOUR))
//        user1.printMe()
//        user2.printMe()
//        user3.printMe()

        println(Utils.transliteration("Иванов Сергей"))
        println(Utils.transliteration("Петров Александр", "_"))
    }

    @Test
    fun test_data() {

        // Date().humanizeDiff()
         println("${Date().add(-455, TimesUnits.MINUTE).humanizeDiff()}")
    }
}
