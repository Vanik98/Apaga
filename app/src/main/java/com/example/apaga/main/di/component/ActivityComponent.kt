package com.example.friends.di.component

import com.example.friends.di.*
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules =[]
)
interface ActivityComponent {

}