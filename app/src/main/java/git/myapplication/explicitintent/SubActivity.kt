package git.myapplication.explicitintent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import git.myapplication.explicitintent.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySubBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.result.setOnClickListener {

            val number1 = intent.getIntExtra("number1",0)
            val number2 = intent.getIntExtra("number2",0)

            Log.d("number1", ""+number1)
            Log.d("number2", ""+number2)

            val result = number1 + number2

            val resultIntent = Intent()
            Log.d("result", ""+result)

            resultIntent.putExtra("result",result)
            setResult(Activity.RESULT_OK, resultIntent)

            this.finish()

            //stack
            //SubActivity -> finish
            //MainActivity -> 元の画面が見えます。
        }
    }
}