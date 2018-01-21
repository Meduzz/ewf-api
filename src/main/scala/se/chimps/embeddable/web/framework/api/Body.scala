package se.chimps.embeddable.web.framework.api

trait Body

case class Form(values:Map[String, String]) extends Body
case class Bytes(data:Array[Byte]) extends Body
