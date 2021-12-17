package com.example.permissionsanddate

import android.Manifest
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.app.ActivityCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.view_location_info.*
import org.threeten.bp.LocalDateTime
import org.threeten.bp.ZoneId
import java.time.Instant
import kotlin.random.Random

class MainFragment : Fragment(R.layout.fragment_main) {

    private val locationList = mutableListOf<LocationInfo>()

    private var adapter = LocationAdapter()
    private var locationAdapter: LocationAdapter? = null
    private var selectedMessageInstant: org.threeten.bp.Instant? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getCurrentLocationButton.setOnClickListener {
            showLocationInfo()
        }
        initTimePicker()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        locationAdapter = null
    }

    private fun showLocationInfo() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            startActivity(Intent(requireContext(), PermissionActivity::class.java))
            return
        }
        locationTextView.isVisible = false
        LocationServices.getFusedLocationProviderClient(requireContext())
            .lastLocation
            .addOnSuccessListener {
                it?.let {
                    val locationInfo = LocationInfo(
                        it.latitude,
                        it.longitude
                    )
                    locationList.add(locationInfo)
                    adapter.setData(locationList)
                } ?: toast("Локация отсутствует")
            }
            .addOnCanceledListener {
                toast("Запрос локации был отменен")
            }
            .addOnFailureListener {
                toast("Запрос локации завершился неудачно")
            }
    }
        private fun initTimePicker() {


            val currentDateTime = LocalDateTime.now()

            locationListView.setOnClickListener {
                DatePickerDialog(
                    requireContext(),
                    { _, year, month, dayOfMonth ->
                        TimePickerDialog(
                            requireContext(),
                            { _, hourOfDay, minute ->
                                val zonedDateTime =
                                    LocalDateTime.of(year, month + 1, dayOfMonth, hourOfDay, minute)
                                        .atZone(ZoneId.systemDefault())

                                toast("Выбрано время: $zonedDateTime")
                                selectedMessageInstant = zonedDateTime.toInstant()
                            },
                            currentDateTime.hour,
                            currentDateTime.minute,
                            true
                        )
                            .show()
                    },
                    currentDateTime.year,
                    currentDateTime.month.value - 1,
                    currentDateTime.dayOfMonth
                )
                    .show()
            }
        }


        private fun toast(text: String) {
            Toast.makeText(requireContext(), text, LENGTH_SHORT).show()
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            locationListView.layoutManager = LinearLayoutManager(requireContext())
            locationListView.adapter = adapter
        }
    }
