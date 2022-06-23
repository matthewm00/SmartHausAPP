package ar.edu.itba.example.api.data

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

class AppExecutors @JvmOverloads constructor(private val mainThread: Executor = MainThreadExecutor()) {
    fun mainThread(): Executor {
        return mainThread
    }

    private class MainThreadExecutor : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable) {
            mainThreadHandler.post(command)
        }
    }
}