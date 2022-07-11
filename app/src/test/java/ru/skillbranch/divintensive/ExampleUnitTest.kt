package ru.skillbranch.divintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.divintensive.models.User
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
//      val user2 = User.makeUser( "Михаил Лермонтов")
//      val user3 = User.makeUser( "Лев Толстой")
//      val user4 = User.makeUser( "Новиков")
//      val user5 = User.makeUser( null)
//        user.printMe()
//        user2.printMe()
//        user3.printMe()
//        user4.printMe()
//        user5.printMe()
        println(user)

    }
}