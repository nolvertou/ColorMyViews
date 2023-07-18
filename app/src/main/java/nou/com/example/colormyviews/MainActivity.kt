package nou.com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import nou.com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()

    }

    private fun setListeners() {
        val clickableViews: List<View> =
            listOf(binding.boxOne,
                binding.boxTwo,
                binding.boxThree,
                binding.boxFour,
                binding.boxFive,
                binding.root,
                binding.redButton,
                binding.greenButton,
                binding.yellowButton
                )
        for (item in clickableViews){
            item.setOnClickListener { makeColored(it)}
        }
    }

    private fun makeColored(view: View) {
        when(view.id){
            // Boxes using Color class colors for background
            R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three -> view.setBackgroundColor(
                ContextCompat.getColor(this@MainActivity,android.R.color.holo_green_light))
            R.id.box_four -> view.setBackgroundColor(
                ContextCompat.getColor(this@MainActivity,android.R.color.holo_green_dark))
            R.id.box_five -> view.setBackgroundColor(
                ContextCompat.getColor(this@MainActivity,android.R.color.holo_blue_dark))

            // Boxes using custom colors for brackground
            R.id.green_button -> binding.boxThree.setBackgroundResource(R.color.my_green)
            R.id.red_button -> binding.boxFour.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFive.setBackgroundResource(R.color.my_yellow)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}