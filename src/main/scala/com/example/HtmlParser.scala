package com.example

import java.net.URL
import org.htmlcleaner.HtmlCleaner
import play.api.libs.json._

object HtmlParser extends App {

  def getHeadlinesFromUrl(url: String): List[String] = {
    val cleaner = new HtmlCleaner
    val rootNode = cleaner.clean(new URL(url))
    val element = rootNode.findElementByAttValue("class", "site-layout__main-content", true, true)
    val tag = element.getChildTagList
    val scriptTag = tag.get(1)
    List(scriptTag.getText.toString)
  }

  val data = getHeadlinesFromUrl("https://www.kaggle.com/iamshubhamdangare")

  val sp = data.headOption
  val splitResult = sp match {
    case Some(value) => value.split("Kaggle.State.push\\(")(1).split("\\);performance && performance.mark")
  }
  val parsedKaggleData = Json.parse(splitResult(0))
  println(parsedKaggleData)
}
