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

class MainActivity4 : AppCompatActivity() {

    private var txtpg4Correction: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        txtpg4Correction = findViewById(R.id.txtpg4Correction)

        val btnRetry = findViewById<Button>(R.id.btnRetry)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Exit app when Exit button is clicked
        btnExit.setOnClickListener {
            finishAffinity()
            exitProcess(1)
        }

        // Restart the quiz when Retry button is clicked
        btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish() // Optional: close current screen
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}