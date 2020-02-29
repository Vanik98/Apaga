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
import com.example.apaga.di.ActivityContext
import com.example.apaga.di.PerActivity
import com.example.apaga.ui.buybags.BuyBagsContract
import com.example.apaga.ui.buybags.BuyBagsPresenter
import com.example.apaga.ui.home.HomeContract
import com.example.apaga.ui.home.HomePresenter
import com.example.apaga.ui.login.LoginContract
import com.example.apaga.ui.login.LoginPresenter
import com.example.apaga.ui.payment.PaymentContract
import com.example.apaga.ui.payment.PaymentPresenter
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(activity: AppCompatActivity) {
    private val activity: AppCompatActivity = activity
    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): AppCompatActivity {
        return activity
    }

    @Provides
    @PerActivity
    fun provideLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter {
        return presenter
    }

    @Provides
    fun provideBuyBugsPresenter(presenter: BuyBagsPresenter): BuyBagsContract.Presenter {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideHomePresenter(presenter: HomePresenter): HomeContract.Presenter {
        return presenter
    }

    @Provides
    @PerActivity
    fun providePaymentPresenter(presenter: PaymentPresenter): PaymentContract.Presenter {
        return presenter
    }

}