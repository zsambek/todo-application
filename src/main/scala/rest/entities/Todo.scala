package rest.entities

import java.util.Date

case class Todo(id: Int, name: String, deadline: Date, isDone: Boolean)