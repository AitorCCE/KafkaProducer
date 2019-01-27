import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.json4s.DefaultFormats
import scala.io.Source
import org.json4s.native.JsonMethods._
import org.json4s.JsonDSL.WithBigDecimal._

object KafkaProducer extends App {

  val topic = "KafkaProducerTopic"
  val brokers = "localhost:9092"
  val props = new Properties()

  props.put("bootstrap.servers", brokers)
  props.put("client.id", "ScalaProducer")
  props.put("key.serializer",
    "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer",
    "org.apache.kafka.common.serialization.StringSerializer")


  val producer = new KafkaProducer[String, String](props)
  val bufferedSource = Source.fromFile("/home/utad/TFM/CitiBike/datos.csv")

  for (line <- bufferedSource.getLines.drop(1)) {
    val cols = line.split(",").map(_.trim)
    val json = ("tripduration" -> cols(0)) ~
      ("starttime" -> cols(1)) ~
      ("stoptime" -> cols(2)) ~
      ("start_station_id" -> cols(3)) ~
      ("start_station_name" -> cols(4)) ~
      ("start_station_latitude" -> cols(5)) ~
      ("start_station_longitude" -> cols(6)) ~
      ("end_station_id" -> cols(7)) ~
      ("end_station_name" -> cols(8)) ~
      ("end_station_latitude" -> cols(9)) ~
      ("end_station_longitude" -> cols(10)) ~
      ("bikeid" -> cols(11)) ~
      ("usertype" -> cols(12)) ~
      ("birth_year" -> cols(13)) ~
      ("gender" -> cols(14))

    implicit val formats: DefaultFormats.type = DefaultFormats

    val msg = compact(render(json))
    val data = new ProducerRecord[String, String](topic, msg)

    producer.send(data)
  }
  bufferedSource.close

  producer.close()
}