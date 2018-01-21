package se.chimps.embeddable.web.framework.api

import org.scalatest.{FunSuite, Matchers}

class HttpResponseTest extends FunSuite with ResponseBuilders with Matchers {

	test("withBody (string) changes things") {
		val response = ok("a", "b")
		val changed = response.withBody("c", "d")

		response.body shouldNot be(empty)
		response.body shouldBe "a".getBytes("utf-8")
		response.headers shouldNot be(empty)
		response.headers("Content-Type") shouldBe "b"

		changed.body shouldNot be(empty)
		changed.body shouldBe "c".getBytes("utf-8")
		changed.headers shouldNot be(empty)
		changed.headers("Content-Type") shouldBe "d"
		changed.code shouldBe 200
		response.code shouldBe 200
	}

	test("withBody (byte[]) changes things") {
		val response = ok("a".getBytes("utf-8"), "b")
		val changed = response.withBody("c".getBytes("utf-8"), "d")

		response.body shouldNot be(empty)
		response.body shouldBe "a".getBytes("utf-8")
		response.headers shouldNot be(empty)
		response.headers("Content-Type") shouldBe "b"
		response.code shouldBe 200

		changed.body shouldNot be(empty)
		changed.body shouldBe "c".getBytes("utf-8")
		changed.headers shouldNot be(empty)
		changed.headers("Content-Type") shouldBe "d"
		changed.code shouldBe 200
	}

	test("withHeader changes things") {
		val response = created().withHeader("a", "b")
		val changed = response.withHeader("a", "c")

		response.headers shouldNot be(empty)
		response.headers("a") shouldBe "b"
		response.code shouldBe 201

		changed.headers shouldNot be(empty)
		changed.headers("a") shouldBe "c"
		changed.code shouldBe 201
	}

}
