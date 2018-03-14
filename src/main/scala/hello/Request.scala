package hello

import scala.beans.BeanProperty

class Request(@BeanProperty var pathParameters: PathParameters) {
  def this() = this(new PathParameters())
}
