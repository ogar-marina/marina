package com.example.a02_toolbar

import android.os.Bundle
import android.os.PersistableBundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.example.a02_toolbar.databinding.ActivityToolbarBinding

class ToolbarActivity : AppCompatActivity() {


    private lateinit var binding: ActivityToolbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initToolbar()
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun initToolbar() {
        binding.ToolBar.setNavigationOnClickListener {
            toast("Navigation clicked")
        }

        binding.ToolBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.action_1 -> {
                    toast("action 1 clicked")
                    true
                }
                R.id.action_2 -> {
                    toast("action 2 clicked")
                    true
                }
                R.id.action_3 -> {
                    toast("action 3 clicked")
                    true
                }
                else -> false
            }
        }

        val searchItem = binding.ToolBar.menu.findItem(R.id.action_search)
        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                toast("search expanded")
                return true
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                toast("search collapsed")
                return true
            }

        })

        (searchItem.actionView as SearchView).setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

    }
}