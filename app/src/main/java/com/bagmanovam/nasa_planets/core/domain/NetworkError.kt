package com.bagmanovam.nasa_planets.core.domain

enum class NetworkError : Error {
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    CONNECTION_ERROR,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN,
}