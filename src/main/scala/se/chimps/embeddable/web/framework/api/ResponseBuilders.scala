package se.chimps.embeddable.web.framework.api

trait ResponseBuilders {
	def ok(body:String, contentType:String):HttpResponse = HttpResponse(200, Map("Content-Type" -> contentType), body.getBytes("utf-8"))

	def ok(body:Array[Byte], contentType:String):HttpResponse = HttpResponse(200, Map("Content-Type" -> contentType), body)

	def error():HttpResponse = HttpResponse(500, Map(), Array())

	def error(body:String, contentType:String):HttpResponse = HttpResponse(500, Map("Content-Type" -> contentType), body.getBytes("utf-8"))

	def notFound():HttpResponse = HttpResponse(404, Map("Content-Type" -> "text/plain"), "Not found.".getBytes("utf-8"))

	def created():HttpResponse = HttpResponse(201, Map(), Array())

	def badRequest():HttpResponse = HttpResponse(400, Map(), Array())

	def forbidden():HttpResponse = HttpResponse(401, Map(), Array())

	def redirect(url:String):HttpResponse = HttpResponse(302, Map("Location" -> url), Array())
}
