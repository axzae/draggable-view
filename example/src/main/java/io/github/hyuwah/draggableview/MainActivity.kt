package io.github.hyuwah.draggableview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.hyuwah.draggableview.databinding.ActivityMainBinding
import io.github.hyuwah.draggableview.utils.launch
import io.github.hyuwah.draggableview.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBasicActivity.setOnClickListener {
            launch<BasicExampleActivity>()
        }

        binding.btnJavaActivity.setOnClickListener {
            launch<JavaMainActivity>()
        }

        binding.btnOverlayActivity.setOnClickListener {
            launch<OverlayDraggableActivity>()
        }

        binding.btnScrollingActivity.setOnClickListener {
            launch<ScrollingActivity>()
        }
    }
}
