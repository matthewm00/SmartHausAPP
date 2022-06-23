package ar.edu.itba.example.api.data

class Resource<T>(status: Status, data: T?, error: ar.edu.itba.example.api.model.Error?) where T : Any? {
    val status: Status
    val error: ar.edu.itba.example.api.model.Error?
    val data: T?

    companion object {
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(error: ar.edu.itba.example.api.model.Error): Resource<T> {
            return Resource(Status.ERROR, null, error)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

    init {
        this.status = status
        this.data = data
        this.error = error
    }
}