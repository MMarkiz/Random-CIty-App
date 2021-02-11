package com.netguru.domain.usecases

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any? {
    abstract suspend fun run(params: Params): Type

    operator fun invoke(
        scope: CoroutineScope,
        params: Params,
        onResult: (Type) -> Unit = {}
    ): Job = scope.launch { onResult(run(params)) }
}
