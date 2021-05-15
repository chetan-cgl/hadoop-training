import org.apache.spark.sql.SparkSession

object AdsRecommendation {

  def main(args: Array[String]): Unit = {

    val clickFilepath = args(0)
    val impressionFilepath = args(1)
    val metricsSQLPath = args(2)
    val recommendationSQLPath = args(3)

    val session = SparkSession
      .builder()
      .appName("App Demo")
      .master("local[*]")
      .getOrCreate()

    //val sc = session.sparkContext

    //val clickFilepath = "file:///home/chetan/workstation/github/hadoop-training/final-assignment/input-data/min-clicks.json"
    //val impressionFilepath = "file:///home/chetan/workstation/github/hadoop-training/final-assignment/input-data/min-impressions.json"

    //read json file into dataframe
    val clickDF = session.read.json(clickFilepath)
    //clickDF.printSchema()
    //clickDF.show(false)

    val impressionDF = session.read.json(impressionFilepath)
    //impressionDF.printSchema()
    //impressionDF.show(false)

    clickDF.createOrReplaceTempView("temp_click")
    impressionDF.createOrReplaceTempView("temp_impression")
    //val top5 = session.sqlContext.sql("select * from temp_click limit 5")
    //println(top5.show())

    val metricsSQL = session.sqlContext.sql("select m.app_id, m.country_code, count(m.id) as impression, count (c.impression_id) as clicks, sum (c.revenue) from temp_impression m left join temp_click c on m.id = c.impression_id group by m.app_id, m.country_code")
    //val metricsSQLPath = "file:///home/chetan/workstation/github/hadoop-training/final-assignment/3-scala/goal-2-calculate-metrics/metrics"

    metricsSQL.write.json(metricsSQLPath)

    val recommendationSQL = session.sqlContext.sql("select m.app_id, m.country_code, m.advertiser_id, sum (c.revenue) as t_revenue from temp_impression m left join temp_click c on m.id = c.impression_id group by m.app_id, m.country_code, m.advertiser_id order by m.app_id, m.country_code , t_revenue desc")
    //val recommendationSQLPath = "file:///home/chetan/workstation/github/hadoop-training/final-assignment/3-scala/goal-3-top-recommendation/recommendation"
    recommendationSQL.write.json(recommendationSQLPath)

  }

}
