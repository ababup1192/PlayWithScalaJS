package org.ababup1192

import org.scalajs.dom
import shared.SharedMessages

import scala.scalajs.js

object ScalaJSMain extends js.JSApp {
  def main(): Unit = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
  }
}