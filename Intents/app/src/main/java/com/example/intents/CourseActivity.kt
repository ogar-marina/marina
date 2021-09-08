package com.example.intents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivityCourseBinding

class CourseActivity:AppCompatActivity(R.layout.activity_course) {
    private lateinit var binding: ActivityCourseBinding

    //https://skillbox.ru/course/profession-android-developer-2021/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleIntentData()
    }

    private fun handleIntentData(){
        intent.data?.lastPathSegment?.let { courseName ->
            binding.courseNameTextView.text = courseName
        }

    }
}