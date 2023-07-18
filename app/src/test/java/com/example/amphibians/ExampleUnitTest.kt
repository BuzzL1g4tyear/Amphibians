package com.example.amphibians

import com.example.amphibians.ui.di.appModule
import com.example.amphibians.ui.di.dataModule
import com.example.amphibians.ui.di.domainModule
import org.junit.Assert.*
import org.junit.Test
import org.koin.android.test.verify.verify
import org.koin.core.annotation.KoinExperimentalAPI

class CheckModulesTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkDataModule() {
        dataModule.verify()
    }

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkAppModule() {
        appModule.verify()
    }

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun checkDomainModule() {
        domainModule.verify()
    }
}