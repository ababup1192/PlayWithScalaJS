package org.ababup1192

import japgolly.scalajs.react.vdom.all._
import japgolly.scalajs.react.{ReactComponentB, ReactDOM}
import org.ababup1192.DuckTree._
import org.ababup1192.Panel.PanelContent
import org.scalajs.dom.document

import scala.scalajs.js


object ScalaJSMain extends js.JSApp {

  val tree = Duck(1, "Grandma", List(
    Duck(2, "Eider", List(
      Duck(3, "Fethry"), Duck(4, "Abner")
    )),
    Duck(5, "Daphne", List(
      Duck(6, "Gladstone")
    )),
    Duck(7, "Quackmore", List(
      Duck(8, "Donald"),
      Duck(9, "Della", List(
        Duck(10, "Huey"), Duck(11, "Dewey"), Duck(12, "Louie")
      ))
    ))
  ))

  val topLevel = ReactComponentB[Unit]("Top level component").render { _ =>
    div(className := "tree",
      Panel.panel(PanelContent(
        id = Some("tree"),
        title = "Tree Chart",
        text = "Here is part of the duck family tree."
      ), DuckTree.treeChart(tree))
    )
  }.buildU

  override def main(): Unit = {
    ReactDOM.render(topLevel(), document.getElementById("container"))
  }
}