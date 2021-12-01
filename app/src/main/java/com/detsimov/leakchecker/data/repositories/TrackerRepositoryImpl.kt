package com.detsimov.leakchecker.data.repositories

import com.detsimov.leakchecker.domain.models.BreachesInfoModel
import com.detsimov.leakchecker.domain.models.TrackerDataType
import com.detsimov.leakchecker.domain.models.TrackerStatusModel
import com.detsimov.leakchecker.domain.repositories.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TrackerRepositoryImpl : TrackerRepository {

    override val statusesFlow: Flow<List<TrackerStatusModel>> = MutableStateFlow(
        listOf(
            TrackerStatusModel("test1@mail.ru", TrackerDataType.EMAIL, 22, 15),
            TrackerStatusModel("test2@mail.ru", TrackerDataType.EMAIL, 822, 0),
            TrackerStatusModel("test3@mail.ru", TrackerDataType.EMAIL, 81, 22),
            TrackerStatusModel("test4@mail.ru", TrackerDataType.EMAIL, 21321, 0),
            TrackerStatusModel("test5@mail.ru", TrackerDataType.EMAIL, 33, 0),
        )
    )

    override val breachesInfoFlow: Flow<BreachesInfoModel> = MutableStateFlow(BreachesInfoModel(5, 1002))
}