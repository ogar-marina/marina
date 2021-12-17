package com.example.permissionsanddate

import org.threeten.bp.Instant
import java.time.OffsetDateTime
import java.util.*

data class LocationInfo(
    val lat: Double,
    val lng: Double,
    val time: OffsetDateTime = OffsetDateTime.now(),
    val id: String = UUID.randomUUID().toString()
)
