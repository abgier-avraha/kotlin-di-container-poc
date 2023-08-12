/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package example

import container.DependencyInjectionContainer
import example.services.IRandomStringsService
import example.utils.IRandomProvider
import kotlin.test.Test
import kotlin.test.assertEquals

class RandomStringsServiceTest {

  @Test
  fun CanGetRandomStrings() {
    // Arrange
    val container = DependencyInjectionContainer().injectServices()
    container.injectSingleton<IRandomProvider>(TestRandomProvider("<random>"))

    // Act
    val scope = container.createScope()
    val service = scope.provide<IRandomStringsService>()
    val res = service.GetRandomStrings()

    // Assert
    assertEquals(listOf("<random>", "<random>", "<random>"), res)
  }
}

class TestRandomProvider : IRandomProvider {
  private val value: String

  constructor(value: String) {
    this.value = value
  }

  override fun CreateRandomString(): String {
    return this.value
  }
}