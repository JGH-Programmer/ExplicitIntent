package git.myapplication.explicitintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import git.myapplication.explicitintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.changeActivity.setOnClickListener {

            val intent = Intent(this@MainActivity, SubActivity::class.java)
            intent.apply {
                this.putExtra("number1", 100)
                this.putExtra("number2", 200)
            }
            //伝達のみ
            //startActivity(intent)

            SubActivityResult.launch(intent)

        }

    }

    private val SubActivityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            when (result.resultCode) {
                RESULT_OK -> {
                    Log.d("resultCode",""+result)
                }
            }
        }
}