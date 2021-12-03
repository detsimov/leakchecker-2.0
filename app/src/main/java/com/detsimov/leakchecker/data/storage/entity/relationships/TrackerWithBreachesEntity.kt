package com.detsimov.leakchecker.data.storage.entity.relationships

import androidx.room.Embedded
import androidx.room.Relation
import com.detsimov.leakchecker.data.storage.entity.BreachEntity
import com.detsimov.leakchecker.data.storage.entity.TrackerEntity
import com.detsimov.leakchecker.domain.models.TrackerDataType
import com.detsimov.leakchecker.domain.models.TrackerStatusModel

data class TrackerWithBreachesEntity(
    @Embedded val tracker: TrackerEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "trackerId"
    )
    val breaches: List<BreachEntity>
) {

    companion object {

        @JvmStatic
        fun TrackerWithBreachesEntity.toTrackerStatusModel() = TrackerStatusModel(
            tracker.email,
            TrackerDataType.EMAIL,
            breaches.count(),
            breaches.count { !it.isSeen }
        )
    }
}

