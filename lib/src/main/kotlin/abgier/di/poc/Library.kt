/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package abgier.di.poc

class Library {
    val services = mutableMapOf<java.lang.Class<Any>, java.lang.Object>()

    inline fun <reified T, reified S>inject() {
        var serviceClass = S::class.java
        val primaryConstructor = serviceClass.getConstructors()[0]

        val params = mutableListOf<Any>()
        for (param in primaryConstructor.getParameters()) {
            val matchingService = this.services.get(param.type)
            if (matchingService != null) {
                params.add(matchingService)
            }
        }

        println(serviceClass)
        println(params)
        val instance = primaryConstructor.newInstance(*params.toTypedArray())
        this.services.put(T::class.java as java.lang.Class<Any>, instance as java.lang.Object)
        return
    }

    inline fun <reified T>provide() : T {
        val matchingService = this.services.get(T::class.java as java.lang.Class<Any>)
        return matchingService as T
    }
}

