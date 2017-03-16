package io.triplew.example

import com.typesafe.config.ConfigFactory
import slick.driver.MySQLDriver.api._
import scala.concurrent.Future
import scala.concurrent.Await
import scala.concurrent.duration.Duration

object Main {
  def main(args: Array[String]) {
    val config = ConfigFactory.load()
    val databaseConfig = config.getConfig("database")
  
    val jdbcUrl = databaseConfig.getString("url")
    val dbUser = databaseConfig.getString("user")
    val dbPassword = databaseConfig.getString("password")

    val db = Database.forURL(jdbcUrl, driver="com.mysql.jdbc.Driver", user=dbUser, password=dbPassword)
        
    val query = sql"select id, device_id from device".as[(Int, String)]
    val f:Future[Vector[(Int, String)]] = db.run(query)
    Await.result(f, Duration.Inf) foreach println
   }
  }
