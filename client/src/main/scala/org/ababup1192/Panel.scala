package org.ababup1192

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.all._


object Panel {

  case class PanelContent(id: Option[String], title: String, text: String)

  val panel = ReactComponentB[PanelContent]("Panel")
    .renderC { ($, children) =>
      div(className := "col-md-6", id := $.props.id,
        div(className := "panel panel-default",
          div(className := "panel-heading",
            h2(className := "panel-title", $.props.title)
          ),
          div(className := "panel-body",
            p(className := "alert alert-info", $.props.text),
            children
          )
        )
      )
    }.build
}
