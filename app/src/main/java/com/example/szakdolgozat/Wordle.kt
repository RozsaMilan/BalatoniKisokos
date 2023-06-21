package com.example.szakdolgozat

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.szakdolgozat.databinding.ActivityWordleBinding
import kotlin.random.Random

class Wordle : AppCompatActivity() {

    private lateinit var binding: ActivityWordleBinding

    private val szoLista = WordleConstants.words

    private val randIndex = Random.nextInt(0,szoLista.size)

    private val szo = szoLista[randIndex]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWordleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        focus()

        binding.edt15.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt11,
                        binding.edt12,
                        binding.edt13,
                        binding.edt14,
                        binding.edt15
                    )
                }
            }

        })
        binding.edt25.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt21,
                        binding.edt22,
                        binding.edt23,
                        binding.edt24,
                        binding.edt25
                    )
                }
            }

        })
        binding.edt35.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt31,
                        binding.edt32,
                        binding.edt33,
                        binding.edt34,
                        binding.edt35
                    )
                }
            }

        })
        binding.edt45.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt41,
                        binding.edt42,
                        binding.edt43,
                        binding.edt44,
                        binding.edt45
                    )
                }
            }

        })
        binding.edt55.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt51,
                        binding.edt52,
                        binding.edt53,
                        binding.edt54,
                        binding.edt55
                    )
                }
            }

        })
        binding.edt65.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    ellenorzes(
                        binding.edt61,
                        binding.edt62,
                        binding.edt63,
                        binding.edt64,
                        binding.edt65
                    )
                }
            }

        })
    }


    private fun inaktivalas() {
        binding.edt11.isEnabled = false
        binding.edt12.isEnabled = false
        binding.edt13.isEnabled = false
        binding.edt14.isEnabled = false
        binding.edt15.isEnabled = false
        binding.edt21.isEnabled = false
        binding.edt22.isEnabled = false
        binding.edt23.isEnabled = false
        binding.edt24.isEnabled = false
        binding.edt25.isEnabled = false
        binding.edt31.isEnabled = false
        binding.edt32.isEnabled = false
        binding.edt33.isEnabled = false
        binding.edt34.isEnabled = false
        binding.edt35.isEnabled = false
        binding.edt41.isEnabled = false
        binding.edt42.isEnabled = false
        binding.edt43.isEnabled = false
        binding.edt44.isEnabled = false
        binding.edt45.isEnabled = false
        binding.edt51.isEnabled = false
        binding.edt52.isEnabled = false
        binding.edt53.isEnabled = false
        binding.edt54.isEnabled = false
        binding.edt61.isEnabled = false
        binding.edt62.isEnabled = false
        binding.edt63.isEnabled = false
        binding.edt64.isEnabled = false
        binding.edt65.isEnabled = false
    }

    private fun ellenorzes(
        edt1: EditText,
        edt2: EditText,
        edt3: EditText,
        edt4: EditText,
        edt5: EditText
    ) {
        val edt1Txt = edt1.text.toString()
        val edt2Txt = edt2.text.toString()
        val edt3Txt = edt3.text.toString()
        val edt4Txt = edt4.text.toString()
        val edt5Txt = edt5.text.toString()

        val karaketr1 = szo[0].toString()
        val karakter2 = szo[1].toString()
        val karakter3 = szo[2].toString()
        val karakter4 = szo[3].toString()
        val karakter5 = szo[4].toString()

        if (edt1Txt == karakter2 || edt1Txt == karakter3 || edt1Txt == karakter4 || edt1Txt == karakter5) {
            edt1.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if (edt2Txt == karaketr1 || edt2Txt == karakter3 || edt2Txt == karakter4 || edt2Txt == karakter5) {
            edt2.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if (edt3Txt == karaketr1 || edt3Txt == karakter2 || edt3Txt == karakter4 || edt3Txt == karakter5) {
            edt3.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if (edt4Txt == karaketr1 || edt4Txt == karakter2 || edt4Txt == karakter3 || edt4Txt == karakter5) {
            edt4.setBackgroundColor(Color.parseColor("#ffff00"))
        }
        if (edt5Txt == karaketr1 || edt5Txt == karakter2 || edt5Txt == karakter3 || edt5Txt == karakter4) {
            edt5.setBackgroundColor(Color.parseColor("#ffff00"))
        }

        if (edt1Txt == karaketr1) {
            edt1.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if (edt2Txt == karakter2) {
            edt2.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if (edt3Txt == karakter3) {
            edt3.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if (edt4Txt == karakter4) {
            edt4.setBackgroundColor(Color.parseColor("#33cc33"))
        }
        if (edt5Txt == karakter5) {
            edt5.setBackgroundColor(Color.parseColor("#33cc33"))
        }



        if (edt1Txt != karaketr1 && edt1Txt != karakter2 && edt1Txt != karakter3 && edt1Txt != karakter4 && edt1Txt != karakter5) {
            edt1.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt2Txt != karaketr1 && edt2Txt != karakter2 && edt2Txt != karakter3 && edt2Txt != karakter4 && edt2Txt != karakter5) {
            edt2.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt3Txt != karaketr1 && edt3Txt != karakter2 && edt3Txt != karakter3 && edt3Txt != karakter4 && edt3Txt != karakter5) {
            edt3.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt4Txt != karaketr1 && edt4Txt != karakter2 && edt4Txt != karakter3 && edt4Txt != karakter4 && edt4Txt != karakter5) {
            edt4.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt5Txt != karaketr1 && edt5Txt != karakter2 && edt5Txt != karakter3 && edt5Txt != karakter4 && edt5Txt != karakter5) {
            edt5.setBackgroundColor(Color.parseColor("#ff3333"))
        }

        if (edt1Txt == karaketr1 && edt2Txt == karakter2 && edt3Txt == karakter3 && edt4Txt == karakter4 && edt5Txt == karakter5) {
            binding.idTVCongo.text = "Gratulálok!\nKitaláltad a helyes szót!"
            binding.idTVCongo.visibility = View.VISIBLE
            inaktivalas()
            binding.newGameBtn.visibility = View.VISIBLE

            return
        }

        if (edt5.id == R.id.edt_65) {
            binding.idTVCongo.text = "Sajnos nem sikerült kitalálni a szót."
            binding.idTVCongo.visibility = View.VISIBLE
            inaktivalas()
            binding.newGameBtn.visibility = View.VISIBLE


        }
    }

    private fun focus() {
        ujKarakter(binding.edt11, binding.edt12)
        ujKarakter(binding.edt12, binding.edt13)
        ujKarakter(binding.edt13, binding.edt14)
        ujKarakter(binding.edt14, binding.edt15)

        ujKarakter(binding.edt21, binding.edt22)
        ujKarakter(binding.edt22, binding.edt23)
        ujKarakter(binding.edt23, binding.edt24)
        ujKarakter(binding.edt24, binding.edt25)

        ujKarakter(binding.edt31, binding.edt32)
        ujKarakter(binding.edt32, binding.edt33)
        ujKarakter(binding.edt33, binding.edt34)
        ujKarakter(binding.edt34, binding.edt35)

        ujKarakter(binding.edt41, binding.edt42)
        ujKarakter(binding.edt42, binding.edt43)
        ujKarakter(binding.edt43, binding.edt44)
        ujKarakter(binding.edt44, binding.edt45)

        ujKarakter(binding.edt51, binding.edt52)
        ujKarakter(binding.edt52, binding.edt53)
        ujKarakter(binding.edt53, binding.edt54)
        ujKarakter(binding.edt54, binding.edt55)

        ujKarakter(binding.edt61, binding.edt62)
        ujKarakter(binding.edt62, binding.edt63)
        ujKarakter(binding.edt63, binding.edt64)
        ujKarakter(binding.edt64, binding.edt65)
    }

    private fun ujKarakter(edt1: EditText, edt2: EditText) {
        edt1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    edt2.requestFocus()
                }
            }

        })
    }

    fun newGame(view: View) {
        startActivity(Intent(this,Wordle::class.java))
    }
}