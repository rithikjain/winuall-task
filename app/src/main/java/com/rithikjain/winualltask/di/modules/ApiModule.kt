package com.rithikjain.winualltask.di.modules

import com.rithikjain.winualltask.network.ApiClient
import com.rithikjain.winualltask.network.ApiService
import org.koin.dsl.module

val apiModule = module {
    factory { ApiService.createRetrofit() }
    factory { ApiClient(get()) }
}