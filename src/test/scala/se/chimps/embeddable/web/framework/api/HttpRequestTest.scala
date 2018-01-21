package se.chimps.embeddable.web.framework.api

import org.scalatest.{FunSuite, Matchers}

class HttpRequestTest extends FunSuite with RequestBuilders with Matchers {

	test("withParam changes param") {
		val request = get("/")
		val changed = request.withParam("a", "b")
		val overwrite = changed.withParam("a", "c")

		request.params shouldBe empty
		changed.params shouldNot be(empty)
		changed.params("a") shouldBe "b"
		overwrite.params shouldNot be(empty)
		overwrite.params("a") shouldBe "c"
	}

	test("withHeader changes header") {
		val request = get("/")
		val changed = request.withHeader("a", "b")
		val overwrite = changed.withHeader("a", "c")

		request.headers shouldBe empty
		changed.headers shouldNot be(empty)
		changed.headers("a") shouldBe "b"
		overwrite.headers shouldNot be(empty)
		overwrite.headers("a") shouldBe "c"
	}

	test("withBody changes body") {
		val request = get("/")
		val changed = request.withBody(Form(Map("a" -> "b")), "form-data")
		val overwrite = changed.withBody(Form(Map("a" -> "c")), "form-data")

		request.body shouldBe None
		request.headers shouldBe empty
		changed.body shouldBe Some(Form(Map("a" -> "b")))
		changed.headers("Content-Type") shouldBe "form-data"
		overwrite.body shouldBe Some(Form(Map("a" -> "c")))
		overwrite.headers("Content-Type") shouldBe "form-data"
	}
}
