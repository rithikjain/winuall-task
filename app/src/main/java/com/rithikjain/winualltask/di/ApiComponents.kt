package com.rithikjain.winualltask.di

import com.rithikjain.winualltask.di.modules.apiModule
import com.rithikjain.winualltask.di.modules.repoModule
import com.rithikjain.winualltask.di.modules.viewModelModule

val appComponents = listOf(apiModule, repoModule, viewModelModule)

