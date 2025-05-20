package vcmsa.ci.thequiztech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity3 : AppCompatActivity() {

    // Declare TextView to show the quiz completion info and score
    private var txtpg1Info: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // Bind UI elements to variables
        txtpg1Info = findViewById(R.id.txtpg1Info)

        val btnRetry = findViewById<Button>(R.id.btnRetry)
        val btnCorrections = findViewById<Button>(R.id.btnCorrections)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val btnMyScore = findViewById<Button>(R.id.btnMyScore)

        // Initially show the message "You have completed the quiz!"
        txtpg1Info?.text = "You Have Completed The Quiz!"

        // Retrieve score from Intent that started this activity
        val score = intent.getIntExtra("SCORE", 0)  // Default to 0 if nothing is passed

        // Calculate score percentage
        val scorePercentage = (score.toFloat() / 5) * 100

        // Define messages based on score percentage
        val scoreMessage = when {
            scorePercentage <= 20 -> "Try again, you can do it!"
            scorePercentage <= 40 -> "Good effort, but there's room for improvement."
            scorePercentage <= 60 -> "Not bad, but try to aim higher!"
            scorePercentage <= 80 -> "You did well! Keep up the good work."
            scorePercentage < 100 -> "Great job! You're almost there!"
            else -> "Excellent! Perfect score!"
        }

        // Show the score message when the button is clicked
        btnMyScore.setOnClickListener {
            // Display the score in the format: "Your score is score/20 (score%)"
            val formattedScore = "Your score is $score/5 (${scorePercentage.toInt()}%)  "
            txtpg1Info?.text = formattedScore + "\n" + scoreMessage
        }

        // Exit app when Exit button is clicked
        btnExit.setOnClickListener {
            finishAffinity() // Finish all activities
            exitProcess(1)   // Exit the app
        }

        // Go to corrections page when Corrections button is clicked
        btnCorrections.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        // Restart the quiz when Retry button is clicked
        btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}