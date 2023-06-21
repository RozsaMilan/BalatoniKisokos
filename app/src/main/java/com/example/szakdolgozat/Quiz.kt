package com.example.szakdolgozat


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Quiz : AppCompatActivity(), View.OnClickListener {

    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView? = null
    private var kerdesTV:TextView? = null
    private var option1TV:TextView? = null
    private var option2TV:TextView? = null
    private var option3TV:TextView? = null
    private var option4TV:TextView? = null
    private var bekuldBtn: Button? = null


    private var pozicio: Int = 1
    private var kerdesLista: ArrayList<Kerdes>? = null

    private var selectedOption: Int = 0
    private var helyesValaszok: Int = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)


        progressBar=findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        kerdesTV = findViewById(R.id.tv_question)
        option1TV = findViewById(R.id.tv_option_one)
        option2TV = findViewById(R.id.tv_option_two)
        option3TV = findViewById(R.id.tv_option_three)
        option4TV = findViewById(R.id.tv_option_four)

        bekuldBtn = findViewById(R.id.btn_submit)
        kerdesLista = Constants.getQuestions()

        setQuestion()

        option1TV?.setOnClickListener(this)
        option2TV?.setOnClickListener(this)
        option3TV?.setOnClickListener(this)
        option4TV?.setOnClickListener(this)

        bekuldBtn?.setOnClickListener (this)
    }


    private fun setQuestion() {

        val kerdes: Kerdes =
            kerdesLista!![pozicio - 1]
        defaultOptionsView()

        if (pozicio == kerdesLista!!.size) {
            bekuldBtn?.text = "BEFEJEZ"
        } else {
            bekuldBtn?.text = "BEKÜLD"
        }

        progressBar?.progress =
            pozicio
        tvProgress?.text =
            "$pozicio" + "/" + progressBar?.max


        kerdesTV?.text = kerdes.question
        option1TV?.text = kerdes.optionOne
        option2TV?.text = kerdes.optionTwo
        option3TV?.text = kerdes.optionThree
        option4TV?.text = kerdes.optionFour
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.tv_option_one -> {
                option1TV?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option_two -> {
                option2TV?.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.tv_option_three -> {
                option3TV?.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.tv_option_four -> {
                option4TV?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btn_submit->{
                if (selectedOption == 0) {
                    pozicio++
                    when {
                        pozicio <= kerdesLista!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this,Eredmeny::class.java)
                            intent.putExtra("points", helyesValaszok.toString())
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = kerdesLista?.get(pozicio - 1)
                    if (question!!.correctAnswer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_option_border_bg)
                    }
                    else {
                        helyesValaszok++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (pozicio == kerdesLista!!.size) {
                        bekuldBtn?.text = "Befejez"
                    } else {
                        bekuldBtn?.text = "Következő kérdés"
                    }

                    selectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                option1TV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                option2TV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                option3TV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                option4TV?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {

        defaultOptionsView()
        selectedOption = selectedOptionNum
        tv.setTextColor(
            Color.parseColor("#363A43")
        )
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }


    private fun defaultOptionsView() {

        val options = ArrayList<TextView>()
        option1TV?.let {
            options.add(0, it)
        }
        option2TV?.let {
            options.add(1, it)
        }
        option3TV?.let {
            options.add(2, it)
        }
        option4TV?.let {
            options.add(3,it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
}