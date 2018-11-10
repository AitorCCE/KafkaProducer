# TFM_KafkaSpark

## Descripción  del  trabajo:
Uno  de  los  procesos  más  costosos  en  los  entornos  de  Big Data  y  de  los  entornos  de  analítica  en  general, es  tener  que  realizar  operaciones  "full-scan" para la obtención de métricas y el análisis de datos. Es por ello que la generación de cubos OLAP, cuando es posible, para la agrupación de datos en tiempo real, y antes de ser persistidos, es una de las técnicas más usadas en entornos con data lakes. Así, la  idea  es  crear  una  aplicación  con  Spark  Streaming  que  reciba  datos  a  través  de Apache  Kafka  y, en  base  a  una  configuración, generar  cubos  OLAP  y  persistirlos  en ElasticSearch. Por otro lado, los datos "en bruto", serán persistidos en HDFS con formato JSON.

## Objetivo:
Aceleración de consultas a través del cálculo al vuelo de datos en streaming antes de ser persistidos.

## Tecnologías  a  usar:
*	Apache Spark.
*	Apache Kafka.
*	Apache Hadoop (HDFS).
*	JSON.
*	Elastic Search.
*	Kibana.
*	Scala.

## Origen de los datos:
Dataset con datos sobre el uso del servicio CitiBike de bicicletas en Nueva York (https://www.citibikenyc.com/system-data)