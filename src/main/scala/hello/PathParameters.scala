package hello

import scala.beans.BeanProperty

class PathParameters(@BeanProperty var message: String) {
  def this() = this("")
}
