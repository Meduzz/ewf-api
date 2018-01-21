package se.chimps.embeddable.web.framework.api

import org.scalatest.{FunSuite, Matchers}

class ResponseBuildersTest extends FunSuite with Matchers with ResponseBuilders with ResponseVerifier {

	test("ok is 200") {
		val string = ok("string", "string")
		verify(string, 200, Map("Content-Type" -> "string"), "string".getBytes("utf-8"))

		val bytes = ok("bytes".getBytes("utf-8"), "bytes")
		verify(bytes, 200, Map("Content-Type" -> "bytes"), "bytes".getBytes("utf-8"))
	}

	test("error is 500") {
		val empty = error()
		verify(empty, 500, Map(), Array())

		val body = error("error", "text")
		verify(body, 500, Map("Content-Type" -> "text"), "error".getBytes("utf-8"))
	}

	test("notFound is 404") {
		val empty = notFound()
		verify(empty, 404, Map("Content-Type" -> "text/plain"), "Not found.".getBytes("utf-8"))
	}

	test("created is 201") {
		val empty = created()
		verify(empty, 201, Map(), Array())
	}

	test("badRequest is 400") {
		val empty = badRequest()
		verify(empty, 400, Map(), Array())
	}

	test("forbidden is 401") {
		val empty = forbidden()
		verify(empty, 401, Map(), Array())
	}

	test("redirect is 302") {
		val empty = redirect("/")
		verify(empty, 302, Map("Location" -> "/"), Array())
	}
}
