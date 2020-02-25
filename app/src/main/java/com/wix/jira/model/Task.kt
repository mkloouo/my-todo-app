package com.wix.jira.model

data class Task(
    val title: String,
    val finished: Boolean = false
)
