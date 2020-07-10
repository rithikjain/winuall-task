package com.rithikjain.winualltask.di.modules

import com.rithikjain.winualltask.repository.AppRepo
import org.koin.dsl.module

val repoModule = module {
    factory { AppRepo(get()) }
}