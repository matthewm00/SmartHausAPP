package ar.edu.itba.example.api.ui

import androidx.lifecycle.ViewModel

open class RepositoryViewModel<T>(protected var repository: T) : ViewModel()