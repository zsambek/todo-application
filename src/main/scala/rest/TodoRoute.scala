package rest

import java.util.Date

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.unmarshalling.Unmarshaller
import rest.entities.Todo
import spray.json.DefaultJsonProtocol


trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {

  import rest.util.DateMarshalling._

  implicit val todoFormat = jsonFormat4(Todo)
}

class TodoRoute extends JsonSupport {


  implicit val dateStringUnmarshaller: Unmarshaller[String, Date] =
    Unmarshaller.strict[String, Date] {
      import java.text.SimpleDateFormat
      val formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
      string => formatter.parse(string)
    }

  val route: Route = {
    path("todo") {
      get {
        parameter("date".as[Date].?) { (date: Option[Date]) =>

          val mockTodos = Seq(
            Todo(0, "first", new Date(0), isDone = false),
            Todo(1, "second", new Date(0), isDone = false),
            Todo(2, "third", new Date(0), isDone = false)
          )

          date match {
            case Some(dt) => complete(mockTodos)
            case None => complete(mockTodos)
          }
        }
      } ~
        post {
          entity(as[Todo]) { (todo: Todo) =>
            complete(StatusCodes.Created)
          }
        }
    } ~
      path("todo" / IntNumber) { (todoId: Int) =>
        put {
          entity(as[Todo]) { (todo: Todo) =>
            complete(StatusCodes.Created)
          }
        }
      }
  }

}
