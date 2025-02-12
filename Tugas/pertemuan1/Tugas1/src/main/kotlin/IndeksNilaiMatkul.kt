
class IndeksNilaiMatkul {
    fun hitungIndeks(nilai: Int?): String {
        return when {
            nilai == null -> "Nilai harus diisi"
            nilai in 80..100 -> "A"
            nilai in 70..79 -> "AB"
            nilai in 60..69 -> "B"
            nilai in 50..59 -> "BC"
            nilai in 40..49 -> "C"
            nilai in 30..39 -> "D"
            nilai in 0..29 -> "E"
            nilai > 100 -> "Nilai di luar jangkauan"
            nilai < 0 -> "Nilai di luar jangkauan"
            else -> "Nilai tidak valid"
        }
    }
}

fun main(args: Array<String>) {
    val indeksNilaiMatkul = IndeksNilaiMatkul()
    println("No\tInput\tOutput")
    for (i in args.indices) {
        val input = args[i]
        val nilai = input.toIntOrNull()
        val indeks = indeksNilaiMatkul.hitungIndeks(nilai)
        println("${i + 1}\t${input}\t${indeks}")
    }
    if (args.isEmpty()) {
        println("1\t{kosong}\tNilai harus diisi")
    }
}