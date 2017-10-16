import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import rest.TodoRoute

object RESTServer extends App{

  implicit val system = ActorSystem()
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = system.dispatcher

  val route = new TodoRoute().route

  Http().bindAndHandle(route, "localhost", 8080)


}
