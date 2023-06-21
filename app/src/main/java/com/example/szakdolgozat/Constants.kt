package com.example.szakdolgozat

object Constants {

    fun getQuestions(): ArrayList<Kerdes> {
        val kerdesLista = ArrayList<Kerdes>()

        // 1
        val que1 = Kerdes(
            1, "Milyen mély a Balaton legmélyebb pontja?",
            "3 méter", "12,5 méter",
            "10 méter", "6 méter", 2
        )

        kerdesLista.add(que1)

        // 2
        val que2 = Kerdes(
            2, "Hány méteresre tud megnőni a harcsa?",
            "2,5 méter", "4 méter",
            "1 méter", "70 centiméter", 1
        )

        kerdesLista.add(que2)

        // 3
        val que3 = Kerdes(
            3, "Hány éve alakult ki a mai is ismert Balaton?",
            "kb 15-17 ezer év", "2023 év",
            "kb 5000 év", "kb 4000 év", 3
        )

        kerdesLista.add(que3)

        // 4
        val que4 = Kerdes(
            4, "Hogy hívják a veddisznó kicsinyét?",
            "malac", "kan",
            "koca", "disznó", 1
        )

        kerdesLista.add(que4)

        // 5
        val que5 = Kerdes(
            5, "Hogy hívják a muflon fején található csontképződményt?",
            "szarv", "agancs",
            "tülök", "agyar", 1
        )

        kerdesLista.add(que5)

        // 6
        val que6 = Kerdes(
            6, "Hány állatfaj él a Balatonban és annak környékén?",
            "63", "256",
            "1930", "1400", 4
        )

        kerdesLista.add(que6)

        // 7
        val que7 = Kerdes(
            7, "Az alábbiak közül melyik madár fokozottan védett?",
            "Kis vöcsök", "Barna rétihéja",
            "Üstökös réce", "Jégmadár", 3
        )

        kerdesLista.add(que7)

        // 8
        val que8 = Kerdes(
            8, "Ki szentelte fel a Zalaszántón található Béke Sztúpát?",
            "XIV. Benedek pápa", "Ferenc pápa",
            "XVI. Benedek pápa", "XIV. Dalai Láma", 4
        )

        kerdesLista.add(que8)

        // 9
        val que9 = Kerdes(
            9, "Milyen hosszú a Balaton partszakasza?",
            "42 km", "195 km",
            "79 km", "594 km", 2
        )

        kerdesLista.add(que9)

        // 10
        val que10 = Kerdes(
            10, "A felsoroltak közül melyik NEM ragadozóhal?",
            "compó", "csuka",
            "balin", "fogassüllő", 1
        )

        kerdesLista.add(que10)

        return kerdesLista
    }

}