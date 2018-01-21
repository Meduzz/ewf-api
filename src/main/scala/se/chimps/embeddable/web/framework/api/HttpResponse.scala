package se.chimps.embeddable.web.framework.api

case class HttpResponse(code:Int, headers:Map[String, String], body:Array[Byte]) {
	def withBody(data:String, contentType:String):HttpResponse = copy(body = data.getBytes("utf-8"), headers = headers ++ Map("Content-Type" -> contentType))
	def withBody(data:Array[Byte], contentType:String):HttpResponse = copy(body = data, headers = headers ++ Map("Content-Type" -> contentType))

	def withHeader(name:String, value:String):HttpResponse = copy(headers = headers ++ Map(name -> value))
}
