package com.example.apaga.data.network.model

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

 class NotificationType (
         title: String,
         items: MutableList<Notification>) : ExpandableGroup<Notification>(title, items) {
}