package org.ababup1192

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.svg.all._
import paths.high.Tree

import scala.scalajs.js

object DuckTree {

  case class Duck(id: Int, name: String, descendants: List[Duck] = List())

  private def move(p: js.Array[Double]) = s"translate(${p(0)},${p(1)})"

  private def isLeaf(duck: Duck) = duck.descendants.isEmpty

  val treeChart = ReactComponentB[Duck]("DuckTree")
    .render_P { duck =>
      val tree = Tree[Duck](
        data = duck,
        children = _.descendants,
        width = 300,
        height = 300
      )

      val branches = tree.curves map { curve =>
        path(d := curve.connector.path.print)
      }
      val nodes = tree.nodes map { node =>
        g(transform := move(node.point),
          circle(r := 5, cx := 0, cy := 0),
          text(
            transform := (if (isLeaf(node.item)) "translate(10,0)" else "translate(-10,0)"),
            textAnchor := (if (isLeaf(node.item)) "start" else "end"),
            node.item.name
          )
        )
      }

      svg(width := 500, height := 400,
        g(transform := "translate(90,50)",
          branches,
          nodes
        )
      )
    }.build
}
