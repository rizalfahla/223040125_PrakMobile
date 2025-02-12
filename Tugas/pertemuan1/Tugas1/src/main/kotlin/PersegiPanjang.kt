class PersegiPanjang(val panjang: Int, val lebar: Int) {
    fun hitungLuas(): Int {
        return panjang * lebar
    }

    fun hitungKeliling(): Int {
        return 2 * (panjang + lebar)
    }
}
fun main(args: Array<String>) {
    if (args.size < 2) {
        println("Error: Masukkan nilai panjang dan lebar")
        return
    }

    try {
        val panjang = args[0].toInt()
        val lebar = args[1].toInt()

        val persegiPanjang = PersegiPanjang(panjang, lebar)
        println("Panjang: ${persegiPanjang.panjang}")
        println("Lebar: ${persegiPanjang.lebar}")
        println("Luas: ${persegiPanjang.hitungLuas()}")
        println("Keliling: ${persegiPanjang.hitungKeliling()}")
    } catch (e: NumberFormatException) {
        println("Error: harus berupa angka")
    }
}