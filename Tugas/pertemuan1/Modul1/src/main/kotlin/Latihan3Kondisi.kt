package Modul1

fun main() {
//    var umur: Int = 25
//    if (umur >= 18) {
//        println("Anda sudah dewasa")
//    } else {
//        println("Anda belum dewasa")
//    }
    var umur = 17
    when (umur) {
        in 0..17 -> println("Anda masih anak-anak")
        else -> println("Anda sudah dewasa")
    }
}