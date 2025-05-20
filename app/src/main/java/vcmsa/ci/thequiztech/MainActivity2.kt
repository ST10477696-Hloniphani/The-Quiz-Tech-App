
/*
1.
The IIE, 2025.
Introduction To Mobile Application Development:
Arrays and Loops.

2.
Kotlin, 2024. Arrays.
[online] Available at:
<https://www.proprofs.com/quiz-school/story.php?title=basic-it-quiz_2>
[Accessed 04 May 2025].


3.
ProProfs, 2024. Basic Information Technology Quiz For All! Trivia.
[online] Available at:
<https://www.proprofs.com/quiz-school/story.php?title=basic-it-quiz_2>
[Accessed 02 May 2025].

4.
Games & Quizzes, 2025. Computers and Technology Quiz.
[online] Available at:
<https://www.britannica.com/quiz/computers-and-technology>
[Accessed 02 May 2025].

5.
stackoverflow, 2014. Android: why use intent.putExtra() method?.
[online] Available at:
<https://stackoverflow.com/questions/24436682/android-why-use-intent-putextra-method>
[Accessed 04 May 2025].

6.
stackoverflow, 2018. how to access the drawable resources by name in android.
[online] Available at:
<https://stackoverflow.com/questions/16369814/how-to-access-the-drawable-resources-by-name-in-android>
[Accessed 04 May 2025].

 */

package vcmsa.ci.thequiztech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity2 : AppCompatActivity() {

    // UI components
    private lateinit var imgQ: ImageView
    private lateinit var txtQuestion: TextView
    private lateinit var txtNotice: TextView

    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNextQ: Button
    private lateinit var btnStartQ: Button
    private lateinit var btnScore: Button
    private lateinit var btnExit: Button

    // Game state
    private var currentQuestionIndex = 0
    private var isAnswered = false
    private var score = 0

    // Shuffled order of questions
    private lateinit var questionOrder: List<Int>

    // Question data
    private val imageNames = arrayOf(
        "qa", "qb", "qc", "qd", "qe", "qf", "qg", "qh", "qi", "qj",
        "qk", "ql", "qm", "qn", "qo", "qp", "qq", "qr", "qs", "qt"
    )

    private val correctAnswers = booleanArrayOf(
        true, false, false, false, false,
        false, false, false, true, true,
        false, false, true, true, false,
        false, true, true, true, false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        // Link UI components
        imgQ = findViewById(R.id.imgQ)
        txtQuestion = findViewById(R.id.txtStarQ)
        txtNotice = findViewById(R.id.txtNotice)

        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNextQ = findViewById(R.id.btnNextQ)
        btnStartQ = findViewById(R.id.btnStartQ)
        btnScore = findViewById(R.id.btnScore)
        btnExit = findViewById(R.id.btnExit)

        // Disable controls initially
        disableAnswerButtons()
        btnNextQ.isEnabled = false
        btnScore.isEnabled = false

        // Button listeners
        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        btnTrue.setOnClickListener {
            checkAns(true)
        }

        btnFalse.setOnClickListener {
            checkAns(false)
        }

        btnStartQ.setOnClickListener {
            startQuiz()
        }

        btnNextQ.setOnClickListener {
            nextQuestion()
        }

        btnScore.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("SCORE", score)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Start or restart the quiz
    private fun startQuiz() {
        questionOrder = (imageNames.indices).shuffled().take(5)
        currentQuestionIndex = 0
        score = 0
        isAnswered = false

        btnStartQ.isEnabled = false
        btnNextQ.isEnabled = true
        btnScore.isEnabled = false
        txtNotice.text = ""

        updateQuestion()
        enableAnswerButtons()
    }

    // Check user's answer against the shuffled question
    private fun checkAns(userAnswer: Boolean) {
        if (!isAnswered && currentQuestionIndex < questionOrder.size) {
            isAnswered = true
            val questionIndex = questionOrder[currentQuestionIndex]

            val isCorrect = userAnswer == correctAnswers[questionIndex]
            if (isCorrect) score++

            txtNotice.text = if (isCorrect) "Correct" else "Incorrect"
            disableAnswerButtons()
        }
    }

    // Proceed to next question or end quiz
    private fun nextQuestion() {
        if (currentQuestionIndex < 4) { // only 5 questions (index 0 to 4)
            currentQuestionIndex++
            isAnswered = false
            txtNotice.text = ""
            updateQuestion()
            enableAnswerButtons()
        } else {
            txtQuestion.text = "This Was The Last Question, Check Your Score!"
            txtNotice.text = ""
            disableAnswerButtons()
            btnNextQ.isEnabled = false
            btnScore.isEnabled = true
        }
    }

    // Display the current question (image and label)
    private fun updateQuestion() {
        val questionIndex = questionOrder[currentQuestionIndex]
        val imageName = imageNames[questionIndex]
        val resId = resources.getIdentifier(imageName, "drawable", packageName)
        imgQ.setImageResource(resId)
        txtQuestion.text = "Question ${currentQuestionIndex + 1}"
    }

    private fun disableAnswerButtons() {
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
    }

    private fun enableAnswerButtons() {
        btnTrue.isEnabled = true
        btnFalse.isEnabled = true
    }
}