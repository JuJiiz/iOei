package com.jujiiz.ioei

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jujiiz.ioei.entity.CatEntity
import com.jujiiz.ioei.recycler.CatAdapter
import com.jujiiz.ioei.recycler.CatListener

class CatsActivity : AppCompatActivity(), CatListener {
    private val catAdapter: CatAdapter = CatAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats)

        findViewById<RecyclerView>(R.id.rvCats)
            .apply {
                layoutManager = LinearLayoutManager(this@CatsActivity)
                adapter = catAdapter
            }

        catAdapter.items = generateCat()
    }

    private fun generateCat(): List<CatEntity> {
        val colors = listOf(
            "#e2ddd7",
            "#cdbfa4",
            "#ebd2be",
            "#faebd7",
            "#F9BD12",
            "#040404",
            "#252525",
        )

        return (0 until 200)
            .map { index ->
                val id = index + 1
                return@map CatEntity(
                    id = id,
                    name = "Cat No.$id",
                    colorHex = colors.random()
                )
            }
    }

    override fun onSelectCat(selected: CatEntity) {
        Toast.makeText(this, "Select ${selected.name}", Toast.LENGTH_SHORT).show()
    }
}