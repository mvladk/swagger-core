import io.swagger.jaxrs.Reader
import io.swagger.models.Swagger
import io.swagger.models.properties.MapProperty
import io.swagger.util.Json
import resources._

import com.wordnik.swagger.jaxrs.config._
import com.wordnik.swagger.models.parameters._


import scala.collection.JavaConverters._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.Matchers

@RunWith(classOf[JUnitRunner])
class RegexPathParamTest extends FlatSpec with Matchers {
  it should "scan a simple resource" in {
    val swagger = new Reader(new Swagger()).read(classOf[RegexPathParamResource])
    val get = swagger.getPaths().get("/{report_type}").getGet()
    val param = get.getParameters().get(0)
    param.getName() should be ("report_type")
    param.getPattern() should be ("[aA-zZ]+")
  }
}