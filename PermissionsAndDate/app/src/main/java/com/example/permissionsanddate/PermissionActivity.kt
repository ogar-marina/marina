package com.example.permissionsanddate


import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import kotlinx.android.synthetic.main.activity_permission.*

class PermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)
        getPermissionButton.setOnClickListener { getPermission() }
    }

    private fun getPermission() {
        val isLocationPermissionGranted = ActivityCompat.checkSelfPermission(
            this, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (isLocationPermissionGranted) {
            onBackPressed()
        } else {
            permissionTextView.visibility = View.GONE
            requestLocationPermission()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
            showLocationInfo()
        } else {
            val needRationale = ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            if (needRationale) {
                showLocationRationaleDialog()
            }
        }
    }

    private fun showLocationInfo() {
        onBackPressed()
    }

    private fun showLocationRationaleDialog() {
        AlertDialog.Builder(this)
            .setMessage("Необходимо одобрение разрешения для отображения информации по локации")
            .setPositiveButton("OK", { _, _ -> requestLocationPermission() })
            .setNegativeButton("Отмена", null)
            .show()
    }

    private fun requestLocationPermission() {
        requestPermissions(
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            PERMISSION_REQUEST_CODE
        )
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 4313
    }
}