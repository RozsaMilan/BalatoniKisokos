package com.example.szakdolgozat

import kotlin.random.Random

class GameManager {

    private var felhasznaltBetu: String = ""
    private lateinit var alahuzottSzo: String
    private lateinit var megfejtes: String
    private val probakSzama = 9
    private var jelenlegiProba = 0
    private var kep: Int = R.drawable.alap

    fun ujJatek(): GameState {
        felhasznaltBetu = ""
        jelenlegiProba = 0
        kep = R.drawable.halal
        val randomIndex = Random.nextInt(0, GameConstants.words.size)
        megfejtes = GameConstants.words[randomIndex]
        alapGeneralas(megfejtes)
        return jatekAllapot()
    }

    fun alapGeneralas(word: String) {
        val sb = StringBuilder()
        word.forEach { char ->
            if (char == '/') {
                sb.append('/')
            } else {
                sb.append("_")
            }
        }
        alahuzottSzo = sb.toString()
    }

    fun jatek(betu: Char): GameState {
        if (felhasznaltBetu.contains(betu)) {
            return GameState.Running(felhasznaltBetu, alahuzottSzo, kep)
        }

        felhasznaltBetu += betu
        val indexek = mutableListOf<Int>()

        megfejtes.forEachIndexed { index, char ->
            if (char.equals(betu, true)) {
                indexek.add(index)
            }
        }

        var atmenetiAlahuzott = "" + alahuzottSzo
        indexek.forEach { index ->
            val sb = StringBuilder(atmenetiAlahuzott).also { it.setCharAt(index, betu) }
            atmenetiAlahuzott = sb.toString()
        }

        if (indexek.isEmpty()) {
            jelenlegiProba++
        }

        alahuzottSzo = atmenetiAlahuzott
        return jatekAllapot()
    }

    private fun kepCsere(): Int {
        return when (jelenlegiProba) {
            0 -> R.drawable.alap
            1 -> R.drawable.oszlop
            2 -> R.drawable.kereszt
            3 -> R.drawable.kotel
            4 -> R.drawable.fej
            5 -> R.drawable.test
            6 -> R.drawable.kar1
            7 -> R.drawable.kar2
            8 -> R.drawable.lab1
            9 -> R.drawable.halal
            else -> R.drawable.halal
        }
    }

    private fun jatekAllapot(): GameState {
        if (alahuzottSzo.equals(megfejtes, true)) {
            return GameState.Won(megfejtes)
        }

        if (jelenlegiProba == probakSzama) {
            return GameState.Lost(megfejtes)
        }

        kep = kepCsere()
        return GameState.Running(felhasznaltBetu, alahuzottSzo, kep)
    }

}