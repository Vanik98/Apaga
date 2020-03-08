/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package com.example.apaga.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apaga.di.ActivityContext
import com.example.apaga.di.PerActivity
import com.example.apaga.ui.address.AddressContract
import com.example.apaga.ui.address.AddressPresenter
import com.example.apaga.ui.buybags.BuyBagsContract
import com.example.apaga.ui.buybags.BuyBagsPresenter
import com.example.apaga.ui.home.HomeContract
import com.example.apaga.ui.home.HomePresenter
import com.example.apaga.ui.login.LoginContract
import com.example.apaga.ui.login.LoginPresenter
import com.example.apaga.ui.main.MainContract
import com.example.apaga.ui.main.MainPresenter
import com.example.apaga.ui.notifications.NotificationsAdapter
import com.example.apaga.ui.notifications.NotificationsContract
import com.example.apaga.ui.notifications.NotificationsPresenter
import com.example.apaga.ui.payment.PaymentContract
import com.example.apaga.ui.payment.PaymentPresenter
import com.example.apaga.ui.qrscanner.QrScannerContract
import com.example.apaga.ui.qrscanner.QrScannerPresenter
import com.example.apaga.ui.registration.RegistrationContract
import com.example.apaga.ui.registration.RegistrationPresenter
import com.example.apaga.ui.waste.WasteContract
import com.example.apaga.ui.waste.WasteListAdapter
import com.example.apaga.ui.waste.WastePresenter
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(activity: AppCompatActivity) {

    private val activity: AppCompatActivity = activity

    @Provides
    @ActivityContext
    fun provideContext(): Context =  activity

    @Provides
    fun provideActivity(): AppCompatActivity = activity

    @Provides
    @PerActivity
    fun provideMainPresenter(presenter: MainPresenter): MainContract.Presenter = presenter

    @Provides
    @PerActivity
    fun provideAddressPresenter(presenter: AddressPresenter): AddressContract.Presenter = presenter

    @Provides
    @PerActivity
    fun provideHomePresenter(presenter: HomePresenter): HomeContract.Presenter = presenter

    @Provides
    fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter = presenter

    @Provides
    fun provideBuyBugsPresenter(presenter: BuyBagsPresenter): BuyBagsContract.Presenter = presenter

    @Provides
    fun providePaymentPresenter(presenter: PaymentPresenter): PaymentContract.Presenter = presenter

    @Provides
    fun provideRegistrationPresenter(presenter: RegistrationPresenter): RegistrationContract.Presenter = presenter

    @Provides
    fun provideNotificationsPresenter(presenter: NotificationsPresenter): NotificationsContract.Presenter = presenter

    @Provides
    fun provideWastePresenter(presenter: WastePresenter): WasteContract.Presenter = presenter

    @Provides
    fun provideWasteAdapter(): WasteListAdapter = WasteListAdapter(activity)

    @Provides
    fun provideQrScannerPresenter(presenter:QrScannerPresenter): QrScannerContract.Presenter = presenter

    @Provides
    fun provideNotificationsAdapter(): NotificationsAdapter =
            NotificationsAdapter(activity, arrayListOf())

    @Provides
    fun provideLinearLayoutManagerAdapter(): LinearLayoutManager =
            LinearLayoutManager(activity)


}