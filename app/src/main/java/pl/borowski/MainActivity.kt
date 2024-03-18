package pl.borowski

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun babelkowe(view: View){
        var ciag = findViewById<EditText>(R.id.editTextText).text
        println(ciag)
        val przed = ciag.split(",").map { it.toInt() }.toIntArray()
        findViewById<TextView>(R.id.przedTekst).text = przed.joinToString()
        val wynik = bubbleSort(przed)
        println(wynik)
        findViewById<TextView>(R.id.poTekst).text = wynik.joinToString()
        val babelkoweOpis = "Algorytm sortowania bąbelkowego jest jednym z najstarszych algorytmów sortujących. Zasada działania opiera się na cyklicznym porównywaniu par sąsiadujących elementów i zamianie ich kolejności w przypadku niespełnienia kryterium porządkowego zbioru. Operację tę wykonujemy dotąd, aż cały zbiór zostanie posortowany."
        findViewById<TextView>(R.id.opis).text = babelkoweOpis
    }

    private fun bubbleSort(tablica: IntArray): IntArray {
        val n = tablica.size
        var czyBylaZmiana: Boolean
        do {
            czyBylaZmiana = false
            for (i in 1 until n) {
                if (tablica[i - 1] > tablica[i]) {
                    val temp = tablica[i]
                    tablica[i] = tablica[i - 1]
                    tablica[i - 1] = temp
                    czyBylaZmiana = true
                }
            }
        } while (czyBylaZmiana)
        return tablica
    }

    fun wstawianie(view: View){
        var ciag = findViewById<EditText>(R.id.editTextText).text
        val przed = ciag.split(",").map { it.toInt() }.toIntArray()
        findViewById<TextView>(R.id.przedTekst).text = przed.joinToString()
        val wynik = insertionSort(przed)
        println(wynik)
        findViewById<TextView>(R.id.poTekst).text = wynik.joinToString()
        val wstawianieOpis = "Algorytm sortowania przez wstawianie, podczas iteracji wstawia każdy element na jego właściwą pozycję. Przy każdej iteracji element jest porównywany ze wcześniejszymi elementami, aż do znalezienia prawidłowej pozycji, następnie elementy po lewej stronie są przesuwane, aby zrobić miejsce dla nowego elementu."
        findViewById<TextView>(R.id.opis).text = wstawianieOpis
    }

    private fun insertionSort(arr: IntArray): IntArray {
        val rozmiar = arr.size
        for (i in 1 until rozmiar) {
            val klucz = arr[i]
            var j = i - 1

            while (j >= 0 && arr[j] > klucz) {
                arr[j + 1] = arr[j]
                j -= 1
            }
            arr[j + 1] = klucz
        }
        return arr
    }
}