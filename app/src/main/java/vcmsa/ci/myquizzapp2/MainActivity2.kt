package vcmsa.ci.myquizzapp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

   private val questions = arrayOf(
       "Nelson Mandela became president in 1994.",
       "Robben island is not the place where mandela was imprisoned.",
       "The soweto uprising took place on june 16 1976",
       "jan van riebeeck did not colonize south africa",
       "Nelson mandela was a kick boxer"

   )
   private val answers = arrayOf(true, false, true, false , false)
    private var currentQuestionIndex = 0
    private var score = 0

    private lateinit var txtQuestion: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        txtQuestion = findViewById(R.id.txtQuestion)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        displayQuestion()

        btnTrue.setOnClickListener {
            checkAnswer(true)
        }

        btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        btnNext.setOnClickListener {
            if (currentQuestionIndex < questions.size - 1) {
                currentQuestionIndex++
                displayQuestion()
            }else{
                val intent = Intent(this,MainActivity3::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }







        }












        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun displayQuestion() {
        txtQuestion.text = questions[currentQuestionIndex]
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentQuestionIndex]){
            score++
            Toast.makeText(this, "Correct!",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, "Inccorect",Toast.LENGTH_SHORT).show()


        }
    }
}