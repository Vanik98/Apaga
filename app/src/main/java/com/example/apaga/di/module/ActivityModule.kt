
package com.example.apaga.di.module

import android.app.Dialog
import android.content.Context
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apaga.di.ActivityContext
import com.example.apaga.di.PerActivity
import com.example.apaga.ui.address.AddressContract
import com.example.apaga.ui.address.AddressPresenter
import com.example.apaga.ui.buybags.BuyBagsContract
import com.example.apaga.ui.buybags.BuyBagsPresenter
import com.example.apaga.ui.dashboard.DashboardAdapter
import com.example.apaga.ui.dashboard.DashboardChildAdapter
import com.example.apaga.ui.dashboard.DashboardContract
import com.example.apaga.ui.dashboard.DashboardPresenter
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
import com.example.apaga.ui.bagscan.BagScanContract
import com.example.apaga.ui.bagscan.BagScanPresenter
import com.example.apaga.ui.registration.RegistrationContract
import com.example.apaga.ui.registration.RegistrationPresenter
import com.example.apaga.ui.schedule.SchedulePickupAdapter
import com.example.apaga.ui.schedule.SchedulePickupContract
import com.example.apaga.ui.schedule.SchedulePickupPresenter
import com.example.apaga.ui.waste.WasteContract
import com.example.apaga.ui.waste.WasteAdapter
import com.example.apaga.ui.waste.WastePresenter
import com.example.apaga.utils.DialogUtils
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
    fun provideWasteAdapter(): WasteAdapter = WasteAdapter(activity)

    @Provides
    fun provideQrScannerPresenter(presenter: BagScanPresenter): BagScanContract.Presenter = presenter

    @Provides
    fun provideDashboardPresenter(presenter:DashboardPresenter): DashboardContract.Presenter = presenter

    @Provides
    fun provideSchedulePickupPresenter(presenter: SchedulePickupPresenter): SchedulePickupContract.Presenter = presenter

    @Provides
    fun provideNotificationsAdapter(): NotificationsAdapter =
            NotificationsAdapter(activity, arrayListOf())

    @Provides
    fun provideSchedulePickupAdapter(): SchedulePickupAdapter =
            SchedulePickupAdapter(activity)

    @Provides
    fun provideDashboardAdapter(childAdapter: DashboardChildAdapter,
                                layoutManager: LinearLayoutManager,
                                dialogUtils: DialogUtils
                                ): DashboardAdapter =
            DashboardAdapter(activity,childAdapter,layoutManager,dialogUtils)

    @Provides
    fun provideDashboardChildAdapter(): DashboardChildAdapter =
            DashboardChildAdapter(activity)

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager =
            LinearLayoutManager(activity)

    @Provides
    fun provideDialogUtils(dialog: Dialog): DialogUtils = DialogUtils(dialog)

    @Provides
    fun provideDialog(): Dialog = Dialog(activity)

    @Provides
    fun provideGeocoder(): Geocoder = Geocoder(activity)

}