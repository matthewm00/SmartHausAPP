package ar.edu.itba.example.api.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RepositoryViewModelFactory<R>(
    private val repositoryClass: Class<R>,
    private val repository: R
) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        require(RepositoryViewModel::class.java.isAssignableFrom(modelClass)) { "Unknown class $modelClass" }
        return try {
            val constructor = modelClass.getConstructor(
                repositoryClass
            )
            constructor.newInstance(repository)
        } catch (e: Exception) {
            throw RuntimeException("Cannot create an instance of class $modelClass", e)
        }
    }
}