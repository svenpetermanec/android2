package hr.tvz.android.listapetermanec

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.tvz.android.listapetermanec.databinding.DetailsBinding

@Suppress("DEPRECATION")
class DetailsActivity : AppCompatActivity() {
    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exercise: Exercise = intent.getParcelableExtra("exercise")!!
        val id = resources.getIdentifier("e" + (exercise.id), "drawable", packageName)

        binding.image.setImageResource(id)
        binding.title.text = resources.getStringArray(R.array.exercises)[exercise.id]
        binding.description.text = resources.getStringArray(R.array.descriptions)[exercise.id]

        val intent = Intent(this, ImageActivity::class.java)
        intent.putExtra("exercise", Exercise(exercise.id))

        binding.image.setOnClickListener { v -> v.context.startActivity(intent) }
    }
}