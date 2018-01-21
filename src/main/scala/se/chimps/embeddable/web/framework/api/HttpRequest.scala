package se.chimps.embeddable.web.framework.api

case class HttpRequest(method:String, url:String, params:Map[String, String], headers:Map[String, String], body:Option[Body]) {
	def withParam(key:String, value:String):HttpRequest = copy(params = params ++ Map(key -> value))

	def withHeader(name:String, value:String):HttpRequest = copy(headers = headers ++ Map(name -> value))

	def withBody(data:Body, contentType:String):HttpRequest = copy(headers = headers ++ Map("Content-Type" -> contentType), body = Some(data))
}
