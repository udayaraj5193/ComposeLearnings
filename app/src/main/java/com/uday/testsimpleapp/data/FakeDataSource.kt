package com.uday.testsimpleapp.data

import kotlin.collections.listOf

class FakeDataSource {

    fun getUsers(): List<User> {
        return listOf(
            User("name1", "9101919191", "some@gmail.com", "https://picsum.photos/200"),
            User("name1", "9101919191", "some@gmail.com", "https://picsum.photos/200"),
            User("name1", "9101919191", "some@gmail.com", "https://picsum.photos/200"),
            User("name1", "9101919191", "some@gmail.com", "https://picsum.photos/200"),
            User("name1", "9101919191", "some@gmail.com", "https://picsum.photos/200"),
        )
    }
}