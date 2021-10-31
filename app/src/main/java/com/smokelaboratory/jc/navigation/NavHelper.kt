package com.smokelaboratory.jc.navigation

import java.lang.StringBuilder

abstract class Route {
    abstract val label: String
    abstract val arguments: List<String>?
    abstract val optionalArguments: List<String>?
    val route: String by lazy {
        StringBuilder(label).apply {
            arguments?.let {
                it.forEach {
                    append("/{$it}")
                }
            }
            optionalArguments?.let {
                it.forEach {
                    append("?$it={$it}")
                }
            }
        }.toString()
    }

    fun address(args: Map<String, String>? = null): String {
        var address: String = route

        args?.entries?.forEach {
            address = address.replace("{${it.key}}", it.value)
        }

        return address
    }
}


object Entry : Route() {
    override val label: String = "entrymodule"
    override val arguments: List<String>? = null
    override val optionalArguments: List<String>? = null

    object Login : Route() {
        override val label: String = "login"
        override val arguments: List<String>? = null
        override val optionalArguments: List<String>? = null
    }

    object Signup : Route() {
        override val label: String = "signup"

        enum class Arguments {
            EMAIL, PASSWORD
        }
        override val arguments: List<String> = Arguments.values().map { it.name }

        enum class OptionalArguments {
            BIRTH_DATE
        }
        override val optionalArguments: List<String> = OptionalArguments.values().map { it.name }
    }
}