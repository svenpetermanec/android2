package hr.tvz.android.listapetermanec

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listapetermanec.databinding.ImageBinding

@Suppress("DEPRECATION")
class ImageActivity : AppCompatActivity() {
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exercise: Exercise = intent.getParcelableExtra("exercise")!!
        val id = resources.getIdentifier("e" + (exercise.id), "drawable", packageName)
        binding.image.setImageResource(id)

        binding.image.alpha = 0f;
        binding.image.visibility = View.VISIBLE

        binding.image.animate().alpha(1F).setDuration(2000).setListener(null)
    }
}