object Main extends App {
  val bufferedSource = io.Source.fromFile("/home/utad/TFM/CitiBike/prueba_datos.csv")
  for (line <- bufferedSource.getLines) {
    val cols = line.split(",").map(_.trim)
    println(s"${cols(1)}|${cols(2)}|${cols(3)}")
  }
  bufferedSource.close
}