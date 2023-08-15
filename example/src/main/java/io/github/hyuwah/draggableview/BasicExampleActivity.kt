package io.github.hyuwah.draggableview

import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import io.github.hyuwah.draggableview.databinding.ActivityBasicExampleBinding
import io.github.hyuwah.draggableview.utils.px2dp
import io.github.hyuwah.draggableview.utils.viewBinding
import io.github.hyuwah.draggableviewlib.DraggableListener
import io.github.hyuwah.draggableviewlib.DraggableView
import io.github.hyuwah.draggableviewlib.setupDraggable

class BasicExampleActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityBasicExampleBinding::inflate)

    private lateinit var layoutTestDraggable: DraggableView<LinearLayout>
    private lateinit var textTestDraggable: DraggableView<TextView>
    private lateinit var imageTestDraggable: DraggableView<ImageView>

    private var layoutDragListener = object : DraggableListener {
        override fun onPositionChanged(view: View) {
            with(binding) {
                textX.text = "X: ${view.x.px2dp}dp / ${(view.parent as View).width.px2dp}dp"
                textY.text = "Y: ${view.y.px2dp}dp / ${(view.parent as View).height.px2dp}dp"
            }
        }

        override fun onLongPress(view: View) {
            showToast("Long press view : ${view.id}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupControl()
        setupDraggableView()
        setupDraggableViewOnClick()

        binding.textX.text = "Density: ${Resources.getSystem().displayMetrics.density}"
        binding.textY.text = ""
    }

    private fun setupDraggableView() {
        // Using extension function
        textTestDraggable = binding.textDragMe.setupDraggable().build()
        // Using DraggableView Builder
        layoutTestDraggable = DraggableView.Builder(binding.layoutText)
            .setStickyMode(DraggableView.Mode.NON_STICKY)
            .setListener(layoutDragListener)
            .build()
        // Using extension function
        imageTestDraggable = binding.imageTest.setupDraggable()
            .setAnimated(true)
            .setStickyMode(DraggableView.Mode.NON_STICKY)
            .build()
    }

    private fun setupDraggableViewOnClick() {
        binding.imageTest.setOnClickListener {
            showToast("This is 0")
        }

        binding.layoutText.setOnClickListener {
            showToast("This is 1")
        }

        binding.textDragMe.setOnClickListener {
            showToast("This is 2")
        }
    }

    private fun setupControl() {
        with(binding.layoutControl) {
            // Set Sticky Mode
            etStickyMode.setText(DraggableView.Mode.NON_STICKY.name)
            val stickyModeAdapter = ArrayAdapter(
                this@BasicExampleActivity,
                android.R.layout.simple_spinner_dropdown_item,
                DraggableView.Mode.values().map { it.name },
            )
            etStickyMode.setAdapter(stickyModeAdapter)
            etStickyMode.doOnTextChanged { text, _, _, _ ->
                val selectedMode = DraggableView.Mode.values().find { it.name == text.toString() }
                showToast(selectedMode?.name ?: "Null")

                selectedMode?.let {
                    layoutTestDraggable.sticky = it
                    textTestDraggable.sticky = it
                    imageTestDraggable.sticky = it
                }
            }

            // Set animation
            swAnimate.isChecked = true
            swAnimate.setOnCheckedChangeListener { _, isChecked ->
                layoutTestDraggable.animated = isChecked
                textTestDraggable.animated = isChecked
                imageTestDraggable.animated = isChecked
            }

            // Set drag enabled / disabled
            swDisableDraggable.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    layoutTestDraggable.disableDrag()
                    textTestDraggable.disableDrag()
                    imageTestDraggable.disableDrag()
                } else {
                    layoutTestDraggable.enableDrag()
                    textTestDraggable.enableDrag()
                    imageTestDraggable.enableDrag()
                }
            }

            // Set show/hide draggable view
            swHideDraggable.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    textTestDraggable.hide()
                    layoutTestDraggable.hide()
                    imageTestDraggable.hide()
                } else {
                    textTestDraggable.show()
                    layoutTestDraggable.show()
                    imageTestDraggable.show()
                }
            }
        }
    }

    private var toast: Toast? = null
    private fun showToast(message: String) {
        toast?.cancel()
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT).apply { show() }
    }
}
