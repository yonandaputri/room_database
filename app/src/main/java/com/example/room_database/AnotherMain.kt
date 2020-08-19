package com.example.room_database

fun main() {
    val car = Car("Terios", "Daihatsu")
    println(car.name)
    println(car.brand)
    //bukan bagian dari object car, tidak mengubah object apapun
//    println(Car.penumpang)
    //hasilnya akan sama
    //masuk ke return terakhir karena nilainya null
    val terios = Car.getSingleCar()
    //masuk ke return if karena nilainya !=null
    val rush = Car.getSingleCar()
    println(terios)
    println(rush)
}

class Car(var name: String, var brand: String) {
    companion object {
        private var SINGLE_CAR: Car? = null

        //        var penumpang = "Dinda"
        fun getSingleCar(): Car? {
            if (SINGLE_CAR != null) {
                return SINGLE_CAR
            }
            SINGLE_CAR = Car("", "")
            return SINGLE_CAR
        }
    }
}